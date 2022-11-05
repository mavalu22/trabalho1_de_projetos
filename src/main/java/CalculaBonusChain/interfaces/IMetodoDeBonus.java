/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculaBonusChain.interfaces;

import model.Funcionario;


public interface IMetodoDeBonus {
    
    public void calculaBonus(Funcionario funcionario);
    
    public void setProximo(IMetodoDeBonus metodoBonus);
}
