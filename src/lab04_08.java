import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab04_08 {
    public static void main(String[] args) {

        JFrame win = new JFrame("BMI Calculator");
        win.setBounds(100, 100, 400, 300);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel lbW = new JLabel("Weight (kg):");
        lbW.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(lbW);

        JTextField txtW = new JTextField(10);
        panel.add(txtW);

        JLabel lbH = new JLabel("Height (cm):");
        lbH.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(lbH);

        JTextField txtH = new JTextField(10);
        panel.add(txtH);

        JButton btn = new JButton("Calculate BMI");
        panel.add(btn);

        JLabel lbBMI = new JLabel();
        lbBMI.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(lbBMI);

        JLabel lbResult = new JLabel();
        lbResult.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(lbResult);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double w = Double.parseDouble(txtW.getText());
                double h = Double.parseDouble(txtH.getText()) / 100;

                double bmi = w / (h * h);
                lbBMI.setText(String.format("BMI = %.2f", bmi));

                if (bmi < 18.5) {
                    lbResult.setText("Underweight");
                } else if (bmi < 25) {
                    lbResult.setText("Normal");
                } else if (bmi < 30) {
                    lbResult.setText("Overweight");
                } else {
                    lbResult.setText("Obese");
                }
            }
        });

        win.add(panel);
        win.setVisible(true);
    }
}