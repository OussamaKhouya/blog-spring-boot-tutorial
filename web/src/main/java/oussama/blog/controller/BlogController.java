package oussama.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import oussama.blog.domain.BlogPost;
import oussama.blog.service.BlogService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

  @Autowired
  private BlogService blogService;

  @RequestMapping(value = "/blog/posts")
  public HashMap<String, Object> getBlogPosts(@RequestParam(value = "page") Long page) throws Exception {
    Pageable pageable = PageRequest.of(page != null ? (page.intValue() - 1) : 0, 1, Sort.by("id").descending());

    Page<BlogPost> slice = blogService.finAll(pageable);
    List<BlogPost> blogPosts = slice.getContent();

    if(pageable.getPageNumber() < 0 || pageable.getPageNumber() > slice.getTotalPages()) {
      throw new Exception("Exception when trying to retrieve blog posts");
    }

    HashMap<String, Object> result = new HashMap<>();
    result.put("blogPosts", blogPosts);
    result.put("pagination", blogService.createPaginationModel(slice));

    return result;
  }

  @RequestMapping(value = "/blog/posts/{id}")
  public Optional<BlogPost> getBlogPost(@PathVariable(value = "id") Long id){
    Optional<BlogPost> blogPost = blogService.findById(id);
    return blogPost;
  }
}
