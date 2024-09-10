package WorkingWithAbstraction.Lab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String[] args) {
        String command = args[0];
        switch (command) {
            case "Create":
                Student student = create(args);
                repo.putIfAbsent(student.getName(), student);
                break;
            case "Show":
                var name = args[1];
                if (repo.containsKey(name)) {
                    System.out.println(show(repo.get(name)));
                }
                break;
        }
    }

    private static Student create(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);

        return new Student(name, age, grade);
    }

    private static String show(Student student) {
        String view = String.format("%s is %s years old.", student.getName(), student.getAge());

        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }

        return view;
    }
}
