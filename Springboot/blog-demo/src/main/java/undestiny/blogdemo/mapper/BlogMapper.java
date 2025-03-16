package undestiny.blogdemo.mapper;

import org.apache.ibatis.annotations.*;
import undestiny.blogdemo.entity.Blog;

import java.util.List;

@Mapper
public interface BlogMapper {

    //发布blog
    @Insert("INSERT INTO blog(content,author_id,create_date,update_date) VALUES (#{content},#{authorId},DATE(NOW()),DATE(NOW()))")
    int insertBlog(Blog blog);

    //Update a blog
    @Update("UPDATE blog SET content = #{content},author_id = #{authorId},update_date = DATE(NOW()) WHERE blog_id = #{blogId}")
    int updateBlog(Blog blog);

    //Remove a blog
    @Delete("DELETE FROM blog WHERE blog_id = #{blog_id}")
    int deleteBlog(@Param("blog_id")Long blogId);

    //查看自己的所有blog
    @Select("SELECT blog_id AS blogId, content, author_id AS authorId, create_date, update_date FROM blog WHERE author_id=#{authorId}")
    List<Blog>selectByAuthorId(@Param("author_id")Long authorId);
}
