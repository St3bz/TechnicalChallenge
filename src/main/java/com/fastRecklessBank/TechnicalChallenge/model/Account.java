package com.fastRecklessBank.TechnicalChallenge.model;



public class Account {
    int id;
    String name;
    double kontostand;

    public Account(int id, double kontostand) {
        this.kontostand = kontostand;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getKontostand() {
        return this.kontostand;
    }
    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    // hinzufügen einer Liste zur Begrenzung von 50 Transaktionen
    // Funktion zum ersetzen der ältesten Transaktion mit der neuen Transaktion bei überschreiten der 50 Transaktionen
}
