package com.rafi.regelseteditor.gui;

import com.rafi.regelseteditor.api.IRegelService;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    private IRegelService service;

    public MainFrame() throws HeadlessException {
        initUI();
    }

    private void initUI() {

    }

    public void setService(IRegelService service) {
        this.service = service;
    }
}
