package bg.softuni.smartwalletapp.wallet.service;

import bg.softuni.smartwalletapp.exception.DomainException;
import bg.softuni.smartwalletapp.transaction.model.Transaction;
import bg.softuni.smartwalletapp.transaction.model.TransactionStatus;
import bg.softuni.smartwalletapp.transaction.model.TransactionType;
import bg.softuni.smartwalletapp.transaction.service.TransactionService;
import bg.softuni.smartwalletapp.user.model.User;
import bg.softuni.smartwalletapp.wallet.model.Wallet;
import bg.softuni.smartwalletapp.wallet.model.WalletStatus;
import bg.softuni.smartwalletapp.wallet.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Slf4j
@Service
public class WalletService {
    private static final String SMART_WALLET_LTD = "Smart Wallet Ltd";

    private final WalletRepository walletRepository;
    private final TransactionService transactionService;

    public WalletService(WalletRepository walletRepository, TransactionService transactionService) {
        this.walletRepository = walletRepository;
        this.transactionService = transactionService;
    }

    public Wallet createNewWallet(User user) {

        Wallet wallet = walletRepository.save(initializeWallet(user));
        log.info("Successfully create new wallet with id [%s] and balance [%.2f].".formatted(wallet.getId(), wallet.getBalance()));

        return wallet;
    }

    @Transactional
    public Transaction topUp(UUID walletId, BigDecimal amount) {

        Wallet wallet = getWalletById(walletId);
        String transactionDescription = "Top up %.2f".formatted(amount.doubleValue());

        if (wallet.getStatus() == WalletStatus.INACTIVE) {

            return transactionService.createNewTransaction(wallet.getOwner(),
                    SMART_WALLET_LTD,
                    walletId.toString(),
                    amount,
                    wallet.getBalance(),
                    wallet.getCurrency(),
                    TransactionType.DEPOSIT,
                    TransactionStatus.FAILED,
                    transactionDescription,
                    "Inactive wallet");
        }

        wallet.setBalance(wallet.getBalance().add(amount));
        wallet.setUpdatedOn(LocalDateTime.now());

        walletRepository.save(wallet);

        return transactionService.createNewTransaction(wallet.getOwner(),
                SMART_WALLET_LTD,
                walletId.toString(),
                amount,
                wallet.getBalance(),
                wallet.getCurrency(),
                TransactionType.DEPOSIT,
                TransactionStatus.SUCCEEDED,
                transactionDescription,
                null);
    }

    @Transactional
    public Transaction charge(UUID walletId, BigDecimal amount, String chargeDescription) {
        Wallet wallet = getWalletById(walletId);
        String failureReason = null;
        TransactionStatus status = TransactionStatus.FAILED;

        if (wallet.getStatus() == WalletStatus.INACTIVE) {
            failureReason = "Inactive wallet";
        } else if (wallet.getBalance().compareTo(amount) < 0) {
            failureReason = "Insufficient balance";
        } else {
            wallet.setBalance(wallet.getBalance().subtract(amount));
            wallet.setUpdatedOn(LocalDateTime.now());
            status = TransactionStatus.SUCCEEDED;

            walletRepository.save(wallet);
        }


        return transactionService.createNewTransaction(
                wallet.getOwner(),
                walletId.toString(),
                SMART_WALLET_LTD,
                amount,
                wallet.getBalance(),
                wallet.getCurrency(),
                TransactionType.WITHDRAWAL,
                status,
                chargeDescription,
                failureReason);
    }


    private Wallet getWalletById(UUID walletId) {

        return walletRepository.findById(walletId)
                .orElseThrow(() -> new DomainException("Wallet with id [%s] does not exist.".formatted(walletId)));
    }

    private Wallet initializeWallet(User user) {
        LocalDateTime now = LocalDateTime.now();

        return Wallet.builder()
                .owner(user)
                .status(WalletStatus.ACTIVE)
                .balance(new BigDecimal("20.00"))
                .currency(Currency.getInstance("EUR"))
                .createdOn(now)
                .updatedOn(now)
                .build();
    }
}
