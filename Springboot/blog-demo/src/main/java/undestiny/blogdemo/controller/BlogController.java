package undestiny.blogdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import undestiny.blogdemo.entity.Blog;
import undestiny.blogdemo.service.BlogServiceImpl;


@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogServiceImpl blogServiceImpl;

    @PostMapping("/publish")
    public Blog publisBlog(@RequestBody Blog blog){
        return blogServiceImpl.publishBlog(blog);
    }

    @PostMapping("/update")
    public Blog updateBlog(@RequestBody Blog blog){
        return blogServiceImpl.updateBlog(blog);
    }

    @GetMapping("/delete/{blogId}")
    public String deleteBlog(@PathVariable("blogId")Long blogId){
        if(blogServiceImpl.deleteBlog(blogId)) return "删除成功";
        return "Delete blog failed";
    }
}
