package Exams.Exam_19Dec22.BusinessLogic.magicGame;

import Exams.Exam_19Dec22.BusinessLogic.magicGame.core.Engine;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
