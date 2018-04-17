package com.ing.cashual.chatboting;

import com.ing.cashual.chatboting.util.FileUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
			Path path = Paths.get(ClassLoader.getSystemResource(utterActionsFile).toURI());
			return FileUtils.getUtterActionMap(path);
		}
		catch (URISyntaxException e) {
			System.out.println("Oops");
			return null;
		}
		catch (IOException e) {
			System.out.println("Oops");
			return null;
		}
	}
}
