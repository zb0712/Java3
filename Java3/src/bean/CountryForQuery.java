package bean;

/**
 * @author 石致彬
 * @create 2021-01-04 15:40
 */
public class CountryForQuery {
    private int confirmed;
    private int recovered;
    private int deaths;
    private String name;

    @Override
    public String toString() {
        return name +":{"+
                "confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths+"}" ;
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

    public CountryForQuery() {
    }

    public CountryForQuery(int confirmed, int recovered, int deaths, String name) {
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.name = name;
    }
}
