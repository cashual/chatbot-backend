package com.ing.cashual.chatboting;

import com.ing.cashual.chatboting.util.FileUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ChatBotIngApplication {

	@Value("${utter-actions.file}")
	private String utterActionsFile;

	public static void main(String[] args) {
		SpringApplication.run(ChatBotIngApplication.class, args);
	}

	@Bean(name = "utterActionMap")
	Map<String,List<String>> utterActionMap() {
		try {
			return FileUtils.getUtterActionMap(utterActionsFile);
		}
		catch (IOException e) {
			System.out.println("Oops");
			return null;
		}
	}
}
