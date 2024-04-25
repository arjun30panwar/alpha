package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * 
 * This is the comparator class used to compare
 * by the engagement rate
 * 
 * A comparator which compares by engagement rates
 * 
 * 
 * @author Arjun Panwar
 * @version Apr 17, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class CompareByEngagement implements Comparator<User> {
    // ~ Fields ................................................................
    private int quarter;
    private String month;
    private boolean alpha;
    

    // ~ Constructors ..........................................................

    /**
     * Creates a new compareByEngagement comparator object
     * 
     * @param quarter
     *            int the quarter for which you wish to compare engagements
     */
    public CompareByEngagement(int quarter) {

        this.quarter = quarter;
        alpha = true;
    }
    public CompareByEngagement(String month) 
    {
        this.month = month;
        alpha = false;
    }


    // ~Public Methods ........................................................
    /**
     * This is the main method used to compare
     * reach engagement of two users
     * 
     * @param user1
     *            represent the first user
     * @param user2
     *            represent the second user
     * @return int negative if user1 is less, positive if it's more, 0 if
     *         they are equal
     */
    public int compare(User user1, User user2) {
        
        double engagement1 = 0;
        double engagement2 = 0;
        if(alpha) {
        engagement1 = user1.calculateReachEngagement(quarter);
        engagement2 = user2.calculateReachEngagement(quarter);
        }
        else 
        {
            engagement1 = user1.calculateReachEngagement(month);
            engagement2 = user2.calculateReachEngagement(month);
        }

        return Double.compare(engagement1, engagement2);
    }

}
