package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllChallenges", query = "SELECT c FROM Challenge c"),
        @NamedQuery(name = "findChallengeByID", query = "SELECT c FROM Challenge c WHERE c.id = :id")}
)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    private String titel;

    @Column
    private String description;


    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    @OrderColumn
    private List<Tag> tags;*/

    //@Column
    //private ... picture;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/*    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }*/




    public int getId() {
        return id;
    }

    public String getTitle() {
        return titel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return id + " " + titel + " " + description;
    }
}
