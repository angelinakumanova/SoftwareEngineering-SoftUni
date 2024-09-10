package Exams.Exam_15Aug23.HighQualityStructure.handball.entities.team;

public class Bulgaria extends BaseTeam {
    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        super.setAdvantage(super.getAdvantage() + 115);
    }
}
