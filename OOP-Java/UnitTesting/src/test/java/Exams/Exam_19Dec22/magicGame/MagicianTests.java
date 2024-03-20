package Exams.Exam_19Dec22.magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MagicianTests {
    private Magic magic;
    private Magician magician;

    @Before
    public void setUp() {
        magic = new Magic("SpecialMagic", 20);
        magician = new Magician("Wizard", 100);
    }

    @Test
    public void magicConstructor_SetsValuesSuccessfully() {
        String expectedName = "SpecialMagic";
        int expectedBullets = 20;

        String actualName = magic.getName();
        int actualBullets = magic.getBullets();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBullets, actualBullets);
    }

    @Test
    public void magicianConstructor_SetsValuesSuccessfully() {
        String expectedUsername = "Wizard";
        int expectedHealth= 100;

        String actualUsername = magician.getUsername();
        int actualHealth = magician.getHealth();

        Assert.assertEquals(expectedUsername, actualUsername);
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = NullPointerException.class)
    public void magicianConstructor_ShouldThrowNullPointerExceptionForInvalidName() {
        new Magician(null, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void magicianConstructor_ShouldThrowAnExceptionForInvalidHealth() {
        new Magician("Wizard", -50);
    }

    @Test
    public void getUsername_ShouldReturnRightUsername() {
        Assert.assertEquals("Wizard", magician.getUsername());
    }

    @Test
    public void getHealth_ShouldReturnRightHealth() {
        Assert.assertEquals(100, magician.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void takeDamage_ShouldThrowExceptionForDeadMagician() {
        magician = new Magician("Wizard", 0);
        magician.takeDamage(10);
    }

    @Test
    public void takeDamage_ShouldSetHealthToZeroIfDamageLowersHealthToANegativeNumber() {
        magician.takeDamage(200);
        Assert.assertEquals(0, magician.getHealth());
    }

    @Test
    public void takeDamage_ShouldRemoveFromHealth() {
        magician.takeDamage(50);
        Assert.assertEquals(50, magician.getHealth());
    }

    @Test
    public void addMagic_ShouldAddMagic() {
        magician.addMagic(magic);

        Assert.assertEquals(List.of(magic), magician.getMagics());
    }

    @Test(expected = NullPointerException.class)
    public void addMagic_ShouldThrowAnExceptionIfNull() {
        magician.addMagic(null);
    }

    @Test
    public void removeMagic_ShouldRemoveGivenMagic() {
        magician.addMagic(magic);

        Assert.assertTrue(magician.removeMagic(magic));
    }

    @Test
    public void getMagic_ShouldReturnGivenMagic() {
        magician.addMagic(magic);

        Assert.assertEquals(magic, magician.getMagic("SpecialMagic"));
    }

    @Test
    public void getMagic_ShouldReturnNullIfNotFound() {
        magician.addMagic(magic);

        Assert.assertEquals(null, magician.getMagic("Unknown"));
    }
}
