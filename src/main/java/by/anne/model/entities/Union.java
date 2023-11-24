package by.anne.model.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "unions")
public class Union {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="u_id")
    private int id;
   @Column(unique = true)
    private String title;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Union union = (Union) o;

        if (id != union.id) return false;
        if (!Objects.equals(title, union.title)) return false;
        return Objects.equals(countries, union.countries);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (countries != null ? countries.hashCode() : 0);
        return result;
    }
}
