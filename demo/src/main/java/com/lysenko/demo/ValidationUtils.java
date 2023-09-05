package com.lysenko.demo;

import org.springframework.stereotype.Component;

@Component
public class ValidationUtils {
    public void validateCircle(Shape shape) throws ValidationException {
        validateNegativeOrZero(shape.getSideA());
    }

    public void validateTriangle(Shape shape) throws ValidationException {
        validateNegativeOrZero(shape.getSideA());
        validateNegativeOrZero(shape.getSideB());
        validateNegativeOrZero(shape.getSideC());
        if (shape.getSideA() >= shape.getSideB() + shape.getSideC()
                || shape.getSideB() >= shape.getSideA() + shape.getSideC()
                || shape.getSideC() >= shape.getSideA() + shape.getSideB()) {
            throw new ValidationException("Impossible to build triangle with this size lengths");
        }
    }

    public void validateRectangle(Shape shape) throws ValidationException {
        validateNegativeOrZero(shape.getSideA());
        validateNegativeOrZero(shape.getSideB());
    }

    public void validateSquare(Shape shape) throws ValidationException {
        validateNegativeOrZero(shape.getSideA());
    }

    private void validateNegativeOrZero(double number) throws ValidationException {
        if (number <= 0) {
            throw new ValidationException("Value is zero or less");
        }
    }
}
