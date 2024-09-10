package Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer {

    private static final double DEFAULT_ENERGY = 60;
    public Archaeologist(String name) {
        super(name, DEFAULT_ENERGY);
    }
}
