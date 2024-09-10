package Exams.Exam_5Aug23.BusinessLogic.bank;

import Exams.Exam_5Aug23.BusinessLogic.bank.core.Engine;
import Exams.Exam_5Aug23.BusinessLogic.bank.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
