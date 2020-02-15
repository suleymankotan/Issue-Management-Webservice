package issuemanagement.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "issue")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description",length = 400)
    private String description;

    @Column(name = "date")
    @Temporal(TemporalType.TIME)
    private Date date;

    @Column(name = "issueStatus")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assignee;
}
