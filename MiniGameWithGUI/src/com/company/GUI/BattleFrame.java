package com.company.GUI;

import com.company.Player1;
import com.company.Player2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BattleFrame extends JFrame implements ActionListener {


    JButton p1SmallAttack;
    JButton p1MediumAttack;
    JButton p1MassiveAttack;
    JButton p1heal;

    JButton p2SmallAttack;
    JButton p2MediumAttack;
    JButton p2MassiveAttack;
    JButton p2heal;

    JLabel player1Label;
    JLabel player2Label;

    JLabel battleLabel;
    JLabel battleInfoLabel;

    public BattleFrame(){
        // przycisk wyboru akcji małego ataku p1
        p1SmallAttack = new JButton("Use Small Attack");
        p1SmallAttack.setBounds(50,225,200,50);
        p1SmallAttack.addActionListener(this);
        p1SmallAttack.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        p1SmallAttack.setFocusable(false);

        // przycisk wyboru akcji średniego ataku p1
        p1MediumAttack = new JButton("Use Medium Attack");
        p1MediumAttack.setBounds(50,300,200,50);
        p1MediumAttack.addActionListener(this);
        p1MediumAttack.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        p1MediumAttack.setFocusable(false);

        // przycisk wyboru akcji dużego ataku p1
        p1MassiveAttack = new JButton("Use Massive Attack");
        p1MassiveAttack.setBounds(50,375,200,50);
        p1MassiveAttack.addActionListener(this);
        p1MassiveAttack.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        p1MassiveAttack.setFocusable(false);

        // przycisk wyboru akcji leczenia p1
        p1heal = new JButton("Use Heal");
        p1heal.setBounds(50,450,200,50);
        p1heal.addActionListener(this);
        p1heal.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        p1heal.setFocusable(false);



        // Tekst wyświetlający napis o wyborze akcji p1
        player1Label = new JLabel();
        player1Label.setText(Player1.HeroesP1.get(0).getName() + "'s actions:");
        player1Label.setBounds(50,80,350,200);
        player1Label.setFont(new Font("MV Boli",Font.PLAIN,25));



        // przycisk wyboru akcji małego ataku p2
        p2SmallAttack = new JButton("Use Small Attack");
        p2SmallAttack.setBounds(625,225,200,50);
        p2SmallAttack.addActionListener(this);
        p2SmallAttack.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        p2SmallAttack.setFocusable(false);

        // przycisk wyboru akcji średniego ataku p2
        p2MediumAttack = new JButton("Use Medium Attack");
        p2MediumAttack.setBounds(625,300,200,50);
        p2MediumAttack.addActionListener(this);
        p2MediumAttack.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        p2MediumAttack.setFocusable(false);

        // przycisk wyboru akcji dużego ataku p2
        p2MassiveAttack = new JButton("Use Massive Attack");
        p2MassiveAttack.setBounds(625,375,200,50);
        p2MassiveAttack.addActionListener(this);
        p2MassiveAttack.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        p2MassiveAttack.setFocusable(false);

        // przycisk wyboru akcji leczenia p2
        p2heal = new JButton("Use Heal");
        p2heal.setBounds(625,450,200,50);
        p2heal.addActionListener(this);
        p2heal.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        p2heal.setFocusable(false);

        p2SmallAttack.setEnabled(false);
        p2MediumAttack.setEnabled(false);
        p2MassiveAttack.setEnabled(false);
        p2heal.setEnabled(false);

        // Tekst wyświetlający napis o wyborze akcji p2
        player2Label = new JLabel();
        player2Label.setText(Player2.HeroesP2.get(0).getName() + "'s actions:");
        player2Label.setBounds(625,80,350,200);
        player2Label.setFont(new Font("MV Boli",Font.PLAIN,25));


        battleLabel = new JLabel("Battle!");
        battleLabel.setBounds(350,0,350,200);
        battleLabel.setFont(new Font("MV Boli",Font.PLAIN,51));


        battleInfoLabel = new JLabel();
        battleInfoLabel.setBounds(275,0,300,600);
        battleInfoLabel.setFont(new Font("MV Boli",Font.PLAIN,20));

        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,600);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(240,169,40));
        this.add(p1heal);
        this.add(p1MassiveAttack);
        this.add(p1MediumAttack);
        this.add(p1SmallAttack);
        this.add(player1Label);

        this.add(p2heal);
        this.add(p2MassiveAttack);
        this.add(p2MediumAttack);
        this.add(p2SmallAttack);
        this.add(player2Label);

        this.add(battleLabel);
        this.add(battleInfoLabel);
    }


    public static void main(String[] args) {

        StartFrame frame = new StartFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == p1SmallAttack)
        {

            String label = Player2.HeroesP2.get(0).getSmallHit(Player1.HeroesP1.get(0));

            battleInfoLabel.setText("<html>" + label.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");


            p1SmallAttack.setEnabled(false);
            p1MediumAttack.setEnabled(false);
            p1MassiveAttack.setEnabled(false);
            p1heal.setEnabled(false);

            p2SmallAttack.setEnabled(true);
            p2MediumAttack.setEnabled(true);
            p2MassiveAttack.setEnabled(true);
            p2heal.setEnabled(true);

            if(Player2.HeroesP2.get(0).getHealth() == 0)
            {

                p1SmallAttack.setEnabled(false);
                p1MediumAttack.setEnabled(false);
                p1MassiveAttack.setEnabled(false);
                p1heal.setEnabled(false);
                p2SmallAttack.setEnabled(false);
                p2MediumAttack.setEnabled(false);
                p2MassiveAttack.setEnabled(false);
                p2heal.setEnabled(false);

                battleInfoLabel.setText(Player1.HeroesP1.get(0).getName() + "wins! Congratulations!");
            }
        }
        if(e.getSource() == p1MediumAttack)
        {
            String label = Player2.HeroesP2.get(0).getMediumHit(Player1.HeroesP1.get(0));

            battleInfoLabel.setText("<html>" + label.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

            p1SmallAttack.setEnabled(false);
            p1MediumAttack.setEnabled(false);
            p1MassiveAttack.setEnabled(false);
            p1heal.setEnabled(false);

            p2SmallAttack.setEnabled(true);
            p2MediumAttack.setEnabled(true);
            p2MassiveAttack.setEnabled(true);
            p2heal.setEnabled(true);

            if(Player2.HeroesP2.get(0).getHealth() == 0)
            {

                p1SmallAttack.setEnabled(false);
                p1MediumAttack.setEnabled(false);
                p1MassiveAttack.setEnabled(false);
                p1heal.setEnabled(false);
                p2SmallAttack.setEnabled(false);
                p2MediumAttack.setEnabled(false);
                p2MassiveAttack.setEnabled(false);
                p2heal.setEnabled(false);

                battleInfoLabel.setText(Player1.HeroesP1.get(0).getName() + " wins! Congratulations!");
            }

        }
        if(e.getSource() == p1MassiveAttack)
        {
            String label = Player2.HeroesP2.get(0).getMassiveHit(Player1.HeroesP1.get(0));

            battleInfoLabel.setText("<html>" + label.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

            p1SmallAttack.setEnabled(false);
            p1MediumAttack.setEnabled(false);
            p1MassiveAttack.setEnabled(false);
            p1heal.setEnabled(false);

            p2SmallAttack.setEnabled(true);
            p2MediumAttack.setEnabled(true);
            p2MassiveAttack.setEnabled(true);
            p2heal.setEnabled(true);

            if(Player2.HeroesP2.get(0).getHealth() == 0)
            {
                p1SmallAttack.setEnabled(false);
                p1MediumAttack.setEnabled(false);
                p1MassiveAttack.setEnabled(false);
                p1heal.setEnabled(false);
                p2SmallAttack.setEnabled(false);
                p2MediumAttack.setEnabled(false);
                p2MassiveAttack.setEnabled(false);
                p2heal.setEnabled(false);

                battleInfoLabel.setText(Player1.HeroesP1.get(0).getName() + " wins! Congratulations!");

            }
        }
        if(e.getSource() == p1heal)
        {
            String label = Player1.HeroesP1.get(0).heal();

            battleInfoLabel.setText("<html>" + label.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

            p1SmallAttack.setEnabled(false);
            p1MediumAttack.setEnabled(false);
            p1MassiveAttack.setEnabled(false);
            p1heal.setEnabled(false);

            p2SmallAttack.setEnabled(true);
            p2MediumAttack.setEnabled(true);
            p2MassiveAttack.setEnabled(true);
            p2heal.setEnabled(true);

            if(Player2.HeroesP2.get(0).getHealth() == 0)
            {

                p1SmallAttack.setEnabled(false);
                p1MediumAttack.setEnabled(false);
                p1MassiveAttack.setEnabled(false);
                p1heal.setEnabled(false);
                p2SmallAttack.setEnabled(false);
                p2MediumAttack.setEnabled(false);
                p2MassiveAttack.setEnabled(false);
                p2heal.setEnabled(false);

                battleInfoLabel.setText(Player1.HeroesP1.get(0).getName() + " wins! Congratulations!");
            }
        }
        if(e.getSource() == p2SmallAttack)
        {
            String label = Player1.HeroesP1.get(0).getSmallHit(Player2.HeroesP2.get(0));

            battleInfoLabel.setText("<html>" + label.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

            p2SmallAttack.setEnabled(false);
            p2MediumAttack.setEnabled(false);
            p2MassiveAttack.setEnabled(false);
            p2heal.setEnabled(false);

            p1SmallAttack.setEnabled(true);
            p1MediumAttack.setEnabled(true);
            p1MassiveAttack.setEnabled(true);
            p1heal.setEnabled(true);

            if(Player1.HeroesP1.get(0).getHealth()== 0)
            {

                p1SmallAttack.setEnabled(false);
                p1MediumAttack.setEnabled(false);
                p1MassiveAttack.setEnabled(false);
                p1heal.setEnabled(false);
                p2SmallAttack.setEnabled(false);
                p2MediumAttack.setEnabled(false);
                p2MassiveAttack.setEnabled(false);
                p2heal.setEnabled(false);

                battleInfoLabel.setText(Player2.HeroesP2.get(0).getName() + " wins! Congratulations!");
            }

        }
        if(e.getSource() == p2MediumAttack)
        {
            String label = Player1.HeroesP1.get(0).getMediumHit(Player2.HeroesP2.get(0));

            battleInfoLabel.setText("<html>" + label.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

            p2SmallAttack.setEnabled(false);
            p2MediumAttack.setEnabled(false);
            p2MassiveAttack.setEnabled(false);
            p2heal.setEnabled(false);

            p1SmallAttack.setEnabled(true);
            p1MediumAttack.setEnabled(true);
            p1MassiveAttack.setEnabled(true);
            p1heal.setEnabled(true);

            if(Player1.HeroesP1.get(0).getHealth()== 0)            {

                p1SmallAttack.setEnabled(false);
                p1MediumAttack.setEnabled(false);
                p1MassiveAttack.setEnabled(false);
                p1heal.setEnabled(false);
                p2SmallAttack.setEnabled(false);
                p2MediumAttack.setEnabled(false);
                p2MassiveAttack.setEnabled(false);
                p2heal.setEnabled(false);

                battleInfoLabel.setText(Player2.HeroesP2.get(0).getName() + " wins! Congratulations!");
            }
        }
        if(e.getSource() == p2MassiveAttack)
        {
            String label = Player1.HeroesP1.get(0).getMassiveHit(Player2.HeroesP2.get(0));

            battleInfoLabel.setText("<html>" + label.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

            p2SmallAttack.setEnabled(false);
            p2MediumAttack.setEnabled(false);
            p2MassiveAttack.setEnabled(false);
            p2heal.setEnabled(false);

            p1SmallAttack.setEnabled(true);
            p1MediumAttack.setEnabled(true);
            p1MassiveAttack.setEnabled(true);
            p1heal.setEnabled(true);

            if(Player1.HeroesP1.get(0).getHealth()== 0)
            {

                p1SmallAttack.setEnabled(false);
                p1MediumAttack.setEnabled(false);
                p1MassiveAttack.setEnabled(false);
                p1heal.setEnabled(false);
                p2SmallAttack.setEnabled(false);
                p2MediumAttack.setEnabled(false);
                p2MassiveAttack.setEnabled(false);
                p2heal.setEnabled(false);

                battleInfoLabel.setText(Player2.HeroesP2.get(0).getName() + " wins! Congratulations!");
            }
        }
        if(e.getSource() == p2heal)
        {
            String label = Player2.HeroesP2.get(0).heal();

            battleInfoLabel.setText("<html>" + label.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

            p2SmallAttack.setEnabled(false);
            p2MediumAttack.setEnabled(false);
            p2MassiveAttack.setEnabled(false);
            p2heal.setEnabled(false);

            p1SmallAttack.setEnabled(true);
            p1MediumAttack.setEnabled(true);
            p1MassiveAttack.setEnabled(true);
            p1heal.setEnabled(true);

            if(Player1.HeroesP1.get(0).getHealth()== 0)
            {
                p1SmallAttack.setEnabled(false);
                p1MediumAttack.setEnabled(false);
                p1MassiveAttack.setEnabled(false);
                p1heal.setEnabled(false);
                p2SmallAttack.setEnabled(false);
                p2MediumAttack.setEnabled(false);
                p2MassiveAttack.setEnabled(false);
                p2heal.setEnabled(false);

                battleInfoLabel.setText(Player2.HeroesP2.get(0).getName() + " wins! Congratulations!");

            }
        }
    }
}
