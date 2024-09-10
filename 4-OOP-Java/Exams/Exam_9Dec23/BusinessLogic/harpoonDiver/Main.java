package Exams.Exam_9Dec23.BusinessLogic.harpoonDiver;

import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.core.Controller;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.core.ControllerImpl;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.core.Engine;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
