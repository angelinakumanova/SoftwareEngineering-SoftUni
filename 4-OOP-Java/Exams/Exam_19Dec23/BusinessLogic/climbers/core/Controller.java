package Exams.Exam_19Dec23.BusinessLogic.climbers.core;

public interface Controller {
    String addClimber(String type, String climberName) throws ClassNotFoundException;

    String addMountain(String mountainName, String... peaks);

    String removeClimber(String climberName);

    String startClimbing(String mountainName);

    String getStatistics();

}
