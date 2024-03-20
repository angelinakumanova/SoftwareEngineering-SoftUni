package Exams.Exam_22Aug22.BusinessLogic.goldDigger;

import Exams.Exam_22Aug22.BusinessLogic.goldDigger.core.Controller;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.core.ControllerImpl;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.core.Engine;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
