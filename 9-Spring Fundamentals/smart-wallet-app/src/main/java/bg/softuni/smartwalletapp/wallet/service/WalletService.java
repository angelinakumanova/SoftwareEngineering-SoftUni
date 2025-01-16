package bg.softuni.smartwalletapp.wallet.service;

import bg.softuni.smartwalletapp.user.model.User;
import bg.softuni.smartwalletapp.wallet.model.Wallet;
import bg.softuni.smartwalletapp.wallet.model.WalletStatus;
import bg.softuni.smartwalletapp.wallet.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Slf4j
@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createNewWallet(User user) {

        Wallet wallet = walletRepository.save(initializeWallet(user));
        log.info("Successfully create new wallet with id [%s] and balance [%.2f].".formatted(wallet.getId(), wallet.getBalance()));

        return wallet;
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
