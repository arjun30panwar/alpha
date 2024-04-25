package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the methods in the user class
 * 
 * @author Natalie Rogers (natalier06)
 * @version Apr 18, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class UserTest extends TestCase {

    private User user;
    private ArrayList<Post> data;

    /**
     * runs before every test
     */
    public void setUp()

    {
        user = new User("wizardHighSchool");
        data = new ArrayList<Post>();
        data.add(new Post("January", "wizardHighSchool", 10, 20, 35, 40));
        data.add(new Post("February", "wizardHighSchool", 10, 20, 35, 40));
        data.add(new Post("March", "wizardHighSchool", 10, 25, 35, 40));
        // likes followers comments views
    }


    /**
     * Tests the constructor
     */
    public void testConstructor() {
        assertEquals("wizardHighSchool", user.getChannelName());

    }


    /**
     * Tests the set posts method
     */
    public void testSetPosts() {
        assertTrue(user.getPosts().isEmpty());
        user.setPosts(data);
        assertEquals(data, user.getPosts());
    }


    /**
     * Tests the calculate traditional engagement method with month parameter
     */
    public void testCalculateTraditionalEngagementMonth() {
        user.setPosts(data);
        assertEquals(data, user.getPosts());
        double engagement = ((10.0 + 35.0) / 20.0) * 100;

        assertEquals(engagement, user.calculateTraditionalEngagement("January"),
            0.001);

        assertEquals(engagement, user.calculateTraditionalEngagement("January"),
            0.001);

    }


    /**
     * Tests the traditional engagement method with the quarter parameter
     */
    public void testCalculateTraditionalEngagementQuarter() {
        user.setPosts(data);
        assertEquals(data, user.getPosts());
        double engagement = ((105.0 + 30.0) / 25.0) * 100.0;
        assertEquals(engagement, user.calculateTraditionalEngagement(1), 0.001);

        data.add(new Post("April", "wizardHighSchool", 15, 20, 35, 40));
        data.add(new Post("May", "wizardHighSchool", 15, 20, 35, 40));
        data.add(new Post("June", "wizardHighSchool", 15, 20, 35, 40));
        double engagement2 = ((45.0 + 105.0) / 20.0) * 100;
        assertEquals(engagement2, user.calculateTraditionalEngagement(2),
            0.001);

        data.add(new Post("July", "wizardHighSchool", 20, 20, 35, 40));
        data.add(new Post("August", "wizardHighSchool", 20, 20, 35, 40));
        data.add(new Post("September", "wizardHighSchool", 20, 20, 35, 40));
        double engagement3 = ((60.0 + 105.0) / 20.0) * 100;
        assertEquals(engagement3, user.calculateTraditionalEngagement(3),
            0.001);

        data.add(new Post("October", "wizardHighSchool", 30, 20, 35, 40));
        data.add(new Post("November", "wizardHighSchool", 10, 20, 35, 40));
        data.add(new Post("December", "wizardHighSchool", 10, 20, 35, 40));
        double engagement4 = ((50.0 + 105.0) / 20.0) * 100;
        assertEquals(engagement4, user.calculateTraditionalEngagement(4),
            0.001);

        ArrayList<Post> zero = new ArrayList<Post>();
        zero.add(new Post("January", "wizardHighSchool", 30, 0, 10, 30));
        user.setPosts(zero);
        assertEquals(-1, user.calculateTraditionalEngagement(1), 0.01);
    }


    /**
     * Tests the calculate traditional engagement method with no parameter
     */
    public void testCalculateTraditionalEngagementAll() {
        user.setPosts(data);
        assertEquals(data, user.getPosts());
        double engagement = ((105.0 + 30.0) / 25.0) * 100.0;
        assertEquals(engagement, user.calculateTraditionalEngagement(), 0.001);

        ArrayList<Post> zero = new ArrayList<Post>();
        zero.add(new Post("January", "wizardHighSchool", 30, 0, 10, 30));
        user.setPosts(zero);
        assertEquals(0.0, user.calculateTraditionalEngagement(), 0.01);
    }


    /**
     * Tests the calculate reach engagement method with a month parameter
     */
    public void testCalculateReachEngagementMonth() {
        user.setPosts(data);
        assertEquals(data, user.getPosts());
        double engagement = ((35.0 + 10.0) / 40) * 100;

        assertEquals(engagement, user.calculateReachEngagement("January"),
            0.001);

        assertEquals(engagement, user.calculateReachEngagement("January"),
            0.001);

    }


    /**
     * Tests the calculate reach engagement method with a quarter parameter
     */
    public void testCalculateReachEngagementQuarter() {
        user.setPosts(data);
        assertEquals(data, user.getPosts());
        double engagement = ((105.0 + 30.0) / 120.0) * 100;
        assertEquals(engagement, user.calculateReachEngagement(1), 0.001);

        data.add(new Post("April", "wizardHighSchool", 15, 20, 35, 40));
        data.add(new Post("May", "wizardHighSchool", 15, 20, 35, 40));
        data.add(new Post("June", "wizardHighSchool", 15, 20, 35, 40));
        double engagement2 = ((45.0 + 105.0) / 120.0) * 100;
        assertEquals(engagement2, user.calculateReachEngagement(2), 0.001);

        data.add(new Post("July", "wizardHighSchool", 20, 20, 35, 40));
        data.add(new Post("August", "wizardHighSchool", 20, 20, 35, 40));
        data.add(new Post("September", "wizardHighSchool", 20, 20, 35, 40));
        double engagement3 = ((60.0 + 105.0) / 120.0) * 100;
        assertEquals(engagement3, user.calculateReachEngagement(3), 0.001);

        data.add(new Post("October", "wizardHighSchool", 30, 20, 35, 40));
        data.add(new Post("November", "wizardHighSchool", 10, 20, 35, 40));
        data.add(new Post("December", "wizardHighSchool", 10, 20, 35, 40));
        double engagement4 = ((50.0 + 105.0) / 120.0) * 100;
        assertEquals(engagement4, user.calculateReachEngagement(4), 0.1);

        // test when views = 0

        ArrayList<Post> zero = new ArrayList<Post>();
        zero.add(new Post("January", "wizardHighSchool", 30, 20, 10, 0));
        user.setPosts(zero);
        assertEquals(-1, user.calculateReachEngagement(1), 0.01);
    }


    /**
     * Tests the calculate reach engagement method with no parameter
     */
    public void testCalculateReachEngagementAll() {
        user.setPosts(data);
        assertEquals(data, user.getPosts());
        double engagement = ((35.0 + 10.0) / 40) * 100;
        assertEquals(engagement, user.calculateReachEngagement(), 0.001);

        ArrayList<Post> zero = new ArrayList<Post>();
        zero.add(new Post("January", "wizardHighSchool", 30, 20, 10, 0));
        user.setPosts(zero);
        assertEquals(-1, user.calculateReachEngagement(), 0.01);
    }


    /**
     * tests the toString method that uses the reach engagement
     */
    public void testToStringForReach() {
        user.setPosts(data);
        assertEquals(data, user.getPosts());
        StringBuilder str = new StringBuilder();
        str.append("wizardHighSchool");
        str.append("\n");
        str.append("reach: ");
        str.append("112.5");
        str.append("\n");
        str.append("==========");
        str.append("\n");
        assertTrue(str.toString().equals(user.toStringForReach()));
    }


    /**
     * tests the toString method that uses traditional engagement
     */
    public void testToString() {
        user.setPosts(data);
        assertEquals(data, user.getPosts());
        StringBuilder str = new StringBuilder();
        str.append("wizardHighSchool");
        str.append("\n");
        str.append("traditional: ");
        str.append("540.0");
        str.append("\n");
        str.append("==========");
        str.append("\n");

        System.out.println(str.toString());
        System.out.println(user.toString());
        assertEquals(str.toString(), user.toString());
    }


    /**
     * This tests when the reach engagement cannot be calculated, test is used
     * from inputFileReader test
     */
    public void testMainFuzzyEqualsSameInputLast() throws java.io.IOException {

        ProjectRunner.main(new String[] { "SampleInput3_2023.csv" });

        String fileName = "SampleOutput3_2023.txt";

        String influencerOutput2 = "";
        Scanner fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            influencerOutput2 += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for other input files "
            + ".csv", influencerOutput2, systemOut().getHistory());

    }


    /**
     * tests the compare to method. not yet implemented
     */
    public void testCompareTo() {
        User user2 = new User("ABC");
        assertEquals(-1, user.compareTo(user2));
    }

}
