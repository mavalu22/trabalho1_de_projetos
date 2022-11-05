/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log.model;

import log.interfaces.ILog;

public class LogFalhaOp implements ILog {
    private String logInfo;

    @Override
    public String getLogInfo() {
        return logInfo;
    }
    
    public LogFalhaOp() {
        this.logInfo = "Falha ao realizar a operação.";
    }     
}
