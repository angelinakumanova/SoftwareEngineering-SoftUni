package Exams.Exam_8April23.HighQualityStructure.robotService;

import Exams.Exam_8April23.HighQualityStructure.robotService.core.Engine;
import Exams.Exam_8April23.HighQualityStructure.robotService.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
