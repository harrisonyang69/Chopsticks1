package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Player {
    //create integers to hold values for each Player's hands
    public static int rightHand;
    public static int leftHand;
    public static int rightHand2;
    public static int leftHand2;
    //create integers to hold number of turns each player has taken
    public static int turn1;
    public static int turn2;


    //constructor with the integer fields as parameters
    Player(int rightHand, int leftHand, int rightHand2, int leftHand2, int turn1, int turn2){
        this.rightHand = rightHand;
        this.leftHand = leftHand;
        this.rightHand2 = rightHand2;
        this.leftHand2 = leftHand2;
        this.turn1 = turn1;
        this.turn2 = turn2;
    }

    //method to write fields into an external textFile
    public static void write(String fileName) throws IOException{
        //create fileWriter and make it write to the file passed in as the parameter
        FileWriter fw = new FileWriter(fileName);
        //create bufferedWriter and attach it to the fileWriter
        BufferedWriter bw = new BufferedWriter(fw);
        //write the integer fields (I used a different symbol at the end of each field so I can load/create in CreateSaveGame class
        bw.write(leftHand + ",\r");
        bw.write(rightHand + ".\r");
        bw.write(leftHand2 + ";\r");
        bw.write(rightHand2 + "/\r");
        bw.write(turn1 + ":\r");
        bw.write(turn2 + ">\r");
        //write a string to distinguish each save game and allow methods in CreateSaveGame to find the ending of each save
        bw.write("End of save game.");
        //close bufferedWriter
        bw.close();
    }



}
