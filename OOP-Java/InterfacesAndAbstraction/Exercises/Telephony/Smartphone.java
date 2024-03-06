package InterfacesAndAbstraction.Exercises.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        this.urls.forEach(url -> {
            if (url.matches(".*\\d+.*")) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }});

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        this.numbers.forEach(number -> {
            if (number.matches(".*\\D+.*")) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            }});

        return sb.toString().trim();
    }
}
