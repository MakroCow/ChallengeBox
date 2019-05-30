package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllVenturers", query = "SELECT v FROM Venturer v"),
        @NamedQuery(name = "findVenturerByName", query = "SELECT v FROM Venturer v WHERE v.lastName = :lastname"),
        @NamedQuery(name = "findVenturerByEmail", query = "SELECT v FROM Venturer v WHERE v.email = :email"),
}
)
public class Venturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private int sportScore;

    @Column
    private int nutritionScore;

    @Column
    private int mentalScore;

    @OneToMany(mappedBy="id", fetch = FetchType.EAGER)
    private List<Task> tasks;

    public Venturer() {
        super();
    }

    public Venturer(String firstName, String lastName, String email, String password){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public boolean checkPW(String pw) {
        //todo
        return true;
    }

    // *  Getter & Setter  *//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSportScore() {
        return sportScore;
    }

    public void setSportScore(int sportScore) {
        this.sportScore = sportScore;
    }

    public int getNutritionScore() {
        return nutritionScore;
    }

    public int getCompleteScore() {
        return this.sportScore + this.nutritionScore + this.mentalScore;
    }

    public void setNutritionScore(int nutritionScore) {
        this.nutritionScore = nutritionScore;
    }

    public int getMentalScore() {
        return mentalScore;
    }

    public void setMentalScore(int mentalScore) {
        this.mentalScore = mentalScore;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
