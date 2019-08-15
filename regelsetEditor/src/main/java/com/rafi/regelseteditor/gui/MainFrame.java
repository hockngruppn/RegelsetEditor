package com.rafi.regelseteditor.gui;

import com.rafi.regelseteditor.api.IRegelService;

import javax.swing.*;

public class MainFrame extends JFrame {


    private IRegelService service;

    public MainFrame() {
        initUI();
    }

    private void initUI() {

    }

    public void setService(IRegelService service) {
        this.service = service;
    }
}
