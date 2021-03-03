package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateSaveGame {
    private static int rightHand;
    private static int leftHand;
    private static int rightHand2;
    private static int leftHand2;
    private static int turn1;
    private static int turn2;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Player> saveGame = new ArrayList<>();

    public static ArrayList createSaveGame(String file) throws IOException {
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String line;
        String handValues = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals("End of save game.")) {
                handValues += line;
            } else {
                parse(handValues);
                handValues = "";
            }
        }
        return saveGame;
    }

    private static void parse(String handValues) {
        int pos = 0, pos2 = 0, pos3 = 0, pos4 = 0, pos5 = 0, pos6 = 0;
        int rightHand = 1, leftHand = 1, rightHand2 = 1, leftHand2 = 1;
        int turn1 = 0, turn2 = 0;
        for (int x = 0; x < handValues.length(); x++) {
            if (handValues.substring(x, x + 1).equals(",")) {
                pos = x;
                rightHand = Integer.parseInt(handValues.substring(0, pos));
            }
            if (handValues.substring(x, x + 1).equals(".")) {
                pos2 = x;
                leftHand = Integer.parseInt(handValues.substring(pos+1, pos2));
            }
            if (handValues.substring(x, x + 1).equals(";")) {
                pos3 = x;
                rightHand2 = Integer.parseInt(handValues.substring(pos2+1,pos3));
            }
            if(handValues.substring(x, x + 1).equals("/")) {
                pos4 = x;
                leftHand2 = Integer.parseInt(handValues.substring(pos3+1, pos4));
            }
            if(handValues.substring(x, x + 1).equals(":")) {
                pos5 = x;
                turn1 = Integer.parseInt(handValues.substring(pos4+1, pos5));
            }
            if(handValues.substring(x, x + 1).equals("s")) {
                pos6 = x;
                turn2 = Integer.parseInt(handValues.substring(pos5+1, pos6));
            }
        }
        saveGame.add(new Player(rightHand, leftHand, rightHand2, leftHand2, turn1, turn2));
    }



}
