package undestiny.blogdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog")
public class Blog {
    //文章自己的id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogId;

    //文章内容
    @NotBlank(message = "Blog can't be empty.❌")
    @Column(columnDefinition = "TEXT")
    private String content;

    //作者id
    @NotBlank(message = "AuthorId can't be empty.❌")
    @Column(name = "author_id")
    private Long authorId;

    @CreatedDate
    @Column(name = "create_date")
    private LocalDate createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDate updateDate;
}
