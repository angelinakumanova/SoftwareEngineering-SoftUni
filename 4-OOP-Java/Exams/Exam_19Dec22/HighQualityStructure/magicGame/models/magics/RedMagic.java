package Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magics;

public class RedMagic extends MagicImpl {
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }


    @Override
    public int fire() {
        int newBulletsCount = super.getBulletsCount();
        newBulletsCount -= 1;

        if (newBulletsCount < 0) {
            newBulletsCount = 0;
        }

        super.setBulletsCount(newBulletsCount);
        return newBulletsCount;
    }
}
