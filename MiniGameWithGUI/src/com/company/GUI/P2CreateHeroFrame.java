package com.company.GUI;

import com.company.Player2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class P2CreateHeroFrame extends JFrame implements ActionListener {


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

    P2CreateHeroFrame(){

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
        nextFrameButton = new JButton("Start Battle!");
        nextFrameButton.setBounds(625,450,200,50);
        nextFrameButton.addActionListener(this);
        nextFrameButton.setFont(new Font("Cosmic Sans",Font.BOLD,14));
        nextFrameButton.setFocusable(false);
        nextFrameButton.setEnabled(false);


        // okno odpowiadaj??ce za wyb??r imienia

        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(250,40));
        nameTextField.setBounds(625,225,200,50);
        nameTextField.setFont(new Font("Consolas", Font.PLAIN,25));


        // Tekst wy??wietlaj??cy napis kt??ry gracz teraz co?? robi (player 1)
        player1Label = new JLabel("Player2");
        player1Label.setBounds(300,0,350,200);
        player1Label.setFont(new Font("MV Boli",Font.PLAIN,65));

        // Tekst wy??wietlaj??cy napis o wyborze klasy
        chooseClass = new JLabel("Choose your Class:");
        chooseClass.setBounds(50,80,350,200);
        chooseClass.setFont(new Font("MV Boli",Font.PLAIN,25));

        // Tekst wy??wietlaj??cy napis o wyborze imienia postaci
        chooseName = new JLabel("Choose your name:");
        chooseName.setBounds(625,80,350,200);
        chooseName.setFont(new Font("MV Boli",Font.PLAIN,25));

        // Tekst wy??wietlaj??cy statystyki postaci

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

            Player2.setHeroClassMage();

            if(mageButton.isEnabled() == false && submitButton.isEnabled() == false)
            {
                nextFrameButton.setEnabled(true);
                Player2.printHeroStats();
                String stats = Player2.printHeroStats();
                statsLabel.setText("<html>" + stats.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }

        }
        if(e.getSource() == rangerButton)
        {
            mageButton.setEnabled(false);
            rangerButton.setEnabled(false);
            warriorButton.setEnabled(false);

            Player2.setHeroClassRanger();

            if(mageButton.isEnabled() == false && submitButton.isEnabled() == false)
            {
                nextFrameButton.setEnabled(true);
                Player2.printHeroStats();
                String stats = Player2.printHeroStats();
                statsLabel.setText("<html>" + stats.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }

        }
        if(e.getSource() == warriorButton)
        {
            mageButton.setEnabled(false);
            rangerButton.setEnabled(false);
            warriorButton.setEnabled(false);

            Player2.setHeroClassWarrior();

            if(mageButton.isEnabled() == false && submitButton.isEnabled() == false)
            {
                nextFrameButton.setEnabled(true);
                Player2.printHeroStats();
                String stats = Player2.printHeroStats();
                statsLabel.setText("<html>" + stats.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }

        }
        if(e.getSource() == submitButton)
        {
            submitButton.setEnabled(false);
            String name = nameTextField.getText();
            Player2.chooseHeroName(name);

            if(mageButton.isEnabled() == false && submitButton.isEnabled() == false)
            {
                nextFrameButton.setEnabled(true);
                Player2.printHeroStats();
                String stats = Player2.printHeroStats();
                statsLabel.setText("<html>" + stats.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }

        }
        if(e.getSource() == nextFrameButton)
        {

            this.dispose();
            BattleFrame battleFrame = new BattleFrame();
            nextFrameButton.setEnabled(false);
        }
    }
}
