package Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magics;

public class BlackMagic extends MagicImpl {
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int newBulletsCount = super.getBulletsCount();
        newBulletsCount -= 10;

        if (newBulletsCount < 0) {
            newBulletsCount = 0;
        }

        super.setBulletsCount(newBulletsCount);
        return newBulletsCount;
    }
}
