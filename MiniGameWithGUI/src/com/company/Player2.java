package com.company;
import com.company.Enum;

import java.util.ArrayList;
import java.util.Scanner;

public class Player2 extends Player1{

    public static ArrayList<Player2> HeroesP2 = new ArrayList<Player2>();

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


    public String getSmallHit(Player1 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 20 + dodgeBonus)
        {
            if(lightArmour && heavyArmour)
            {
                int damageTaken = (int) (10*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s heavy armour is on."+"\n" + this.name +" is hitted by Small Hit."+"\n"+ "Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            if(lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (15*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s light armour is on. "+"\n" + this.name +" is hitted by Small Hit."+"\n"+" Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            if(!lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (20*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name +"'s armour is off."+"\n" + this.name +" is hitted by Small Hit."+"\n"+" Health is reduced by "+ damageTaken +"."+"\n"+
                        this.name +"'s new Health is " + this.health + "."+"\n"+ this.name+"'s turn.";
            }
            /*if(this.health == 0)
            {
                System.out.println(this.name + " is dead");
            }*/
        }
        else return caster.name + " missed the attack.";
        return " ";
    }

    public String getMediumHit(Player1 caster) {

        int critChace = (int) (Math.random() * (max - min + 1) + min);


        if (critChace >= 50 + dodgeBonus) {
            if (lightArmour && heavyArmour) {
                int damageTaken = (int) (20 * caster.damageRatio);
                this.health -= damageTaken;

                if (this.health <= 0) this.health = 0;
                return this.name + "'s heavy armour is on." + "\n" + this.name + " is hitted by Medium Hit." + "\n" + "Health is reduced by " + damageTaken + "." + "\n" +
                        this.name + "'s new Health is " + this.health + "." + "\n" + this.name + "'s turn.";
            }
            if (lightArmour && !heavyArmour) {
                int damageTaken = (int) (25 * caster.damageRatio);
                this.health -= damageTaken;

                if (this.health <= 0) this.health = 0;
                return this.name + "'s light armour is on. " + "\n" + this.name + " is hitted by Medium Hit." + "\n" + " Health is reduced by " + damageTaken + "." + "\n" +
                        this.name + "'s new Health is " + this.health + "." + "\n" + this.name + "'s turn.";
            }
            if (!lightArmour && !heavyArmour) {
                int damageTaken = (int) (30 * caster.damageRatio);
                this.health -= damageTaken;

                if (this.health <= 0) this.health = 0;
                return this.name + "'s armour is off." + "\n" + this.name + " is hitted by Medium Hit." + "\n" + " Health is reduced by " + damageTaken + "." + "\n" +
                        this.name + "'s new Health is " + this.health + "." + "\n" + this.name + "'s turn.";
            }
        }
        else return caster.name + " missed the attack.";
        return " ";
    }

    public String getMassiveHit(Player1 caster)
    {

        int critChace = (int)(Math.random()*(max-min+1)+min);


        if(critChace >= 80 + dodgeBonus)
        {
            if(lightArmour && heavyArmour)
            {
                int damageTaken = (int) (40*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name + "'s heavy armour is on." + "\n" + this.name + " is hitted by Massive Hit." + "\n" + "Health is reduced by " + damageTaken + "." + "\n" +
                        this.name + "'s new Health is " + this.health + "." + "\n" + this.name + "'s turn.";
            }
            if(lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (45*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name + "'s light armour is on. " + "\n" + this.name + " is hitted by Massive Hit." + "\n" + " Health is reduced by " + damageTaken + "." + "\n" +
                        this.name + "'s new Health is " + this.health + "." + "\n" + this.name + "'s turn.";
            }
            if(!lightArmour && !heavyArmour)
            {
                int damageTaken = (int) (50*caster.damageRatio);
                this.health -=damageTaken;

                if(this.health <= 0) this.health = 0;
                return this.name + "'s armour is off." + "\n" + this.name + " is hitted by Massive Hit." + "\n" + " Health is reduced by " + damageTaken + "." + "\n" +
                        this.name + "'s new Health is " + this.health + "." + "\n" + this.name + "'s turn.";
            }
        }
        else return caster.name + " missed the attack.";
        return " ";

    }

    @Override
    public String heal() {
        this.health += 30;
        if(this.health >=100) this.health = 100;

        // komunikat o uleczeniu bohatera
        return this.name + " healed himself by 30. Current health is " + this.health+"."+"\n"+ Player1.HeroesP1.get(0).name+"'s turn.";
    }


    public static void createHero()
    {
        new Player2();
    }

    public static void setHeroClassMage()
    {
        HeroesP2.get(0).setClass(Enum.Skill.Mage);

        HeroesP2.get(0).setHealth(100);
        HeroesP2.get(0).setDamageRatio(1.3);
        HeroesP2.get(0).setDodgeBonus(5);
        HeroesP2.get(0).setLightArmour(false);
        HeroesP2.get(0).setHeavyArmour(false);
    }
    public static void setHeroClassRanger()
    {
        HeroesP2.get(0).setClass(Enum.Skill.Ranger);
        HeroesP2.get(0).setHealth(100);
        HeroesP2.get(0).setDamageRatio(1.00);
        HeroesP2.get(0).setDodgeBonus(10);
        HeroesP2.get(0).setLightArmour(true);
        HeroesP2.get(0).setHeavyArmour(false);
    }
    public static  void setHeroClassWarrior()
    {
        HeroesP2.get(0).setClass(Enum.Skill.Warrior);
        HeroesP2.get(0).setHealth(100);
        HeroesP2.get(0).setDamageRatio(0.75);
        HeroesP2.get(0).setDodgeBonus(0);
        HeroesP2.get(0).setLightArmour(true);
        HeroesP2.get(0).setHeavyArmour(true);
    }

    public static String  printHeroStats()
    {
        return HeroesP2.get(0).toString();
    }
    public static void chooseHeroName(String name)
    {
        HeroesP2.get(0).setName(name);
    }
}
