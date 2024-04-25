package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author arjun
 *  @version Apr 25, 2024
 */
public class CompareByTraditional implements Comparator<User> {

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
    public CompareByTraditional(int quarter) {

        this.quarter = quarter;
        alpha = true;
    }
    public CompareByTraditional(String month) 
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
        engagement1 = user1.calculateTraditionalEngagement(quarter);
        engagement2 = user2.calculateTraditionalEngagement(quarter);
        }
        else 
        {
            engagement1 = user1.calculateTraditionalEngagement(month);
            engagement2 = user2.calculateTraditionalEngagement(month);
        }

        return Double.compare(engagement1, engagement2);
    }

}
