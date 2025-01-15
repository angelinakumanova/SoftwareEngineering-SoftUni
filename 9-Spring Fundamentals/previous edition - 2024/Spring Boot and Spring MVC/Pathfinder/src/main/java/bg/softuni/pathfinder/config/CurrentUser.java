package bg.softuni.pathfinder.config;

import bg.softuni.pathfinder.data.entities.User;
import bg.softuni.pathfinder.data.enums.UserRoles;
import bg.softuni.pathfinder.web.model.UserProfileDetails;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser {
    private final ModelMapper modelMapper;

    private User user;

    public CurrentUser(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public boolean isLoggedIn() {
        return this.user != null;
    }

    public boolean isAdmin() {
        return this.user.getRoles().stream().anyMatch(r -> r.getName().equals(UserRoles.ADMIN));
    }

    public UserProfileDetails mapToDto() {
        return this.modelMapper.map(this.user, UserProfileDetails.class);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
