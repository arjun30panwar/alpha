package prj5;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Tests the methods in the compare by engagement class
 * 
 * @author Natalie Rogers (natalier06)
 * @version Apr 18, 2024
 */

public class CompareByEngagementTest extends student.TestCase {
    // ~ Fields ................................................................

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

    // ~ Fields ................................................................

    private CompareByEngagement compare;
    private User user1;
    private User user2;
    private ArrayList<Post> posts1;
    private ArrayList<Post> posts2;

    // ~ Constructors ..........................................................
    /**
     * runs before every test
     */
    public void setUp() {
        user1 = new User("ABC");
        user2 = new User("XYZ");
        posts1 = new ArrayList<Post>();
        posts2 = new ArrayList<Post>();
        compare = new CompareByEngagement(1);
        user1.setPosts(posts1);
        user2.setPosts(posts2);

    }


    // ~Public Methods ........................................................
    /**
     * tests compare
     */
    public void testCompareGreater() {
        posts1.add(new Post("January", "ABC", 10, 20, 30, 40));
        posts1.add(new Post("February", "ABC", 10, 20, 30, 40));
        posts1.add(new Post("March", "ABC", 10, 20, 30, 40));

        posts2.add(new Post("January", "XYZ", 20, 20, 30, 40));
        posts2.add(new Post("February", "XYZ", 20, 20, 30, 40));
        posts2.add(new Post("March", "XYZ", 20, 20, 30, 40));

        double engagement1 = ((90.0 + 30.0) / 120.0) * 100;
        double engagement2 = ((90.0 + 60.0) / 120.0) * 100;

        User user3 = new User("EFG");
        ArrayList<Post> posts3 = new ArrayList<Post>();
        user3.setPosts(posts3);
        posts3.add(new Post("January", "EFG", 10, 20, 30, 40));
        posts3.add(new Post("February", "EFG", 10, 20, 30, 40));
        posts3.add(new Post("March", "EFG", 10, 20, 30, 40));

        double engagement3 = ((90.0 + 30.0) / 120.0) * 100;

        assertEquals(engagement1, user1.calculateReachEngagement(1), 0.001);
        assertEquals(engagement2, user2.calculateReachEngagement(1), 0.001);
        assertEquals(engagement3, user3.calculateReachEngagement(1), 0.001);
        assertTrue(compare.compare(user1, user2) < 0);
        assertTrue(compare.compare(user2, user1) > 0);
        assertEquals(0, compare.compare(user1, user3));
    }
}
