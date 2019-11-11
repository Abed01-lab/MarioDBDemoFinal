// @Abed
// @Sumit
// @ Gustav
//Hello

package Model;

import Database.PizzaMapper;
import java.util.ArrayList;


public class Menu {

    ArrayList <Pizza> menuListe =  new PizzaMapper().getPizzas("menu");
    
    public void printMenu (){
        for(Pizza pizza: menuListe)
            System.out.println(pizza);
    }
}
