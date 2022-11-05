/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;
import dao.FuncionarioDao;
import dto.FuncionarioDTO;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioPresenter {
    
    public void create(FuncionarioDTO Funcionario){
        FuncionarioDao creator = new FuncionarioDao();
        creator.create(Funcionario);
    }
    
    public List<FuncionarioDTO> readAll(){
        FuncionarioDao reader = new FuncionarioDao();
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();
        listFuncionarioDTO = reader.read();
        return listFuncionarioDTO;
    }
    
    public void update(){
    
    }
    
    public void delete(){
    
    }
}
