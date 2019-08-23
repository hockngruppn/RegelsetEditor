package com.rafi.regelseteditor.gui;

import com.rafi.regelseteditor.api.IRegelService;
import com.rafi.regelseteditor.model.Regelset;
import com.rafi.regelseteditor.util.RegelContainer;
import com.rafi.regelseteditor.util.Regeldetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *  select regelset in this frame
 */
public class SetFrame extends JFrame {

    private JComboBox rulesetSelection;
    private JScrollPane detailListScroller;
    private JList detailViewList;
    private JTextArea testOutput;


    private RegelContainer container;
    List<Regeldetail> detailList;

    private IRegelService service;

    public SetFrame(IRegelService service) {
        this.service = service;
        createAndShowGUI();
    }

    private void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        detailViewList = new JList();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 20, 20, 20);
        c.gridx = 1;
        c.gridy = 0;
        rulesetSelection = new JComboBox(service.findAllRegelsets().toArray());
        rulesetSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Regelset set = (Regelset) comboBox.getSelectedItem();
                testOutput.setText(set.toString());

                container = service.getRegelContainer(set);
                detailList = service.getRegeldetailList(container);
                detailViewList.setListData(detailList.toArray());
                detailListScroller = new JScrollPane(detailViewList);
            }
        });
        pane.add(rulesetSelection, c);

        c.gridy = 2;
        if (detailList != null) {
            detailViewList.setListData(detailList.toArray());
        }
        detailViewList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        detailViewList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        detailViewList.setVisibleRowCount(-1);
        detailListScroller = new JScrollPane(detailViewList);
        detailListScroller.setPreferredSize(new Dimension(250, 80));
        pane.add(detailListScroller, c);

        c.gridy = 3;
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

//        this.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createTitledBorder(
//                        "Edit the HTML, then click the button"),
//                BorderFactory.createEmptyBorder(10,10,10,10)));

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
