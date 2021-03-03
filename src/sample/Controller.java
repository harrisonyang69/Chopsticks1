package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public Button buttonStartGame;
    public Button buttonLeftHit;
    public Button buttonRightHit;
    public Button buttonRightCombine;
    public Button buttonLeftCombine;
    public Button buttonLeftHit2;
    public Button buttonRightHit2;
    public Button buttonRightCombine2;
    public Button buttonLeftCombine2;
    public Button buttonSaveScores;
    public Button buttonLoadGame;
    public Tab user1Choice;
    public Tab user2Choice;
    public Button buttonPrintHands;
    Player player = new Player(1, 1, 1, 1, 0, 0);
    Scanner scan = new Scanner(System.in);

    public void startGame(MouseEvent mouseEvent) {
        buttonSaveScores.setDisable(false);
        buttonStartGame.setDisable(true);
        user1Choice.setDisable(false);
        buttonLeftHit.setDisable(false);
        buttonRightHit.setDisable(false);
        buttonLeftCombine.setDisable(false);
        buttonRightCombine.setDisable(false);
        user2Choice.setDisable(false);
        buttonLeftHit2.setDisable(true);
        buttonRightHit2.setDisable(true);
        buttonRightCombine2.setDisable(true);
        buttonLeftCombine2.setDisable(true);
    }

    public void leftHit(MouseEvent mouseEvent) {
        System.out.println("\nInput 'right' if you want to hit Player 2's left hand with right hand or 'left' if you want to hit with your left hand.");
        String handChoice1 = scan.next();
        if(handChoice1.equals("right")){
            Player.leftHand2 += Player.rightHand;
        }else if(handChoice1.equals("left")){
            Player.leftHand2 += Player.leftHand;
        }
        if(Player.leftHand2 >= 5){
            System.out.println("Player 1 wins! Navigate to Main Menu to start again.");
            buttonStartGame.setDisable(false);
            buttonSaveScores.setDisable(true);
            Player.leftHand = 1;
            Player.rightHand = 1;
            Player.leftHand2 = 1;
            Player.rightHand2 = 1;
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonRightCombine2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            user1Choice.setDisable(true);
            user2Choice.setDisable(true);
        }else {
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(false);
            buttonRightHit2.setDisable(false);
            buttonRightCombine2.setDisable(false);
            buttonLeftCombine2.setDisable(false);
            Player.turn1++;
        }
    }

    public void rightHit(MouseEvent mouseEvent) {
        System.out.println("\nInput 'right' if you want to hit Player 2's right hand with your right hand or 'left' if you want to hit with left hand.");
        String handChoice1 = scan.next();
        if(handChoice1.equals("right")){
            Player.rightHand2 += Player.rightHand;
        }else if(handChoice1.equals("left")){
            Player.rightHand2 += Player.leftHand;
        }
        if(Player.rightHand2 >= 5){
            System.out.println("Player 1 wins! Navigate to Main Menu to start again.");
            buttonStartGame.setDisable(false);
            buttonSaveScores.setDisable(true);
            Player.leftHand = 1;
            Player.rightHand = 1;
            Player.leftHand2 = 1;
            Player.rightHand2 = 1;
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonRightCombine2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            user1Choice.setDisable(true);
            user2Choice.setDisable(true);
        }else {
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(false);
            buttonRightHit2.setDisable(false);
            buttonRightCombine2.setDisable(false);
            buttonLeftCombine2.setDisable(false);
            Player.turn1++;
        }
    }

    public void rightCombine(MouseEvent mouseEvent) {
        System.out.println("\nHow many do you want to move to the right hand?");
        int combineChoice1 = scan.nextInt();
        Player.rightHand += combineChoice1;
        if(Player.rightHand >= 5){
            System.out.println("\nYou cannot do that because your right hand will exceed 5! Select another move from the window.");
            Player.rightHand -= combineChoice1;
        }else if(Player.leftHand - combineChoice1 < 0){
            System.out.println("You cannot do that because your left hand does not have enough points! Select another move from the window.");
            Player.rightHand -= combineChoice1;
        }else{
            Player.leftHand -= combineChoice1;
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(false);
            buttonRightHit2.setDisable(false);
            buttonRightCombine2.setDisable(false);
            buttonLeftCombine2.setDisable(false);
            Player.turn1++;
        }
    }

    public void leftCombine(MouseEvent mouseEvent) {
        System.out.println("\nHow many do you want to move to the left hand?");
        int combineChoice1 = scan.nextInt();
        Player.leftHand += combineChoice1;
        if(Player.leftHand >= 5){
            System.out.println("\nYou cannot do that as your left hand will exceed 5! Select another move from te window.");
            Player.leftHand -= combineChoice1;
        }else if(Player.rightHand - combineChoice1 < 0){
            System.out.println("You cannot do that because your right hand does not have enough points! Select another move from the window.");
            Player.rightHand -= combineChoice1;
        }else{
            Player.rightHand -= combineChoice1;
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(false);
            buttonRightHit2.setDisable(false);
            buttonRightCombine2.setDisable(false);
            buttonLeftCombine2.setDisable(false);
            Player.turn1++;
        }
    }

    public void printHands(MouseEvent mouseEvent) {
        System.out.print("\nPlayer 1 Left: " + Player.leftHand);
        System.out.print("\tPlayer 1 Right: " + Player.rightHand);
        System.out.print("\nPlayer 2 Left: " + Player.leftHand2);
        System.out.print("\tPlayer 2 Right: " + Player.rightHand2);
    }

    public void printInstructions(MouseEvent mouseEvent) {
        System.out.println("In chopsticks, 2 players start by holding out their hands with one finger (usually their index) out on each hand.");
        System.out.println("The players' hands are opposite to each other, and player 1 begins by either hitting either one of the other player's");
        System.out.println("fingers or combining the values on each of his/her finger onto one chosen finger. Player 2 does the same, and the game");
        System.out.println("continues until one of the players' hands exceed 5.");
    }

    public void leftHit2(MouseEvent mouseEvent) {
        System.out.println("\nInput 'right' if you want to hit Player 1's left hand with right hand or 'left' if you want to hit with your left hand.");
        String handChoice2 = scan.next();
        if(handChoice2.equals("right")){
            Player.leftHand += Player.rightHand2;
        }else if(handChoice2.equals("left")){
            Player.leftHand += Player.leftHand2;
        }
        if(Player.leftHand >= 5){
            System.out.println("Player 2 wins! Navigate to Main Menu to start again.");
            buttonStartGame.setDisable(false);
            buttonSaveScores.setDisable(true);
            Player.leftHand = 1;
            Player.rightHand = 1;
            Player.leftHand2 = 1;
            Player.rightHand2 = 1;
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonRightCombine2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            user1Choice.setDisable(true);
            user2Choice.setDisable(true);
        }else {
            buttonLeftHit.setDisable(false);
            buttonRightHit.setDisable(false);
            buttonRightCombine.setDisable(false);
            buttonLeftCombine.setDisable(false);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonRightCombine2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            Player.turn2++;
        }
    }

    public void rightHit2(MouseEvent mouseEvent) {
        System.out.println("\nInput 'right' if you want to hit Player 1's right hand with your right hand or 'left' if you want to hit with left hand.");
        String handChoice2 = scan.next();
        if(handChoice2.equals("right")){
            Player.rightHand += Player.rightHand2;
        }else if(handChoice2.equals("left")){
            Player.rightHand += Player.leftHand2;
        }
        if(Player.rightHand >= 5){
            System.out.println("Player 1 wins! Navigate to Main Menu to start again.");
            buttonStartGame.setDisable(false);
            buttonSaveScores.setDisable(true);
            Player.leftHand = 1;
            Player.rightHand = 1;
            Player.leftHand2 = 1;
            Player.rightHand2 = 1;
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonRightCombine2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            user1Choice.setDisable(true);
            user2Choice.setDisable(true);
        }else {
            buttonLeftHit.setDisable(false);
            buttonRightHit.setDisable(false);
            buttonRightCombine.setDisable(false);
            buttonLeftCombine.setDisable(false);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonRightCombine2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            Player.turn2++;
        }
    }

    public void rightCombine2(MouseEvent mouseEvent) {
        System.out.println("\nHow many do you want to move to the right hand?");
        int combineChoice2 = scan.nextInt();
        Player.rightHand2 += combineChoice2;
        if(Player.rightHand2 >= 5){
            System.out.println("\nYou cannot do that as your right hand will exceed 5! Select another move from the window.");
            Player.rightHand2 -= combineChoice2;
        }else if(Player.leftHand - combineChoice2 < 0){
            System.out.println("You cannot do that because your left hand does not have enough points! Select another move from the window.");
            Player.rightHand -= combineChoice2;
        }else{
            Player.leftHand2 -= combineChoice2;
            buttonLeftHit.setDisable(false);
            buttonRightHit.setDisable(false);
            buttonRightCombine.setDisable(false);
            buttonLeftCombine.setDisable(false);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonRightCombine2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            Player.turn2++;
        }
    }

    public void leftCombine2(MouseEvent mouseEvent) {
        System.out.println("\nHow many do you want to move to the right hand?");
        int combineChoice2 = scan.nextInt();
        Player.leftHand2 += combineChoice2;
        if(Player.leftHand2 >= 5){
            System.out.println("\nYou cannot do that as your left hand will exceed 5! Select another move from the window.");
            Player.leftHand2 -= combineChoice2;
        }else if(Player.rightHand - combineChoice2 < 0){
            System.out.println("You cannot do that because your left hand does not have enough points! Select another move from the window.");
            Player.leftHand -= combineChoice2;
        }else{
            Player.rightHand2 -= combineChoice2;
            buttonLeftHit.setDisable(false);
            buttonRightHit.setDisable(false);
            buttonRightCombine.setDisable(false);
            buttonLeftCombine.setDisable(false);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonRightCombine2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            Player.turn2++;
        }
    }

    public void saveScores(MouseEvent mouseEvent) throws IOException{
        System.out.println("\nAre you sure you want to save the hand scores? 'Yes' or 'No'.");
        String saveChoice = scan.next();
        if(saveChoice.equals("Yes")){
            System.out.println("Name the file you want the save to be called.");
            String saveChoice2 = scan.next();
            Player.write(saveChoice2);
            buttonLoadGame.setDisable(false);
        }else if(saveChoice.equals("No")){
            System.out.println("Please select Start Game to begin the game, or Save Game to try to save again.");
        }
    }

    public void loadGame(MouseEvent mouseEvent) throws IOException{
        System.out.println("\nWhat is the name of the save game?");
        String loadChoice = scan.next();
        ArrayList<Player> saveGame = CreateSaveGame.createSaveGame(loadChoice);
        buttonStartGame.setDisable(true);
        buttonSaveScores.setDisable(false);
        if(Player.turn2 > Player.turn1){
            user1Choice.setDisable(false);
            user2Choice.setDisable(false);
            buttonLeftHit.setDisable(false);
            buttonRightHit.setDisable(false);
            buttonLeftCombine.setDisable(false);
            buttonRightCombine.setDisable(false);
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            buttonRightCombine2.setDisable(true);
        }else if(Player.turn1 > Player.turn2){
            user2Choice.setDisable(false);
            user1Choice.setDisable(false);
            buttonLeftHit2.setDisable(false);
            buttonRightHit2.setDisable(false);
            buttonLeftCombine2.setDisable(false);
            buttonRightCombine2.setDisable(false);
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonRightCombine.setDisable(true);
        }
    }

}
