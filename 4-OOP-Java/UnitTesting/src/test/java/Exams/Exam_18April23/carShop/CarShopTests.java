package Exams.Exam_18April23.carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarShopTests {

    private CarShop carShop;
    private Car car1;
    private Car car2;

    @Before
    public void setUp() {
        carShop = new CarShop();
        car1 = new Car("BMW", 320, 180);
        car2 = new Car("Toyota", 130, 60);
    }

    @Test
    public void testConstructor_ShouldInitializeList() {
        Assert.assertTrue(carShop.getCars().isEmpty());
    }

    @Test
    public void testGetCount_ShouldReturnCorrectCount() {
        carShop.add(car1);
        Assert.assertEquals(1, carShop.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxHorsePower_ShouldReturnAllCarsWithHorsepowerGreaterThanGiven() {
        int horsepower = 150;
        carShop.add(car1);
        carShop.add(car2);

        Assert.assertEquals(1, carShop.findAllCarsWithMaxHorsePower(horsepower).size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddCar_ShouldThrowExceptionIfCarIsNull() {
        carShop.add(null);
    }

    @Test
    public void testAddCar_ShouldAddCarSuccessfully() {
        carShop.add(car1);

        Assert.assertTrue(carShop.getCars().contains(car1));
    }

    @Test
    public void testRemoveCar_ShouldRemoveCarSuccessfully() {
        carShop.add(car2);

        carShop.remove(car2);
        Assert.assertFalse(carShop.getCars().contains(car2));
    }

    @Test
    public void testGetTheMostLuxuryCar_ShouldReturnCarWithHighestPrice() {
        carShop.add(car1);
        carShop.add(car2);

        Car mostExpensiveCar = carShop.getTheMostLuxuryCar();
        Assert.assertEquals(car1, mostExpensiveCar);
    }

    @Test
    public void testFindAllCarByModel_ShouldReturnAllCarsByGivenModel() {
        carShop.add(car1);
        carShop.add(car2);

        List<Car> carsByModel = carShop.findAllCarByModel("BMW");
        Assert.assertEquals(1, carsByModel.size());
    }

}

