// @Abed
// @Sumit
// @ Gustav

package Model;

public class Pizza implements Comparable{

    String pizzaNavn;
    String beskrivelse;
    int afhentningsTid;
    int pizzaNr;
    int pris;

    public Pizza(String pizzaNavn, int pizzaNr, String beskrivelse, int pris) {
        this.pizzaNavn = pizzaNavn;
        this.pizzaNr = pizzaNr;
        this.pris = pris;
        this.beskrivelse = beskrivelse;

    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getPris() {
        return pris;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public void setPizzaNavn(String pizzaNavn) {
        this.pizzaNavn = pizzaNavn;
    }

    public int getAfhentingsTid() {
        return afhentningsTid;
    }

    @Override
    public int compareTo(Object pizza) {
        int compareTime = ((Pizza) pizza).getAfhentingsTid();
        return this.afhentningsTid - compareTime;
    }

    @Override
    public String toString() {
        return "Nr: " + pizzaNr + ", Navn: " + pizzaNavn + ", Beskrivelse: " + beskrivelse + ", Pris: " + pris + " Kr.";
    }
}
