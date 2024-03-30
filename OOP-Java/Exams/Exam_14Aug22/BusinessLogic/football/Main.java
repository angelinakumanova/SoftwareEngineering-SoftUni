package Exams.Exam_14Aug22.BusinessLogic.football;

import Exams.Exam_14Aug22.BusinessLogic.football.core.Engine;
import Exams.Exam_14Aug22.BusinessLogic.football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
