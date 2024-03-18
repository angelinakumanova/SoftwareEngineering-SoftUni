package Exams.Exam_15Aug23.BusinessLogic.handball;

import Exams.Exam_15Aug23.BusinessLogic.handball.core.Engine;
import Exams.Exam_15Aug23.BusinessLogic.handball.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
