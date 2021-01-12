package exer;

import bean.All;
import bean.CountryForQuery;
import bean.Province;
import bean.ProvinceForQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 石致彬
 * @create 2020-12-28 15:20
 */
public class Jdbc {
    public void insertData()  {
        Data data = new Data();
        data.get();
        ArrayList<All> list1 = data.getList1();
        ArrayList<Province> list2 = data.getList2();

        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        String sql1 = "insert into country(confirmed,recovered,deaths,country,population,sq_km_area,life_expectancy,elevation_in_meters,continent,abbreviation,location,iso,capital_city)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "insert into province(province_name,lat,`long`,confirmed,recovered,deaths,updated,country_name)values(?,?,?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            Iterator<All> iterator = list1.iterator();
            while (iterator.hasNext()) {
                All next = iterator.next();
                ps.setInt(1, next.getConfirmed());
                ps.setInt(2, next.getRecovered());
                ps.setInt(3, next.getDeaths());
                ps.setString(4, next.getCountry());
                ps.setInt(5, next.getPopulation());
                ps.setDouble(6,next.getArea());
                ps.setString(7,next.getLife_expectancy());
                ps.setString(8,next.getElevation_in_meters());
                ps.setString(9,next.getContinent());
                ps.setString(10,next.getAbbreviation());
                ps.setString(11,next.getLocation());
                ps.setInt(12,next.getIso());
                ps.setString(13,next.getCapital_city());
                ps.execute();
            }
            ps = conn.prepareStatement(sql2);
            Iterator<Province> iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                Province next = iterator2.next();
                ps.setString(1,next.getName());
                ps.setString(2,next.getLat());
                ps.setString(3,next.getM_long());
                ps.setInt(4,next.getConfirmed());
                ps.setInt(5,next.getRecovered());
                ps.setInt(6,next.getDeaths());
                ps.setDate(7,new Date(next.getUpdated().getTime()));
                ps.setString(8,next.getCountry());
                ps.execute();
            }
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            JdbcUtils.closeResource(conn,ps);
        }
    }

    public void updateData() {
        Data data = new Data();
        data.get();
        ArrayList<All> list1 = data.getList1();
        ArrayList<Province> list2 = data.getList2();

        boolean f = true;
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        String sql = "update country set confirmed = ?,recovered = ?,deaths = ?,population = ? where country = ?";
        String sql2 = "update province set lat = ?,`long` = ?,confirmed = ?,recovered = ?,deaths = ?,updated = ? where province_name = ? and country_name = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            Iterator<All> iterator = list1.iterator();
            while (iterator.hasNext()) {
                All next = iterator.next();
                ps.setInt(1,next.getConfirmed());
                ps.setInt(2,next.getRecovered());
                ps.setInt(3,next.getDeaths());
                ps.setInt(4,next.getPopulation());
                ps.setString(5,next.getCountry());
                ps.execute();
            }
            ps = conn.prepareStatement(sql2);
            Iterator<Province> iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                Province next = iterator2.next();
                ps.setString(1,next.getLat());
                ps.setString(2,next.getM_long());
                ps.setInt(3,next.getConfirmed());
                ps.setInt(4,next.getRecovered());
                ps.setInt(5,next.getDeaths());
                ps.setDate(6,new Date(next.getUpdated().getTime()));
                ps.setString(7,next.getName());
                ps.setString(8,next.getCountry());
                ps.execute();
            }
            conn.commit();
        } catch (SQLException throwables) {
            f = false;
            throwables.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            JdbcUtils.closeResource(conn,ps);
        }
        if (f) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    public void queryData(String QueryCountry)  {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select confirmed,recovered,deaths,country from country where country = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,QueryCountry);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int confirmed = resultSet.getInt(1);
                int recovered = resultSet.getInt(2);
                int deaths = resultSet.getInt(3);
                String name = resultSet.getString(4);
                CountryForQuery country1 = new CountryForQuery(confirmed,recovered,deaths,name);
                System.out.println(country1);
            }
            String sql2 = "select confirmed,recovered,deaths,updated,province_name,country_name from province where country_name = ?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1,QueryCountry);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int confirmed = resultSet.getInt(1);
                int recovered = resultSet.getInt(2);
                int deaths = resultSet.getInt(3);
                Date updated = resultSet.getDate(4);
                String province_name = resultSet.getString(5);
                String country_name = resultSet.getString(6);
                ProvinceForQuery province = new ProvinceForQuery(confirmed,recovered,deaths,province_name,country_name,updated);
                System.out.println(province);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn,ps,resultSet);
        }
    }
}
