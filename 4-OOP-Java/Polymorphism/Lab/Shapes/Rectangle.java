package Polymorphism.Lab.Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected Double calculatePerimeter() {
        super.setPerimeter(2 * (this.height +  this.width));
        return super.getPerimeter();
    }

    @Override
    protected Double calculateArea() {
        super.setArea(this.width * this.height);
        return super.getArea();
    }
}
