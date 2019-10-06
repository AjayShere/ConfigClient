package ConfigClient.ConfigClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ConfigClientApplication {

	@Autowired
	RestTemplate restTemplate;

	@Value("${api.service.provider.url}")
	private String url;

	@Value("${db}")
	private String db;

	@GetMapping("test")
	public String callprovider() {
		String output = restTemplate.getForObject(url, String.class);
		System.out.println("output id  " + output);
		System.out.println("db value  " + db);
		return output;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

}
