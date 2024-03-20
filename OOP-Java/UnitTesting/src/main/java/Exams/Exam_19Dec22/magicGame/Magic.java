package Exams.Exam_19Dec22.magicGame;

public class Magic {
    private String name;
    private int bullets;

    public Magic(String name, int bullets) {
        this.setName(name);
        this.setBullets(bullets);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getBullets() {
        return this.bullets;
    }

    private void setBullets(int bullets) {
        this.bullets = bullets;
    }
}
