package Database;

import Model.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PizzaMapper {

    public ArrayList<Pizza> getPizzas(String db) {
        ArrayList <Pizza> pizzas = new ArrayList();
        try {
            Connection con = DatabaseConnector.getConnector();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + db);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");

                Pizza pizza = new Pizza(name, id, description, price);
                pizzas.add(pizza);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PizzaMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pizzas;
    }
        
    public void InnsertPizza (Pizza pizza, String db) {
        String sql = "INSERT INTO " + db + " (name, description, price) VALUES (?,?,?)";
        try {
            Connection con = DatabaseConnector.getConnector();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pizza.getPizzaNavn());
            ps.setString(2, pizza.getBeskrivelse());
            ps.setInt(3, pizza.getPris());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PizzaMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


