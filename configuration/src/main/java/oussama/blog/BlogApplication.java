package oussama.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"oussama.blog"})
@EntityScan("oussama.blog")
@EnableJpaRepositories("oussama.blog")
@EnableJpaAuditing
public class BlogApplication {
  public static void main(String[] args) {
    SpringApplication.run(BlogApplication.class, args);
  }
}
