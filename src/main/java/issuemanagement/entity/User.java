package issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "users")
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username",length = 100,unique = true)
    private String username;

    @Column(name = "Surname",length = 200)
    private String surname;

    @Column(name = "email",length = 100)
    private String email;

    @Column(name = "pwd",length = 200)
    private String password;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;

}
