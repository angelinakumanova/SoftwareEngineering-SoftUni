package UnitTesting.Lab.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {
    private static final String HERO_NAME = "Peter";
    private static final int TARGET_XP = 10;
    private static final int TARGET_HEALTH = 15;
    private static final int WEAPON_ATTACK = 10;

    private Weapon weapon;
    private Target target;
    private Hero hero;

    @Before
    public void setUp() {
        weapon = Mockito.mock(Weapon.class);
        target = Mockito.mock(Target.class);
        hero = new Hero(HERO_NAME, weapon);
    }

    @Test
    public void testAttack_HeroGainsExperienceIfTargetIsDead() {


        Mockito.when(target.giveExperience()).thenReturn(TARGET_XP);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(weapon.getAttackPoints()).thenReturn(WEAPON_ATTACK);


        hero.attack(target);

        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }

}
