package hausaufgabe.Logik;

import java.util.List;

public class NotenLogik {

    private List <Double> noten = new ArrayList<>();
    
    double notendurchschnitt() {
        listeLeer();

        double summe = 0;
        for (double note : noten) {
            summe += note;
        }
        return (double) summe / noten.size();
    
    }
    public double besteNote() {
        listeLeer();

        double beste;
        for (double note : noten) {
            if (note < beste) {
                beste = note;
            }
        }
        return beste;
    }
    public double schlechtesteNote() {
        listeLeer();

        double schlechteste;
        for (double note : noten) {
            if (note > schlechteste) {
                schlechteste = note;
            }
        }
        return schlechteste;
    }
    public void noteHinzufuegen (double note) {
        noteGueltig(note);
        noten.add(note);
    }
    public void noteEntfernen (double note) {
        listeLeer();
        noten.remove(note);
    
    }
    public List <Double> getNotenListe() {
    return Collections.unmodifiableList(noten);
    } 
    public static void noteGueltig(double note){
        if (note < 1.0 || note > 6.0) 
            throw new IllegalArgumentException("Ungültige Note: " + note);
     }
     public static void listeLeer(){
        if (noten.isEmpty())
            throw new IllegalStateException("Notenliste ist leer.");
     }
    }
    
    