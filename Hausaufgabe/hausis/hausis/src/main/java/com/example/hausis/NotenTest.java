package hausaufgabe.logik;
// JUnit 5 Annotation: Methode vor jedem Test ausführen
import org.junit.jupiter.api.BeforeEach;
// JUnit 5 Annotation: markiert eine Testmethode

import org.junit.jupiter.api.Test;

import java.util.List;

// Hamcrest: zentrale assertThat-Funktion
import static org.hamcrest.MatcherAssert.assertThat;
// Hamcrest: Matchers wie is(), contains(), hasSize(), not(), closeTo()
import static org.hamcrest.Matchers.*;
// JUnit: prüft erwartete Exceptions
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotenLogikTest {

 // Test-Feld: System Under Test (SUT) – die Klasse, die wir prüfen
    private NotenLogik logik;

     // Wird VOR JEDEM Test aufgerufen, frische Instanz pro Test
    @BeforeEach
    void setUp() {
          // Initialisiert SUT: vermeidet Seiteneffekte zwischen Tests
        logik = new NotenLogik();
    }

    @Test
    void testNoteHinzufuegenUndListe() {
        logik.noteHinzufuegen(1.3);
        logik.noteHinzufuegen(2.7);

        List<Double> noten = logik.getNotenListe();
         // Assert: Liste enthält GENAU diese Werte (Reihenfolge zählt)
        assertThat(noten, contains(1.3, 2.7));     
            // Assert: Liste hat genau 2 Elemente
        assertThat(noten, hasSize(2));
    }

    @Test
    void testDurchschnitt() {
        logik.noteHinzufuegen(2.0);
        logik.noteHinzufuegen(4.0);

        double avg = logik.notendurchschnitt();
        // Assert: ~3.0 mit sehr kleiner Toleranz (double!)
        assertThat(avg, closeTo(3.0, 1e-9));      
    }
    @Test
    void testBesteNote() {
        logik.noteHinzufuegen(2.5);
        logik.noteHinzufuegen(1.3);
        logik.noteHinzufuegen(3.0);
        // Assert: Minimum ist 1.3
        assertThat(logik.besteNote(), is(1.3));
    }

    @Test
    void testSchlechtesteNote() {
        logik.noteHinzufuegen(2.5);
        logik.noteHinzufuegen(1.3);
        logik.noteHinzufuegen(4.0);
        // Assert: Maximum ist 4.0
        assertThat(logik.schlechtesteNote(), is(4.0));
    }

    @Test
    void testNoteEntfernen() {
        logik.noteHinzufuegen(2.0);
        logik.noteHinzufuegen(3.0);

        logik.noteEntfernen(2.0);
        // Assert: nur noch 3.0 drin (exakte Reihenfolge)
        assertThat(logik.getNotenListe(), contains(3.0));
            // Assert: 2.0 ist nicht mehr in der Liste
        assertThat(logik.getNotenListe(), not(hasItem(2.0)));
    }

    @Test
    void wirftBeiLeererListe_Durchschnitt() {
        // Assert: erwartet IllegalStateException
        // Act: Aufruf ohne vorheriges Hinzufügen
        assertThrows(IllegalStateException.class, () -> logik.notendurchschnitt());
    }

    @Test
    // Test: Guard – leere Liste -> Exception bei besteNote
    void wirftBeiLeererListe_Beste() {
        assertThrows(IllegalStateException.class, () -> logik.besteNote());
    }

    @Test
    // Test: Guard – leere Liste -> Exception bei schlechtesteNote
    void wirftBeiLeererListe_Schlechteste() {
        assertThrows(IllegalStateException.class, () -> logik.schlechtesteNote());
    }

    @Test
    void wirftBeiUngueltigerNote() {
        // Test: Eingabevalidierung – ungültige Werte
        assertThrows(IllegalArgumentException.class, () -> logik.noteHinzufuegen(0.9));
        assertThrows(IllegalArgumentException.class, () -> logik.noteHinzufuegen(6.1));
    }

    @Test
    // Test: Unveränderliche Sicht (Immutability)
    void getNotenListeIstUnveraenderlich() {
        logik.noteHinzufuegen(2.0);
        List<Double> view = logik.getNotenListe();

        // Assert: Modifikation wirft Exception
        assertThrows(UnsupportedOperationException.class, () -> view.add(1.0));
        // Assert: Original bleibt unverändert
        assertThat(view, contains(2.0));
    }
}


