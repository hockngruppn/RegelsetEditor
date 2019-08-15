package com.rafi.regelseteditor.config;

import com.rafi.regelseteditor.api.IRegelService;
import com.rafi.regelseteditor.gui.MainFrame;
import com.rafi.regelseteditor.gui.demo.GridBagLayoutDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GuiConfig {

    @Autowired
    private IRegelService service;

    @Bean
    public MainFrame getMainFrame() {
        MainFrame main = new MainFrame();
//        main.setService(service);
        return main;
    }

    @Bean
    public GridBagLayoutDemo getGridBagDemo() {
        return new GridBagLayoutDemo();
    }
}
