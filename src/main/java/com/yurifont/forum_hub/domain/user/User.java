package com.yurifont.forum_hub.domain.user;

import com.yurifont.forum_hub.domain.user.dto.RegisterUserData;
import jakarta.persistence.*;
import lombok.*;

import org.mindrot.jbcrypt.BCrypt;

@Table(name = "users")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    public User(RegisterUserData data) {
        this.name = data.name();
        this.email = data.email();
        this.password = hashPassword(data.password());
    }

    public String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

}
