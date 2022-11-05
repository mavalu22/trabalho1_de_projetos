/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculadoraSalario;

import model.Funcionario;


public class CalculaSalarioPadrao implements ICalculadoraSalario{

    @Override
    public void processarSalario(Funcionario funcionario) {
        double salarioTotal = funcionario.getSalarioBase() + funcionario.getValorTotalBonus();
        
        funcionario.setSalario(salarioTotal);
    }

    
}
