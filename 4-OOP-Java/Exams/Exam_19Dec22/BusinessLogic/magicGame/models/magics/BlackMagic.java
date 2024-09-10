package Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magics;

public class BlackMagic extends MagicImpl {
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int newBulletsCount = super.getBulletsCount();
        int bullets = newBulletsCount >= 10 ? 10 : 0;
        newBulletsCount -= 10;

        if (newBulletsCount < 0) {
            newBulletsCount = 0;
        }

        super.setBulletsCount(newBulletsCount);
        return bullets;
    }
}
