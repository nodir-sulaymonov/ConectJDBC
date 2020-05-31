package com.nodir.query;

import com.nodir.connection.DataSource;
import com.nodir.entityQuery.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


public class QueryExecutor {

    private static DataSource dataSource = new DataSource();

    private static final String SQL_QUERY_1 = "SELECT city  from airports group by city having Count(city) > 1;";
    private static final String SQl_QUERY_2 = "SELECT airport_name FROM airports WHERE city =";


    public static List<SolutionQuery1> query1() {

        List<String> citys = new ArrayList<>();


        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_QUERY_1);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                citys.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());
            citys = new ArrayList<>();
        }



        List<SolutionQuery1> solutionQuery1s = new ArrayList<>();

        for (String city : citys) {

            String query = SQl_QUERY_2 +"'"+ city + "';";

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {
                SolutionQuery1 solutionQuery1;
                String airportsName = "";
                while (rs.next()) {
                    airportsName = airportsName+ ",  " + rs.getString(1);
                }
                solutionQuery1 = new SolutionQuery1(city, airportsName);
                solutionQuery1s.add(solutionQuery1);

            } catch (SQLException ex) {
                System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());
                return new ArrayList<>();
            }

        }

        return solutionQuery1s;
    }

    public static List<SolutionQuery2> selectQuery2(){
        String query  = "SELECT a.city, count(a.city) FROM airports a, flights f WHERE \n" +
                "a.airport_code = f.departure_airport AND f.status = 'Cancelled'\n" +
                "GROUP BY a.city  ORDER BY COUNT(a.city);\n";
        List<SolutionQuery2> solutionQuery2s = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();

             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            SolutionQuery2 solutionQuery2;
            while (rs.next()) {
                String city = rs.getString(1);
                int count = rs.getInt(2);
                solutionQuery2 = new SolutionQuery2(city, count);
                solutionQuery2s.add(solutionQuery2);
            }
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());
            return new ArrayList<>();
        }
        return solutionQuery2s;
    }

    public static  List<SolutionQuery3> selectQuery3(){
        String query  = "(SELECT air.city,  MAX(fl.arrival_airport\t) arival_point, MIN((DATE_PART('day', fl.scheduled_arrival::timestamp - fl.scheduled_departure::timestamp) * 24 + " +
                " DATE_PART('hour', fl.scheduled_arrival::timestamp - fl.scheduled_departure::timestamp)) * 60 +  DATE_PART('minute', fl.scheduled_arrival::timestamp - fl.scheduled_departure::timestamp)) duration" +
                " FROM flights fl JOIN airports air ON fl.departure_airport = air.airport_code \n" +
                "GROUP BY air.city);";
        List<SolutionQuery3> solutionQuery3s = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            SolutionQuery3 solutionQuery3;
            while (rs.next()) {
                String city = rs.getString(1);
                String arrival_point = rs.getString(2);
                int duration = rs.getInt(3);
                solutionQuery3 = new SolutionQuery3(city, arrival_point, duration);
                solutionQuery3s.add(solutionQuery3);
            }
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());
            return new ArrayList<>();
        }
        return solutionQuery3s;
    }

    public static List <SolutionQuery4> selectQuery4(){
        String query  = "SELECT month, COUNT(tbl.status) FROM  (SELECT DATE_PART('month', scheduled_departure) as month, status FROM flights WHERE status = 'Cancelled') as tbl\n" +
                "GROUP BY tbl.month;";

        List<SolutionQuery4> solutionQuery4s = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            SolutionQuery4 solutionQuery4;
            while (rs.next()) {
                int monz = rs.getInt(1);
                int count = rs.getInt(2);

                solutionQuery4 = new SolutionQuery4(monz, count);
                solutionQuery4s.add(solutionQuery4);
            }
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());
            return new ArrayList<>();
        }
        return solutionQuery4s;
    }

    public static List <SolutionQuery5> selectQueryIn5(){
        String query  = "SELECT DATE_PART('day', scheduled_arrival) AS day, COUNT(flight_id) as flights\n" +
                "            FROM flights\n" +
                "            WHERE actual_arrival IS NOT NULL\n" +
                "              AND arrival_airport IN ('DME', 'SVO', 'VKO')\n" +
                "            GROUP BY day;";

        List<SolutionQuery5> solutionQuery5s = new ArrayList<>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            SolutionQuery5 solutionQuery5;
            while (rs.next()) {
                int day_count = rs.getInt(1);
                int flight_count = rs.getInt(2);

                solutionQuery5 = new SolutionQuery5(day_count, flight_count);
                solutionQuery5s.add(solutionQuery5);
            }
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());
            return new ArrayList<>();
        }
        return solutionQuery5s;
    }
    public static List <SolutionQuery5> selectQueryOut5(){
        String query  = "SELECT DATE_PART('day', scheduled_departure) AS day, COUNT(flight_id) as flights\n" +
                "            FROM flights\n" +
                "            WHERE actual_departure IS NOT NULL\n" +
                "              AND departure_airport IN ('DME', 'SVO', 'VKO')\n" +
                "            GROUP BY day;";

        List<SolutionQuery5> solutionQuery5s = new ArrayList<>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            SolutionQuery5 solutionQuery5;
            while (rs.next()) {
                int day_count = rs.getInt(1);
                int flight_count = rs.getInt(2);

                solutionQuery5 = new SolutionQuery5(day_count, flight_count);
                solutionQuery5s.add(solutionQuery5);
            }
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());
            return new ArrayList<>();
        }
        return solutionQuery5s;
    }

    public static void deleteQuery6(){
        String query  = "CREATE PROCEDURE insert_data(model varchar)\n" +
                "LANGUAGE SQL\n" +
                "AS $$\n" +
                "CREATE TABLE tempTable (ticket_no VARCHAR,  flight_id INT);\n" +
                "INSERT INTO values tempTable \n" +
                "Select ticket_no, flight_id from ticket_flights where flight_id  in (select flight_id from flights where aircraft_code in (Select aircraft_code from aircrafts WHERE model ->> 'en' = 'Boeing'));\n" +
                "\n" +
                "delete from ticket_flights where ticket_no in (select ticket_no from tempTable);\n" +
                "delete from tickets where ticket_no in (select ticket_no from tempTable);\n" +
                "delete from flights where flight_id in (select flight_id from tempTable);\n" +
                "DROP TABLE tempTable;\n" +
                "$$;\n" +
                "\n" +
                "CALL insert_data('Nodir');";

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int day_count = rs.getInt(1);
                int flight_count = rs.getInt(2);

            }
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }
    }

    public static List <SolutionQuery7> selectQuery7(){
        String query  = "SELECT SUM(amount) as lesion, DATE_PART('day', scheduled_departure) AS day\n" +
                "            FROM ticket_flights as tf\n" +
                "            JOIN flights as fl ON tf.flight_id = fl.flight_id\n" +
                "            JOIN airports as air ON fl.departure_airport = air.airport_code\n" +
                "            WHERE (scheduled_departure BETWEEN '01.08.17' AND '15.08.17') AND air.city ->>'en' ='Moscow'\n" +
                "            GROUP BY day;";

        List<SolutionQuery7> solutionQuery7s = new ArrayList<>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            SolutionQuery7 solutionQuery7;
            while (rs.next()) {
                int sum_lesion = rs.getInt(1);
                int day_count = rs.getInt(2);
                solutionQuery7 = new SolutionQuery7(sum_lesion, day_count);
                solutionQuery7s.add(solutionQuery7);
            }
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());
            return new ArrayList<>();
        }
        return solutionQuery7s;
    }
}
