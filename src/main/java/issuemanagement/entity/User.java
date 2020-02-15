package issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username",length = 100,unique = true)
    private String username;

    @Column(name = "name_Surname",length = 200)
    private String nameSurname;

    @Column(name = "email",length = 100)
    private String email;

    @Column(name = "pwd",length = 200)
    private String password;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;

}
