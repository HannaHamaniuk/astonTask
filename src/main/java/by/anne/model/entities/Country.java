package by.anne.model.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private int id;
    private String name;
    private String president;
    private String capital;

    @ManyToMany(cascade = {CascadeType.ALL,CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name="country_union", joinColumns = @JoinColumn(name = "c_id"), inverseJoinColumns = @JoinColumn(name="u_id"))
    private List<Union> unions;

    public Country() {
    }

    public Country(String name, String president, String capital) {
        this.name = name;
        this.president = president;
        this.capital = capital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<Union> getUnions() {
        return unions;
    }

    public void setUnions(List<Union> unions) {
        this.unions = unions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (!Objects.equals(name, country.name)) return false;
        if (!Objects.equals(president, country.president)) return false;
        if (!Objects.equals(capital, country.capital)) return false;
        return Objects.equals(unions, country.unions);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (president != null ? president.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (unions != null ? unions.hashCode() : 0);
        return result;
    }
}
