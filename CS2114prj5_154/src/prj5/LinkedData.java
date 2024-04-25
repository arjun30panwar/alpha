package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * A linked list class of the data
 * 
 * @param <T>
 * @author Prakhar Modi (prakharmodi)
 * @version Apr 18, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class LinkedData<T>
    implements LinkedListADT<T>
{

    private static class Node<T>
    {
        private Node<T> next;
        private Node<T> prev;
        private T data;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(T d)
        {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<T> n)
        {
            next = n;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrev(Node<T> n)
        {
            prev = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<T> getNext()
        {
            return next;
        }


        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<T> getPrev()
        {
            return prev;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public T getData()
        {
            return data;
        }

    }

    private int numberOfEntries;
    private Node<T> firstNode;
    private Node<T> lastNode;

    /**
     * Creates a new linked data object
     */
    public LinkedData()
    {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }


    /**
     * Returns if the list is empty or not
     * 
     * @return boolean true if empty
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }


    /**
     * returns the number of entries in the list
     * 
     * @return int the number of entries
     */
    public int getNumberOfEntries()
    {
        return numberOfEntries;
    }


    /**
     * clears the list and makes it empty
     */
    public void clear()
    {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }


    /**
     * adds a data node to the front
     * 
     * @param data
     *            T the data which you wish to add
     */
    public void addFront(T data)
    {
        Node<T> newNode = new Node<T>(data);
        if (firstNode == null)
        {
            firstNode = newNode;
            lastNode = newNode;
        }
        else
        {
            newNode.next = firstNode;
            firstNode.prev = newNode;
            firstNode = newNode;
        }
        numberOfEntries++;

    }


    /**
     * adds a data node to the back
     * 
     * @param data
     *            T the data which you wish to add
     */
    public void addBack(T data)
    {
        Node<T> newNode = new Node<T>(data);
        if (lastNode == null)
        {
            firstNode = newNode;
            lastNode = newNode;
        }
        else
        {
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
            lastNode = newNode;
        }
        numberOfEntries++;
    }


    /**
     * removes a data node from the front
     * 
     * @return T the data removed
     * @throws EmptyListException
     */

    public T removeFront()
    {
        if (firstNode == null)
        {
            throw new RuntimeException("List is empty");
        }
        T data = firstNode.getData();

        if (firstNode == lastNode)
        {
            firstNode = null;
            lastNode = null;
        }
        else
        {
            firstNode = firstNode.getNext();
            firstNode.prev = null;
        }
        numberOfEntries--;
        return data;
    }


    /**
     * removes a data node from the back
     * 
     * @return T the data removed
     * @throws EmptyListException
     */

    public T removeBack()
    {
        if (lastNode == null)
        {
            throw new RuntimeException("List is empty");
        }

        T data = lastNode.data;

        if (firstNode == lastNode)
        {
            firstNode = null;
            lastNode = null;
        }
        else
        {
            lastNode = lastNode.getPrev();
            lastNode.next = null;
        }
        numberOfEntries--;
        return data;
    }


    /**
     * Returns the data at a given index
     * 
     * @param index
     *            int the index which you wish to retrieve the data from
     * @return T the data from that index
     */
    public T getData(int index)
    {
        if (isEmpty())
        {
            return null;
        }
        if (index < 0 || index >= numberOfEntries)
        {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + numberOfEntries);
        }
        Node<T> current = firstNode;

        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }

        return current.data;
    }


    /**
     * Returns the value of the front of the list
     * 
     * @return T the value of the front
     */
    public T getFront()
    {
        return firstNode.data;
    }


    /**
     * Returns if the list contains the given data
     * 
     * @param data
     *            T the data which you wish to search for
     * @return boolean true if the list contains it
     */
    public boolean contains(T data)
    {
        Node<T> current = firstNode;
        while (current != null)
        {
            if (current.data.equals(data))
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * returns a string representation of the data
     * 
     * @return String the string representation
     */
    @SuppressWarnings("null")
    public String toString()
    {
        Node<T> curr = firstNode;

        StringBuilder str = new StringBuilder();
        while (curr != null)
        {
            str.append(curr.data.toString());
            curr = curr.getNext();
        }
        str.append("**********\n");
        str.append("**********");
        return str.toString();

    }


    /**
     * returns a string representation of the data
     * 
     * @return String the string representation
     */
    public String toString2()
    {
        StringBuilder str = new StringBuilder();
        Node<T> currTwo = firstNode;
        while (currTwo != null)
        {
            str.append(((User)currTwo.data).toStringForReach());
            currTwo = currTwo.getNext();
        }
        return str.toString();
    }

// public void sortByName(LinkedData<User> linkedList)
// {
// linkedList.insertionSort(linkedList, new CompareByName());
// }


    /**
     * sets the given index to the given data
     * 
     * @param index
     *            int the index which you wish to put the data at
     * @param newData
     *            T the data which you wish to set the index to
     * @throws IndexOutOfBoundsException
     *             if the index is out of bounds
     */
    public void set(int index, T newData)
        throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= numberOfEntries)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = firstNode;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        current.data = newData;
    }


    /**
     * Sorts the provided list using the given comparator using insertion sort
     * 
     * @param list
     *            LinkedData<User> the list you wish to sort
     * @param comparator
     *            Comparator<User> the comparator you wish to use to sort by
     */
    public
        void
        insertionSort(LinkedData<User> list, Comparator<User> comparator)
    {
        int j = 0;
        User temp = null;
        for (int i = 1; i < list.getNumberOfEntries(); i++)
        {
            temp = list.getData(i);
            j = i - 1;
            while ((j > -1) && comparator.compare(list.getData(j), temp) > 0)
            {
                list.set(j + 1, list.getData(j));
                j = j - 1;
            }
            list.set(j + 1, temp);

        }

    }


    /**
     * Sorts the provided list using the given comparator using insertion sort
     * 
     * @param list
     *            LinkedData<User> the list you wish to sort
     * @param comparator
     *            ComparatorByEnagagement the comparator you wish to use to sort
     *            by
     */
    public
        void
        insertionSort(LinkedData<User> list, CompareByEngagement comparator)
    {
        int j = 0;

        User temp = null;
        for (int i = 1; i < list.getNumberOfEntries(); i++)
        {
            temp = list.getData(i);
            j = i - 1;
            while ((j > -1) && comparator.compare(list.getData(j), temp) < 0)
            {
                list.set(j + 1, list.getData(j));
                j = j - 1;
            }
            list.set(j + 1, temp);

        }

    }

}
