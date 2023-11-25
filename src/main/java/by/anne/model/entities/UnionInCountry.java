package by.anne.model.entities;

public class UnionInCountry {
    private String title;
    private int country_id;

    public UnionInCountry( int country_id) {
        this.country_id = country_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
