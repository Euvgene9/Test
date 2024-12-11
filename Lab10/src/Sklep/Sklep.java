package Sklep;

import KartaKlienta.*;
import Transakcja.*;

import java.io.*;
import java.util.Scanner;

public class Sklep {
	private static final int max=100;
	Transakcja[] transakcje= new Transakcja[max];
	
	public static void Menu() {
		System.out.println("\nMenu:");
        System.out.println("1. Dodaj kilka transakcji");
        System.out.println("2. Wyświetl wszystkie transakcje");
        System.out.println("3. Dodaj jedną transakcję");
        System.out.println("4. Policz transakcje z KartąSeniora");
        System.out.println("5. Znajdź klienta z KartąStudenta, który zapłacił najwięcej");
        System.out.println("6. Zapisz transakcje z KartąStudenta do pliku");
        System.out.println("0. Wyjście");
        System.out.print("Wybierz opcję: ");
	}

	public static void main(String[] args) {
		
		int wybor;
		Sklep sklep = new Sklep();
        Scanner scanner = new Scanner(System.in);
        Menu();
        while(scanner.hasNext()) {
        	
        wybor=scanner.nextInt(); 
        scanner.nextLine();
        if(wybor!=0) {
        	switch(wybor) {
        	case(1):
        		sklep.dodajKilkaTransakcji();
        	break;
        	case(2):
        		sklep.wyswietlTransakcje();
        	break;
        	case(3):
        		sklep.dodajTransakcje(scanner);
        	break;
        	case(4):
        		sklep.policzTransakcjeKartaSeniora();
        	break;
        	case(5):
        		sklep.znajdzNajwyzszaTransakcjeKartaStudenta();
        	break;
        	case(6):
        		sklep.zapiszTransakcjeKartaStudenta();
        	break;
        	default:
        	{
        		System.out.println("Niepoprawna opcja!");
        		break;
        		
        	}
        }
        	Menu();
     }else break;
        
  }
        
	}

	
	private void dodajKilkaTransakcji() {
		 if (Transakcja.getNumerTransakcji() + 3 > max) {
			 System.out.println("Nie można dodać więcej transakcji!");
			 return;  
			 }
	        transakcje[Transakcja.getNumerTransakcji()] = new Transakcja(100, new KartaPodstawowa(1, "Kowal"));
	        transakcje[Transakcja.getNumerTransakcji()] = new Transakcja(200, new KartaStudenta(2, "Marchew"));
	        transakcje[Transakcja.getNumerTransakcji()] = new Transakcja(150, new KartaSeniora(3, "Wiśnia"));
	        System.out.println("Dodano kilka transakcji.");
	        }
	
	 private void wyswietlTransakcje() {
	        if (Transakcja.getNumerTransakcji() == 0) {
	            System.out.println("Brak transakcji.");
	        } else {
	            for (int i = 0; i < Transakcja.getNumerTransakcji(); i++) {
	                System.out.println(transakcje[i]);
	            }
	        }
	    }
	 
	 
	
	private void dodajTransakcje(Scanner scanner) {
        System.out.print("Podaj kwotę: ");
        double kwota = scanner.nextDouble();
        System.out.print("Wybierz typ karty (1 - Podstawowa, 2 - Studenta, 3 - Seniora): ");
        int typKarty = scanner.nextInt();
        System.out.print("Podaj nazwisko klienta: ");
        scanner.nextLine(); 
        String nazwisko = scanner.nextLine();
        
        KartaKlienta karta;
        switch (typKarty) {
        case(1):
        	karta=new KartaPodstawowa((Transakcja.getNumerTransakcji()+1), nazwisko);
        break;
        case(2):
        	karta=new KartaStudenta((Transakcja.getNumerTransakcji()+1), nazwisko);
        break;
        case(3):
        	karta=new KartaSeniora((Transakcja.getNumerTransakcji()+1), nazwisko);
        break;
        default:
            System.out.println("Niepoprawny typ karty!");
            return;
        }
        transakcje[Transakcja.getNumerTransakcji()] = new Transakcja(kwota, karta);
        System.out.println("Dodano transakcję.");
        
	}
	
	private void policzTransakcjeKartaSeniora() {
        int liczba = 0;
        for (int i = 0; i < Transakcja.getNumerTransakcji(); i++) {
            if (transakcje[i].getKarta() instanceof KartaSeniora) {
                liczba++;
            }
        }
        System.out.println("Liczba transakcji z KartąSeniora: " + liczba);
    }
	
	 private void znajdzNajwyzszaTransakcjeKartaStudenta() {
		 Transakcja maxTransakcja=null;
		 double max=0;
	        for (int i = 0; i < Transakcja.getNumerTransakcji(); i++) {
	            if (transakcje[i].getKarta() instanceof KartaStudenta) {
	            	Transakcja T=transakcje[i];
	                if (T.kwotaDoZaplaty() > max) {
	                	max=T.kwotaDoZaplaty();
	                    maxTransakcja=T;
	                    
	                }
	            }
	        }
	        if (maxTransakcja != null) {
	            System.out.println("Najwyższa transakcja z KartąStudenta: " + maxTransakcja);
	        } else {
	            System.out.println("Brak transakcji z KartąStudenta.");
	        }
	    }
	 
	 private void zapiszTransakcjeKartaStudenta() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transakcje_studenta.txt"))) {
	            for (int i = 0; i < Transakcja.getNumerTransakcji(); i++) {
	                if (transakcje[i].getKarta() instanceof KartaStudenta) {
	                    writer.write(transakcje[i].toString());
	                    writer.newLine();
	                }
	            }
	            System.out.println("Zapisano transakcje do pliku.");
	        } catch (IOException e) {
	            System.out.println("Błąd podczas zapisywania do pliku.");
	        }
	 }
	        
	    

	 }
