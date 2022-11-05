/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log.model;

import java.util.ArrayList;
import log.interfaces.ILog;

public class LogCalculaSalario implements ILog {
    private String logInfo;
    
    @Override
    public String getLogInfo() {
        return logInfo;
    }
    
    public LogCalculaSalario (ArrayList<String> nomes){
        this.logInfo = "Salário calculado para o(s) funcionário(s): [ ";
        for(String nome : nomes){
            this.logInfo += nome + ", ";
            
        }
        this.logInfo += "]";        
    }
    
}
