package com.rafi.regelseteditor.gui;

import com.rafi.regelseteditor.api.IRegelService;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    private IRegelService service;

    public MainFrame(IRegelService service) {
        this.service = service;
        createAndShowGUI();
    }

    private void addComponentsToPane(Container pane) {
        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

        JPanel left = new JPanel();
        JTextArea area = new JTextArea("text");
        left.add(area);

        JPanel right = new JPanel();
        right.add(area);
        splitPane.setLeftComponent(left);
        splitPane.setRightComponent(right);

        splitPane.setDividerLocation(100);
        splitPane.setDividerSize(5);
        splitPane.setOneTouchExpandable(true);

        pane.add(splitPane);
    }

    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200, 400));

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


}
