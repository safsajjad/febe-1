package saf.com.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@SpringBootApplication
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://saf.frontend, http://localhost:8000")
public class BackendServiceOne {

	//private static final String baseUrl = "http://localhost:8082/api";
	private static final String baseUrl = "http://backend2/api";
	private static final Logger logger = LoggerFactory.getLogger(BackendServiceOne.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendServiceOne.class, args);
	}
	
	@GetMapping("/backend1")
    public String hello() {
        String message =  "Hello from Backend Service ONE & ";
		logger.debug("SAF -- This is a debug message from Backend Service ONE");
		logger.info("SAF -- This is a debug message from Backend Service ONE");
		logger.warn("SAF -- This is a debug message from Backend Service ONE");
        
		try {
			message = message + restTemplate.getForObject("/backend2", String.class);
		} catch (Exception ev) {
			message = message + " unable to connect to Backend Service TWO .....";
			logger.error(ev.getMessage());
		}    
        return message;
    }
    
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler(baseUrl);
		return builder.uriTemplateHandler(uriTemplateHandler).build();

	}
}