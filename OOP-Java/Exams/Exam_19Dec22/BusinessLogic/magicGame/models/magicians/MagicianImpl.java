package Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians;

import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magics.Magic;

import static Exams.Exam_19Dec22.BusinessLogic.magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {
    private String username;
    private int health;

    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.setMagic(magic);
        this.isAlive = true;
    }

    @Override
    public void takeDamage(int points) {
        if (this.protection - points > 0) {
            this.protection -= points;
        } else {
            this.protection = 0;
            this.health -= points;
            if (health < 0) {
                this.health = 0;
            }
        }
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(": ").append(this.username).append(System.lineSeparator());
        sb.append("Health: ").append(this.health).append(System.lineSeparator());
        sb.append("Protection: ").append(this.protection).append(System.lineSeparator());
        sb.append("Magic: ").append(this.getMagic().getName());

        return sb.toString();
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    private void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }
}
