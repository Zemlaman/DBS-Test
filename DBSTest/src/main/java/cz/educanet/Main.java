package cz.educanet;

import java.sql.*;

public class Main {

    public static  void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT Z.jmeno, Z.id, D.nazev FROM Zvirata AS Z JOIN Druhy AS D ON (Z.druh = D.id) LIMIT 100");


        while(result.next()){
            String id = result.getString("id");
            String jmeno = result.getString("jmeno");
            String druh = result.getString("nazev");
            System.out.println(id + "\t;" + jmeno + "\t;" + druh);
        }

        connection.close();
    }
}
