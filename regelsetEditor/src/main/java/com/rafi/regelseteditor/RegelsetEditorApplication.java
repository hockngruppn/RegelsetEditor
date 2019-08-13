package com.rafi.regelseteditor;

import com.rafi.regelseteditor.api.IRegelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RegelsetEditorApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(RegelsetEditorApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// start gui here
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("Hello World");
//			}
//		};
//	}

}
