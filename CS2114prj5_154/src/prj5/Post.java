package prj5;

// -------------------------------------------------------------------------
/**
 * A class representing a single post
 * 
 * @author Natalie Rogers (natalier06), Prakhar Modi, Arjun Panwar
 * @version Apr 15, 2024
 */

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.

public class Post {
    // ~ Fields ................................................................
    private String month;
    private String userName;
    private int likes;
    private int followers;
    private int comments;
    private int views;

    // ~ Constructors ..........................................................
    /**
     * Creates a new post object
     * 
     * @param month
     *            String a string representing the month
     * @param name
     *            String the channel name
     * @param likes
     *            int the number of likes on the post
     * @param followers
     *            int the number of followers on the post
     * @param comments
     *            int the number of comments on the post
     * @param views
     *            int the number of views on the post
     */
    public Post(
        String month,
        String name,
        int likes,
        int followers,
        int comments,
        int views) {
        this.month = month;
        this.userName = name;
        this.likes = likes;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }


    // ~Public Methods ........................................................
    /**
     * Returns the month the post was made in
     * 
     * @return String the month the post was made in
     */
    public String getMonth() {
        return month;
    }


    /**
     * Returns the channel name
     * 
     * @return String the channel name
     */
    public String getUserName() {
        return userName;
    }


    /**
     * Sets the channel name
     * 
     * @param newName
     *            String the name which you wish to set the channel name to
     */
    public void setUserName(String newName) {
        userName = newName;
    }


    /**
     * Returns the number of likes on the post
     * 
     * @return int the nubmer of likes on the post
     */
    public int getLikes() {
        return likes;
    }


    /**
     * Returns the number of followers on the post
     * 
     * @return int the number of followers on the post
     */
    public int getFollowers() {
        return followers;
    }


    /**
     * Returns the number of comments on the post
     * 
     * @return int the number of comments on the post
     */
    public int getComments() {
        return comments;
    }


    /**
     * Returns the number of views on the post
     * 
     * @return int the number of views on the post
     */
    public int getViews() {
        return views;
    }


    /**
     * Returns a string representation of the post in the form:
     * january, justamink, likes: 70, followers: 69, comments: 830, views: 632
     * 
     * @return String a string representation of the post
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(month);
        str.append(", ");
        str.append(userName);
        str.append(", likes: ");
        str.append(likes);
        str.append(", followers: ");
        str.append(followers);
        str.append(", comments: ");
        str.append(comments);
        str.append(", views: ");
        str.append(views);

        return str.toString();
    }
}
