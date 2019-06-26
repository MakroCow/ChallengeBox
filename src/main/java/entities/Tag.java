package entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Datenobjekt Tag
 */
@Entity
/**
 * benötigte querys für die Services
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id &&
                tagName.equals(tag.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName);
    }
}
