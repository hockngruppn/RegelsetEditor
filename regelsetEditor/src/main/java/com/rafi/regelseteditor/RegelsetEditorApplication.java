package com.rafi.regelseteditor;

import com.rafi.regelseteditor.gui.demo.GridBagLayoutDemo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class RegelsetEditorApplication implements CommandLineRunner {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(RegelsetEditorApplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {
			// start gui here
			GridBagLayoutDemo ex = ctx.getBean(GridBagLayoutDemo.class);
		});
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	}

}
