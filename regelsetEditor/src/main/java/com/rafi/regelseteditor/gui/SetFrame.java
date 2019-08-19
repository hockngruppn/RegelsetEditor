package com.rafi.regelseteditor.gui;

import com.rafi.regelseteditor.api.IRegelService;
import com.rafi.regelseteditor.model.Regelset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  select regelset in this frame
 */
public class SetFrame extends JFrame {

    private JComboBox selection;
    private JTextArea testOutput;

    private IRegelService service;

    public SetFrame(IRegelService service) {
        this.service = service;
        createAndShowGUI();
    }

    private void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 20, 20, 20);
        c.gridx = 1;
        c.gridy = 0;
        selection = new JComboBox(service.findAllRegelsets().toArray());
        selection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Regelset set = (Regelset) comboBox.getSelectedItem();
                testOutput.setText(set.toString());
            }
        });
        pane.add(selection, c);

        c.gridy = 1;
        c.insets = new Insets(400, 20, 20, 20);
        testOutput = new JTextArea("Selection");
        pane.add(testOutput, c);
    }

    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
