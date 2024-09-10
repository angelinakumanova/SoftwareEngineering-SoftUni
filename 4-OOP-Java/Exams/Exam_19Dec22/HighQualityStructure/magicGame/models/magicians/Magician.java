package Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magicians;

import Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magics.Magic;

public interface Magician {
    String getUsername();

    int getHealth();

    int getProtection();

    Magic getMagic();

    boolean isAlive();

    void takeDamage(int points);
}
