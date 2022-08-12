package com.company.GUI;

import com.company.Player1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class StartFrame extends JFrame implements ActionListener {


    JButton startButton;
    JLabel gameNameLabel;

    public StartFrame(){

        startButton = new JButton("Start Game!");
        startButton.setBounds(300,250,300,100);
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Cosmic Sans",Font.BOLD,25));
        startButton.setBackground(Color.GRAY);
        startButton.setBorder(BorderFactory.createEtchedBorder());

        gameNameLabel = new JLabel("Mikolaj's Game");
        gameNameLabel.setBounds(275,50,350,200);
        gameNameLabel.setFont(new Font("MV Boli",Font.PLAIN,51));



        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,600);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(240,169,40));
        this.add(startButton);
        this.add(gameNameLabel);
    }


    public static void main(String[] args) {

        StartFrame frame = new StartFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton)
        {
            this.dispose();
            P1CreateHeroFrame p1heroFrame = new P1CreateHeroFrame();
            startButton.setEnabled(false);
            Player1.createHero();
        }
    }
}

