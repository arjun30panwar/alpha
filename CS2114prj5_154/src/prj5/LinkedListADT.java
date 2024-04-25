package prj5;

import java.util.NoSuchElementException;

/**
 * An interface representing a linked list abstract data type.
 * 
 * @param <T>
 *            The type of elements in the linked list.
 * @author Prakhar Modi
 * @version 4.18.2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public interface LinkedListADT<T>
{

    /**
     * Checks if the linked list is empty.
     * 
     * @return true if the linked list is empty, false otherwise.
     */
    boolean isEmpty();


    /**
     * Returns the number of elements in the linked list.
     * 
     * @return the number of elements in the linked list.
     */
    int getNumberOfEntries();


    /**
     * Adds a new element to the front of the linked list.
     * 
     * @param element
     *            the element to be added.
     */
    void addFront(T element);


    /**
     * Adds a new element to the back of the linked list.
     * 
     * @param element
     *            the element to be added.
     */
    void addBack(T element);


    /**
     * Removes and returns the element from the front
     * 
     * @return element removed from the front.
     * @throws NoSuchElementException
     *             if the linked list is empty.
     */
    T removeFront()
        throws NoSuchElementException;


    /**
     * Removes and returns the element from the back of the linked list.
     * 
     * @return the element removed from the back.
     * @throws NoSuchElementException
     *             if the linked list is empty.
     */
    T removeBack()
        throws NoSuchElementException;


    /**
     * Retrieves the element at the specified index in the linked list.
     * 
     * @param index
     *            the index of the element to retrieve.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException
     *             if the index is out of range.
     */
    T getData(int index)
        // throws IndexOutOfBoundsException;
        throws IndexOutOfBoundsException;


    /**
     * Sets the element at the specified index in the linked list.
     * 
     * @param index
     *            the index of the element to set.
     * @param element
     *            the new element to set at the specified index.
     * @throws IndexOutOfBoundsException
     *             if the index is out of range.
     */
    void set(int index, T element)
        throws IndexOutOfBoundsException;


    /**
     * Checks if the linked list contains the specified element.
     * 
     * @param element
     *            the element to search for.
     * @return true if the linked list contains the element, false otherwise.
     */
    boolean contains(T element);


    /**
     * Clears all elements from the linked list.
     */
    void clear();

}
