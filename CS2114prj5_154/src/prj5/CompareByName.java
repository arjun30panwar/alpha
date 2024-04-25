package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * This is a comparator class used to compare lexicographically with name A
 * comparator which compares by channelname
 * 
 * @author Arjun Panwar
 * @version Apr 17, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class CompareByName
    implements Comparator<User>
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * This is the main method to compare two users by their name
     * 
     * @param user1
     *            represents the first user
     * @param user2
     *            represents the second users
     * @return represents the integer value
     */
    public int compare(User user1, User user2)
    {

        return user1.getChannelName()
            .compareToIgnoreCase(user2.getChannelName());

    }

}
