package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.io;

import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
