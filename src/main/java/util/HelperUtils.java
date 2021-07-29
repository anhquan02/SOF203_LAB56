/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mypc
 */
//Class tiện ích
public class HelperUtils {

    private HelperUtils() {

    }

    //check rỗng 1 textfield trả về boolean
    public static boolean isEmpty(JTextField tf) {
        if (tf.getText().length() == 0) {
            tf.requestFocus();
            JOptionPane.showMessageDialog(null, "Không được để trống");
            return true;
        }
        return false;
    }
//check 1 textfield là 1 số thực không trả về boolean

    public static boolean isDouble(JTextField tf) {
        try {
            double so = Double.parseDouble(tf.getText());
            if (so < 0) {
                tf.requestFocus();
                JOptionPane.showMessageDialog(null, "Yêu cầu nhập số dương");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            tf.requestFocus();
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập số dương");
            return false;
        }
    }
    //check 1 textfield là 1 số nguyên không trả về boolean

    public static boolean isInteger(JTextField tf) {
        try {
            int so = Integer.parseInt(tf.getText());
            if (so < 0) {
                tf.requestFocus();
                JOptionPane.showMessageDialog(null, "Yêu cầu nhập số nguyên dương");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            tf.requestFocus();
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập số nguyên dương");
            return false;
        }
    }

}
