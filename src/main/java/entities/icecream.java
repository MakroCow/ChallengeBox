package entities;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
@Table(name = "icecream")
public class icecream {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @Column(name="taste")
    private String taste;

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
