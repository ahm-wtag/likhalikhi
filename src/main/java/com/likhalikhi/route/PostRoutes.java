package com.likhalikhi.route;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.likhalikhi.exception.ApiRequestException;
import com.likhalikhi.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostRoutes {



    @GetMapping
    public ModelAndView getAlLPosts() {
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject("http://localhost:8080/api/posts", String.class);
        System.out.println(jsonString);
        try {
            List<Post> postList = mapper.readValue(jsonString, new TypeReference<List<Post>>(){});
            ModelAndView mv = new ModelAndView("post/posts.jsp");
            mv.addObject("postList",postList);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiRequestException("This is dumb");
        }

    }


    @PostMapping("/new")
    public String showForm() {
        return "post/post-form.jsp";
    }


}
