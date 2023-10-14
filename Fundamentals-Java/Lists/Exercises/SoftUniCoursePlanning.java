package Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("course start")) {

            if (command.contains("Add")) {
                String lesson = command.split(":")[1];
                if (!existingLesson(schedule, lesson)) {
                    schedule.add(lesson);
                }
            } else if (command.contains("Insert")) {
                String lesson = command.split(":")[1];
                int index = Integer.parseInt(command.split(":")[2]);

                if (!existingLesson(schedule, lesson)) {
                    schedule.add(index, lesson);
                }
            } else if (command.contains("Remove")) {
                String lesson = command.split(":")[1];
                String exercise = lesson + "-Exercise";

                if (existingLesson(schedule, lesson)) {
                    schedule.remove(lesson);
                    if (existingExercise(schedule, exercise)) {
                        schedule.remove(exercise);
                    }
                }
            } else if (command.contains("Swap")) {
                String firstLesson = command.split(":")[1];
                String secondLesson = command.split(":")[2];
                String firstExercise = firstLesson + "-Exercise";
                String secondExercise = secondLesson + "-Exercise";

                if (existingLesson(schedule, firstLesson) && existingLesson(schedule, secondLesson)) {
                    int firstLessonIdx = schedule.indexOf(firstLesson);
                    int secondLessonIdx = schedule.indexOf(secondLesson);
                    schedule.set(firstLessonIdx, secondLesson);
                    schedule.set(secondLessonIdx, firstLesson);

                    if (existingExercise(schedule, firstExercise)) {
                        schedule.remove(firstExercise);
                        schedule.add((secondLessonIdx + 1), firstExercise);
                    }
                    if (existingExercise(schedule, secondExercise)) {
                        schedule.remove(secondExercise);
                        schedule.add((firstLessonIdx + 1), secondExercise);
                    }
                }
            } else if (command.contains("Exercise")) {
                String lesson = command.split(":")[1];
                String exercise = lesson + "-Exercise";

                if (existingLesson(schedule, lesson) && !existingExercise(schedule, exercise)) {
                    int indexOfLesson = schedule.indexOf(lesson);
                    schedule.add((indexOfLesson + 1), exercise);
                }
                if (!existingLesson(schedule, lesson) && !existingExercise(schedule, exercise)){
                    schedule.add(lesson);
                    schedule.add(exercise);
                }
            }


            command = scanner.nextLine();
        }

        printSchedule(schedule);
    }


    public static boolean existingLesson (List<String> schedule, String lesson) {
        boolean isExistingLesson = false;

        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).equals(lesson)) {
                isExistingLesson = true;
                break;
            }
        }
        return isExistingLesson;
    }

    public static boolean existingExercise (List<String> schedule, String exercise) {
        boolean isExistingExercise = false;


        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).equals(exercise)) {
                isExistingExercise = true;
                break;
            }
        }
        return isExistingExercise;
    }

    public static void printSchedule (List<String> schedule) {
        int index = 1;
        for (String lesson : schedule) {
            System.out.println(index + "." + lesson);
            index++;
        }
    }
}
