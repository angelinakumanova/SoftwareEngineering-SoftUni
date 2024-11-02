package bg.softuni.usersystem.data.entities.annotations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private int min;
    private int max;
    private boolean containsLower;
    private boolean containsUpper;
    private boolean containsDigit;
    private boolean containsSpecialSymbol;

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.length() < min || password.length() > max) return false;

        boolean hasLower = containsLower && password.chars().anyMatch(Character::isLowerCase);
        boolean hasUpper = containsUpper && password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = containsDigit && password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = containsSpecialSymbol && password.matches(".*[!@#$%^&*()_+<>?].*");

        return (!containsLower || hasLower) &&
                (!containsUpper || hasUpper) &&
                (!containsDigit || hasDigit) &&
                (!containsSpecialSymbol || hasSpecial);
    }

    @Override
    public void initialize(Password constraint) {
        this.min = constraint.minLength();
        this.max = constraint.maxLength();
        this.containsLower = constraint.containsLowerCase();
        this.containsUpper = constraint.containsUpperCase();
        this.containsDigit = constraint.containsDigit();
        this.containsSpecialSymbol = constraint.containsSpecialSymbol();
    }
}
