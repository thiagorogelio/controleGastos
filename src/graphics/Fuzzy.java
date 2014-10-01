/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;
import controlegastos.*;

/**
 *
 * @author maxx
 */
public class Fuzzy {
    private double nec;
    private double desnec;
    private double econ;
    private double econ_esperada;
    
    private double sovino;
    private double moderado;
    private double gastador;
    private double esbanjador;
    
    private double myvar;
    
    private int rank;
    
    Fuzzy(double nec, double des){
        double total = nec + des;
        econ = ControleGastos.salario - total;
        econ_esperada = (ControleGastos.salario - nec) * (ControleGastos.economia / 100.00);
        sovino = 0;
        moderado = 0;
        gastador = 0;
        esbanjador = 0;
        myvar = econ / econ_esperada;
        fuzzy();
        unfuzzy();
    }
    
    // Fuzzificação
    private void fuzzy(){
        //Regras de produção
        if(myvar > 1)
            sovino = 1;
        else if(myvar > 0.90){
            sovino = 1-(myvar-0.9)*10.0;
            moderado = 1 - sovino;
        } else if(myvar > 0.7){
            moderado = 1;
        }  else if(myvar > 0.6){
            moderado = 0.7 - myvar;
            gastador = 1 - moderado;
        } else if(myvar > 0.3){
            gastador = 1;
        } else if(myvar > 0.2){
            gastador = 0.3 -myvar;
            esbanjador = 1 - gastador;
        } else
          esbanjador = 1;  
    }
    
    // Defuzzificação
    private void unfuzzy(){
        // primeiro dos máximos
        if(sovino > moderado)
            rank = 1;
        else if(moderado > gastador)
            rank = 2;
        else if(gastador > esbanjador)
            rank = 3;
        else 
            rank = 4;
    }
    
    
    public String getRank() {
        switch (rank){
            case 1:
                return "sovino";
            case 2:
                return "moderado";
            case 3:
                return "gastador";
            case 4:
                return "esbanjador";
        }
        return "indefinido";
    }
    
    public java.awt.Color getColour() {
        
        switch (rank){
            case 1:
                return java.awt.Color.GREEN;
            case 2:
                return java.awt.Color.YELLOW;
            case 3:
                return java.awt.Color.ORANGE;
            case 4:
                return java.awt.Color.RED;
        }
        return java.awt.Color.GRAY;
    }
}
