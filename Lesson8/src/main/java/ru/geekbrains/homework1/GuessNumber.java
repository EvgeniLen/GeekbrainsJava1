package ru.geekbrains.homework1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumber extends JFrame {
    private int randomNumber;
    private JTextField textField;
    private int countMove = 0;

    public GuessNumber(){

        setTitle("Guess the number");
        setBounds(600, 300, 600, 140);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        randomNumber = (int) (Math.random()*10) + 1;
        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        Font font = new Font("Arial", Font.PLAIN, 18);
        textField.setFont(font);
        textField.setText("Программа загадала число от 1 до 10");
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 10));
        add(buttonsPanel, BorderLayout.CENTER);

        JButton[] buttons = new JButton[10];

        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttonsPanel.add(buttons[i]);
            buttons[i].setFont(font);
            int buttonIndex = i + 1;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    countMove++;
                    if (countMove <= 3){
                        tryAnswer(buttonIndex, buttons[buttonIndex - 1]);
                    } else {
                        textField.setText("Игра закончена! Нажмите на кнопку Начать заново.");
                    }
                }
            });
        }

        JButton button = new JButton("Начать заново");
        button.setFont(font);
        add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomNumber = (int) (Math.random() * 10) + 1;
                textField.setText("Программа загадала число от 1 до 10");
                for (JButton jButton : buttons) {
                    jButton.setBackground(UIManager.getColor("TextField.background"));
                }
                countMove = 0;
            }
        });

        setVisible(true);
    }

    public void tryAnswer(int answer, JButton button){
        if (answer == randomNumber){
            textField.setText("Вы угадали! Ответ: " + randomNumber);
            countMove = 3;
            button.setBackground(Color.green);
        } else  if(answer > randomNumber){
            textField.setText("Не угадали, загаданное число меньше");
        } else {
            textField.setText("Не угадали, загаданное число больше");
        }
    }
}
