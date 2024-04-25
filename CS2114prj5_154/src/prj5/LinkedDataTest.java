package prj5;

import java.util.ArrayList;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the methods in the linked data class
 * 
 * 
 * 
 * @author Natalie Rogers (natalier06), Prakhar Modi (prakharmodi), Arjun
 *         Panwar(arjunpanwar)
 * @version Apr 18, 2024
 * 
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class LinkedDataTest extends TestCase {

    private LinkedData<String> list;

    /**
     * runs before every test
     */

    public void setUp() {
        list = new LinkedData<String>();

    }


    /**
     * tests the add front method
     */
    public void testAddFront() {

        assertEquals(0, list.getNumberOfEntries());
        list.addFront("STRING1");
        assertEquals(1, list.getNumberOfEntries());
        list.addFront("STRING2");
        assertEquals(2, list.getNumberOfEntries());

        assertEquals("STRING2STRING1**********\n" + "**********", list
            .toString());
    }


    /**
     * tests the add back method
     */
    public void testAddBack() {
        assertEquals(0, list.getNumberOfEntries());
        list.addBack("STRING1");
        assertEquals(1, list.getNumberOfEntries());
        list.addBack("STRING2");
        assertEquals(2, list.getNumberOfEntries());
        assertEquals("STRING1STRING2**********\r\n" + "**********", list
            .toString());
    }


    /**
     * tests the remove front method
     * 
     * 
     * @throws EmptyListException
     * 
     */
    public void testRemoveFront() {

        assertEquals(0, list.getNumberOfEntries());
        list.addFront("STRING1");
        assertEquals(1, list.getNumberOfEntries());
        list.addFront("STRING2");
        assertEquals(2, list.getNumberOfEntries());
        assertEquals("STRING2", list.removeFront());
        assertEquals("STRING1", list.removeFront());

        Exception thrown = null;
        try {
            list.removeFront();
        }

        catch (Exception e)

        {
            thrown = e;
        }
        assertNotNull(thrown);

    }


    /**
     * tests the remove back method
     * 
     * 
     * @throws EmptyListException
     * 
     */
    public void testRemoveBack() {

        assertEquals(0, list.getNumberOfEntries());
        list.addFront("STRING1");
        assertEquals(1, list.getNumberOfEntries());
        list.addFront("STRING2");
        assertEquals(2, list.getNumberOfEntries());
        assertEquals("STRING1", list.removeBack());
        assertEquals("STRING2", list.removeBack());
        Exception thrown = null;
        try {
            list.removeBack();
        }

        catch (Exception e)

        {
            thrown = e;
        }
        assertNotNull(thrown);

    }


    /**
     * tests the get data method
     */
    public void testGetData() {

        assertNull(list.getData(0));
        list.addFront("STRING1");
        list.addBack("STRING2");
        list.addBack("STRING3");
        list.addBack("STRING4");
        assertEquals("STRING2", list.getData(1));
        assertEquals("STRING3", list.getData(2));
        Exception thrown = null;
        try {
            list.getData(-1);
        }

        catch (Exception e) {

            thrown = e;
        }
        assertNotNull(thrown);

        Exception thrown2 = null;
        try {
            list.getData(10);
        }

        catch (Exception f) {

            thrown2 = f;
        }
        assertNotNull(thrown2);
    }


    /**
     * tests the get front method
     */
    public void testGetFront() {

        list.addFront("STRING1");
        list.addBack("STRING2");
        list.addBack("STRING3");
        list.addBack("STRING4");
        assertEquals("STRING1", list.getFront());
        list.addFront("NEWFRONT");
        assertEquals("NEWFRONT", list.getFront());

    }


    /**
     * tests the contains method
     */
    public void testContains() {

        list.addFront("STRING1");
        list.addBack("STRING2");
        list.addBack("STRING3");
        list.addBack("STRING4");
        assertTrue(list.contains("STRING2"));
        assertFalse(list.contains("STRING9"));
    }


    /**
     * tests the clear method
     */
    public void testClear() {

        list.addFront("STRING1");
        list.addBack("STRING2");
        list.addBack("STRING3");
        list.addBack("STRING4");
        assertEquals(4, list.getNumberOfEntries());
        list.clear();
        assertEquals(0, list.getNumberOfEntries());
    }


    /**
     * Tests the set method
     */
    public void testSet() {
        list.addFront("A");
        list.addBack("B");
        list.addBack("C");
        assertEquals("ABC**********\r\n" + "**********", list.toString());
        list.set(1, "D");
        assertEquals("ADC**********\r\n" + "**********", list.toString());

        IndexOutOfBoundsException myIOBE = null;
        try {
            list.set(3, "Z");
        }
        catch (IndexOutOfBoundsException iobe) {
            myIOBE = iobe;
        }
        assertNotNull(myIOBE);

        myIOBE = null;

        try {
            list.set(-1, "Z");
        }
        catch (IndexOutOfBoundsException iobe) {
            myIOBE = iobe;
        }
        assertNotNull(myIOBE);

    }


    /**
     * Tests the insertion sort method with a comparator
     */
    public void testInsertionSort() {
        LinkedData<User> userList = new LinkedData<User>();
        User user = new User("User");
        User abby = new User("Abby");
        User lucy = new User("Lucy");
        userList.addFront(user);
        userList.addFront(abby);
        userList.addBack(lucy);
        assertTrue(userList.getData(0).equals(abby));
        assertTrue(userList.getData(1).equals(user));
        assertTrue(userList.getData(2).equals(lucy));

        userList.insertionSort(userList, new CompareByName());
        assertTrue(userList.getData(0).equals(abby));
        assertTrue(userList.getData(1).equals(lucy));
        assertTrue(userList.getData(2).equals(user));

    }


    /**
     * Tests the insertion sort method with a CompareByEngagement comparator
     */
    public void testInsertionSort2() {
        LinkedData<User> userList = new LinkedData<User>();
        User user = new User("User");
        ArrayList<Post> userPosts = new ArrayList<Post>();
        userPosts.add(new Post("January", "User", 10, 10, 20, 30));
        user.setPosts(userPosts);
        // engagement = 100

        User abby = new User("Abby");
        ArrayList<Post> abbyPosts = new ArrayList<Post>();
        abbyPosts.add(new Post("January", "Abby", 10, 10, 20, 40));
        abby.setPosts(abbyPosts);
        // engagement = 75

        User lucy = new User("Lucy");
        ArrayList<Post> lucyPosts = new ArrayList<Post>();
        lucyPosts.add(new Post("January", "Lucy", 10, 10, 20, 50));
        lucy.setPosts(lucyPosts);
        // reach engagement = 60

        userList.addFront(user);
        userList.addFront(abby);
        userList.addBack(lucy);
        assertTrue(userList.getData(0).equals(abby));
        assertTrue(userList.getData(1).equals(user));
        assertTrue(userList.getData(2).equals(lucy));

        userList.insertionSort(userList, new CompareByEngagement(1));
        assertTrue(userList.getData(0).equals(user));
        assertTrue(userList.getData(1).equals(abby));
        assertTrue(userList.getData(2).equals(lucy));

    }


    /**
     * Tests the toString 2 method
     */
    public void testToString2() {
        LinkedData<User> userList = new LinkedData<User>();
        userList.addFront(new User("User"));
        userList.addFront(new User("Abby"));
        userList.addBack(new User("Lucy"));

        assertEquals("Abby\r\n" + "reach: N/A" + "\r\n" + "==========\r\n"
            + "User\r\n" + "reach: N/A" + "\r\n" + "==========\r\n" + "Lucy\r\n"
            + "reach: N/A" + "\r\n" + "==========\r\n" + "", userList
                .toString2());

        assertEquals("Abby\r\n" + "reach: N/A" + "\r\n" + "==========\r\n"
            + "User\r\n" + "reach: N/A" + "\r\n" + "==========\r\n" + "Lucy\r\n"
            + "reach: N/A" + "\r\n" + "==========\r\n" + "", userList
                .toString2());

    }

}
