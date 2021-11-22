/*
 * Copyright (c) cocomine 2021.
 */

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 * Detect input
 */
public class DetectInput {
    private final Scanner scanner;

    /**
     * Default setup
     */
    public DetectInput() {
        scanner = new Scanner(System.in); //Prepare scanner
    }

    /**
     * Custom setup
     * @param scanner_obj Scanner object
     */
    public DetectInput(Scanner scanner_obj) {
        scanner = scanner_obj; //Prepare scanner
    }

    /**
     * 取得輸入
     * @param call Host call
     * @return Number return
     */
    public int getInput(List<Integer> call) {
        int in = 0;
        do {
            System.out.print("Game Host call (0 to exit): ");
            if(scanner.hasNextInt()){ //Check if it is a number
                in = scanner.nextInt();
                //System.out.println();

                /* 檢查 */
                if (call.contains(in)) System.out.println("The number " + in + " is repeated, please call again!"); //Repeating numbers
                if (in == 0) System.exit(0); //Exit the program
                if (in < 1 || in >25) System.out.println("The number must be between 1 to 25, please call again!"); //Restricted range
            }else{
                System.out.println("\nThe \""+scanner.nextLine()+"\" is not number, please call again!");
            }
        } while (in < 1 || in >25 || call.contains(in)); //Check whether to exit the loop
        System.out.println(); //next Line
        return in;
    }
}

