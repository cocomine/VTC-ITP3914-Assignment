/*
 * Copyright (c) cocomine 2021.
 */

import java.util.ArrayList;

public class Card_MG {

    private final int[][][] Players;

    /**
     * Setup player's card
     * @param Player
     */
    public Card_MG(int[][]... Player) {
        Players = Player;
    }

    /**
     * Show player card
     *
     * @param call Host call array
     */
    public void ShowCard(ArrayList<Integer> call) {

        /* Show All Player card */
        for (int n = 0; n < Players.length; n++) {
            System.out.println("Player" + (n + 1) + "'s Card:"); //print name
            printCard(Players[n], call); //print
            System.out.println(); //next Line
        }
    }

    /**
     * Check BingGo
     *
     * @param call     Host call array
     * @param callback Callback which player BingGo
     * @return is BingGo?
     */
    public boolean CheckBingGo(ArrayList<Integer> call, PlayerBingGo_Callback callback) {
        boolean bingGo = false;

        /* Check All Player */
        for (int n = 0; n < Players.length; n++) {
            if (CheckCard(Players[n], call)) {
                bingGo = true; //is BingGo
                callback.printWhoBingGo("Player" + (n + 1)); //callback is who BingGo
            }
        }

        return bingGo; //return is BingGo?
    }

    /**
     * Check Player card
     *
     * @param card Player card
     * @param call Host call array
     * @return is BingGo?
     */
    private boolean CheckCard(int[][] card, ArrayList<Integer> call) {
        /* row check -- */
        for (int[] rows : card) { //get rows of card
            int correct = 0;
            for (int cols : rows) { //get columns of card
                if (call.contains(cols)) {
                    correct++; //Add one if correct
                }
            }
            if (correct >= rows.length) { //Such as row all pairs
                return true;
            }
        }

        /* col check || */
        for (int col = 0; col < card[0].length; col++) { //get columns of card
            int correct = 0;
            for (int[] rows : card) { //get rows of card
                if (call.contains(rows[col])) {
                    correct++; //Add one if correct
                }
            }
            if (correct >= card[0].length) { //Such as col all pairs
                return true;
            }
        }

        /* Right oblique check \\ */
        int Right_correct = 0;
        for (int i = 0; i < card.length; i++) {
            if (call.contains(card[i][i])) {
                Right_correct++; //Add one if correct
            }
        }
        if (Right_correct >= card.length) { //Such as right diagonal all right
            return true;
        }

        /* Left oblique check // */
        int Left_correct = 0;
        for (int i = card.length - 1; i >= 0; i--) {
            if (call.contains(card[i][card.length - i - 1])) {
                Left_correct++; //Add one if correct
            }
        }
        //If the left oblique is all right, otherwise it will output false
        return Left_correct >= card.length;
    }

    /**
     * Print card to console
     *
     * @param card Player card
     * @param call Host call array
     */
    private void printCard(int[][] card, ArrayList<Integer> call) {
        for (int[] rows : card) { //get rows of card
            for (int cols : rows) { //get columns of card
                if (call.contains(cols)) { //If it matches, hit xx
                    if (call.get(call.size() - 1) == cols) { //Current input is highlighted
                        System.out.printf(" %2s ", "XX");
                    } else {
                        System.out.printf(" %2s ", "XX"); //bing
                    }
                } else {
                    System.out.printf(" %2s ", cols); //Output number
                }
            }
            System.out.println(); //nextline
        }
    }
}