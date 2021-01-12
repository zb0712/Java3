package bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author 石致彬
 * @create 2020-12-28 15:22
 */
public class All {
    @JSONField(ordinal = 0)
    private int confirmed;
    @JSONField(ordinal = 1)
    private int recovered;
    @JSONField(ordinal = 2)
    private int deaths;
    @JSONField(ordinal = 3)
    private String country;
    @JSONField(ordinal = 4)
    private int population;
    @JSONField(name = "sq_km_area",ordinal = 5)
    private double area;
    @JSONField(ordinal = 6)
    private String life_expectancy;
    @JSONField(ordinal = 7)
    private String elevation_in_meters;
    @JSONField(ordinal = 8)
    private String continent;
    @JSONField(ordinal = 9)
    private String abbreviation;
    @JSONField(ordinal = 10)
    private String location;
    @JSONField(ordinal = 11)
    private int iso;
    @JSONField(ordinal = 12)
    private String capital_city;

    @Override
    public String toString() {
        return "All{" +
                "confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", life_expectancy='" + life_expectancy + '\'' +
                ", elevation_in_meters='" + elevation_in_meters + '\'' +
                ", continent='" + continent + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", location='" + location + '\'' +
                ", iso=" + iso +
                ", capital_city='" + capital_city + '\'' +
                '}';
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getLife_expectancy() {
        return life_expectancy;
    }

    public void setLife_expectancy(String life_expectancy) {
        this.life_expectancy = life_expectancy;
    }

    public String getElevation_in_meters() {
        return elevation_in_meters;
    }

    public void setElevation_in_meters(String elevation_in_meters) {
        this.elevation_in_meters = elevation_in_meters;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIso() {
        return iso;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public String getCapital_city() {
        return capital_city;
    }

    public void setCapital_city(String capital_city) {
        this.capital_city = capital_city;
    }

    public All() {
    }

    public All(int confirmed, int recovered, int deaths, String country, int population, double area, String life_expectancy, String elevation_in_meters, String continent, String abbreviation, String location, int iso, String capital_city) {
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.country = country;
        this.population = population;
        this.area = area;
        this.life_expectancy = life_expectancy;
        this.elevation_in_meters = elevation_in_meters;
        this.continent = continent;
        this.abbreviation = abbreviation;
        this.location = location;
        this.iso = iso;
        this.capital_city = capital_city;
    }
}
