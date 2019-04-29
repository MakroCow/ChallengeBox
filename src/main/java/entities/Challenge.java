package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    private String taste;

    @Column
    private String description;

    @Column
    private String titel;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    @OrderColumn
    private List<Tag> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
