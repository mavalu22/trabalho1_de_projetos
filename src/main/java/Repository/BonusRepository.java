/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dao.BonusDao;
import dto.BonusDTO;
import java.util.ArrayList;
import java.util.List;
import model.Bonus;

public class BonusRepository {
    
    public List<Bonus> read(String nome){
        List<Bonus> listBonus = new ArrayList<Bonus>();
        List<BonusDTO> listBonusDTO = new ArrayList<BonusDTO>();
        BonusDao bonusDao = new BonusDao();
        
        listBonusDTO = bonusDao.read(nome);
        
        
        for(BonusDTO bonusDTO: listBonusDTO){
            Bonus bonus = new Bonus(bonusDTO.getNome(), bonusDTO.getValor());
            bonus.setData(bonusDTO.getData());
            listBonus.add(bonus);
        }
                
        
        return listBonus;
    }    
}
