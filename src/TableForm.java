import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class TableForm extends JFrame {
    private  JTextField nameField;
    private JButton submitButton;
    private JLabel messageLabel;
    private JTable playerTable;
    private DefaultTableModel tableModel;
    private List<PlayerData> players;

    public  TableForm() {
        setTitle("Modern Form with Table");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // מרכז את החלון במסך

        // הגדרת פאנל מרכזי עם מרווח פנימי
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

        // יצירת פאנל עליון לכותרת
        JLabel titleLabel = new JLabel("Welcome to Pac-Man", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(50, 50, 150));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // יצירת פאנל מרכזי לשדה הטקסט, רשימה ותווית
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // תווית עבור שדה הטקסט
        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(nameLabel);

        // שדה טקסט
        nameField = new JTextField(20);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameField.getPreferredSize().height));
        centerPanel.add(nameField);

        // רשימת שחקנים
        players = Login.loadPlayers();

        // מודל טבלה
        tableModel = new DefaultTableModel(new Object[]{"playerName", "level", "score", "lives","point"}, 0);
        playerTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(playerTable);
        centerPanel.add(tableScrollPane);

        // תווית הודעה
        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        messageLabel.setForeground(Color.RED);
        mainPanel.add(messageLabel, BorderLayout.SOUTH);

        // יצירת פאנל תחתון לכפתור
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // כפתור Submit
        submitButton = new JButton("close");
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(submitButton);
        for(PlayerData pd:players){
            addPlayerToTable(pd);
        }
        // הוספת מאזין לכפתור
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void addPlayerToTable(PlayerData player) {
        tableModel.addRow(new Object[]{player.getPlayerName(), player.getLevel(), player.getScore(), player.getLives()});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TableForm form = new TableForm();
                form.setVisible(true);
            }
        });
    }
}
