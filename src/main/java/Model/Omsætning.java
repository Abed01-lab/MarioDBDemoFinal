// @Abed
// @Sumit
// @ Gustav

package Model;

import Database.PizzaMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Omsætning {

    ArrayList<Pizza> omsætningsListe = new ArrayList<Pizza>();
    PizzaMapper pm = new PizzaMapper();

    public int beregn() {
        int sum = 0;
        for (Pizza pizza : omsætningsListe) {
            sum = sum + pizza.getPris();
        }
        return sum;
    }
    
    public void tilføjDB (Pizza pizza) {
        pm.InsertPizza(pizza, "Omsætning");
    }

    public void tilføj(Pizza pizza) {
        omsætningsListe.add(pizza);
    }

    public void printListe() {
        getDatafraDB();
        if (omsætningsListe.size() != 0) {
            int i = 0;
            for (Pizza pizza : omsætningsListe) {
                i++;
                System.out.println(i + ". Pizza: " + pizza.getPizzaNavn() + ", afhentnignstid: KL " + pizza.getAfhentingsTid());
            }
        } else {
            System.out.println("Ingen omsætning!");
        }
    }

    private String favoritePizza() {
        getDatafraDB();
        int maxCounter = 0;
        Pizza favoritPizza = new Pizza("", 0,"", 0);

        for (int i = 0; i < omsætningsListe.size(); i++) {
            int counter = 0;
            for (int j = 0; j < omsætningsListe.size(); j++) {
                if (omsætningsListe.get(i) == omsætningsListe.get(j)) {
                    counter++;
                }
            }

            if (maxCounter < counter) {
                maxCounter = counter;
                favoritPizza = (Pizza) omsætningsListe.get(i);
            }
        }
        return "favorit pizza: " + favoritPizza.getPizzaNavn() + ", antal: " + (maxCounter);
    }

    public void exportereOmsætningTilFil() throws IOException {
        getDatafraDB();
        File file = new File("Omsætning.text");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Pizza:\n");
        bw.write("\n");
        for (Pizza pizza : omsætningsListe) {
            bw.write(pizza.toString());
            bw.newLine();
        }

        bw.write("\nTotal omsætning: " + beregn() + " kr.");
        bw.write("\n");
        bw.write(favoritePizza());
        bw.close();
        
        System.out.println("Er blevet eksporterede!");
    }
    
    private void getDatafraDB (){
        omsætningsListe = new PizzaMapper().getPizzas("omsætning");
    }
}
