package bg.softuni.pathfinder.util.validation;

import bg.softuni.pathfinder.web.model.UserRegisterModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<EqualPasswords, UserRegisterModel> {

    @Override
    public boolean isValid(UserRegisterModel user, ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
