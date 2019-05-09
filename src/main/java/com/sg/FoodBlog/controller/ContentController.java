package com.sg.FoodBlog.controller;

/**
 *
 * @author lukem
 */
import com.sg.FoodBlog.Repositories.CategoryRepository;
import com.sg.FoodBlog.Repositories.PostRepository;
import com.sg.FoodBlog.Repositories.RoleRepository;
import com.sg.FoodBlog.Repositories.TagRepository;
import com.sg.FoodBlog.Repositories.UserRepository;
import com.sg.FoodBlog.entities.Category;
import com.sg.FoodBlog.entities.Post;
import com.sg.FoodBlog.entities.Tag;
import com.sg.FoodBlog.entities.User;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContentController {

    @Autowired
    CategoryRepository categoryR;

    @Autowired
    PostRepository postR;

    @Autowired
    RoleRepository roleR;

    @Autowired
    TagRepository tagR;

    @Autowired
    UserRepository userR;
    
   

    @GetMapping("/content")
    public String displayContentPage(Model model) {
        
        
      List <Post> postList = postR.findByStatus("pending");
      
      model.addAttribute("posts", postList);
      
        return "content";
    }
    
     @PostMapping("/deletePost")
    public String deletePost(Integer id) {

        Post post = postR.findById(id).orElse(null);
        
        postR.delete(post);

        return "redirect:/content";
    }
 
    @PostMapping("/approvePost")
    public String approvePost(Integer id) {

        Post post = postR.findById(id).orElse(null);
        
        post.setStatus("approved");
        
        postR.save(post);

        return "redirect:/content";
    }

    @PostMapping("/addPost")
    public String addPost(String title, String content, String category, HttpServletRequest request, Principal principal) {

        String[] tags = request.getParameterValues("tag");

        Category categoryNow = categoryR.findByName(category);

        List<Tag> tagList = new ArrayList();
        for (String tagzz : tags) {
            if (tagzz.isEmpty()) {
                Tag tag = tagR.findByName(tagzz);

                if (tag == null) {
                    tag = new Tag();

                    tagR.save(tag);
                    tag.setName(tagzz);
                    tagList.add(tag);

                } else {

                    tagList.add(tag);
                }

            }
        }

        String uName = principal.getName();

        User nUser = userR.findByUsername(uName);

        Post post = new Post();

        post.setTitle(title);
        post.setDate(LocalDate.now());
        post.setContent(content);
        post.setCategory(categoryNow);
        post.setTag(tagList);
        post.setUser(nUser);
        post.setStatus("pending");
        
        

        postR.save(post);

        return "redirect:/content";
    }

    @GetMapping("/category")
    public String viewCategory(String name, Model model, String status) {

        Category cat = categoryR.findByName(name);
        
        status = "approved";

        List<Post> postList = postR.findByCategoryAndStatus(cat, status);
       
        model.addAttribute("posts", postList);

        return "category";
    }

    @GetMapping("/user")
    public String viewUserPosts(String name, Model model, String status) {

        User user = userR.findByUsername(name);
        
        status = "approved";

        List<Post> postList = postR.findByUserAndStatus(user, status);

        model.addAttribute("posts", postList);

        return "user";

    }

    @GetMapping("/status")
    public String viewPendingPosts(Model model) {

        List<Post> postList = postR.findByStatus("pending");

        model.addAttribute("posts", postList);

        return "status";

    }
    
    @PostMapping("/logout")
    public String userLogOut(){
        return "home";
    }
    
    
}
