import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lad4_1v2 {
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setTitle("Hello Program : Chutima Pakkaseenung 68160318 n44");
        f.setSize(500,300);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel label1 = new JLabel();
        label1.setText("Enter name : ");
        f.add(label1);

        JTextField nameBox = new JTextField(5);
        f.add(nameBox);

        JButton b1 = new JButton();
        b1.setText("send");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = nameBox.getText();
                JOptionPane.showMessageDialog(null,"Hello "+ str);
            }
        });
        f.add(b1);

        f.setVisible(true);
    }
}
