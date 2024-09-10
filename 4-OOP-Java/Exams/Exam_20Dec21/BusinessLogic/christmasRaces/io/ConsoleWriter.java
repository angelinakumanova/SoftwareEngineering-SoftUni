package Exams.Exam_20Dec21.BusinessLogic.christmasRaces.io;

import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
