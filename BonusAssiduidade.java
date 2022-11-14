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

public class BonusAssiduidade implements IMetodoDeBonus{
    
    private IMetodoDeBonus proximo;
    
    @Override
    public void calculaBonus(Funcionario funcionario) {
        if(funcionario.getFalta() == 0)
            funcionario.setBonus(new Bonus("0 faltas ",0.05));
        else if(funcionario.getFalta() == 1 || funcionario.getFalta() <= 3)
            funcionario.setBonus(new Bonus("Entre 1 a 3 faltas ",0.03));
        else if(funcionario.getFalta()== 4 || funcionario.getFalta() == 5)
            funcionario.setBonus(new Bonus("Possui 4 ou 5 faltas",0.01));
        else if(funcionario.getFalta()>= 6)
            funcionario.setBonus(new Bonus("Possui 6 faltas ou mais ",0.00));
        
        this.proximo.calculaBonus(funcionario);
    }
    
    @Override
    public void setProximo(IMetodoDeBonus proximo){
        this.proximo = proximo;
    }
        
}
