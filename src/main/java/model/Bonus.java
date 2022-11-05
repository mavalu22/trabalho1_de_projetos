/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Bonus {
    private String Nome;
    private double Valor;
    private String Data;

    public Bonus(String Nome, double Valor) {
        this.Nome = Nome;
        this.Valor = Valor;
    }

    public Bonus() {
    }

    public String getNome() {
        return Nome;
    }

    public double getValor() {
        return Valor;
    }
    
    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
    
    @Override
    public String toString() {
        return ("O tipo de bônus é: " + Nome + " | O seu valor é: " + Valor + " | A data deste cálculo efetuado é: " + Data );
    }
}
