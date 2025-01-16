package bg.softuni.smartwalletapp.transaction.service;

import bg.softuni.smartwalletapp.transaction.model.Transaction;
import bg.softuni.smartwalletapp.transaction.model.TransactionStatus;
import bg.softuni.smartwalletapp.transaction.model.TransactionType;
import bg.softuni.smartwalletapp.transaction.repository.TransactionRepository;
import bg.softuni.smartwalletapp.user.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createNewTransaction(User owner, String sender, String receiver,
                                            BigDecimal transactionAmount, BigDecimal balanceLeft,
                                            Currency currency, TransactionType type, TransactionStatus status,
                                            String transactionDescription, String failureReason) {

        Transaction transaction = Transaction.builder()
                .owner(owner)
                .sender(sender)
                .receiver(receiver)
                .amount(transactionAmount)
                .balanceLeft(balanceLeft)
                .currency(currency)
                .type(type)
                .status(status)
                .description(transactionDescription)
                .failureReason(failureReason)
                .createdOn(LocalDateTime.now())
                .build();

        return transactionRepository.save(transaction);
    }
}
