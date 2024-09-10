package Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver;

import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.core.Controller;
import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.core.Engine;
import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = null; //TODO new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
