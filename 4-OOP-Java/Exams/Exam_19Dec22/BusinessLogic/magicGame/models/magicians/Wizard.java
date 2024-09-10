package Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians;

import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magics.Magic;

public class Wizard extends MagicianImpl{
    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
