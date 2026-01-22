import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class lab04_07 {
    public static void main(String[] args) {

        int[] n1 = new int[1];
        int[] n2 = new int[1];
        int[] ans = new int[1];
        int[] count = new int[]{1};
        int[] score = new int[1];
        String[] operator = new String[1];

        JFrame win = new JFrame("Easy Math Quiz");
        win.setBounds(100, 100, 500, 300);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel subwin = new JPanel();
        subwin.setBackground(Color.pink);

        JLabel labelCount = new JLabel("Question 1 / 10");
        labelCount.setFont(new Font("Serif", Font.PLAIN, 20));
        subwin.add(labelCount);

        JLabel label1 = new JLabel();
        label1.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(label1);

        JLabel labelOp = new JLabel();
        labelOp.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(labelOp);

        JLabel label2 = new JLabel();
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
        labelResult.setFont(new Font("Serif", Font.PLAIN, 25));
        subwin.add(labelResult);

        Runnable newQuestion = () -> {
            n1[0] = (int)(Math.random() * 10);
            n2[0] = (int)(Math.random() * 10);
            int op = (int)(Math.random() * 3);

            if (op == 0) {
                operator[0] = " + ";
                ans[0] = n1[0] + n2[0];
            } else if (op == 1) {
                operator[0] = " - ";
                ans[0] = n1[0] - n2[0];
            } else {
                operator[0] = " * ";
                ans[0] = n1[0] * n2[0];
            }

            label1.setText("" + n1[0]);
            label2.setText("" + n2[0]);
            labelOp.setText(operator[0]);
            labelCount.setText("Question " + count[0] + " / 10");
            ansBox.setText("");
            labelResult.setText("");
        };

        newQuestion.run();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userAns = Integer.parseInt(ansBox.getText());

                if (userAns == ans[0]) {
                    score[0]++;
                    labelResult.setText("Correct!");
                } else {
                    labelResult.setText("Wrong!");
                }

                if (count[0] == 10) {
                    JOptionPane.showMessageDialog(win,
                            "Your score: " + score[0] + " / 10");
                    System.exit(0);
                }

                count[0]++;
                newQuestion.run();
            }
        });

        win.add(subwin);
        win.setVisible(true);
    }
}
