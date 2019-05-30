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

    @ManyToOne(fetch=FetchType.EAGER)
    public Challenge challenge;

    public Task(){
        super();
    }

    public Task(Date accepted, Date done, Date beaten, Date failed, Challenge challenge) {
        this.accepted = accepted;
        this.done = done;
        this.beaten = beaten;
        this.failed = failed;
        this.challenge = challenge;
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

    public Date getBeaten() {
        return beaten;
    }

    public void setBeaten(Date beaten) {
        this.beaten = beaten;
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
}
