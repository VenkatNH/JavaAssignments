package assignmentFour.controller;

import assignmentFour.model.Item;

import java.sql.*;

/**
 * Created by venkatdatta on 07/07/17.
 */
class Producer extends Thread {

    private Itinerary itinerary;

    Producer(Itinerary items){
        itinerary = items;
    }

    public void run(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String myURL = "jdbc:mysql://localhost/abc";
            Connection conn = DriverManager.getConnection(myURL,"root", "root");
            Statement st = conn.createStatement();
            String query = "SELECT * FROM item";

            ResultSet resultSet = st.executeQuery(query);

            while(resultSet.next()){

                itinerary.setItemList(new Item(resultSet.getString("name"),
                                               resultSet.getDouble("price") ,
                                               resultSet.getInt("quantity"),
                                               resultSet.getString("type")));

            }
            itinerary.readComplete=true;
            itinerary.notifyReadComplete();

        } catch (ClassNotFoundException e) {
            System.out.println(" MySQL JDBC Driver Not Found");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
