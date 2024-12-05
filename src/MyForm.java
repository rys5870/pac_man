
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyForm extends JFrame {
    private JTextField nameField;
    private JButton submitButton;

    private JButton submitButton2;

    private JLabel label;


    public static String name;


    public MyForm() {

        setTitle("My Form");


        setSize(300, 150);


        nameField = new JTextField(20);
        submitButton = new JButton("כניסה");

        submitButton2 = new JButton("נתונים");
        JScrollPane jScrollPane = new JScrollPane();


        label = new JLabel();
        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        setLocationRelativeTo(null);
        submitButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableForm tableForm = new TableForm();
                tableForm.setVisible(true);
            }
        });


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameField.getText().isEmpty()) {
                    name = nameField.getText();
                    System.out.println(name);
                    Login.loadPlayers();
                    PlayerData newPlayer = new PlayerData(name, 0, 0, 3, 0);
                    Login.addPleyer(newPlayer);


                    JFrame window = new JFrame("pac-man");
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setResizable(false);

                    GamePanel gamePanel = new GamePanel();
                    window.add(gamePanel);


                    window.pack();
                    window.setVisible(true);
                    gamePanel.startGameThread();
                    dispose();
                } else {
                    label.setText("לא הוכנס שם משתמש");
                }


            }
        });


        setLayout(new FlowLayout());


        add(new JLabel("Enter your name:"));
        add(nameField);
        add(submitButton);
        add(submitButton2);
        add(label);


        add(label);
    }


}

