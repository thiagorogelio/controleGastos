/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlegastos;
import graphics.*;

/**
 *
 * @author maxx
 */
public class ControleGastos {
    public static double salario;
    public static int economia;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        salario = 1000;
        economia = 20;
        mainMenu menu = new mainMenu();
        menu.setVisible(true);
        menu.setLocation(600, 300);
    }
    
}
