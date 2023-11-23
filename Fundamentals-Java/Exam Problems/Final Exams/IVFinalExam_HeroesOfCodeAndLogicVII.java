package ExamProblems.FinalExams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class IVFinalExam_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int heroes = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> heroesHealth = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> heroesMana = new LinkedHashMap<>();
        for (int i = 0; i < heroes; i++) {
            String[] heroInfo = scanner.nextLine().split(" ");
            heroesHealth.put(heroInfo[0], Integer.parseInt(heroInfo[1]));
            heroesMana.put(heroInfo[0], Integer.parseInt(heroInfo[2]));
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String hero = tokens[1];
            if (tokens[0].equals("CastSpell")) {
                int neededMP = Integer.parseInt(tokens[2]);
                String spell = tokens[3];

                if (heroesMana.get(hero) >= neededMP) {
                    heroesMana.put(hero, heroesMana.get(hero) - neededMP);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                            hero,
                            spell,
                            heroesMana.get(hero));
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", hero, spell);
                }
            } else if (tokens[0].equals("TakeDamage")) {
                int damage = Integer.parseInt(tokens[2]);
                String attacker = tokens[3];

                int leftHealth = heroesHealth.get(hero) - damage;
                if (leftHealth > 0) {
                    heroesHealth.put(hero, leftHealth);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                            hero,
                            damage,
                            attacker,
                            leftHealth);
                } else {
                    System.out.printf("%s has been killed by %s!%n", hero, attacker);
                    heroesMana.remove(hero);
                    heroesHealth.remove(hero);
                }
            } else if (tokens[0].equals("Recharge")) {;
                int amount = Integer.parseInt(tokens[2]);

                int beforeRecharge = heroesMana.get(hero);
                heroesMana.put(hero, Math.min(200, heroesMana.get(hero) + amount));
                System.out.printf("%s recharged for %d MP!%n", hero, heroesMana.get(hero) - beforeRecharge);
            } else if (tokens[0].equals("Heal")) {
                int amount = Integer.parseInt(tokens[2]);
                int beforeHeal = heroesHealth.get(hero);

                heroesHealth.put(hero, Math.min(100, heroesHealth.get(hero) + amount));
                System.out.printf("%s healed for %s HP!%n", hero, heroesHealth.get(hero) - beforeHeal);
            }




            command = scanner.nextLine();
        }

        for (Map.Entry<String,Integer> hero : heroesHealth.entrySet()) {
            for (Map.Entry<String, Integer> entry : heroesMana.entrySet()) {
                if (entry.getKey().equals(hero.getKey())) {
                    System.out.println(hero.getKey());
                    System.out.printf("  HP: %d%n", hero.getValue());
                    System.out.printf("  MP: %d%n", entry.getValue());
                }
            }
        }
    }
}
