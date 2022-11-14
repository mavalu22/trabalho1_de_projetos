/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculaBonusChain.implement;

import CalculaBonusChain.interfaces.IMetodoDeBonus;
import CalculaBonusChain.interfaces.IMetodoDeBonus;
import java.time.LocalDate;
import model.Bonus;
import model.Funcionario;

public class BonusNormal implements IMetodoDeBonus{

    private IMetodoDeBonus proximo;
    
    @Override
    public void calculaBonus(Funcionario funcionario) {
        funcionario.setBonus(new Bonus("Normal", 0.005));
        
        this.proximo.calculaBonus(funcionario);
    }
    
    @Override
    public void setProximo(IMetodoDeBonus proximo){
        this.proximo = proximo;
    }
}
