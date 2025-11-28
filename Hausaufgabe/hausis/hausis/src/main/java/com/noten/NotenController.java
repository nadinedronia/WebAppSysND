package com.noten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotenController {

    @Autowired
    private NotenLogik notenLogik;

    // Seite anzeigen
    @GetMapping("/noten")
    public String showNotenPage(Model model) {

        // Notenliste ins Model legen
        model.addAttribute("notenListe", notenLogik.getNotenListe());

        // Wenn Liste nicht leer ist: Durchschnitt, beste, schlechteste
        if (!notenLogik.getNotenListe().isEmpty()) {
            model.addAttribute("durchschnitt", notenLogik.notendurchschnitt());
            model.addAttribute("beste", notenLogik.besteNote());
            model.addAttribute("schlechteste", notenLogik.schlechtesteNote());
        }

        // Attribut für Fehlermeldung oder Info kannst du später noch hinzufügen

        return "noten"; // verweist auf noten.html in templates
    }

    // Neue Note aus Formular übernehmen
    @PostMapping("/noten")
    public String addNote(@RequestParam("note") double note, Model model) {
        try {
            notenLogik.noteHinzufuegen(note);
        } catch (IllegalArgumentException | IllegalStateException e) {
            // einfache Variante: Fehler wieder an die Seite geben
            model.addAttribute("error", e.getMessage());
        }

        // Danach wieder auf die GET-Seite – PRG-Pattern wäre redirect, hier einfach:
        return "redirect:/noten";
    }
}
