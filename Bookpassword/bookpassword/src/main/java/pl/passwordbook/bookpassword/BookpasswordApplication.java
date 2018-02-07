package pl.passwordbook.bookpassword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BookpasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookpasswordApplication.class, args);
	}
}
