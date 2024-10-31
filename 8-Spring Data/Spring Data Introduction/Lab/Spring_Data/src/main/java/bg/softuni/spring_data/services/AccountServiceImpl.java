package bg.softuni.spring_data.services;


import bg.softuni.spring_data.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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

    @Override
    public void transferMoney(BigDecimal amount, int id) {

    }
}
