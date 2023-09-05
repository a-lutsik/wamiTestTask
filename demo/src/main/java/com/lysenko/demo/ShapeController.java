package com.lysenko.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShapeController {

    @Autowired
    private ShapeService shapeService;
    @PostMapping("/shapes")
    public Result calculateCircleAreaAndPerimeter(@RequestBody Shape shape) throws ValidationException {
        return shapeService.calculateAreaAndPerimeter(shape);
    }


}
