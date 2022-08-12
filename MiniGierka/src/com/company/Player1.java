package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import com.company.Enum;
public class Player1 {

    static ArrayList<Player1> HeroesP1 = new ArrayList<Player1>(); // lista bohaterów stworzona w celu ułątwienia sobie życia

    public Player1(){HeroesP1.add(this);} // konstruktor postaci


    String name; //imie postaci

    int health; // punkty zdrowia
    boolean lightArmour; // lekki pancerz
    boolean heavyArmour; // ciężki pancerz
    int dodgeBonus; // dodatkowe punkty uniku
    double damageRatio; // przelicznik obrażeń

    Enum.Skill Class;  // Klasa postaci



    // poniżej kilka funkcji sprawdzających wartości atrybutów lub ustawiających je
    public boolean isLightArmour() {
        return lightArmour;
    }

    public void setLightArmour(boolean lightArmour) {
        this.lightArmour = lightArmour;
    }

    public boolean isHeavyArmour() {
        return heavyArmour;
    }

    public void setHeavyArmour(boolean heavyArmour) {
        this.heavyArmour = heavyArmour;
    }

    public int getDodgeBonus() {
        return dodgeBonus;
    }

    public void setDodgeBonus(int dodgeBonus) {
        this.dodgeBonus = dodgeBonus;
    }

    public double getDamageRatio() {
        return damageRatio;
    }

    public void setDamageRatio(double damageRatio) {
        this.damageRatio = damageRatio;
    }

    public void setClass(Enum.Skill aClass) {
        Class = aClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }



    public int min = 0; // zmienna min i max jest potrzebna do losowania liczby między 0 a 100 w celu określenia czy dany atak trafił czy nie
    public int max = 100;

    @Override
    public String toString() { // toString do wyświetlanie informacji o postaci
        return this.name+ "'s Stats: \n" +
                "Class: " + this.Class +"\n"+
                "Health: " + this.health +"\n"+
                "Dodge bonus: " + this.dodgeBonus +"\n"+
                "Damage ratio: " + this.damageRatio +"\n"+
                "Light Armour: " + this.lightArmour +"\n"+
                "Heavy armour: " + this.heavyArmour +"\n";

    }



