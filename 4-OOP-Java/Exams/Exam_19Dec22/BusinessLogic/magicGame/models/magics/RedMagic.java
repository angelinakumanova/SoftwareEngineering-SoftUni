package Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magics;

public class RedMagic extends MagicImpl{
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }


    @Override
    public int fire() {
        int newBulletsCount = super.getBulletsCount();
        int bullets = newBulletsCount >= 1 ? 1 : 0;
        newBulletsCount -= 1;

        if (newBulletsCount < 0) {
            newBulletsCount = 0;
        }

        super.setBulletsCount(newBulletsCount);
        return bullets;
    }
}
