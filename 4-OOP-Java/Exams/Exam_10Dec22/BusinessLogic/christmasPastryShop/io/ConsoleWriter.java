package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.io;

import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
