package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class icecream {

    @Id
    public int id;

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
