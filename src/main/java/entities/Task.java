package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    public Boolean accepted;

    @Column
    public Date date;

    @Column
    public Boolean beaten;

    @Column
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    public List<Challenge> challenge_id;
}
