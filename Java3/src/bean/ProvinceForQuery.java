package bean;

import java.sql.Date;

/**
 * @author 石致彬
 * @create 2021-01-04 15:40
 */
public class ProvinceForQuery {
    private int confirmed;
    private int recovered;
    private int deaths;
    private String name;
    private String country;
    private Date update;
    @Override
    public String toString() {
        return name + ":{"+
                "confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", country=" + country +
                ", update=" + update +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public ProvinceForQuery() {
    }

    public ProvinceForQuery(int confirmed, int recovered, int deaths, String name, String country, Date update) {
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.name = name;
        this.country = country;
        this.update = update;
    }
}
