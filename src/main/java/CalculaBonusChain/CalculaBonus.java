/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculaBonusChain;

import CalculaBonusChain.interfaces.IMetodoDeBonus;
import CalculaBonusChain.implement.BonusAssiduidade;
import CalculaBonusChain.implement.BonusDistancia;
import CalculaBonusChain.implement.BonusGeneroso;
import CalculaBonusChain.implement.BonusMembroFamilia;
import CalculaBonusChain.implement.BonusNormal;
import CalculaBonusChain.implement.BonusTempoServico;
import java.util.ArrayList;
import model.Bonus;
import model.Funcionario;


public class CalculaBonus {
    
    public void calculaBonus(Funcionario funcionario, String nomePrimeiroBonus){
        double porcentagemTotal = 0, valorTotalBonus;
        
        IMetodoDeBonus BAssiduidade = new BonusAssiduidade();
        IMetodoDeBonus BDistancia = new BonusDistancia();
        IMetodoDeBonus BGeneroso = new BonusGeneroso();
        IMetodoDeBonus BMembroFamilia = new BonusMembroFamilia();
        IMetodoDeBonus BNormal = new BonusNormal();
        IMetodoDeBonus BTempoServico = new BonusTempoServico();
        
        BGeneroso.setProximo(BAssiduidade);
        BNormal.setProximo(BAssiduidade);
        BAssiduidade.setProximo(BDistancia);
        BDistancia.setProximo(BMembroFamilia);
        BMembroFamilia.setProximo(BTempoServico);
        
        
        if(nomePrimeiroBonus == "Bonus Generoso"){
            BGeneroso.calculaBonus(funcionario);
        } else {
            BNormal.calculaBonus(funcionario);
        }
        
        
        ArrayList<Bonus> listBonus = funcionario.getBonus();
        
        for(Bonus bonus : listBonus){
            porcentagemTotal += bonus.getValor();
        }
        
        valorTotalBonus = funcionario.getSalarioBase() * porcentagemTotal;
        
        funcionario.setValorTotalBonus(valorTotalBonus);
    }
}
