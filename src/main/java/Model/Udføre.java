// @Abed
// @Sumit
// @ Gustav


package Model;

import Database.PizzaMapper;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;

public class Udføre {

    BestillingsListe bestillingsListe = new BestillingsListe();
    Omsætning omsætning = new Omsætning();
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    PizzaMapper ps = new PizzaMapper();

    public void startProgram() throws IOException {

        while (true) {

            startText();
            int swichInput = input.nextInt();

            switch (swichInput) {

                //Opret Ordre
                case 1:
                    opretBestilling(true);
                    break;

                //Fjern bestilling                               
                case 2:
                    fjernBestilling();
                    break;

                //Print bestillingsListe
                case 3:
                    printBestilling();
                    break;

                //Print Menu
                case 4:
                    printMenu();
                    break;
                
                //Printer omsætingen i console
                case 5:
                    printOmsætning();
                    break;
                 
                //Eksportere omsætning til textfil
                case 6:
                    eksportereOmsætningTiltxt();
                    break;
                
                //SEND MENU TIL DATABASE
                case 7:
                    SendTilDb();
                    break;
            }
        }
    }

    private void opretBestilling(boolean bestil) {
        while (bestil) {
            System.out.println("Hvilken pizza nr vil du tilføje?");
            int pizzaNr = input.nextInt();

            if (pizzaNr > 14 || pizzaNr < 1) {
                System.out.println("Pizza findes ikke, prøv igen!");
                break;
            }

            System.out.println("Hvor mange vil du tilføje");
            int antal = input.nextInt();

            if (antal <= 0) {
                System.out.println("Antalet er ugyldigt...");
                break;
            }

            System.out.println("Hvornår skal orden afhentes?");
            int afhentTid = input.nextInt();

            if (afhentTid > 2400 || afhentTid < 0) {
                System.out.println("Uglydlig tidspunkt...");
                break;
            }

            tilføjeBestillingTilListe(pizzaNr, antal, afhentTid);

            System.out.println("Vil du tilføje mere...");
            System.out.println("1 for ja, 2 for nej");
            int svar = input.nextInt();

            if (svar == 2) {
                break;
            }
        }
    }

    private void fjernBestilling() {
        bestillingsListe.printListe();
        System.out.println("Indtast pizza nr for at fjerne");
        int pizzaNr1 = input.nextInt();

        bestillingsListe.fjern(pizzaNr1);
        System.out.println("Er fjernet!");
    }

    private void printBestilling() {
        Collections.sort(bestillingsListe.bestillingsListe);
        bestillingsListe.printListe();
    }

    private void printMenu() {
        menu.printMenu();
    }

    private void printOmsætning() {
        omsætning.printListe();
        System.out.println(omsætning.beregn());
    }

    private void eksportereOmsætningTiltxt() throws IOException {
        omsætning.exportereOmsætningTilFil();
    }

    private void tilføjeBestillingTilListe(int nr, int antal, int tid) {
        for (int i = 0; i < antal; i++) {
            bestillingsListe.tilføj(menu.menuListe.get(nr));
            omsætning.tilføj(menu.menuListe.get(nr));
            omsætning.tilføjDB(menu.menuListe.get(nr));       
            menu.menuListe.get(i).afhentningsTid = tid;
        }
    }
    
    private void SendTilDb(){
        for(Pizza pizza: menu.menuListe){
           ps.InnsertPizza(pizza, "pizza");
        }
        System.out.println("tjek database!");
            
    }

    private void startText() {
        System.out.println("\nIndtast: ");
        System.out.println("1. Opret bestilling");
        System.out.println("2. Fjern en bestilling");
        System.out.println("3. Se Bestillings Liste");
        System.out.println("4. Se Menu");
        System.out.println("5. Se Omsætning");
        System.out.println("6. Eksportere omsætning");

    }
    

}
