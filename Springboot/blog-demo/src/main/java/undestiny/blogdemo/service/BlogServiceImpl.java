package undestiny.blogdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import undestiny.blogdemo.entity.Blog;
import undestiny.blogdemo.mapper.BlogMapper;
import undestiny.blogdemo.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogMapper blogMapper;

    @Override
    public Blog publishBlog(Blog blog) {
        if(blogMapper.insertBlog(blog) != 1)
            throw new RuntimeException("博客发布失败");
        return blog;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        if(blogMapper.updateBlog(blog) != 1)
            throw new RuntimeException("修改博客失败");
        return blog;
    }

    @Override
    public boolean deleteBlog(Long blogId) {
        if(blogMapper.deleteBlog(blogId) != 1)
            return false;
        return true;
    }

    @Override
    public List<Blog> getBlogs(Long authorId) {
        List<Blog> blogs = blogMapper.selectByAuthorId(authorId);
        return blogs;
    }
}
