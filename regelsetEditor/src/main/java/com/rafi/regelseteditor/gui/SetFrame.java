package com.rafi.regelseteditor.gui;

import com.rafi.regelseteditor.api.IRegelService;
import com.rafi.regelseteditor.model.Regelkonf;
import com.rafi.regelseteditor.model.Regelparam;
import com.rafi.regelseteditor.model.Regelset;
import com.rafi.regelseteditor.util.RegelContainer;
import com.rafi.regelseteditor.util.RegelUtil;
import com.rafi.regelseteditor.util.Regeldetail;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  select regelset in this frame
 */
public class SetFrame extends JFrame {

    private JPanel mainPanel;

    private JComboBox rulesetSelection;
    private JScrollPane detailListScroller;
    private JList detailViewList;

    private JTree viewTree;

    JTextArea testOutput;

    private RegelContainer container;
    List<Regeldetail> detailList;

    private IRegelService service;

    public SetFrame(IRegelService service) {
        this.service = service;
        createAndShowGUI();
    }

    private void addComponentsToPane(Container contentPane) {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(249, 255, 249));
        mainPanel.setLayout(new BorderLayout(10, 10));
        contentPane.add(mainPanel);

        JPanel north = new JPanel();
        north.setBackground(new Color(110, 110, 110));
        north.setPreferredSize(new Dimension(900, 50));
        setLabeledBorder(north, "north");

        JPanel south = new JPanel();
        south.setBackground(new Color(110, 110, 110));
        south.setPreferredSize(new Dimension(900, 20));
        setLabeledBorder(south, "south");

        JPanel east = new JPanel();
        east.setBackground(new Color(52, 217, 103));
        east.setPreferredSize(new Dimension(100, 700));

        JPanel west = new JPanel();
        west.setBackground(new Color(110, 110, 110));
        west.setPreferredSize(new Dimension(100, 700));
        setLabeledBorder(west, "west");

        JPanel center = new JPanel();
        center.setBackground(new Color(96, 151, 217));
        center.setPreferredSize(new Dimension(300, 300));
        center.setLayout(new BorderLayout(3, 3));
        JPanel centerNorth = new JPanel();
        centerNorth.setPreferredSize(new Dimension(700, 500));
        centerNorth.setBackground(new Color(255, 159, 245));
        setLabeledBorder(centerNorth, "center - north");
        centerNorth.add(getTreePanel());

        JPanel centerSouth = new JPanel();
        centerSouth.setPreferredSize(new Dimension(700, 200));
        centerSouth.setBackground(new Color(255, 159, 245));
        setLabeledBorder(centerSouth, "center - south");
        center.add(centerNorth, BorderLayout.NORTH);
        center.add(centerSouth, BorderLayout.SOUTH);

        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(south, BorderLayout.SOUTH);
//        mainPanel.add(east, BorderLayout.EAST);
        mainPanel.add(west, BorderLayout.WEST);
        mainPanel.add(center, BorderLayout.CENTER);
    }

    private void setLabeledBorder(JPanel panel, String label) {
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(label),
                BorderFactory.createLineBorder(new Color(0, 0, 0), 5, true)));
    }

    private JPanel getTestPanel() {
        JPanel testPanel = new JPanel();
        testPanel.setBackground(new Color(217, 217, 31));
//        testPanel.setPreferredSize(new Dimension(200, 200));
        return testPanel;
    }

    private JPanel getTreePanel() {
        JPanel treePanel = new JPanel();
        treePanel.setBackground(new Color(255, 113, 98));
        treePanel.setLayout(new BorderLayout(20, 20));
        treePanel.setPreferredSize(new Dimension(700, 450));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Regelsets (DB)");

        for (Regelset set : service.findAllRegelsets()) {
            DefaultMutableTreeNode setNode = new DefaultMutableTreeNode(set.getName());
            root.add(setNode);
            RegelContainer container = service.getRegelContainer(set);

            // first level - konf
            // TODO: util: regelkonf nach reihenfolge sortieren -> hier alles mit streams machen
            container.getRegelkonfList().sort(Comparator.comparing(Regelkonf::getReihenfolge));
            for (Regelkonf konf : container.getRegelkonfList()) {
                DefaultMutableTreeNode konfNode = new DefaultMutableTreeNode(konf.getReihenfolge());
                setNode.add(konfNode);

                // second level - param
                // TODO - layout implodes on click
                for (Regelparam param : service.findRegelparamByRegelkonfId(konf.getId())) {
                    String label = param.getName()+": "+param.getDatatype()+" --> "+param.getValue();
                    DefaultMutableTreeNode paramNode = new DefaultMutableTreeNode(label);
                    konfNode.add(paramNode);
                }
            }
        }

        viewTree = new JTree(root);
        viewTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        viewTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                String s = e.getPath().toString();
                if (s != null && !s.isEmpty()) {
//                    testOutput.setText(s);
                }
            }
        });
