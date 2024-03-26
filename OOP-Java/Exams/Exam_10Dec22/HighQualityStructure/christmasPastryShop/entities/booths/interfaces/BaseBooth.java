package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.booths.interfaces;

import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int capacity, int numberOfPeople, double pricePerPerson) {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.setCapacity(capacity);
        this.setNumberOfPeople(numberOfPeople);
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReserved = true;
        this.price = numberOfPeople * pricePerPerson;
    }

    @Override
    public double getBill() {
        double sumOfAllDelicacies = this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        double sumOfAllCocktails = this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();

        return sumOfAllCocktails + sumOfAllDelicacies;
    }

    @Override
    public void clear() {
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.price = 0;
        this.numberOfPeople = 0;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }
}
