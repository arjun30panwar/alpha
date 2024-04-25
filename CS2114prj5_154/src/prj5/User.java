package prj5;

import java.text.DecimalFormat;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * A class representing a single user
 * 
 * @author Natalie Rogers (natalier06), Arjun Panwar, Prakhar Modi
 * @version Apr 15, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class User implements Comparable<User> {
    // ~ Fields ................................................................
    private String channelName;
    private ArrayList<Post> posts; // make it a linked list

    // ~ Constructors ..........................................................
    /**
     * Creates a new user object
     * 
     * @param channelName
     *            String the channel's name
     */
    public User(String channelName) {
        this.channelName = channelName;
        posts = new ArrayList<Post>();
    }


    // ~Public Methods ........................................................
    /**
     * Sets the posts for the user
     * 
     * @param newPosts
     *            ArrayList<Post> the new posts array list
     */
    public void setPosts(ArrayList<Post> newPosts) {
        posts = newPosts;
    }


    /**
     * Returns the posts array list
     * 
     * @return ArrayList<Post> the posts of the user
     */
    public ArrayList<Post> getPosts() {
        return posts;
    }


    /**
     * Calculates the traditional engagement rate using the formula:
     * Engagement rate = (comments + likes) / followers * 100
     * 
     * @param month
     *            String the month for which you wish to calculate engagement
     * @return double the traditional engagement
     */
    public double calculateTraditionalEngagement(String month) {
        double comments = sumComments(month);
        double likes = sumLikes(month);
        double followers = sumFollowers(month);
        if (followers == 0) {
            return 0;
        }
        return (((comments + likes)) / followers) * 100;
    }


    /**
     * Calculates the traditional engagement rate using the formula:
     * Engagement rate = (comments + likes) / followers * 100
     * 
     * @return double the traditional engagement
     */
    public double calculateTraditionalEngagement() {
        double comments = sumComments();
        double likes = sumLikes();
        double followers = sumFollowers("March");
        if (followers == 0) {
            return 0;
        }
        return (((comments + likes)) / followers) * 100;
    }


    /**
     * Calculates the traditional engagement rate for the given quarter using
     * the formula:
     * Engagement rate = (comments + likes) / followers * 100
     * 
     * @param quarter
     *            int the quarter for which you wish to calculate the
     *            traditional engagement
     * @return double the traditional engagement for the quarter
     */
    public double calculateTraditionalEngagement(int quarter) {
        double comments = 0;
        double likes = 0;
        double followers = 0;

        switch (quarter) {
            case 1:
                comments = sumComments("January") + sumComments("February")
                    + sumComments("March");
                likes = sumLikes("January") + sumLikes("February") + sumLikes(
                    "March");
                // followers = sumFollowers("January") +
                // sumFollowers("February")
                // + sumFollowers("March");
                followers = sumFollowers("March");
                break;
            case 2:
                comments = sumComments("April") + sumComments("May")
                    + sumComments("June");
                likes = sumLikes("April") + sumLikes("May") + sumLikes("June");
                followers = sumFollowers("June");
                break;
            case 3:
                comments = sumComments("July") + sumComments("August")
                    + sumComments("September");
                likes = sumLikes("July") + sumLikes("August") + sumLikes(
                    "September");
                followers = sumFollowers("September");
                break;
            case 4:
                comments = sumComments("October") + sumComments("November")
                    + sumComments("December");
                likes = sumLikes("October") + sumLikes("November") + sumLikes(
                    "December");
                followers = sumFollowers("December");
                break;
            default:
                break;
        }

        if (followers == 0) {
            return -1;
        }

        double value = ((comments + likes) / followers) * 100;
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(value));

    }


    /**
     * Calculates the reachengagement rate using the formula:
     * Engagement rate = (comments + likes) / views* 100
     * 
     * @return double the reach engagement
     */
    public double calculateReachEngagement() {
        double comments = sumComments();
        double likes = sumLikes();
        double views = sumViews();
        if (views == 0) {

            return -1;

        }
        return ((comments + likes) / views) * 100;
    }


    /**
     * calculates the reach engagement for the given month
     * 
     * @param month
     *            String the month to calculate reach engagement for
     * @return double the reach engagement for that month
     */
    public double calculateReachEngagement(String month) {
        double comments = sumComments(month);
        double likes = sumLikes(month);
        double views = sumViews(month);

        if (views == 0) {
            return -1;
        }

        return ((comments + likes) / views) * 100;
    }


    /**
     * Calculates the reach engagement rate for the given quarter using
     * the formula:
     * Engagement rate = (comments + likes) / views * 100
     * 
     * @param quarter
     *            int the quarter for which you wish to calculate the
     *            reach engagement
     * @return double the reach engagement for the quarter
     */
    public double calculateReachEngagement(int quarter) {
        double comments = 0;
        double likes = 0;
        double views = 0;

        switch (quarter) {
            case 1:
                comments = sumComments("January") + sumComments("February")
                    + sumComments("March");
                likes = sumLikes("January") + sumLikes("February") + sumLikes(
                    "March");
                views = sumViews("January") + sumViews("February") + sumViews(
                    "March");
                break;
            case 2:
                comments = sumComments("April") + sumComments("May")
                    + sumComments("June");
                likes = sumLikes("April") + sumLikes("May") + sumLikes("June");
                views = sumViews("April") + sumViews("May") + sumViews("June");
                break;
            case 3:
                comments = sumComments("July") + sumComments("August")
                    + sumComments("September");
                likes = sumLikes("July") + sumLikes("August") + sumLikes(
                    "September");
                views = sumViews("July") + sumViews("August") + sumViews(
                    "September");
                break;
            case 4:
                comments = sumComments("October") + sumComments("November")
                    + sumComments("December");
                likes = sumLikes("October") + sumLikes("November") + sumLikes(
                    "December");
                views = sumViews("October") + sumViews("November") + sumViews(
                    "December");
                break;
            default:
                break;
        }

        if (views == 0) {
            return -1;

        }

        double value = ((comments + likes) / views) * 100;
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(value));

    }


    /**
     * Sums the likes of all posts for the user
     * 
     * @return int the likes of all posts for the user
     */
    private double sumLikes() {
        double sum = 0;
        for (Post post : posts) {
            sum += post.getLikes();
        }
        return sum;
    }


    /**
     * Sums the likes of all posts in a given month
     * 
     * @param month
     *            String the month whose likes you wish to sum
     * @return int the sum of likes
     */
    private double sumLikes(String month) {
        double sum = 0;
        for (Post post : posts) {
            if (post.getMonth().equals(month)) {
                sum += post.getLikes();
            }
        }
        return sum;
    }

    // /**
    // * Sums the likes of all posts for the user
    // *
    // * @return int the likes of all posts for the user
    // */
    // private double sumFollowers() {
    // double sum = 0;
    // for (Post post : posts) {
    // sum += post.getFollowers();
    // }
    // return sum;
    // }


    /**
     * Sums the followers of all posts in a given month
     * 
     * @param month
     *            String the month whose followers you wish to sum
     * @return int the sum of followers
     */
    private double sumFollowers(String month) {
        double sum = 0;
        for (Post post : posts) {
            if (post.getMonth().equals(month)) {
                sum += post.getFollowers();
            }
        }
        return sum;
    }


    /**
     * Sums the comments of all posts for the user
     * 
     * @return int the comments of all posts for the user
     */
    private double sumComments() {
        double sum = 0;
        for (Post post : posts) {
            sum += post.getComments();
        }
        return sum;
    }


    /**
     * Sums the comments of all posts in a given month
     * 
     * @param month
     *            String the month whose comments you wish to sum
     * @return int the sum of comments
     */
    private double sumComments(String month) {
        double sum = 0;
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);

            if (post.getMonth().equals(month)) {
                sum = sum + post.getComments();
            }
        }
        return sum;
    }


    /**
     * Sums the views of all posts for the user
     * 
     * @return int the views of all posts for the user
     */
    private double sumViews() {
        double sum = 0;
        for (Post post : posts) {
            sum += post.getViews();
        }
        return sum;
    }


    /**
     * Sums the views of all posts in a given month
     * 
     * @param month
     *            String the month whose views you wish to sum
     * @return int the sum of views
     */
    private double sumViews(String month) {
        double sum = 0;
        for (Post post : posts) {
            if (post.getMonth().equals(month)) {
                sum += post.getViews();
            }
        }
        return sum;
    }


    /**
     * Compares one user to another
     * 
     * @return int
     * @param other
     *            User the user to which you wish to compare
     */
    public int compareTo(User other) {
        // implement later
        return -1;
    }


    /**
     * Returns the channel name
     * 
     * @return String the channel name
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * returns a string representation of the user using reach engagement
     * of the first quarter in the form:
     * 
     * wizardHighSchool
     * reach: 105.2
     * ==========
     * 
     * @return String the string representation
     */
    public String toStringForReach() {
        StringBuilder str = new StringBuilder();

        str.append(getChannelName());
        str.append("\n");
        str.append("reach: ");

        if (calculateReachEngagement(1) < 0) {
            str.append("N/A");
        }
        else {
            str.append(calculateReachEngagement(1));
        }

        str.append("\n");
        str.append("==========");
        str.append("\n");
        return str.toString();

    }


    /**
     * returns a string representation of the user using traditional engagement
     * of the first quarter in the form:
     * 
     * wizardHighSchool
     * traditional: 193.4
     * ==========
     * 
     * @return String the string representation
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getChannelName());
        str.append("\n");
        str.append("traditional: ");

        if (calculateTraditionalEngagement(1) < 0) {
            str.append("N/A");
        }
        else {
            str.append(calculateTraditionalEngagement(1));
        }

        str.append("\n");
        str.append("==========");
        str.append("\n");

        return str.toString();
    }
}
