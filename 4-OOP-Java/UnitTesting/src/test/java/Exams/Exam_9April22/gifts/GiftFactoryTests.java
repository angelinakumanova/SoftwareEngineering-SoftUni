package Exams.Exam_9April22.gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {
    private GiftFactory factory;
    private Gift gift1;
    private Gift gift2;

    @Before
    public void setUp() {
        this.factory = new GiftFactory();
        this.gift1 = new Gift("magicGift", 20);
        this.gift2 = new Gift("specialGift", 100);
        this.factory.createGift(gift1);
        this.factory.createGift(gift2);
    }

    @Test
    public void testGetCount_ShouldReturnCorrectValue() {
        Assert.assertEquals(2, factory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGift_ShouldThrowExceptionIfGiftWithSameNameAlreadyExists() {
        this.factory.createGift(new Gift("magicGift", 50));
    }

    @Test
    public void testCreateGift_ShouldAddGiftSuccessfully() {
        this.factory.createGift(new Gift("newGift", 100));

        Assert.assertEquals(3, this.factory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGift_ShouldThrowExceptionIfGivenNameIsNull() {
        this.factory.removeGift(null);
    }

    @Test
    public void testRemoveGift_ShouldRemoveGivenGiftSuccessfully() {
        this.factory.removeGift("magicGift");

        Assert.assertFalse(this.factory.getPresents().contains(gift1));
    }

    @Test
    public void testGetPresentWithLeastMagic_ShouldReturnGiftWithTheLeastMagic() {
        Gift presentWithLeastMagic = this.factory.getPresentWithLeastMagic();

        Assert.assertEquals(gift1, presentWithLeastMagic);
    }

    @Test
    public void testGetPresentWithLeastMagic_ShouldReturnNullIfFactoryIsEmpty() {
        Gift presentWithLeastMagic = new GiftFactory().getPresentWithLeastMagic();

        Assert.assertNull(presentWithLeastMagic);
    }

    @Test
    public void testGetPresent_ShouldReturnPresentByGivenName() {
        Gift searchedGift = this.factory.getPresent("specialGift");

        Assert.assertEquals(gift2, searchedGift);
    }

    @Test
    public void testGetPresent_ShouldReturnNullIfPresentIsNonExistent() {
        Gift searchedGift = this.factory.getPresent("nonExistent");

        Assert.assertNull(searchedGift);
    }

}
