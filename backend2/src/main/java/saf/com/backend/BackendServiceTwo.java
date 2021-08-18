package saf.com.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class BackendServiceTwo {

	private static final Logger logger = LoggerFactory.getLogger(BackendServiceTwo.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BackendServiceTwo.class, args);
	}
	
	@RequestMapping(value = "/backend2", method= RequestMethod.GET)
    public String getReply() {
        String message =  "Hello from Backend Service TWO...";
		logger.debug("SAF -- This is a debug message from Backend Service TWO");
		logger.info("SAF -- This is a debug message from Backend Service TWO");
		logger.warn("SAF -- This is a debug message from Backend Service TWO");        
		System.out.println(message);
		return message;
    }
}