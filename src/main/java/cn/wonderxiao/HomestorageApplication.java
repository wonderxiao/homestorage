package cn.wonderxiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HomestorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomestorageApplication.class, args);
	}
}
