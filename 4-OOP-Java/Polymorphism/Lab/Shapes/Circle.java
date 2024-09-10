package Polymorphism.Lab.Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected Double calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
        return super.getPerimeter();
    }

    @Override
    protected Double calculateArea() {
        super.setArea(Math.PI * Math.pow(this.radius, 2));
        return super.getArea();
    }
}
