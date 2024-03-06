package InterfacesAndAbstraction.Exercises.MilitaryElite;

import InterfacesAndAbstraction.Exercises.MilitaryElite.commando.impl.CommandoImpl;
import InterfacesAndAbstraction.Exercises.MilitaryElite.engineer.impl.EngineerImpl;
import InterfacesAndAbstraction.Exercises.MilitaryElite.enums.Corp;
import InterfacesAndAbstraction.Exercises.MilitaryElite.general.impl.LieutenantGeneralImpl;
import InterfacesAndAbstraction.Exercises.MilitaryElite.mission.Mission;
import InterfacesAndAbstraction.Exercises.MilitaryElite.mission.impl.MissionImpl;
import InterfacesAndAbstraction.Exercises.MilitaryElite.priv.impl.PrivateImpl;
import InterfacesAndAbstraction.Exercises.MilitaryElite.repair.Repair;
import InterfacesAndAbstraction.Exercises.MilitaryElite.repair.impl.RepairImpl;
import InterfacesAndAbstraction.Exercises.MilitaryElite.soldier.Soldier;
import InterfacesAndAbstraction.Exercises.MilitaryElite.spy.impl.SpyImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<Soldier> soldiers = new LinkedHashSet<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (type) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.add(priv);
                    System.out.println(priv);
                    break;
                case "LieutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    LieutenantGeneralImpl lieutenantGeneral =
                            new LieutenantGeneralImpl(id, firstName, lastName, salary, soldiers);
                    System.out.println(lieutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    if (!corps.equals("Airforces") && !corps.equals("Marines")) {
                        break;
                    }
                    Set<Repair> repairs = new LinkedHashSet<>();
                    for (int i = 6; i < tokens.length; i += 2) {
                        repairs.add(new RepairImpl(tokens[i], Integer.parseInt(tokens[i + 1])));
                    }
                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, Corp.valueOf(corps), repairs);
                    System.out.println(engineer);
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    corps = tokens[5];
                    Set<Mission> missions = new LinkedHashSet<>();
                    for (int i = 6; i < tokens.length; i += 2) {
                        if (tokens[i + 1].equals("inProgress") || tokens[i + 1].equals("finished")) {
                            missions.add(new MissionImpl(tokens[i], tokens[i + 1]));
                        }
                    }
                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, Corp.valueOf(corps), missions);
                    System.out.println(commando);
                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    System.out.println(new SpyImpl(id, firstName, lastName, codeNumber));
                    break;

            }

            input = scanner.nextLine();
        }
    }
}
