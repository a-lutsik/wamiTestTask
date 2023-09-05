package com.lysenko.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    @Autowired
    ValidationUtils validationUtils;

    public Result calculateAreaAndPerimeter(Shape shape) throws ValidationException {
        switch (shape.getType()) {
            case CIRCLE:
                return calculateCircle(shape);
            case RECTANGLE:
                return calculateRectangle(shape);
            case SQUARE:
                return calculateSquare(shape);
            case TRIANGLE:
                return calculateTriangle(shape);
        }
        throw new ValidationException("This shape is not supported");
    }

    private Result calculateCircle(Shape shape) throws ValidationException {
        validationUtils.validateCircle(shape);
        double radius = shape.getSideA();
        Result result = new Result();
        result.setArea(Math.PI * radius * radius);
        result.setPerimeter(2 * Math.PI * radius);
        return result;
    }

    private Result calculateTriangle(Shape shape) throws ValidationException {
        validationUtils.validateTriangle(shape);
        Result result = new Result();
        result.setPerimeter(shape.getSideA() + shape.getSideB() + shape.getSideC());
        double s = result.getPerimeter() / 2.0;
        result.setArea(Math.sqrt(s * (s - shape.getSideA()) * (s - shape.getSideB()) * (s - shape.getSideC())));
        return result;
    }

    private Result calculateRectangle(Shape shape) throws ValidationException {
        validationUtils.validateRectangle(shape);
        Result result = new Result();
        result.setArea(shape.getSideA() * shape.getSideB());
        result.setPerimeter((shape.getSideA() + shape.getSideB()) * 2);
        return result;
    }

    private Result calculateSquare(Shape shape) throws ValidationException {
        validationUtils.validateSquare(shape);
        Result result = new Result();
        result.setArea(shape.getSideA() * shape.getSideA());
        result.setPerimeter(shape.getSideA() * 4);
        return result;
    }
}
