package undestiny.blogdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "username can't be null")
    @Column(nullable = false)
    private String username;

    @NotBlank(message = "password can't be null")
    @Length(max=16,min=8,message = "密码最短8位，最长16位")
    @Column(nullable = false)
    private String password;
}
