import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmInterface extends JFrame {
    private BankAccount account;
    private JTextField amountField;
    private JLabel balanceLabel;

    public AtmInterface(BankAccount account) {
        this.account = account;
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("ATM Machine");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton exitButton = new JButton("Exit");

        amountField = new JTextField();
        balanceLabel = new JLabel("Current Balance: $" + account.getBalance());

        panel.add(new JLabel("Enter amount:"));
        panel.add(amountField);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(exitButton);

        add(panel, BorderLayout.CENTER);
        add(balanceLabel, BorderLayout.SOUTH);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a positive number.");
            } else if (account.getBalance() < amount) {
                JOptionPane.showMessageDialog(this, "Insufficient balance.");
            } else {
                account.withdraw(amount);
                JOptionPane.showMessageDialog(this, "Withdrawal successful. Please take your cash.");
                updateBalance();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a positive number.");
            } else {
                account.deposit(amount);
                JOptionPane.showMessageDialog(this, "Deposit successful.");
                updateBalance();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    private void checkBalance() {
        JOptionPane.showMessageDialog(this, "Your current balance is: $" + account.getBalance());
        updateBalance();
    }

    private void updateBalance() {
        balanceLabel.setText("Current Balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        new AtmInterface(account);
    }
}
 class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }
}
