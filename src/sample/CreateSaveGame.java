package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateSaveGame {
    //same fields as Player class
    private static int rightHand;
    private static int leftHand;
    private static int rightHand2;
    private static int leftHand2;
    private static int turn1;
    private static int turn2;
    //import fileReader and bufferedReader
    private static FileReader fr;
    private static BufferedReader br;
    //arraylist to hold the save game
    private static ArrayList<Player> saveGame = new ArrayList<>();

    //method to load game
    //takes in a file to load game
    public static ArrayList createSaveGame(String file) throws IOException {
        //initialize fileReader and bufferedReader
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String line;
        String handValues = "";
        //while String line does not get to the end of the line, and line does not equal "End of save game" add line to handValues
        while ((line = br.readLine()) != null) {
            if (!line.equals("End of save game.")) {
                handValues += line;
            //otherwise parse String handValues and set it back to ""
            } else {
                parse(handValues);
                handValues = "";
            }
        }
        //return arraylist saveGame
        return saveGame;
    }

    //method to add the integer fields to the arraylist
    private static void parse(String handValues) {
        //initialize all the integer fields
        int pos = 0, pos2 = 0, pos3 = 0, pos4 = 0, pos5 = 0, pos6 = 0;
        int rightHand = 1, leftHand = 1, rightHand2 = 1, leftHand2 = 1;
        int turn1 = 0, turn2 = 0;
        //while int x is less than the length of handValues
        for (int x = 0; x < handValues.length(); x++) {
            //if the substring x, x+1 equals ',', leftHand equals substring from 0 to x
            //this is because at the end of the write method I put a comma behind the leftHand value
            if (handValues.substring(x, x + 1).equals(",")) {
                pos = x;
                leftHand = Integer.parseInt(handValues.substring(0, pos));
            }
            //if substring x, x+1 equals '.' rightHand equals substring from pos+1 to pos2
            //in the write method in Player.java, I put a period after rightHand
            if (handValues.substring(x, x + 1).equals(".")) {
                pos2 = x;
                rightHand = Integer.parseInt(handValues.substring(pos+1, pos2));
            }
            //if substring x, x+1 equals ';', the substring from pos2+1 to pos3 equals leftHand2
            //similar to the first two if statements, I put the corresponding symbol from the write method here so I could match up the values from the external text file
            //the case is the same for the following if statements: the symbols for each pos are the same symbols I wrote with the BufferedWriter in the write method
            if (handValues.substring(x, x + 1).equals(";")) {
                pos3 = x;
                leftHand2 = Integer.parseInt(handValues.substring(pos2+1,pos3));
            }
            if(handValues.substring(x, x + 1).equals("/")) {
                pos4 = x;
                rightHand2 = Integer.parseInt(handValues.substring(pos3+1, pos4));
            }
            if(handValues.substring(x, x + 1).equals(":")) {
                pos5 = x;
                turn1 = Integer.parseInt(handValues.substring(pos4+1, pos5));
            }
            if(handValues.substring(x, x + 1).equals(">")) {
                pos6 = x;
                turn2 = Integer.parseInt(handValues.substring(pos5+1, pos6));
            }
        }
        //add all of these values to the saveGame arraylist
        saveGame.add(new Player(leftHand, rightHand, leftHand2, rightHand2, turn1, turn2));
    }



}
