/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dao.FuncionarioDao;
import dto.FuncionarioDTO;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class FuncionarioRepository {
    public List<Funcionario> read(){
        List<Funcionario> listFuncionario = new ArrayList<Funcionario>();
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<FuncionarioDTO>();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        
        listFuncionarioDTO = funcionarioDao.read();
        
        Funcionario funcionario = new Funcionario();
        for(FuncionarioDTO funcionarioDTO: listFuncionarioDTO){
            funcionario.setId(funcionarioDTO.getId());
            funcionario.setNome(funcionarioDTO.getNome());
            funcionario.setIdade(funcionarioDTO.getIdade());
            funcionario.setSalario(funcionarioDTO.getSalario());
            funcionario.setSalarioBase(funcionarioDTO.getSalarioBase());
            funcionario.setCargo(funcionarioDTO.getCargo());
            funcionario.setFalta(funcionarioDTO.getFalta());
            funcionario.setTempoServico(funcionarioDTO.getTempoServico());
            funcionario.setQtdMembroFamilia(funcionarioDTO.getQtdMembroFamilia());
            funcionario.setDistanciaTrabalho(funcionarioDTO.getDistanciaTrabalho());
            funcionario.setValorTotalBonus(funcionarioDTO.getValorTotalBonus());
            
            listFuncionario.add(funcionario);
        }
                
        
        return listFuncionario;
    }
}
