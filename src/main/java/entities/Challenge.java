package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllChallenges", query = "SELECT c FROM Challenge c")}
)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(name = "challenge_tag",
            joinColumns = @JoinColumn(name = "challenge_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @Column
    private int sportPoints;

    @Column
    private int nutritionPoints;

    @Column
    private int mentalPoints;

    public Challenge(){
        super();
    }

    public Challenge(String title, String description, List<Tag> tags, int sportPoints, int nutritionPoints, int mentalPoints) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.sportPoints = sportPoints;
        this.nutritionPoints = nutritionPoints;
        this.mentalPoints = mentalPoints;
    }

    //@Column TODO
    //private ... picture;

    //Challenge Score Points

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSportPoints() {
        return sportPoints;
    }

    public void setSportPoints(int sportPoints) {
        this.sportPoints = sportPoints;
    }

    public int getNutritionPoints() {
        return nutritionPoints;
    }

    public void setNutritionPoints(int nutritionPoints) {
        this.nutritionPoints = nutritionPoints;
    }

    public int getMentalPoints() {
        return mentalPoints;
    }

    public void setMentalPoints(int mentalPoints) {
        this.mentalPoints = mentalPoints;
    }

    public String toString() {
        return id + " " + title + " " + description + " | mental: "+ mentalPoints + " nutrition: "+nutritionPoints+" sport: " + sportPoints;
    }

    public int points() {
        return sportPoints + nutritionPoints + mentalPoints;
    }
}
