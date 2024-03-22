package UnitTesting.Lab.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int AXE_ATTACK = 5;
    private static final int AXE_DURABILITY = 10;

    private Target target;
    private Weapon weapon;

    @Before
    public void setUp() {
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        target.takeAttack(5);

        Assert.assertEquals(15, target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsAnExceptionIfAttacked() {
        target = new Dummy(0, DUMMY_EXPERIENCE);

        target.takeAttack(2);
    }

    @Test
    public void deadDummyCanGiveXP() {
        Hero hero = new Hero("Peter", weapon);
        target = new Dummy(2, DUMMY_EXPERIENCE);
        hero.attack(target);

        Assert.assertEquals(10, hero.getExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {

        target.giveExperience();
    }
}
