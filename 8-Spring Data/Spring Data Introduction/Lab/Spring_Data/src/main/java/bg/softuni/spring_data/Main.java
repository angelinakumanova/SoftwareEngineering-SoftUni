package bg.softuni.spring_data;

import bg.softuni.spring_data.models.Account;
import bg.softuni.spring_data.models.User;
import bg.softuni.spring_data.services.AccountService;
import bg.softuni.spring_data.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
public class Main implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    public Main(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(2000));

        User user = new User();
        user.setUsername("jacksmith");
        user.setAge(25);

//        userService.register(user);
//        userService.addAccountToUser(1, BigDecimal.valueOf(5000));

//        accountService.withdrawMoney(BigDecimal.valueOf(1000), 1);

        accountService.transferMoney(1, 1, 2, BigDecimal.valueOf(1000));
    }


}
