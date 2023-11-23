package by.anne.model.entities;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "unions")
public class Union {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="u_id")
    private int id;
    private String title;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name = "country_union", joinColumns = @JoinColumn(name = "u_id"),inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Country>countries;

    public Union() {
    }

    public Union(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }


}
