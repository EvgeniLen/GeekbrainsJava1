package ru.geekbrains.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapWindow extends JFrame {
    private int x = 100;
    private int y = 100;
    private static int SIZE = 40;
    public MapWindow(){
        setTitle("Map");
        setBounds(600, 300, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // запрет на изменение размера поля
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#008800"));
        add(mainPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.setPreferredSize(new Dimension(20, 20));
        add(buttonsPanel, BorderLayout.SOUTH);

        JPanel rectPanel = new JPanel();
        rectPanel.setBounds(x, y, SIZE, SIZE);
        rectPanel.setBackground(Color.red);
        mainPanel.add(rectPanel);

        JButton buttonDown = new JButton("Down");
        JButton buttonUp = new JButton("Up");
        buttonsPanel.add(buttonDown);
        buttonsPanel.add(buttonUp);

        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y += 10;
                rectPanel.setBounds(x, y, SIZE, SIZE);
            }
        });

        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y -= 10;
                rectPanel.setBounds(x, y, SIZE, SIZE);
            }
        });


        setVisible(true);

    }
}
