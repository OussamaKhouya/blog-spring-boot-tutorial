package oussama.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import oussama.blog.domain.BlogPost;
import oussama.blog.repository.BlogRepository;

@Controller
public class BlogAdminController {
 @Autowired
 BlogRepository blogRepository;

 @RequestMapping(value = "/", method = RequestMethod.GET)
 public String addBolgPost(Model model) {
   model.addAttribute("blogPost", new BlogPost());
   return "addBlogPost";
 }
  @RequestMapping(value = "/blogPost", method = RequestMethod.POST)
 public String saveBlogPost(@ModelAttribute BlogPost blogPost) {
   blogRepository.save(blogPost);
   return "result";

 }
}
