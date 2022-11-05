package log.model;

import log.interfaces.ILog;


public class LogOpFuncionario implements ILog {

    private String logInfo;

    @Override
    public String getLogInfo() {
        return logInfo;
    }
    
    public LogOpFuncionario(String nome, String operacao) {
        this.logInfo = "Funcionário " + nome + " " + operacao;
    }
    
}
