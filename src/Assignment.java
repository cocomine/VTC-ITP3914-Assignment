/*
 * Copyright (c) cocomine 2021.
 */

import java.util.*;

public class Assignment {
    //Player1 卡片
    public static final int[][] Player1 = {
            {24, 2, 8, 1, 25},
            {12, 16, 7, 17, 15},
            {5, 6, 20, 19, 13},
            {14, 23, 22, 4, 3},
            {10, 18, 11, 21, 9}};
    //Player2 卡片
    public static final int[][] Player2 = {
            {24, 21, 17, 15, 6},
            {10, 3, 8, 18, 20},
            {14, 7, 16, 12, 5},
            {25, 23, 13, 19, 11},
            {22, 4, 9, 1, 2}};
    private static final ArrayList<Integer> call = new ArrayList<>(); //Game Host call

    public static void main(String[] args) {
        DetectInput detectInput = new DetectInput(); //Prepare input interface
        Card_MG card_mg = new Card_MG(Player1, Player2); //Prepare game manager

        /* Override Player BingGo callback method */
        PlayerBingGo_Callback callback = player -> {
            System.out.println(player + " Bingo!"); //Output which player wins
        };

        /* Start the game */
        card_mg.ShowCard(call); //Show card
        while (true){
            call.add(detectInput.getInput(call)); //Get input numbers
            card_mg.ShowCard(call); //Show card
            if(card_mg.CheckBingGo(call, callback)){ //Check card
                System.exit(0); //BingGo exit
            }
        }
    }
}
