package Exams.Exam_14Aug22.BusinessLogic.football.entities.field;

import Exams.Exam_14Aug22.BusinessLogic.football.entities.player.Player;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.supplement.Supplement;

import java.util.Collection;

public interface Field {
    int sumEnergy();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void addSupplement(Supplement supplement);

    void drag();

    String getInfo();

    Collection<Player> getPlayers();

    Collection<Supplement> getSupplements();

    String getName();
}
