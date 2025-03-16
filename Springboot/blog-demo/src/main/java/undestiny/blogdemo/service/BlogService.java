package undestiny.blogdemo.service;

import org.apache.ibatis.annotations.Param;
import undestiny.blogdemo.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog publishBlog(Blog blog);
    Blog updateBlog(Blog blog);
    boolean deleteBlog(Long blogId);
    List<Blog> getBlogs(Long authorId);
}
