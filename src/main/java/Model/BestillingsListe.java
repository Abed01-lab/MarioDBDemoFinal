// @Abed
// @Sumit
// @ Gustav

package Model;

import java.util.ArrayList;

public class BestillingsListe {

    ArrayList<Pizza> bestillingsListe = new ArrayList<Pizza>();


    public void tilføj(Pizza pizza) {
        bestillingsListe.add(pizza);
    }

    public void fjern(int i) {
        bestillingsListe.remove(i - 1);
    }

    public void printListe() {
        if (bestillingsListe.size() != 0) {
            int i = 0;
            for (Pizza pizza : bestillingsListe) {
                i++;
                System.out.println(i + ". Pizza: " + pizza.getPizzaNavn() + ", afhentnignstid: KL " + pizza.getAfhentingsTid());
            }
        } else {
            System.out.println("Ingen bestillinger...");
        }
    }
}
