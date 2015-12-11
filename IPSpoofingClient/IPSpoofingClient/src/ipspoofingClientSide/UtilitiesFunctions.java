package ipspoofingClientSide;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UtilitiesFunctions {

    public void settextnullonmouseclick(MouseEvent evt) {
        javax.swing.JTextField obj = (javax.swing.JTextField) evt.getSource();
        obj.setText("");
    }

    public boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            System.out.println("This is integer checked");
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Not integer value");
            return false;
        }
    }

    public boolean isOutOfRange(String value) {
        int val = Integer.parseInt(value);
        System.out.println(val);
        if ((val < 0) || (val > 65536)) {
            JOptionPane.showMessageDialog(null, "Input Integer must be in between 0 to 65536");
            return false;
        } else {
            System.out.println("This is not out of range");
            return true;
        }
    }

    public void repaintandvalidate(JButton jButton1) {
        java.awt.Container objj = jButton1.getParent();
        objj.revalidate();//this should revalidate and repaint the container of jButton1 button
        objj.repaint();
    }

    void showButton(JButton jButton1) {
        JButton buttontoshow = jButton1;
        buttontoshow.show();
    }

    void enableButtons(JButton jButton3, JButton jButton4) {
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
    }

    void hideButton(JButton jButton5) {
        jButton5.hide();
    }

    void disableButton(JButton jButton3) {
        jButton3.setEnabled(false);
    }

}