    public void getSmallHit(Player2 caster) // otrzymanie słabego ciosu
    {

        int critChace = (int)(Math.random()*(max-min+1)+min); //losowanie liczby od 0 do 100


        if(critChace >= 10 + dodgeBonus)  //warunek trafienia ciosem
        {
            if(lightArmour && heavyArmour) // sprawdzanie posiadania pancerza lekkiego i ciężkiego
            {
                int damageTaken = (int) (10*caster.damageRatio); //zmienna obliczająca ile obrażeń otrzyma bohater
                this.health -=damageTaken; // obrażenia otrzymane

                if(this.health <= 0) this.health = 0;  //zabezpieczenie przed minusowymi punktami życia
                System.out.println(this.name +"'s heavy armour is on. " + this.name +" is hitted by Small Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health); // wyświetlanie informacji o uderzeniu
            }
            if(lightArmour && !heavyArmour) // tutaj kolejny przypadek pancerza, im lepszy pancerz tym mniejsze obrażenia dostaje bohater
            {
                int damageTaken = (int) (15*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s light armour is on. " + this.name +" is hitted by Small Hit. Health is reduced by "+ damageTaken +"."+
                       this.name +"'s new Health is " + this.health);
            }
            if(!lightArmour && !heavyArmour) // tutaj ostatni przypadek pancerza
            {
                int damageTaken = (int) (20*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s armour is off. " + this.name +" is hitted by Small Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(this.health == 0) // sprawdzanie czy bohater żyje
            {
                System.out.println(this.name + " is dead"); //komunikat o śmierci bohatera
            }
        }
        else System.out.println(this.name+" dodged the attack."); // komunikat o uniknieciu ataku przez bohatera
    }
    public void getMediumHit(Player2 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 40 + dodgeBonus)
        {
            if(lightArmour && heavyArmour)
            {
                int damageTaken = (int) (20*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s heavy armour is on. " + this.name +" is hitted by Medium Hit. Health is reduced by "+ damageTaken+"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (25*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s light armour is on. " + this.name +" is hitted by Medium Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(!lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (30*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s armour is off. " + this.name +" is hitted by Medium Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(this.health == 0)
            {
                System.out.println(this.name + " is dead");
            }
        }
        else System.out.println(this.name+" dodged the attack.");
    }
    public void getMassiveHit(Player2 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 70 + dodgeBonus)
        {
            if(lightArmour && heavyArmour)
            {
                int damageTaken = (int) (40*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s heavy armour is on. " + this.name +" is hitted by Massive Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (45*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s light armour is on. " + this.name +" is hitted by Massive Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(!lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (50*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s armour is off. " + this.name +" is hitted by Massive Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(this.health == 0)
            {
                System.out.println(this.name + " is dead");
            }
        }
        else System.out.println(this.name+" dodged the attack.");
    }

    public void heal() // funkcja lecząca bohatera
    {
        if(this.Class == Enum.Skill.Mage) // sprawdzam jaką klasę ma bohater, aby nie przekroczyć jego maksymalnej wartości życia
        {
            this.health += 30;
            if(this.health >=80) this.health = 80;
        }
        if(this.Class == Enum.Skill.Ranger)
        {
            this.health += 30;
            if(this.health >=100) this.health = 100;
        }
        if(this.Class == Enum.Skill.Warrior)
        {
            this.health += 30;
            if(this.health >=120) this.health = 120;
        }
        // komunikat o uleczeniu bohatera
        System.out.println(this.name + " healed himself by 30. Current health is " + this.health);
    }

    public void whatAction(Player1 hero1, Player2 hero2) throws WrongActionException // funkcja wywoływana w samej rozgrywce, gracz musi wybrać rodzaj akcji jaki chce wykonać
    {
        System.out.println(Player1.HeroesP1.get(0).name +" choose your action: \n (1) heal \n (2) Small Hit \n (3) Medium Hit \n (4) Massive Hit");

        Scanner scan1 = new Scanner(System.in);
        int actionP1 = scan1.nextInt();

        if(actionP1 != 1 && actionP1 != 2 && actionP1 != 3 && actionP1 != 4)
        {
            throw new WrongActionException("\nWrong number. Try Again.");
        }
        else {

            switch (actionP1) // wybór akcji
            {
                case 1:
                    hero1.heal();
                    break;
                case 2:
                    hero2.getSmallHit(hero1);
                    break;
                case 3:
                    hero2.getMediumHit(hero1);
                    break;
                case 4:
                    hero2.getMassiveHit(hero1);
                    break;
            }
        }
    }

    public static void createHero() throws WrongActionException // funkcja do tworzenia nowego bohatera i ustawienia jego statystyk
    {


        Scanner s1 = new Scanner(System.in); //tworzenie skanera

        System.out.println("Choose your hero class: \n (1) Mage \n (2) Ranger \n (3) Warrior ");// komunikat o wyborze klasy bohatera
        int classP1 = s1.nextInt(); // przyjęcie z klawiatury wartości odpowiadającej za wybór klasy

        if(classP1 != 1 && classP1 != 2 && classP1 != 3)
        {
            throw new WrongActionException("\nWrong number. Try Again.");
        }
        else {
            new Player1(); // użycie podstawowego konstruktora

            switch (classP1)  // ustawianie klasy bohatera
            {
                case 1:
                    HeroesP1.get(0).setClass(Enum.Skill.Mage);
                    break;
                case 2:
                    HeroesP1.get(0).setClass(Enum.Skill.Ranger);
                    break;
                case 3:
                    HeroesP1.get(0).setClass(Enum.Skill.Warrior);
                    break;
            }

            if (HeroesP1.get(0).Class == Enum.Skill.Mage) // ustawianie wartości bohatera w zależności od wybranej klasy
            {
                HeroesP1.get(0).setHealth(100);
                HeroesP1.get(0).setDamageRatio(1.3);
                HeroesP1.get(0).setDodgeBonus(5);
                HeroesP1.get(0).setLightArmour(false);
                HeroesP1.get(0).setHeavyArmour(false);
            }
            if (HeroesP1.get(0).Class == Enum.Skill.Ranger) // ustawianie wartości bohatera w zależności od wybranej klasy
            {
                HeroesP1.get(0).setHealth(100);
                HeroesP1.get(0).setDamageRatio(1.00);
                HeroesP1.get(0).setDodgeBonus(10);
                HeroesP1.get(0).setLightArmour(true);
                HeroesP1.get(0).setHeavyArmour(false);
            }
            if (HeroesP1.get(0).Class == Enum.Skill.Warrior) // ustawianie wartości bohatera w zależności od wybranej klasy
            {
                HeroesP1.get(0).setHealth(100);
                HeroesP1.get(0).setDamageRatio(0.75);
                HeroesP1.get(0).setDodgeBonus(0);
                HeroesP1.get(0).setLightArmour(true);
                HeroesP1.get(0).setHeavyArmour(true);
            }
            System.out.println("Choose your name: "); // wybór swojego imienia
            String nameP1 = s1.next();
            HeroesP1.get(0).setName(nameP1); // ustawienie swojego imienia
        }
    }
}
