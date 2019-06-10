package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTasks", query = "SELECT t FROM Task t WHERE t.venturer.id = :venturer_id"),
        @NamedQuery(name = "findDoneTasks", query = "SELECT t FROM Task t WHERE (t.done is not null) AND t.venturer.id = :venturer_id"),
        @NamedQuery(name = "findTerminatedTasks", query = "SELECT t FROM Task t WHERE t.done is not null or t.failed is not null AND t.venturer.id = :venturer_id"),
        @NamedQuery(name = "findOpenTasks", query = "SELECT t FROM Task t WHERE t.done is null and t.failed is null AND t.venturer.id = :venturer_id")}
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
    public Date failed;

    @ManyToOne(fetch = FetchType.EAGER)
    public Challenge challenge;

    @OneToOne
    public Venturer venturer;

    public Task() {
        super();
    }

    public Task(Challenge challenge, Venturer venturer, Date accepted, Date done, Date beaten, Date failed) {
        this.accepted = accepted;
        this.done = done;
        this.failed = failed;
        this.challenge = challenge;
        this.venturer = venturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAccepted() {
        return accepted;
    }

    public void setAccepted(Date accepted) {
        this.accepted = accepted;
    }

    public Date getDone() {
        return done;
    }

    public void setDone(Date done) {
        this.done = done;
    }

    public Date getFailed() {
        return failed;
    }

    public void setFailed(Date failed) {
        this.failed = failed;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Venturer getVenturer() {
        return venturer;
    }

    public void setVenturer(Venturer venturer) {
        this.venturer = venturer;
    }
}