//        viewTree.setPreferredSize(new Dimension(700, 450));
        JScrollPane treeScrollPane = new JScrollPane(viewTree);
//        treeScrollPane.setPreferredSize(new Dimension(700, 450));
        treePanel.add(treeScrollPane, BorderLayout.CENTER);
        return treePanel;
    }

    private void addComponentsToPane_00(Container contentPane) {
        JPanel pane = new JPanel();
        pane.setBackground(new Color(83, 48, 255));
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        detailViewList = new JList();

        c.fill = GridBagConstraints.HORIZONTAL;
//        c.insets = new Insets(20, 20, 20, 20);
        c.gridx = 0;
        c.gridy = 0;
        rulesetSelection = new JComboBox(service.findAllRegelsets().toArray());
        rulesetSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Regelset set = (Regelset) comboBox.getSelectedItem();

                container = service.getRegelContainer(set);
                detailList = service.getRegeldetailList(container);
                detailViewList.setListData(detailList.toArray());

                // shorter string for more readability
                List<String> shortDetailsList =
                        detailList.stream().map(detail ->
                        detail.getReihenfolge()+", "+detail.getKlasse()+", "+detail.getDatatype()+
                            ": "+detail.getWert()).collect(Collectors.toList());
                JList<String> tempList = new JList(shortDetailsList.toArray());
                detailListScroller.setViewportView(tempList);
            }
        });

        c.gridy = 1;
        c.gridheight = 4;
        JList regelSetScrollList = new JList(service.findAllRegelsets().toArray());
        JScrollPane regelSetScrollPane = new JScrollPane(regelSetScrollList);
        regelSetScrollList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList tmplist = (JList) e.getSource();
                Regelset selectedSet = (Regelset) tmplist.getSelectedValue();

                container = service.getRegelContainer(selectedSet);
                detailList = service.getRegeldetailList(container);
                detailViewList.setListData(detailList.toArray());
            }
        });
//        pane.add(regelSetScrollPane, c);

        c.gridy = 5;
        c.gridheight = 4;
        if (detailList != null) {
            detailViewList.setListData(detailList.toArray());
        }
        detailViewList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        detailViewList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        detailViewList.setVisibleRowCount(-1);
        detailListScroller = new JScrollPane(detailViewList);
        detailListScroller.setPreferredSize(new Dimension(250, 80));
//        pane.add(detailListScroller, c);

        c.gridy = 0;
        c.gridheight = 10;
        c.gridwidth = 5;

//        c.insets = new Insets(400, 20, 20, 20);

        JPanel viewTreePanel = new JPanel();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Regelsets (DB)");

        for (Regelset set : service.findAllRegelsets()) {
            DefaultMutableTreeNode setNode = new DefaultMutableTreeNode(set.getName());
            root.add(setNode);
            RegelContainer container = service.getRegelContainer(set);

            // first level - konf
            // TODO: util: regelkonf nach reihenfolge sortieren -> hier alles mit streams machen
            container.getRegelkonfList().sort(Comparator.comparing(Regelkonf::getReihenfolge));
            for (Regelkonf konf : container.getRegelkonfList()) {
                DefaultMutableTreeNode konfNode = new DefaultMutableTreeNode(konf.getReihenfolge());
                setNode.add(konfNode);

                // second level -
                // TODO - layout implodes on click
                for (Regelparam param : service.findRegelparamByRegelkonfId(konf.getId())) {
                    String label = param.getName()+": "+param.getDatatype()+" --> "+param.getValue();
                    DefaultMutableTreeNode paramNode = new DefaultMutableTreeNode(label);
                    konfNode.add(paramNode);
                }
            }
        }

        viewTree = new JTree(root);
        viewTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        viewTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                String s = e.getPath().toString();
                if (s != null && !s.isEmpty()) {
                    testOutput.setText(s);
                }
            }
        });
        JScrollPane treeScrollPane = new JScrollPane(viewTree);

        viewTreePanel.add(treeScrollPane);
        pane.add(viewTreePanel, c);

        c.gridheight = 1;
        c.gridy = 20;
        testOutput = new JTextArea();
        pane.add(testOutput, c);

        pane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        "Regelset Overview"),
                BorderFactory.createEmptyBorder(50,50,50,50)));

        contentPane.add(pane);
    }

    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TODO - title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 900));

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        frame.setResizable(false);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
