package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTasks", query = "SELECT t FROM Task t"),
        @NamedQuery(name = "findDoneTasks", query = "SELECT t FROM Task t WHERE t.done is not null"),
        @NamedQuery(name = "findTerminatedTasks", query = "SELECT t FROM Task t WHERE t.done is not null or t.failed is not null"),
        @NamedQuery(name = "findOpenTasks", query = "SELECT t FROM Task t WHERE t.done is null and t.failed is null")}
)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    public Date accepted;

    @Column
    public Date done;

    @Column
    public Date beaten;

    @Column
    public Date failed;

    @Column
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    public List<Challenge> challenge_id;
}
