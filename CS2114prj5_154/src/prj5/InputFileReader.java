package prj5;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
// import cs1705.IOHelper;
import student.IOHelper;

// -------------------------------------------------------------------------
/**
 * This is the main class that is responsible for reading the file Reads the
 * input files
 * 
 * @author Arjun Panwar, Prakhar Modi
 * @version Apr 15, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class InputFileReader
{
    // ~ Fields ................................................................
    private LinkedData<User> users;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * This is the constructor for the class
     * 
     * @param inputFileName
     *            represents the file that is supposed to be read creates a new
     *            inputfilereader object
     * @param inputFileName
     *            String the name of the input file
     * @throws FileNotFoundException
     *             when the file does not exist
     */
    @SuppressWarnings("javadoc")
    public InputFileReader(String inputFileName)
        throws FileNotFoundException
    {

        users = readInputFile(inputFileName);
    }


    /**
     * This is a private helper method to read the input from file
     * 
     * @param inputFile
     *            represents the file to be read
     * @return LinkedData<User> represents the linked list that is returned
     */
    private LinkedData<User> readInputFile(String inputFile)
        throws FileNotFoundException
    {

        // File newFile = new File(inputFile);
        Scanner inStream = IOHelper.createScanner(inputFile);
        inStream.nextLine();// skip header
        Integer likes = null;
        Integer comments = null;
        Integer followers = null;
        Integer views = null;
        users = new LinkedData<User>();

        while (inStream.hasNextLine())
        {
            ArrayList<Post> arr1 = new ArrayList<Post>();
            boolean userFound = false;
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] arr = line.split(",");
            String month = arr[0];
            String username = arr[1];
            String channelName = arr[2];
            likes = Integer.valueOf(arr[5]);
            Integer posts = Integer.valueOf(arr[6]);
            followers = Integer.valueOf(arr[7]);
            comments = Integer.valueOf(arr[8]);

            views = Integer.valueOf(arr[9]);  
            Post post = new Post(month, username, likes, followers, comments,
                views);

            

            User currUser = null;
            if (!users.isEmpty())
            {
                for (int i = 0; i < users.getNumberOfEntries(); i++)
                {
                    currUser = users.getData(i);
                    if (currUser.getChannelName().equals(channelName))
                    {
                        userFound = true;
                        break;
                    }
                }
            }
            // for(int i = 0; i <= users.getNumberOfEntries(); i++)
            // {
            if (userFound)
            {
                // Post post = new Post(month, username, likes, followers,
                // comments, views);
                // arr1.add(post);
                ArrayList<Post> currPosts = currUser.getPosts();
                currPosts.add(post);
                currUser.setPosts(currPosts);
            }
            else
            {
                // Post post = new Post(month, username, likes, followers,
                // comments, views);
                arr1.add(post);
                User newUser = new User(channelName);
                newUser.setPosts(arr1);
                users.addBack(newUser);
            }
            // }
// Post post = new Post(month, username, likes, followers, comments, views);
// arr1.add(post);
// user.setPosts(arr1);
// users.add(user);

        }

        inStream.close();
        return users;
// Integer EngagementRate = ( (comments + likes)/ followers) * 100;
// Integer EngagementRateByReach = ( (comments + likes)/ views) * 100;
// return arr1;

    }


    /**
     * returns the linked list of users
     * 
     * @return LinkedData<User> the linked list of users
     */
    public LinkedData<User> getUsers()

    {
        return users;
    }
// private boolean userFound(String channelName)
// {
// User currUser = null;
// if(!users.isEmpty()) {
// for(int i = 0; i < users.getNumberOfEntries(); i++)
// {
// currUser = users.getData(i);
// if(currUser.getChannelName().equals(channelName))
// {
// return true;
// }
// }
// }
// return false;
// }

}
