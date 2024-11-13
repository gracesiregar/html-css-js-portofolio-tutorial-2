import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginRegisterApp extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JLabel titleLabel;

    public LoginRegisterApp() {
        setTitle("Login & Register Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Judul di atas panel utama
        titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(34, 139, 34)); // Warna hijau untuk judul
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createRegisterPanel(), "Register");

        // Menambahkan label judul dan panel utama ke frame
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        cardLayout.show(mainPanel, "Login");
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new BorderLayout());
        loginPanel.setBackground(new Color(204, 255, 204)); // Warna hijau muda

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(new Color(224, 255, 224));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(204, 255, 204));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Submit Login");
        JButton switchToRegisterButton = new JButton("Register");

        // Warna dan font untuk tombol
        loginButton.setBackground(new Color(34, 139, 34));
        loginButton.setForeground(Color.WHITE);
        switchToRegisterButton.setBackground(new Color(34, 139, 34));
        switchToRegisterButton.setForeground(Color.WHITE);

        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        buttonPanel.add(loginButton);
        buttonPanel.add(switchToRegisterButton);

        loginPanel.add(formPanel, BorderLayout.CENTER);
        loginPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Listener untuk beralih ke panel register
        switchToRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titleLabel.setText("Register"); // Ubah judul
                cardLayout.show(mainPanel, "Register");
            }
        });

        // Listener untuk tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(loginPanel, "Login Successful!");
            }
        });

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel(new BorderLayout());
        registerPanel.setBackground(new Color(204, 255, 204)); // Warna hijau muda

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBackground(new Color(224, 255, 224));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(204, 255, 204));

        JLabel nameLabel = new JLabel("Nama:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Submit Register");
        JButton switchToLoginButton = new JButton("Login");

        // Warna dan font pada tombol
        registerButton.setBackground(new Color(34, 139, 34));
        registerButton.setForeground(Color.WHITE);
        switchToLoginButton.setBackground(new Color(34, 139, 34));
        switchToLoginButton.setForeground(Color.WHITE);

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        buttonPanel.add(registerButton);
        buttonPanel.add(switchToLoginButton);

        registerPanel.add(formPanel, BorderLayout.CENTER);
        registerPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Listener untuk beralih ke panel login
        switchToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titleLabel.setText("Login"); // Ubah judul
                cardLayout.show(mainPanel, "Login");
            }
        });

        // Listener untuk tombol register
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(registerPanel, "Registration Successful!");
            }
        });

        return registerPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginRegisterApp().setVisible(true);
        });
    }
}
