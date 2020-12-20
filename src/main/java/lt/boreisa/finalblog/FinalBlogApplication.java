package lt.boreisa.finalblog;

import lt.boreisa.finalblog.security.ApplicationSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class FinalBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalBlogApplication.class, args);
    }

}
