package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MainWindow extends JFrame {

    private JButton sendButton;
    private JTextField textField;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JPanel inputPanel;

    MainWindow() throws HeadlessException {
        setTitle("Очень главное окно");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 500);

        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        list = new JList(listModel);

        sendButton = new JButton("Отправить");
        sendButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.add(listModel.size(), textField.getText());
                textField.setText("");
            }
        });
        textField = new JTextField( );
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    listModel.add(listModel.size(), textField.getText());
                    textField.setText("");
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(textField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(list, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);


    }
}
