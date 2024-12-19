package bg.softuni.pathfinder.config;

import bg.softuni.pathfinder.data.entities.User;
import bg.softuni.pathfinder.data.enums.UserRoles;
import org.springframework.stereotype.Component;

@Component("currentUser")
public class CurrentUser {
    private User user;

    public boolean isLoggedIn() {
        return this.user != null;
    }

    public boolean isAdmin() {
        return this.user.getRoles().stream().anyMatch(r -> r.getName().equals(UserRoles.ADMIN));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
