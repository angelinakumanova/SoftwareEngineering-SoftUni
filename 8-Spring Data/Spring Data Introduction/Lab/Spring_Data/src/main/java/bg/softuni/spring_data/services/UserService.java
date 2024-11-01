package bg.softuni.spring_data.services;


import bg.softuni.spring_data.models.User;

import java.math.BigDecimal;

public interface UserService {
    void register(User user);

    User get(int id);

    void addAccountToUser(int userId, BigDecimal initialBalance);
}
