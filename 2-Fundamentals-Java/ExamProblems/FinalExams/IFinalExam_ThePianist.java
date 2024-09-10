package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IFinalExam_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> pieces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            pieces.add(input);
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] tokens = command.split("\\|");


            if (command.contains("Add")) {
                String piece = tokens[1];
                String composer = tokens[2];
                String key = tokens[3];
                if (!isInCollection(pieces, piece)) {
                    String pieceInput = piece + "|" + composer + "|" + key;
                    pieces.add(pieceInput);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                } else {
                    System.out.printf("%s is already in the collection!%n", piece);
                }
            } else if (command.contains("Remove")) {
                String piece = tokens[1];
                if (isInCollection(pieces, piece)) {
                    for (String pieceList : pieces) {
                        if (pieceList.contains(piece)) {
                            System.out.printf("Successfully removed %s!%n", piece);
                            pieces.remove(pieceList);
                            break;
                        }
                    }
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            } else if (command.contains("ChangeKey")) {
                String piece = tokens[1];
                String key = tokens[2];

                if (isInCollection(pieces, piece)) {
                    for (int i = 0; i < pieces.size(); i++) {
                        String pieceList = pieces.get(i);
                        if (pieceList.contains(piece)) {
                            String[] pieceSplit = pieceList.split("\\|");
                            String newPiece = pieceSplit[0] + "|" + pieceSplit[1] + "|" + key;
                            pieces.set(i, newPiece);
                            System.out.printf("Changed the key of %s to %s!%n", piece, key);
                        }
                    }
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            }

            command = scanner.nextLine();
        }

        for (String piece : pieces) {
            String[] pieceSplit = piece.split("\\|");
            System.out.printf("%s -> Composer: %s, Key: %s%n", pieceSplit[0], pieceSplit[1], pieceSplit[2]);
        }
    }

    public static boolean isInCollection (List<String> pieces, String pieceFromInput) {
        for (String piece : pieces) {
            if (piece.contains(pieceFromInput)) {
                return true;
            }
        }
        return false;
    }
}
