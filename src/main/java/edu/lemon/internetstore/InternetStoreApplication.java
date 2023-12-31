package edu.lemon.internetstore;

import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class InternetStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetStoreApplication.class, args);
	}

}
