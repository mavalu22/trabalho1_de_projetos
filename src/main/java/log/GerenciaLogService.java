/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;

import dao.LogDao;
import log.interfaces.ILog;
import log.json.LogAdapterJson;
import log.txt.LogAdapterTxt;

public class GerenciaLogService {
    private int logType;
    private LogAdapterJson jsonLog;
    private LogAdapterTxt txtLog;

    public GerenciaLogService(int logType) {
        this.logType = logType;
        this.jsonLog = new LogAdapterJson();
        this.txtLog = new LogAdapterTxt();

    }
    
    public void salvaLog(ILog log){
        if(this.logType == 0){
            this.jsonLog.manipulaArquivo(log);
        } else {
            this.txtLog.manipulaArquivo(log);
        }
    }
    
    public void escreveArquivo(){
        if(this.logType == 0){
            this.jsonLog.escreveArquivo();
        } else {
            this.txtLog.escreveArquivo();
        }          
    }
    
    public void alteraTipoPersistencia(){
        LogDao logDao = new LogDao();
        
        if(this.logType == 0){
            this.jsonLog.alteraPersistenciaLog(txtLog);
            this.jsonLog.limpaArquivo();
            this.logType = 1;
            this.escreveArquivo();
            logDao.updateType(1);
        } else {
            this.txtLog.alteraPersistenciaLog(jsonLog);
            this.txtLog.limpaArquivo();
            this.logType = 0;
            this.escreveArquivo();
            logDao.updateType(0);
        }          
        
    }
    
}
