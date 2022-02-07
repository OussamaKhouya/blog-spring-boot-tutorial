package oussama.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import oussama.blog.domain.BlogPost;

@Repository
@Component
public interface BlogRepository extends CrudRepository<BlogPost, Long> {

}
