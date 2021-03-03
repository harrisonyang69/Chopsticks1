package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Player {
    public static int rightHand;
    public static int leftHand;
    public static int rightHand2;
    public static int leftHand2;
    public static int turn1;
    public static int turn2;


    Player(int rightHand, int leftHand, int rightHand2, int leftHand2, int turn1, int turn2){
        this.rightHand = rightHand;
        this.leftHand = leftHand;
        this.rightHand2 = rightHand2;
        this.leftHand2 = leftHand2;
        this.turn1 = turn1;
        this.turn2 = turn2;
    }

    public static void write(String fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(rightHand + ",\r");
        bw.write(leftHand + ".\r");
        bw.write(rightHand2 + ";\r");
        bw.write(leftHand2 + "/\r");
        bw.write(turn1 + ":\r");
        bw.write(turn2 + ">\r");
        bw.write("End of save game.");
        bw.close();
    }


}
