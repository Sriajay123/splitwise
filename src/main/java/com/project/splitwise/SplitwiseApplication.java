package com.project.splitwise;

import com.project.splitwise.commands.Command;
import com.project.splitwise.commands.CommandRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		while (true) {
			System.out.println("Awiating input");
			String input = scanner.nextLine();
			Command command = CommandRegistry.getInstance().getCommand(input);
			 command.execute(input);


		}
	}
}
