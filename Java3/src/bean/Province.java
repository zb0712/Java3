package bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Date;

/**
 * @author 石致彬
 * @create 2020-12-28 15:21
 */
public class Province {
    @JSONField(name = "province_name")
    private String name;
    @JSONField(name = "lat",ordinal = 0)
    private String lat;
    @JSONField(name = "long",ordinal = 1)
    private String m_long;
    @JSONField(ordinal = 2,name = "confirmed")
    private int confirmed;
    @JSONField(ordinal = 3,name = "recovered")
    private int recovered;
    @JSONField(ordinal = 4,name = "deaths")
    private int deaths;
    @JSONField(ordinal = 5,format = "yyyy/MM/dd HH:mm:ssX",name = "updated")
    private Date updated;
    @JSONField(name = "country_name")
    private String country;

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", lat='" + lat + '\'' +
                ", m_long='" + m_long + '\'' +
                ", confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", updated=" + updated +
                ", country='" + country + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getM_long() {
        return m_long;
    }

    public void setM_long(String m_long) {
        this.m_long = m_long;
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

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Province(String name, String lat, String m_long, int confirmed, int recovered, int deaths, Date updated, String country) {
        this.name = name;
        this.lat = lat;
        this.m_long = m_long;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.updated = updated;
        this.country = country;
    }

    public Province() {
    }
}
