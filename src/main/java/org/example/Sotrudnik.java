package org.example;

public class Sotrudnik {
    private String fio;
    private String dolzhnost;
    private String email;
    private String telefon;
    private double zarplata;
    private int vozrast;

    public Sotrudnik(String fio, String dolzhnost, String email, String telefon, double zarplata, int vozrast) {
        this.fio = fio;
        this.dolzhnost = dolzhnost;
        this.email = email;
        this.telefon = telefon;
        this.zarplata = zarplata;
        this.vozrast = vozrast;
    }

    public void printInfo() {
        System.out.println("Full Name: " + fio);
        System.out.println("Position: " + dolzhnost);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + telefon);
        System.out.println("Salary: " + zarplata);
        System.out.println("Age: " + vozrast);
    }
}