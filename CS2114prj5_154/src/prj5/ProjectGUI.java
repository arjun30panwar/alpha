
package prj5;

import cs2.*;
import cs2.Button;
import cs2.Shape;
import cs2.Window;

import java.awt.*;

/**
 * Write a one-sentence summary of your class here.
 * Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 *
 * @author arjun
 * @version Apr 22, 2024
 */

public class ProjectGUI {
    // ~ Fields ................................................................
    private Window window;
    private static final double DISPLAY_FACTOR = 1.5;
    private Button sortChannel;
    private Button sortEngagement;
    private Button quit;
    private Button traditional;
    private Button reach;
    private Button month1;
    private Button month2;
    private Button month3;
    private Button quarter;
    private LinkedData<User> mainData;
    private TextShape time;
    private TextShape engagementRate;
    private TextShape sortingBy;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    public ProjectGUI() {
        window = new Window("arjunpanwar prakharmodi mohtasimnahin natalier06");
        window.setSize((int)(500 * DISPLAY_FACTOR), (int)(500
            * DISPLAY_FACTOR));
        sortChannel = new Button("Sort By Channel Name");
        sortEngagement = new Button("Sort by Engagement Rate");
        quit = new Button("Quit");
        traditional = new Button("Traditional Engagement Rate");
        reach = new Button("Reach Engagement Rate");
        mainData = new LinkedData<User>();
        month1 = new Button("January");
        month2 = new Button("February");
        month3 = new Button("March");
        quarter = new Button("First Quarter(Jan - March)");

        window.addButton(sortChannel, WindowSide.NORTH);
        window.addButton(sortEngagement, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);

        window.addButton(traditional, WindowSide.WEST);
        window.addButton(reach, WindowSide.WEST);
        window.addButton(month1, WindowSide.SOUTH);
        window.addButton(month2, WindowSide.SOUTH);
        window.addButton(month3, WindowSide.SOUTH);
        window.addButton(quarter, WindowSide.SOUTH);
        month1.onClick(this, "month1");
        month2.onClick(this, "month2");
        month3.onClick(this, "month3");
        quarter.onClick(this, "quarter1");
        traditional.onClick(this, "traditional");
        reach.onClick(this, "reach");
        sortChannel.onClick(this, "sortChannel");
        sortEngagement.onClick(this, "sortEngagement");
        
        
        
        

        
    }


    public void month1(Button button) {
        if (time != null) {
            window.removeShape(time);
        }
        time = new TextShape(20, 15, "Jnauary");
        window.addShape(time);

        window.repaint();
        
        this.drawShape();
        
        

    }


    public void month2(Button button) {
        if (time != null) {
            window.removeShape(time);
        }

        time = new TextShape(20, 15, "Feburary");
        window.addShape(time);
        window.repaint();

    }


    public void month3(Button button) {
        if (time != null) {
            window.removeShape(time);
        }

        time = new TextShape(20, 15, "March");
        window.addShape(time);
        window.repaint();

    }


    public void quarter1(Button button) {
        if (time != null) {
            window.removeShape(time);
        }

        time = new TextShape(20, 15, "First Quarter (Jan-Mar)");
        window.addShape(time);
        window.repaint();

    }


    public void traditional(Button button) {
        if (engagementRate != null) {
            window.removeShape(engagementRate);
        }
        engagementRate = new TextShape(20, 35, "Traditional Engagement Rate");
        window.addShape(engagementRate);
        window.repaint();
    }


    public void reach(Button button) {
        if (engagementRate != null) {
            window.removeShape(engagementRate);
        }
        engagementRate = new TextShape(20, 35, "Reach Engagement Rate");
        window.addShape(engagementRate);
        window.repaint();
    }


    public void sortChannel(Button button) {
        if (sortingBy != null) {
            window.removeShape(sortingBy);
        }
        sortingBy = new TextShape(20, 55, "Sorting by Channel Name");
        window.addShape(sortingBy);
        window.repaint();
    }


    public void sortEngagement(Button button) {
        if (sortingBy != null) {
            window.removeShape(sortingBy);
        }
        sortingBy = new TextShape(20, 55, "Sorting by Engagement Rate");
        window.addShape(sortingBy);
        window.repaint();
    }


    public void drawShape() {

        Shape a = new Shape(100, 100, 200, 10, new Color(50, 50, 50));
        window.addShape(a);

    }

}
