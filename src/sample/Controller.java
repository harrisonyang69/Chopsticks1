package sample;

//import the required javafx controls
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    //buttons that users can press to play the game
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
    //3 tabs are needed- main menu, user 1's choice, and user 2's choice
    public Tab user1Choice;
    public Tab user2Choice;
    public Button buttonPrintHands;
    //create new Player object and give the parameters the starting values of 1 and 0
    //turn1 and turn2 are integers to track how many turns each Player has took; this allows the load method to determine which Player gets to take the turn first
    Player player = new Player(1, 1, 1, 1, 0, 0);
    //create scanner to get user input
    Scanner scan = new Scanner(System.in);

    //method that starts the game by disabling all the user 2 choice buttons and enabling the user 1 choice buttons
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


    //method that allows user to hit the opponent's left hand with the selected hand
    public void leftHit(){
        System.out.println("\nInput 'right' if you want to hit Player 2's left hand with right hand or 'left' if you want to hit with your left hand.");
        //use scanner to get user input
        String handChoice1 = scan.next();
        //use an if else statement to determine which hand Player 1 hits with
        if(handChoice1.equals("right")){
            Player.leftHand2 += Player.rightHand;
            //if Player 2's hand exceeds 5, Player 1 wins. Reset the game by setting left and right hands to their original values and disabling user choice buttons
            if(Player.leftHand2 >= 5){
                System.out.println("Player 1 wins! Navigate to Main Menu to start again.");
                //allow Players to start the game again
                buttonStartGame.setDisable(false);
                //game has not started so disable save scores button
                buttonSaveScores.setDisable(true);
                //revert hands to original values
                Player.leftHand = 1;
                Player.rightHand = 1;
                Player.leftHand2 = 1;
                Player.rightHand2 = 1;
                //disable user moves
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
            }else if(Player.leftHand2 < 5) {
                //if Player 2's hand does not exceed 5 continue playing. Disables Player 1's button choices to allow Player 2 to move.
                buttonLeftHit.setDisable(true);
                buttonRightHit.setDisable(true);
                buttonRightCombine.setDisable(true);
                buttonLeftCombine.setDisable(true);
                buttonLeftHit2.setDisable(false);
                buttonRightHit2.setDisable(false);
                buttonRightCombine2.setDisable(false);
                buttonLeftCombine2.setDisable(false);
                //Document that Player 1 took a turn by adding 1 to int turn1
                Player.turn1++;
            }
        }else if(handChoice1.equals("left")){
            Player.leftHand2 += Player.leftHand;
            //if Player 2's hand exceeds 5, Player 1 wins. Reset the game by setting left and right hands to their original values and disabling user choice buttons
            if(Player.leftHand2 >= 5){
                System.out.println("Player 1 wins! Navigate to Main Menu to start again.");
                //allow Players to start the game again
                buttonStartGame.setDisable(false);
                //game has not started so disable save scores button
                buttonSaveScores.setDisable(true);
                //revert hands to original values
                Player.leftHand = 1;
                Player.rightHand = 1;
                Player.leftHand2 = 1;
                Player.rightHand2 = 1;
                //disable user moves
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
            }else if(Player.leftHand2 < 5) {
                //if Player 2's hand does not exceed 5 continue playing. Disables Player 1's button choices to allow Player 2 to move.
                buttonLeftHit.setDisable(true);
                buttonRightHit.setDisable(true);
                buttonRightCombine.setDisable(true);
                buttonLeftCombine.setDisable(true);
                buttonLeftHit2.setDisable(false);
                buttonRightHit2.setDisable(false);
                buttonRightCombine2.setDisable(false);
                buttonLeftCombine2.setDisable(false);
                //Document that Player 1 took a turn by adding 1 to int turn1
                Player.turn1++;
            }
        }else{
            System.out.println("Choose another move.");
        }
    }


    //method to call left hit method when user presses the button in the GUI
    public void buttonLeftHit(MouseEvent mouseEvent) {
        leftHit();
    }


    //method that hits Player 2's right hand with the hand Player 1 selects
    public void rightHit() {
        //code is the same as previous method leftHit
        System.out.println("\nInput 'right' if you want to hit Player 2's right hand with your right hand or 'left' if you want to hit with left hand.");
        String handChoice1 = scan.next();
        if(handChoice1.equals("right")){
            Player.rightHand2 += Player.rightHand;
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
                //document Player 1 took a turn by adding 1 to turn1
                Player.turn1++;
            }
        }else if(handChoice1.equals("left")){
            Player.rightHand2 += Player.leftHand;
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
            }else{
                buttonLeftHit.setDisable(true);
                buttonRightHit.setDisable(true);
                buttonRightCombine.setDisable(true);
                buttonLeftCombine.setDisable(true);
                buttonLeftHit2.setDisable(false);
                buttonRightHit2.setDisable(false);
                buttonRightCombine2.setDisable(false);
                buttonLeftCombine2.setDisable(false);
                //document Player 1 took a turn by adding 1 to turn1
                Player.turn1++;
            }
        }else{
            System.out.println("Choose another move.");
        }
    }

    //method to call right hit method when user presses the button
    public void buttonRightHit(MouseEvent mouseEvent){
        rightHit();
    }

    //method that moves allows Player 1 to move a certain number of points to their left hand
    public void leftCombine() {
        System.out.println("\nHow many do you want to move to the left hand?");
        //scan for the next integer
        int combineChoice1 = scan.nextInt();
        //add the number of points to Player 1's left hand
        Player.leftHand += combineChoice1;
        Player.rightHand -= combineChoice1;
        //if Player 1's left hand exceeds 5 after adding return the left hand to the original value
        if(Player.leftHand >= 5){
            System.out.println("\nYou cannot do that as your left hand will exceed 5! Select another move from te window.");
            Player.leftHand -= combineChoice1;
            Player.rightHand += combineChoice1;
        //if Player 1's right hand does not have enough points return left hand to former value
        }else if(Player.rightHand < 0){
            System.out.println("You cannot do that because your right hand does not have enough points! Select another move from the window.");
            Player.leftHand -= combineChoice1;
            Player.rightHand += combineChoice1;
        }else{
            //since Player 1 has made a move, disable all user 1's buttons and enable user 2's buttons
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(false);
            buttonRightHit2.setDisable(false);
            buttonRightCombine2.setDisable(false);
            buttonLeftCombine2.setDisable(false);
            //document Player 1 has taken a turn by adding 1 to turn1
            Player.turn1++;
        }
    }

    //method to call left combine method when mouse pressed
    public void buttonLeftCombine(MouseEvent mouseEvent){
        leftCombine();
    }

    //method that enables Player 1 to move a specific amount of points to his/her right hand
    public void rightCombine() {
        //same code as leftCombine
        System.out.println("\nHow many do you want to move to the right hand?");
        int combineChoice1 = scan.nextInt();
        Player.rightHand += combineChoice1;
        Player.leftHand -= combineChoice1;
        if(Player.rightHand >= 5){
            System.out.println("\nYou cannot do that because your right hand will exceed 5! Select another move from the window.");
            Player.rightHand -= combineChoice1;
            Player.leftHand += combineChoice1;
        }else if(Player.leftHand < 0){
            System.out.println("You cannot do that because your left hand does not have enough points! Select another move from the window.");
            Player.rightHand -= combineChoice1;
            Player.leftHand += combineChoice1;
        }else{
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonRightCombine.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonLeftHit2.setDisable(false);
            buttonRightHit2.setDisable(false);
            buttonRightCombine2.setDisable(false);
            buttonLeftCombine2.setDisable(false);
            //add 1 to turn1 to show Player 1 has taken a turn
            Player.turn1++;
        }
    }

    //method to call Right Combine method when pressed
    public void buttonRightCombine(MouseEvent mouseEvent){
        rightCombine();
    }

    //method to print out the currents hands if the users wish to
    public void printHands(MouseEvent mouseEvent) {
        System.out.print("\nPlayer 1 Left: " + Player.leftHand);
        System.out.print("\tPlayer 1 Right: " + Player.rightHand);
        System.out.print("\nPlayer 2 Left: " + Player.leftHand2);
        System.out.print("\tPlayer 2 Right: " + Player.rightHand2);
    }

    //if users do not know how to play, print instructions to show how to play
    public void printInstructions(MouseEvent mouseEvent) {
        System.out.println("\nIn chopsticks, 2 players start by holding out their hands with one finger (usually their index) out on each hand.");
        System.out.println("The players' hands are opposite to each other, and player 1 begins by either hitting either one of the other player's");
        System.out.println("fingers or combining the values on each of his/her finger onto one chosen finger. Player 2 does the same, and the game");
        System.out.println("continues until one of the players' hands exceed 5. The possible moves are left hit, which hits the other player's left");
        System.out.println("hand, right hit, which hits the other player's right hand, left combine, which moves a certain number of points onto the");
        System.out.println("player's left hand. and right combine, which moves a specific amount of points to the player's right hand.");
    }

    //same method as leftHit but for Player 2
    public void leftHit2() {
        System.out.println("\nInput 'right' if you want to hit Player 1's left hand with right hand or 'left' if you want to hit with your left hand.");
        //since this is Player 2, I changed the String to handChoice2 instead of handChoice 1
        String handChoice2 = scan.next();
        if(handChoice2.equals("right")){
            Player.leftHand += Player.rightHand2;
            //if Player 1's left hand exceeds 5
            if(Player.leftHand >= 5){
                System.out.println("Player 2 wins! Navigate to Main Menu to start again.");
                //enable button StartGame so players can start the game again
                buttonStartGame.setDisable(false);
                //disable button Save Scores because game has ended and there are currently no scores for the hands
                buttonSaveScores.setDisable(true);
                //set hands to starting values
                Player.leftHand = 1;
                Player.rightHand = 1;
                Player.leftHand2 = 1;
                Player.rightHand2 = 1;
                //disable all the user 1 and user 2 moves
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
            }else{
                //if Player 1's left hand does not exceed or equal 5 continue playing by disabling Player 2's buttons and enabling Player 1's buttons
                buttonLeftHit.setDisable(false);
                buttonRightHit.setDisable(false);
                buttonRightCombine.setDisable(false);
                buttonLeftCombine.setDisable(false);
                buttonLeftHit2.setDisable(true);
                buttonRightHit2.setDisable(true);
                buttonRightCombine2.setDisable(true);
                buttonLeftCombine2.setDisable(true);
                //document that Player 2 has taken a turn by adding 1 to turn2
                Player.turn2++;
            }
        }else if(handChoice2.equals("left")){
            Player.leftHand += Player.leftHand2;
            //if Player 1's left hand exceeds 5
            if(Player.leftHand >= 5){
                System.out.println("Player 2 wins! Navigate to Main Menu to start again.");
                //enable button StartGame so players can start the game again
                buttonStartGame.setDisable(false);
                //disable button Save Scores because game has ended and there are currently no scores for the hands
                buttonSaveScores.setDisable(true);
                //set hands to starting values
                Player.leftHand = 1;
                Player.rightHand = 1;
                Player.leftHand2 = 1;
                Player.rightHand2 = 1;
                //disable all the user 1 and user 2 moves
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
            }else{
                //if Player 1's left hand does not exceed or equal 5 continue playing by disabling Player 2's buttons and enabling Player 1's buttons
                buttonLeftHit.setDisable(false);
                buttonRightHit.setDisable(false);
                buttonRightCombine.setDisable(false);
                buttonLeftCombine.setDisable(false);
                buttonLeftHit2.setDisable(true);
                buttonRightHit2.setDisable(true);
                buttonRightCombine2.setDisable(true);
                buttonLeftCombine2.setDisable(true);
                //document that Player 2 has taken a turn by adding 1 to turn2
                Player.turn2++;
            }
        }else{
            System.out.println("Choose another move.");
        }
    }

    //method to call left hit 2 method when button is pressed
    public void buttonLeftHit2(MouseEvent mouseEvent){
        leftHit2();
    }

    //same method as rightHit for Player 2
    public void rightHit2() {
        System.out.println("\nInput 'right' if you want to hit Player 1's right hand with your right hand or 'left' if you want to hit with left hand.");
        String handChoice2 = scan.next();
        if(handChoice2.equals("right")){
            Player.rightHand += Player.rightHand2;
            if(Player.rightHand >= 5){
                //same code as leftHit2
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
            }else{
                //disable Player 2's move choices and enable Player 1's
                buttonLeftHit.setDisable(false);
                buttonRightHit.setDisable(false);
                buttonRightCombine.setDisable(false);
                buttonLeftCombine.setDisable(false);
                buttonLeftHit2.setDisable(true);
                buttonRightHit2.setDisable(true);
                buttonRightCombine2.setDisable(true);
                buttonLeftCombine2.setDisable(true);
                //add 1 to turn2 to show that Player 2 has taken a turn
                Player.turn2++;
            }
        }else if(handChoice2.equals("left")){
            Player.rightHand += Player.leftHand2;
            if(Player.rightHand >= 5){
                //same code as leftHit2
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
            }else{
                //disable Player 2's move choices and enable Player 1's
                buttonLeftHit.setDisable(false);
                buttonRightHit.setDisable(false);
                buttonRightCombine.setDisable(false);
                buttonLeftCombine.setDisable(false);
                buttonLeftHit2.setDisable(true);
                buttonRightHit2.setDisable(true);
                buttonRightCombine2.setDisable(true);
                buttonLeftCombine2.setDisable(true);
                //add 1 to turn2 to show that Player 2 has taken a turn
                Player.turn2++;
            }
        }else{
            System.out.println("Choose another move.");
        }
    }

    //method that calls right hit 2 method when button is pressed
    public void buttonRightHit2(MouseEvent mouseEvent){
        rightHit2();
    }

    //method that combines Player 2's right hand onto the left hand
    public void leftCombine2() {
        //prompt user on how many points he/she wants to move
        System.out.println("\nHow many do you want to move to the right hand?");
        //scan for next integer
        int combineChoice2 = scan.nextInt();
        Player.leftHand2 += combineChoice2;
        Player.rightHand2 -= combineChoice2;
        //if else ladder to prevent user from selecting a number that makes their left hand exceed 5 or make their right hand negative
        if(Player.leftHand2 >= 5){
            System.out.println("\nYou cannot do that as your left hand will exceed 5! Select another move from the window.");
            Player.leftHand2 -= combineChoice2;
            Player.rightHand2 += combineChoice2;
        }else if(Player.rightHand < 0){
            System.out.println("You cannot do that because your left hand does not have enough points! Select another move from the window.");
            Player.leftHand2 -= combineChoice2;
            Player.rightHand2 += combineChoice2;
        }else{
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

    //method calling left combine 2 method
    public void buttonLeftCombine2(MouseEvent mouseEvent){
        leftCombine2();
    }

    //method to combine left hand onto right hand
    public void rightCombine2() {
        //same code as above method leftCombine2
        System.out.println("\nHow many do you want to move to the right hand?");
        int combineChoice2 = scan.nextInt();
        Player.rightHand2 += combineChoice2;
        Player.leftHand2 -= combineChoice2;
        if(Player.rightHand2 >= 5){
            System.out.println("\nYou cannot do that as your right hand will exceed 5! Select another move from the window.");
            Player.rightHand2 -= combineChoice2;
            Player.leftHand2 += combineChoice2;
        }else if(Player.leftHand < 0){
            System.out.println("You cannot do that because your left hand does not have enough points! Select another move from the window.");
            Player.rightHand -= combineChoice2;
            Player.leftHand2 += combineChoice2;
        }else{
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

    //call right combine 2 method when button is pressed
    public void buttonRightCombine2(MouseEvent mouseEvent){
        rightCombine2();
    }

    //method to save scores and progress
    //this method saves left hand, right hand, P2 left hand, P2 right hand, and the amount of turns each player has taken
    public void saveScores(MouseEvent mouseEvent) throws IOException{
        //ask if user is sure they want to save
        System.out.println("\nAre you sure you want to save the hand scores? 'Yes' or 'No'.");
        //scan for user input
        String saveChoice = scan.next();
        //if user wants to save, prompt them on the name of the save file
        if(saveChoice.equals("Yes")){
            System.out.println("Name the file you want the save to be called.");
            //scan again
            String saveChoice2 = scan.next();
            //call method write from Player class to write the scores into an external text file
            Player.write(saveChoice2);
            //enable load button so users can load their progress
            buttonLoadGame.setDisable(false);
            Player.turn1 = 0;
            Player.turn2 = 0;
        //if users did not want to save, tell them to begin the game, attempt to save again, or continue playing
        }else if(saveChoice.equals("No")){
            System.out.println("Please select Start Game to begin the game, Save Game to try to save again, or continue playing.");
        }
    }

    //method to load the save the users want to load
    public void loadGame(MouseEvent mouseEvent) throws IOException{
        //ask users what the name of the save is
        System.out.println("\nWhat is the name of the save game?");
        //scan for input
        String loadChoice = scan.next();
        //create arraylist of class Player that calls method createSaveGame from class CreateSaveGame to load the save the users want
        ArrayList<Player> saveGame = CreateSaveGame.createSaveGame(loadChoice);
        //since the save is only allowed when the game begins, disable start game so users can't press it again
        buttonStartGame.setDisable(true);
        //enable button SaveScores so players can save again
        buttonSaveScores.setDisable(false);
        //determine which player gets to make the first move- if turn2 is greater than turn1, Player 1 gets to move first, and vice versa
        if(Player.turn2 > Player.turn1){
            //enable user choice tabs
            user1Choice.setDisable(false);
            user2Choice.setDisable(false);
            //enable Player 1's buttons
            buttonLeftHit.setDisable(false);
            buttonRightHit.setDisable(false);
            buttonLeftCombine.setDisable(false);
            buttonRightCombine.setDisable(false);
            //disable Player 2's button choices
            buttonLeftHit2.setDisable(true);
            buttonRightHit2.setDisable(true);
            buttonLeftCombine2.setDisable(true);
            buttonRightCombine2.setDisable(true);
        }else if(Player.turn1 > Player.turn2){
            user2Choice.setDisable(false);
            user1Choice.setDisable(false);
            //if Player 1 has taken more turns than Player 2, disable Player 1's buttons and enable Player 2's buttons
            buttonLeftHit2.setDisable(false);
            buttonRightHit2.setDisable(false);
            buttonLeftCombine2.setDisable(false);
            buttonRightCombine2.setDisable(false);
            buttonLeftHit.setDisable(true);
            buttonRightHit.setDisable(true);
            buttonLeftCombine.setDisable(true);
            buttonRightCombine.setDisable(true);
        }else if(Player.turn1 == Player.turn2){
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
        }
    }


}
