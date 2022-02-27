/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 02/26/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW6 - LifeGUI
 * Description: Calculates John Conway's Game of Life and prints GUI
 * Grade Level: Challenge
 */

package Life;

import java.util.ArrayList;

/**
 * lifeGen class is the central game engine, containing the user interface
 * and calls the game methods
 *
 * @author Tiana Noll-Walker
 * @author Elisha Phillips
 */
public class lifeGen {

    // Instantiates game classes
    private lifeBoard life = new lifeBoard();
    private lifePrint print = new lifePrint();

    // Default for minimum grid size
    private int minSize = 19;

    /**
     * Starts the game, and obtains user params for grid size and
     * number of generations to print
     *
     */
    public void initiateGame() {
        // Game headers
        System.out.println("Conway's Game of Life");
        System.out.println("\n");

        // User input request for grid size
        System.out.println("\nWhat size would you like the board to be?");
        System.out.println("Minimum size is " + minSize + ": \n");
        // Method for user input
        int size = print.input(minSize - 1);

        // Method to run game with user-defined parameters
        runGame(size);
    }

    /**
     * Calculates and prints successive generations of the game board
     *
     * @param gen  integer value determines number of generations to calculate
     *
     * @param size integer value determines height and width of square array
     *             shape: (size, size)
     *
     */
    public void runGame(int size) {

        ArrayList<int[][]> gridList = new ArrayList<int[][]>();

        // Method to generate initial grid and add to gridList
        gridList.add(life.Step(life.generateStartingBoard(size)));

        //prints the grid
        print.GUI(gridList);
    }
}