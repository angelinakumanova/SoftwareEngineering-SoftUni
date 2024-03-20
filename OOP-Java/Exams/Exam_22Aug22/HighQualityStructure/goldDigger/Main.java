package Exams.Exam_22Aug22.HighQualityStructure.goldDigger;

import Exams.Exam_22Aug22.HighQualityStructure.goldDigger.core.Controller;
import Exams.Exam_22Aug22.HighQualityStructure.goldDigger.core.ControllerImpl;
import Exams.Exam_22Aug22.HighQualityStructure.goldDigger.core.Engine;
import Exams.Exam_22Aug22.HighQualityStructure.goldDigger.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
