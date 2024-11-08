package bg.softuni.springdata_automapping_exercise.utils;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidatorUtil {

    <E> Set<ConstraintViolation<E>> validate(E entity);

    <E> boolean isValid(E entity);
}
