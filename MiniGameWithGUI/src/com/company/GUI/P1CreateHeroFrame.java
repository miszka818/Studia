package com.company.GUI;

import com.company.Player1;
import com.company.Player2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class P1CreateHeroFrame extends JFrame implements ActionListener {


    JButton mageButton;
    JButton rangerButton;
    JButton warriorButton;
    JButton submitButton;
    JButton nextFrameButton;

    JLabel player1Label;
    JLabel chooseClass;
    JLabel chooseName;
    JLabel statsLabel;
    JTextField nameTextField;


    P1CreateHeroFrame(){


        // przycisk wyboru klasy maga
        mageButton = new JButton("Choose Mage Class");
        mageButton.setBounds(50,225,200,50);
        mageButton.addActionListener(this);
        mageButton.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        mageButton.setFocusable(false);

        // przycisk wyboru klasy ranger
        rangerButton = new JButton("Choose Ranger Class");
        rangerButton.setBounds(50,300,200,50);
        rangerButton.addActionListener(this);
        rangerButton.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        rangerButton.setFocusable(false);

        // przycisk wyboru klasy warrior
        warriorButton = new JButton("Choose Warrior Class");
        warriorButton.setBounds(50,375,200,50);
        warriorButton.addActionListener(this);
        warriorButton.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        warriorButton.setFocusable(false);

        // przycisk potwierdzenia wyboru imienia
        submitButton = new JButton("Submit");
        submitButton.setBounds(675,300,100,50);
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        submitButton.setFocusable(false);

        // przycisk przechodzenia do kolejnego gracza
        nextFrameButton = new JButton("Next Player");
        nextFrameButton.setBounds(625,450,200,50);
        nextFrameButton.addActionListener(this);
        nextFrameButton.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        nextFrameButton.setFocusable(false);
        nextFrameButton.setEnabled(false);


        // okno odpowiadające za wybór imienia

        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(250,40));
        nameTextField.setBounds(625,225,200,50);
        nameTextField.setFont(new Font("Consolas", Font.PLAIN,25));


        // Tekst wyświetlający napis który gracz teraz coś robi (player 1)
        player1Label = new JLabel("Player1");
        player1Label.setBounds(300,-25,350,200);
        player1Label.setFont(new Font("MV Boli",Font.PLAIN,65));

        // Tekst wyświetlający napis o wyborze klasy
        chooseClass = new JLabel("Choose your Class:");
        chooseClass.setBounds(50,80,350,200);
        chooseClass.setFont(new Font("MV Boli",Font.PLAIN,25));

        // Tekst wyświetlający napis o wyborze imienia postaci
        chooseName = new JLabel("Choose your name:");
        chooseName.setBounds(625,80,350,200);
        chooseName.setFont(new Font("MV Boli",Font.PLAIN,25));

        // Tekst wyświetlający statystyki postaci

        statsLabel = new JLabel();
        statsLabel.setBounds(350,80,350,400);
        statsLabel.setFont(new Font("MV Boli",Font.PLAIN,20));



        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,600);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(240,169,40));
        this.add(mageButton);
        this.add(rangerButton);
        this.add(warriorButton);
        this.add(player1Label);
        this.add(chooseClass);
        this.add(submitButton);
        this.add(nameTextField);
        this.add(chooseName);
        this.add(nextFrameButton);
        this.add(statsLabel);


    }


    public static void main(String[] args) {

        P1CreateHeroFrame frame = new P1CreateHeroFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mageButton)
        {
            mageButton.setEnabled(false);
            rangerButton.setEnabled(false);
            warriorButton.setEnabled(false);
            Player1.setHeroClassMage();

            if(mageButton.isEnabled() == false && submitButton.isEnabled() == false)
            {
                nextFrameButton.setEnabled(true);
                Player1.printHeroStats();
                String stats = Player1.printHeroStats();
                statsLabel.setText("<html>" + stats.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }



        }
        if(e.getSource() == rangerButton)
        {
            mageButton.setEnabled(false);
            rangerButton.setEnabled(false);
            warriorButton.setEnabled(false);
            Player1.setHeroClassRanger();
            if(mageButton.isEnabled() == false && submitButton.isEnabled() == false)
            {
                nextFrameButton.setEnabled(true);
                Player1.printHeroStats();
                String stats = Player1.printHeroStats();
                statsLabel.setText("<html>" + stats.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }


        }
        if(e.getSource() == warriorButton)
        {
            mageButton.setEnabled(false);
            rangerButton.setEnabled(false);
            warriorButton.setEnabled(false);
            Player1.setHeroClassWarrior();
            if(mageButton.isEnabled() == false && submitButton.isEnabled() == false)
            {
                nextFrameButton.setEnabled(true);
                Player1.printHeroStats();
                String stats = Player1.printHeroStats();
                statsLabel.setText("<html>" + stats.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }


        }
        if(e.getSource() == submitButton)
        {
            submitButton.setEnabled(false);
            String name = nameTextField.getText();

            Player1.chooseHeroName(name);

            if(mageButton.isEnabled() == false && submitButton.isEnabled() == false)
            {
                nextFrameButton.setEnabled(true);
                Player1.printHeroStats();
                String stats = Player1.printHeroStats();
                statsLabel.setText("<html>" + stats.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }




        }
        if(e.getSource() == nextFrameButton)
        {
            this.dispose();
            P2CreateHeroFrame p2heroFrame = new P2CreateHeroFrame();
            nextFrameButton.setEnabled(false);
            Player2.createHero();
        }
    }
}
