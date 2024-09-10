package Exams.Exam_8April23.BusinessLogic.robotService;

import Exams.Exam_8April23.BusinessLogic.robotService.core.Engine;
import Exams.Exam_8April23.BusinessLogic.robotService.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
