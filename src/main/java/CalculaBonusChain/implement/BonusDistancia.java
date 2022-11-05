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

public class BonusDistancia implements IMetodoDeBonus{
    
    private IMetodoDeBonus proximo;
    
    
    @Override
    public void calculaBonus(Funcionario funcionario) {
        if(funcionario.getDistanciaTrabalho() <= 15)
            funcionario.setBonus(new Bonus("Distância até 15km do local de trabalho ",0.01));
        else if(funcionario.getDistanciaTrabalho() <= 30)
            funcionario.setBonus(new Bonus("Distância até 30km do local de trabalho ",0.03));
        else if(funcionario.getDistanciaTrabalho() <= 50)
            funcionario.setBonus(new Bonus("Distância até 50km do local de trabalho ",0.05));
        else if(funcionario.getDistanciaTrabalho()>50)
            funcionario.setBonus(new Bonus("Distância maior que 50km do local de trabalho ",0.07));
        
        this.proximo.calculaBonus(funcionario);
    }
    
    @Override
    public void setProximo(IMetodoDeBonus proximo){
        this.proximo = proximo;
    }
    
}
