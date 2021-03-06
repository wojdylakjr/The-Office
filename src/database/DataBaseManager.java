package database;

import java.sql.*;

public class DataBaseManager {
    public static final String URL = "jdbc:postgresql://ella.db.elephantsql.com:5432/rgmshaji";
    public static final String USER = "rgmshaji";
    public static final String PASSWORD = "A08RoNsnkGV_fhRAcy5J4g0kY_Mbq1Uq";
    public static Connection connection;

    public static void initDatabaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Nie znaleziono sterownika!");
            System.out.println("Wyduk sledzenia bledu i zakonczenie.");
            cnfe.printStackTrace();
            System.exit(1);
        }


        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Polaczono z baza");
        } catch (SQLException se) {
            System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
            se.printStackTrace();
            System.exit(1);
        }
    }

    public static void closeDatabaseConnection() throws SQLException {
        connection.close();
        System.out.println("Zamknieto polaczenie z baza");
    }
}



