package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.delicacies.interfaces;

import static Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseDelicacy implements Delicacy {
    private String name;
    private double portion;
    private double price;

    public BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPrice(price);
        this.setPortion(portion);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f", this.name, this.portion, this.price);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }
}
