package Exams.Exam_18April23.BusinessLogic.vehicleShop;

import Exams.Exam_18April23.BusinessLogic.vehicleShop.core.Engine;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
