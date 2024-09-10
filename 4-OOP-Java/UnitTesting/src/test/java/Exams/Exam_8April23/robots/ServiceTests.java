package Exams.Exam_8April23.robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ServiceTests {

    private Robot robot;
    private Service service;

    @Before
    public void setUp() {
        this.robot = new Robot("Bot");
        this.service = new Service("RobotService", 10);
    }

    @Test
    public void robotConstructor_ShouldSetValuesCorrectly() {
        Assert.assertEquals("Bot", robot.getName());
    }

    @Test
    public void serviceConstructor_ShouldSetValuesCorrectly() {
        Assert.assertEquals("RobotService", service.getName());
        Assert.assertEquals(10, service.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void serviceConstructor_ShouldThrowAnExceptionIfNullOrEmpty() {
        new Service(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void serviceConstructor_ShouldThrowAnExceptionIfCapacityIsInvalid() {
        new Service("RobotService", -5);
    }

    @Test
    public void getName_ShouldReturnRightName() {
        Assert.assertEquals("RobotService", service.getName());
    }


    @Test
    public void getCapacity_ShouldReturnCorrectCapacity() {
        Assert.assertEquals(10, service.getCapacity());
    }

    @Test
    public void getCount_ShouldReturnRobotsCount() {
        service.add(robot);

        Assert.assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRobot_ShouldThrowAnExceptionIfCapacityLimitIsReached() {
        service = new Service("RobotService", 1);
        service.add(robot);
        service.add(robot);

    }

    @Test
    public void addRobot_ShouldAddRobot() {
        service.add(robot);

        Assert.assertEquals(1, service.getCount());
    }

    @Test
    public void removeRobot_ShouldRemoveRobot() {
        service.add(robot);
        service.remove("Bot");

        Assert.assertEquals(0, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeRobot_ShouldThrowAnExceptionIfRobotIsNonExistent() {
        service.remove("Bot");

    }

    @Test
    public void forSale_ShouldSetRobotForSale() {
        service.add(robot);

        Assert.assertFalse(service.forSale("Bot").isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void forSale_ShouldThrowAnExceptionIfRobotIsNonExistent() {
        service.forSale("Bot");
    }

    @Test
    public void report_ShouldReturnAllRobots() {
        service.add(robot);

        Assert.assertEquals("The robot Bot is in the service RobotService!", service.report());
    }

}
