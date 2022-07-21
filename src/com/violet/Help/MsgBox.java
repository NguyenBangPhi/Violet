/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.Help;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MsgBox {
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message,"Hệ thống quản lí khách sạn",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean confirm(Component parent,String message){
        int result = JOptionPane.showConfirmDialog(parent, message,"Hệ thống quản lí khách sạn",JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component parent,String message){
        return JOptionPane.showInputDialog(parent, message,"Hệ thống quản lý khách sạn",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int confirm2(Component parent,String message){
         int input = JOptionPane.showConfirmDialog(parent, 
                message, "Hệ thống quản lí khách sạn",JOptionPane.YES_NO_CANCEL_OPTION);
         return input;
    }
}