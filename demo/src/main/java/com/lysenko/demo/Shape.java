package com.lysenko.demo;

import com.lysenko.demo.shapes.ShapeType;
import lombok.Data;

@Data
public class Shape {
    private ShapeType type;
    private double sideA;
    private double sideB;
    private double sideC;

    public Shape() {
    }
}
