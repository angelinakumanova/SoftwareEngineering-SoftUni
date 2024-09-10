package Exams.Exam_19Dec23.BusinessLogic.climbers;

import Exams.Exam_19Dec23.BusinessLogic.climbers.core.Controller;
import Exams.Exam_19Dec23.BusinessLogic.climbers.core.ControllerImpl;
import Exams.Exam_19Dec23.BusinessLogic.climbers.core.Engine;
import Exams.Exam_19Dec23.BusinessLogic.climbers.core.EngineImpl;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
