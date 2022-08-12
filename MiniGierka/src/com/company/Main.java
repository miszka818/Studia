package com.company;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Player no 1. Create your Hero:");

        while(true) {
            try {
                Player1.createHero();
                break;
            } catch (Exception e1) {
                System.out.println("A problem occured: "+ "\nWrong number.Try again.\n");
            }
        }

        System.out.println();
        System.out.println(Player1.HeroesP1.get(0));

        System.out.println();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Player no 2. Create your Hero:");
        while (true) {
            try {
                Player2.createHero();
                break;
            }
            catch(Exception e1)
            {
                System.out.println("A problem occured: "+ "\nWrong number.Try again.\n");
            }
        }
        System.out.println();
        System.out.println(Player2.HeroesP2.get(0));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("ARE YOU READY?! \n"+"Let's the Battle begin!\n");


        while(true) {

            // akcja gracza nr 1
            while(true) {
                try {
                    Player1.HeroesP1.get(0).whatAction(Player1.HeroesP1.get(0),Player2.HeroesP2.get(0));
                    break;
                } catch (Exception e1) {
                    System.out.println("A problem occured: "+ "\nWrong number.Try again.\n");
                }
            }

            System.out.println(); // spacja

            //sprawdzanie czy ktoś wygrał
            if(Player1.HeroesP1.get(0).health == 0 || Player2.HeroesP2.get(0).health == 0)
            {
                System.out.println("Someone died. Game is over.");
                break;
            }

            // akcja gracza nr 2
            while(true) {
                try {
                    Player2.HeroesP2.get(0).whatAction(Player1.HeroesP1.get(0),Player2.HeroesP2.get(0));
                    break;
                } catch (Exception e1) {
                    System.out.println("A problem occured: "+ "\nWrong number.Try again.\n");
                }
            }

            System.out.println(); // spacja

            // sprawdzenie czy ktoś wygrał
            if(Player1.HeroesP1.get(0).health == 0 || Player2.HeroesP2.get(0).health == 0)
            {
                System.out.println("Someone died. Game is over.");
                break;
            }

        }
        }

}
