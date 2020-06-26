package model;

import javax.persistence.*;

@Entity
@Table(name = "country_capital_town_rel")
public class CountryCapitalTownRel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private int id;

    @Column(name = "capital_start_year")
    private Integer capital_start_year;

    @Column(name = "capital_end_year")
    private Integer capital_end_year;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id",nullable = false)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    @ManyToOne(cascade = CascadeType.REFRESH)///////////////////////////////////////////////////////////////////
    @JoinColumn(name = "town_id", referencedColumnName = "id", nullable = false)
    private Town town;

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }


    /////////////////////////////////////////////////////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    /////////////////////////////////////////////////////////
    public Integer getCapital_start_year() {
        return capital_start_year;
    }

    public void setCapital_start_year(Integer capital_start_year) {
        this.capital_start_year = capital_start_year;
    }

    /////////////////////////////////////////////////////////
    public Integer getCapital_end_year() {
        return capital_end_year;
    }

    public void setCapital_end_year(Integer capital_end_year) {
        this.capital_end_year = capital_end_year;
    }

    @Override
    public String toString() {
        return "CountryCapitalTownRel:\n" +
                "id: " + id +
                "\ncountry id: " + country.getId() +
                "\ntown id : " + town.getId() + "" +
                "\ntown name : " + town.getName() + "" +
                "\ncapital_start_year : " + capital_start_year +
                "\ncapital_end_year : " + capital_end_year;// +
    }
}
