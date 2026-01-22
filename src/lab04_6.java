import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab04_6 {
    public static void main(String[] args) {

        int n1 = (int)(Math.random() * 10);
        int n2 = (int)(Math.random() * 10);

        int op = (int)(Math.random() * 3);
        String operator = "";
        int[] ans = new int[1];


        if (op == 0) {
            operator = " + ";
            ans[0] = n1 + n2;
        } else if (op == 1) {
            operator = " - ";
            ans[0] = n1 - n2;
        } else {
            operator = " * ";
            ans[0] = n1 * n2;
        }

        JFrame win = new JFrame("Easy Math Quiz");
        win.setBounds(100, 100, 500, 300);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel subwin = new JPanel();
        subwin.setBackground(Color.pink);

        JLabel label1 = new JLabel("" + n1);
        label1.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(label1);

        JLabel labelOp = new JLabel(operator);
        labelOp.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(labelOp);

        JLabel label2 = new JLabel("" + n2);
        label2.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(label2);

        JLabel label4 = new JLabel(" = ");
        label4.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(label4);

        JTextField ansBox = new JTextField(3);
        ansBox.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(ansBox);

        JButton b1 = new JButton("Check");
        b1.setFont(new Font("Serif", Font.PLAIN, 20));
        subwin.add(b1);

        JLabel labelResult = new JLabel();
        labelResult.setFont(new Font("Serif", Font.PLAIN, 30));
        subwin.add(labelResult);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userAns = Integer.parseInt(ansBox.getText());
                if (ans[0] == userAns) {
                    labelResult.setText("Excellent!");
                } else {
                    labelResult.setText("Try again!");
                }

            }
        });

        win.add(subwin);
        win.setVisible(true);
    }
}

