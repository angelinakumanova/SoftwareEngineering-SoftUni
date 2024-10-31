package bg.softuni.spring_data.services;

import bg.softuni.spring_data.models.Account;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal amount, int id);
    void transferMoney(BigDecimal amount, int id);
}
