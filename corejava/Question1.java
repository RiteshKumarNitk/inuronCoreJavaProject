

/*
 Write a Java program that uses polymorphism by defining an interface called Shape
with methods to calculate the area and perimeter of a shape. Then create classes
that implement the Shape interface for different types of shapes, such as circles and
triangles. */

package corejava;
interface Shape {
    double getPerimeter();
    double getArea();
}

class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle implements Shape {
    private double[] sides;

    Triangle(double sideA, double sideB, double sideC) {
        this.sides = new double[]{sideA, sideB, sideC};
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0.0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        double area = Math.sqrt(s);
        for (double side : sides) {
            area *= (s - side);
        }
        return Math.sqrt(area);
    }
}

public class Question1 {
    public static void main(String[] args) {
        Shape circle = new Circle(30.2);
        System.out.println("Perimeter of Circle: " + String.format("%.2f", circle.getPerimeter()));
        System.out.println("Area of Circle: " + String.format("%.2f", circle.getArea()));

        Shape triangle = new Triangle(10.4, 20, 12);
        System.out.println("Perimeter of Triangle: " + String.format("%.2f", triangle.getPerimeter()));
        System.out.println("Area of Triangle: " + String.format("%.2f", triangle.getArea()));
    }
}
