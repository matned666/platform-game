package eu.mrndesign.matned;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class XmlServerStarter {

	public static void main(String[] args) {
		SpringApplication.run(XmlServerStarter.class, args);
	}

}
