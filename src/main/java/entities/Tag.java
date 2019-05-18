package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTags", query = "SELECT t FROM Tag t"),
        @NamedQuery(name = "findTagByTagName", query = "SELECT t FROM Tag t WHERE t.tagName = :tagName")}
)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    private String tagName;

    /*@ManyToMany(
            mappedBy = "tags",
            fetch = FetchType.EAGER)
    private List<Challenge> challenges;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
