package ru.geekbrains.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow(){
        setTitle("My simple Window");
        setBounds(600, 300, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        JButton button = new JButton("Log");
        button.setPreferredSize(new Dimension(60, 60));
        add(button);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
            }
        });
//        for (int i = 0; i < 10; i++) {
//            add(new JButton("" + i));
//        }



        JTextArea textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);

        setVisible(true);
    }
}
