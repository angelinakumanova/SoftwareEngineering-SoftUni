package bg.softuni.spring_data.services;


import bg.softuni.spring_data.models.Account;
import bg.softuni.spring_data.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Transactional
    @Override
    public void withdrawMoney(BigDecimal amount, int id) {
        this.accountRepository.findById(id).ifPresentOrElse(account -> {
            if (account.getUser() == null) {
                System.out.println("You are not logged in");
                return;
            }

            if (account.getBalance().compareTo(amount) < 0) {
                System.out.println("You don't have enough money!");
                return;
            }

            account.setBalance(account.getBalance().subtract(amount));
            accountRepository.save(account);
            System.out.printf("You have successfully withdrawn %.2f to account %d\n", amount, id);
        }, () -> System.out.println("Account not found."));
    }

    @Transactional
    @Override
    public void transferMoney(int userId, int sourceAccountId, int targetAccountId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Transfer amount must be positive!");
            return;
        }

        Optional<Account> sourceAccountOpt = accountRepository.findById(sourceAccountId);
        Optional<Account> targetAccountOpt = accountRepository.findById(targetAccountId);

        if (sourceAccountOpt.isEmpty() || targetAccountOpt.isEmpty()) {
            System.out.println("One or both accounts not found.");
            return;
        }

        Account sourceAccount = sourceAccountOpt.get();
        Account targetAccount = targetAccountOpt.get();

        if (sourceAccount.getUser().getId() != userId) {
            System.out.println("The source account does not belong to the specified user.");
            return;
        }

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            System.out.println("Insufficient funds in the source account.");
            return;
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        targetAccount.setBalance(targetAccount.getBalance().add(amount));

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        System.out.printf("Successfully transferred %.2f from account %d to account %d\n",
                amount, sourceAccountId, targetAccountId);
    }


}
