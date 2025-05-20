import javax.swing.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField tf1, tf2, tfResult;
    JButton addBtn, subBtn, mulBtn, divBtn;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Number 1:");
        l1.setBounds(30, 30, 100, 20);
        add(l1);

        tf1 = new JTextField();
        tf1.setBounds(130, 30, 100, 20);
        add(tf1);

        JLabel l2 = new JLabel("Number 2:");
        l2.setBounds(30, 60, 100, 20);
        add(l2);

        tf2 = new JTextField();
        tf2.setBounds(130, 60, 100, 20);
        add(tf2);

        JLabel l3 = new JLabel("Result:");
        l3.setBounds(30, 90, 100, 20);
        add(l3);

        tfResult = new JTextField();
        tfResult.setBounds(130, 90, 100, 20);
        tfResult.setEditable(false);
        add(tfResult);

        addBtn = new JButton("+");
        addBtn.setBounds(30, 130, 50, 30);
        add(addBtn);

        subBtn = new JButton("-");
        subBtn.setBounds(90, 130, 50, 30);
        add(subBtn);

        mulBtn = new JButton("*");
        mulBtn.setBounds(150, 130, 50, 30);
        add(mulBtn);

        divBtn = new JButton("/");
        divBtn.setBounds(210, 130, 50, 30);
        add(divBtn);

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(tf1.getText());
            double num2 = Double.parseDouble(tf2.getText());
            double result = 0;

            if (e.getSource() == addBtn) {
                result = num1 + num2;
            } else if (e.getSource() == subBtn) {
                result = num1 - num2;
            } else if (e.getSource() == mulBtn) {
                result = num1 * num2;
            } else if (e.getSource() == divBtn) {
                if (num2 != 0)
                    result = num1 / num2;
                else
                    tfResult.setText("Divide by 0");
            }

            if (!(e.getSource() == divBtn && num2 == 0))
                tfResult.setText(String.valueOf(result));
        } catch (Exception ex) {
            tfResult.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.setVisible(true);
    }
}
