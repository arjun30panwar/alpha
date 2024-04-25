package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the methods in the post class
 * 
 * @author Prakhar Modi (prakharmodi)
 * @version Apr 18, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class PostTest extends TestCase {
    private Post post;

    /**
     * runs before every test
     */

    public void setUp() {
        post = new Post("January", "actionDan", 53821, 95800, 4129, 442422);
    }


    /**
     * tests the getters in the post class
     */

    public void testGetters() {
        assertEquals("January", post.getMonth());
        assertEquals("actionDan", post.getUserName());
        assertEquals(53821, post.getLikes());
        assertEquals(95800, post.getFollowers());
        assertEquals(4129, post.getComments());
        assertEquals(442422, post.getViews());
        post.setUserName("newName");
        assertEquals("newName", post.getUserName());

    }


    /**
     * tests the toString method
     */
    public void testToString() {
        assertEquals("January, actionDan, likes: 53821, followers: 95800, "
            + "comments: 4129, views: 442422", post.toString());
    }

}
