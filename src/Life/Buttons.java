package Life;


import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This is a simple client for the BigOval class
 */
public class Buttons extends javax.swing.JFrame
        implements java.awt.event.ActionListener {
    /**
     * The method from ActionListener
     * @param e The action that triggered this handler
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        javax.swing.JButton btn;
        btn = (javax.swing.JButton)e.getSource();
        btn.setText("Next Color");
    }

    // fields for counter
    private int genCount;
    private int length;
    // fields for the buttons
    private javax.swing.JButton nextButton;
    private javax.swing.JButton prevButton;
    //public static javax.swing.JPanel toolbar = new javax.swing.JPanel();

    private ArrayList<int[][]> gridList = new ArrayList<int[][]>();
    private lifeGUI display = new lifeGUI();

    /**
     * Create the ButtonButton
     */
    public Buttons() {

        // button for previous color, add to toolbar
        prevButton = new javax.swing.JButton("<< " + length);

        // button for next color, add to toolbar
        nextButton = new javax.swing.JButton("1 >>");

        //toolbar.add(nextButton, BorderLayout.EAST);
        //toolbar.add(prevButton, BorderLayout.WEST);

        // add action listener for previous button
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // call method to set previous dot color and update buttons
                prevGen();

            }
        });

        // add action listener for next button
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // call method to set next dot color and update buttons
                nextGen();
            }
        });


        // finally, set the window to be visible
        setVisible(true);
    }

    public void retrieveGrid(ArrayList<int[][]> l) {
        gridList = l;
        length = gridList.size();
    }


    /**
     * method to set next Generation
     */
    public void nextGen() {
        // Advance counter, loop back to zero at last value
        genCount = nextIndex(genCount);

        // update next button text
        nextButton.setText(">> " + String.valueOf(nextIndex(genCount)));
        // update previous button text
        prevButton.setText(String.valueOf(prevIndex(genCount)) + " <<");

        // Set next generation
        display.updateGridLayout(gridList.get(genCount));

    }

    /**
     * method to set previous Generation
     */
    public void prevGen() {
        // Advance counter, loop back to zero at last value
        genCount = prevIndex(genCount);

        // update next button text
        nextButton.setText(">> " + String.valueOf(nextIndex(genCount)));
        // update previous button text
        prevButton.setText(String.valueOf(genCount) + " <<");

        // Set prev generation
        display.updateGridLayout(gridList.get(genCount));
    }


    /**
     * method to get prev index
     *
     * @param Count input counter integer
     * @return next index integer
     */
    public int prevIndex(int Count) {
        int index;
        // if minimum, set index to end value
        // else, set index one step back
        if (Count == 0) {
            index = length;
        } else {
            index = Count - 1;
        }
        return index;
    }

    /**
     * method to get next index
     *
     * @param Count input counter integer
     * @return next index integer
     */
    public int nextIndex(int Count) {
        int index;
        // if minimum, set index to end value
        // else, set index one step back
        if (Count == length) {
            index = 0;
        } else {
            index = Count + 1;
        }
        return index;
    }

}