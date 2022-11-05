/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log.txt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import log.interfaces.ILog;
import log.interfaces.ILogAdapter;
import log.model.Log;

public class LogAdapterTxt implements ILogAdapter{
    public ArrayList<String> texto = new ArrayList<String>();
    public int qtd = 1;
    
    @Override
    public void escreveArquivo() {
        try{
            FileWriter writeFile = null;
            writeFile = new FileWriter("saida.txt"); 
            for(String logInfo : this.texto)
                writeFile.write(logInfo + "\n");
            writeFile.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public LogAdapterTxt() {
        leArquivo();
    }

    @Override
    public void leArquivo() {
        try{
            Scanner in = new Scanner(new FileReader("saida.txt"));
            while (in.hasNextLine()) {
               String line = in.nextLine();
               texto.add(line);         
            }
        }catch(FileNotFoundException e){
                e.printStackTrace();
        }

    }
    
    
    @Override
    public void manipulaArquivo(ILog log){
        String erroFormatado;
        
        String id = String.valueOf(qtd);
        erroFormatado = "log_id: " + id + ", log_info: " + log.getLogInfo();
        this.texto.add(erroFormatado);
        this.qtd++;
    }
    
    public void alteraPersistenciaLog(ILogAdapter typeLog){
        String[] splitText;
        String logText;
        
        
        
        for(String logInfo : this.texto){
            splitText = logInfo.split("log_info: ");
            logText = splitText[1];
            typeLog.manipulaArquivo(new Log(logText));
        }
        
    }
    
    public void limpaArquivo() {
        try{
            FileWriter writeFile = null;
            writeFile = new FileWriter("saida.txt"); 
            writeFile.write("");
            writeFile.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
