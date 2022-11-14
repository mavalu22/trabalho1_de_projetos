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


public class BonusTempoServico implements IMetodoDeBonus {
    
    private IMetodoDeBonus proximo;
    
    @Override
    public void calculaBonus(Funcionario funcionario) {
        if(funcionario.getTempoServico() == 0)
            funcionario.setBonus(new Bonus("Menos de 1 ano de serviço na respectiva empresa ",0.00));
        else if(funcionario.getTempoServico() == 1 || funcionario.getTempoServico() <= 5)
            funcionario.setBonus(new Bonus("Entre 1 a 5 anos de serviço na respectiva empresa ",0.02));
        else if(funcionario.getTempoServico()== 6 || funcionario.getTempoServico() <= 10)
            funcionario.setBonus(new Bonus("Entre 6 a 10 anos de serviço na respectiva empresa ",0.03));
        else if(funcionario.getTempoServico() == 11 || funcionario.getTempoServico() <= 15)
            funcionario.setBonus(new Bonus("Entre 11 a 15 anos de serviço na respectiva empresa ",0.08));
        else if(funcionario.getTempoServico()== 16 || funcionario.getTempoServico() <= 20)
            funcionario.setBonus(new Bonus("Possui 16 a 20 anos de serviço na respectiva empresa",0.10));
        else if(funcionario.getTempoServico() > 6)
            funcionario.setBonus(new Bonus("Possui mais de 20 anos de serviço na respectiva empresa, parabéns ",0.15));
        
        
    }
    
    @Override
    public void setProximo(IMetodoDeBonus metodoBonus){
        // acabou a chain
    }
    
}
