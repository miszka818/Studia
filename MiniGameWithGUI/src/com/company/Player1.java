package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import com.company.Enum;

public class Player1 {

    public static ArrayList<Player1> HeroesP1 = new ArrayList<Player1>(); // lista bohaterów stworzona w celu ułątwienia sobie życia

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


    public String getSmallHit(Player2 caster) // otrzymanie słabego ciosu
    {

        int critChace = (int)(Math.random()*(max-min+1)+min); //losowanie liczby od 0 do 100


        if(critChace >= 10 + dodgeBonus)  //warunek trafienia ciosem
        {
            if(lightArmour && heavyArmour) // sprawdzanie posiadania pancerza lekkiego i ciężkiego
            {
                int damageTaken = (int) (10*caster.damageRatio); //zmienna obliczająca ile obrażeń otrzyma bohater
                this.health -=damageTaken; // obrażenia otrzymane

                if(this.health <= 0) this.health = 0;  //zabezpieczenie przed minusowymi punktami życia

                return this.name +"'s heavy armour is on."+"\n" + this.name +" is hitted by Small Hit."+"\n"+ "Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            if(lightArmour && !heavyArmour) // tutaj kolejny przypadek pancerza, im lepszy pancerz tym mniejsze obrażenia dostaje bohater
            {
                int damageTaken = (int) (15*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s light armour is on. "+"\n" + this.name +" is hitted by Small Hit."+"\n"+" Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            if(!lightArmour && !heavyArmour) // tutaj ostatni przypadek pancerza
            {
                int damageTaken = (int) (20*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s armour is off."+"\n" + this.name +" is hitted by Small Hit."+"\n"+" Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            /*if(this.health == 0) // sprawdzanie czy bohater żyje
            {
                System.out.println(this.name + " is dead"); //komunikat o śmierci bohatera
            }*/
        }
        else return caster.name + " missed the attack."+"\n" + this.name + "'s turn.";
        return " ";
    }
    public String getMediumHit(Player2 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 40 + dodgeBonus)
        {
            if(lightArmour && heavyArmour)
            {
                int damageTaken = (int) (20*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s heavy armour is on."+"\n" + this.name +" is hitted by Medium Hit."+"\n"+ "Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            if(lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (25*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s light armour is on. "+"\n" + this.name +" is hitted by Medium Hit."+"\n"+" Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            if(!lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (30*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s armour is off."+"\n" + this.name +" is hitted by Medium Hit."+"\n"+" Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
        }
        else return caster.name + " missed the attack."+"\n" + this.name + "'s turn.";
        return " ";
    }
    public String getMassiveHit(Player2 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 70 + dodgeBonus)
        {
            if(lightArmour && heavyArmour)
            {
                int damageTaken = (int) (40*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s heavy armour is on."+"\n" + this.name +" is hitted by Medium Hit."+"\n"+ "Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            if(lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (45*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s light armour is on. "+"\n" + this.name +" is hitted by Medium Hit."+"\n"+" Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            if(!lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (50*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s armour is off."+"\n" + this.name +" is hitted by Medium Hit."+"\n"+" Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
        }
        else return caster.name + " missed the attack."+"\n" + this.name + "'s turn.";
        return " ";
    }

    public String heal() // funkcja lecząca bohatera
    {
            this.health += 30;
            if(this.health >=100) this.health = 100;

        // komunikat o uleczeniu bohatera
        return this.name + " healed himself by 30. Current health is " + this.health+"."+"\n"+ Player2.HeroesP2.get(0).name+"'s turn.";
    }

    public static String printHeroStats()
    {
       return HeroesP1.get(0).toString();
    }

    public static void createHero()
    {
        new Player1();
    }

    public static void setHeroClassMage()
    {
        HeroesP1.get(0).setClass(Enum.Skill.Mage);

        HeroesP1.get(0).setHealth(100);
        HeroesP1.get(0).setDamageRatio(1.3);
        HeroesP1.get(0).setDodgeBonus(5);
        HeroesP1.get(0).setLightArmour(false);
        HeroesP1.get(0).setHeavyArmour(false);
    }

    public static void setHeroClassRanger()
    {
        HeroesP1.get(0).setClass(Enum.Skill.Ranger);
        HeroesP1.get(0).setHealth(100);
        HeroesP1.get(0).setDamageRatio(1.00);
        HeroesP1.get(0).setDodgeBonus(10);
        HeroesP1.get(0).setLightArmour(true);
        HeroesP1.get(0).setHeavyArmour(false);
    }

    public static  void setHeroClassWarrior()
    {
        HeroesP1.get(0).setClass(Enum.Skill.Warrior);
        HeroesP1.get(0).setHealth(100);
        HeroesP1.get(0).setDamageRatio(0.75);
        HeroesP1.get(0).setDodgeBonus(0);
        HeroesP1.get(0).setLightArmour(true);
        HeroesP1.get(0).setHeavyArmour(true);
    }

    public static void chooseHeroName(String name)
    {
        HeroesP1.get(0).setName(name);
    }


}
