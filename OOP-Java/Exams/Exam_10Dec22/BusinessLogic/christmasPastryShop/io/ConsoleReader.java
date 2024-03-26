package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.io;


import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.io.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader  implements InputReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
