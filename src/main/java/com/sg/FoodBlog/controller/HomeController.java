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
import com.sg.FoodBlog.entities.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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

    @GetMapping("home")
    public String displayHomePage(Model model) {

        List<Post> postList = postR.findByStatus("approved");

        model.addAttribute("posts", postList);

        return "home";
    }

}
