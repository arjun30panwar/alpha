package prj5;

import java.io.FileNotFoundException;
import java.io.IOException;

// -------------------------------------------------------------------------
/**
 * Runs the project
 * 
 * @author Arjun Panwar(arjunpanwar), Prakhar Modi(prakharmodi)
 * @version Apr 15, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class ProjectRunner {
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    public static void main(String[] args) throws IOException {
        InputFileReader filer;
        boolean showConsole = false;
        boolean showGUI = true;
        if (args.length > 0) {
            filer = new InputFileReader(args[0]);
        }
        else {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }
        LinkedData<User> usersList = filer.getUsers();
        usersList.insertionSort(usersList, new CompareByName());

        LinkedData<User> sortedByEngagement = new LinkedData<User>();

        for (int i = 0; i < usersList.getNumberOfEntries(); i++) {
            sortedByEngagement.addBack(usersList.getData(i));
        }
        sortedByEngagement.insertionSort(sortedByEngagement,
            new CompareByEngagement(1));
        if (showConsole) {

            System.out.println(usersList.toString());
            System.out.println(sortedByEngagement.toString2());
            /*
             * TODO: For intermediate Submission - Should print the data on the
             * console
             */
        }
        if (showGUI) {
            
            
            ProjectGUI gui = new ProjectGUI();
            
            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
        }
    }
}
