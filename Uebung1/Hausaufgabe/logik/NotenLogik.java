package hausaufgabe.logik;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class NotenLogik {

    private List <Double> noten = new ArrayList<>();
    
    public double notendurchschnitt() {
        listeLeer();

        double summe = 0;
        for (double note : noten) {
            summe += note;
        }
        return summe / noten.size();
    
    }
    public double besteNote() {
        listeLeer();

        double beste = noten.get(0);
        for (double note : noten) {
            if (note < beste) {
                beste = note;
            }
        }
        return beste;
    }
    public double schlechtesteNote() {
        listeLeer();

        double schlechteste = noten.get(0);
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
    private void noteGueltig(double note){
        if (note < 1.0 || note > 6.0) 
            throw new IllegalArgumentException("Ungültige Note: " + note);
     }
     private void listeLeer(){
        if (noten.isEmpty())
            throw new IllegalStateException("Notenliste ist leer.");
     }
    }
    
    