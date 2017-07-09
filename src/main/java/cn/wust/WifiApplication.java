package cn.wust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:quartzConfig.xml"})
public class WifiApplication {
	public static void main(String[] args) {
		SpringApplication.run(WifiApplication.class, args);
	}
}
