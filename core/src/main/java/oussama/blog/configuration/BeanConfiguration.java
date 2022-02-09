package oussama.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import oussama.blog.repository.BlogRepository;
import oussama.blog.service.BlogService;

@Configuration
@ComponentScan
public class BeanConfiguration {

  @Bean
  public BlogService blogService(BlogRepository blogRepository){
    return new BlogService(blogRepository);
  }
}
