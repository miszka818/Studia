package com.company;
import com.company.Enum;

import java.util.ArrayList;
import java.util.Scanner;

public class Player2 extends Player1{

    static ArrayList<Player2> HeroesP2 = new ArrayList<Player2>();

    public Player2(){HeroesP2.add(this);}

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean isLightArmour() {
        return super.isLightArmour();
    }

    @Override
    public void setLightArmour(boolean lightArmour) {
        super.setLightArmour(lightArmour);
    }

    @Override
    public boolean isHeavyArmour() {
        return super.isHeavyArmour();
    }

    @Override
    public void setHeavyArmour(boolean heavyArmour) {
        super.setHeavyArmour(heavyArmour);
    }

    @Override
    public int getDodgeBonus() {
        return super.getDodgeBonus();
    }

    @Override
    public void setDodgeBonus(int dodgeBonus) {
        super.setDodgeBonus(dodgeBonus);
    }

    @Override
    public double getDamageRatio() {
        return super.getDamageRatio();
    }

    @Override
    public void setDamageRatio(double damageRatio) {
        super.setDamageRatio(damageRatio);
    }

    @Override
    public void setClass(Enum.Skill aClass) {
        super.setClass(aClass);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }


    public void getSmallHit(Player1 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 20 + dodgeBonus)
        {
            if(lightArmour && heavyArmour)
            {
                int damageTaken = (int) (10*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s heavy armour is on. " + this.name +" is hitted by Small Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (15*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s light armour is on. " + this.name +" is hitted by Small Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(!lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (20*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                System.out.println(this.name +"'s armour is off. " + this.name +" is hitted by Small Hit. Health is reduced by "+ damageTaken +"."+
                        this.name +"'s new Health is " + this.health);
            }
            if(this.health == 0)
            {
                System.out.println(this.name + " is dead");
            }
        }
        else System.out.println(this.name+" dodged the attack.");
    }

    public void getMediumHit(Player1 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 50 + dodgeBonus)
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
    public void getMassiveHit(Player1 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 80 + dodgeBonus)
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

    @Override
    public void heal() {
        super.heal();
    }

    @Override
    public void whatAction(Player1 hero1, Player2 hero2) throws WrongActionException {

        System.out.println(Player2.HeroesP2.get(0).name +" choose your action: \n (1) heal \n (2) Small Hit \n (3) Medium Hit \n (4) Massive Hit");
        Scanner scan2 = new Scanner(System.in);

        int actionP2 = scan2.nextInt();

        if(actionP2 != 1 && actionP2 != 2 && actionP2 != 3 && actionP2 != 4)
        {
            throw new WrongActionException("\nWrong number. Try Again.");
        }
        else {
            switch (actionP2) {
                case 1:
                    hero2.heal();
                    break;
                case 2:
                    hero1.getSmallHit(hero2);
                    break;
                case 3:
                    hero1.getMediumHit(hero2);
                    break;
                case 4:
                    hero1.getMassiveHit(hero2);
                    break;
            }
        }
    }

    public static void createHero() throws WrongActionException
    {


        Scanner s1 = new Scanner(System.in);

        System.out.println("Choose your hero class: \n (1) Mage \n (2) Ranger \n (3) Warrior ");
        int classP2 = s1.nextInt();

        if(classP2 != 1 && classP2 != 2 && classP2 != 3)
        {
            throw new WrongActionException("\nWrong number. Try Again.");
        }
        else {
            new Player2();

            switch (classP2) {
                case 1:
                    HeroesP2.get(0).setClass(Enum.Skill.Mage);
                    break;
                case 2:
                    HeroesP2.get(0).setClass(Enum.Skill.Ranger);
                    break;
                case 3:
                    HeroesP2.get(0).setClass(Enum.Skill.Warrior);
                    break;
            }
            if (HeroesP2.get(0).Class == Enum.Skill.Mage) {
                HeroesP2.get(0).setHealth(100);
                HeroesP2.get(0).setDamageRatio(1.35);
                HeroesP2.get(0).setDodgeBonus(5);
                HeroesP2.get(0).setLightArmour(false);
                HeroesP2.get(0).setHeavyArmour(false);
            }
            if (HeroesP2.get(0).Class == Enum.Skill.Ranger) {
                HeroesP2.get(0).setHealth(100);
                HeroesP2.get(0).setDamageRatio(1.00);
                HeroesP2.get(0).setDodgeBonus(10);
                HeroesP2.get(0).setLightArmour(true);
                HeroesP2.get(0).setHeavyArmour(false);
            }
            if (HeroesP2.get(0).Class == Enum.Skill.Warrior) {
                HeroesP2.get(0).setHealth(100);
                HeroesP2.get(0).setDamageRatio(0.80);
                HeroesP2.get(0).setDodgeBonus(0);
                HeroesP2.get(0).setLightArmour(true);
                HeroesP2.get(0).setHeavyArmour(true);
            }
            System.out.println("Choose your name: ");
            String nameP2 = s1.next();
            HeroesP2.get(0).setName(nameP2);
        }
    }
}
