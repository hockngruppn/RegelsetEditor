package com.rafi.regelseteditor.config;

import com.rafi.regelseteditor.api.IRegelService;
import com.rafi.regelseteditor.model.Regelset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RegelsetConfig {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private IRegelService service;

    @Bean
    public Regelset testRegelsetBean() {
        // gui zeug hier?
        return null;
    }
}
