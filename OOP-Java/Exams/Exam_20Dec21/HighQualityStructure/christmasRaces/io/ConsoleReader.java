package Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.io;

import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.io.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader  implements InputReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
