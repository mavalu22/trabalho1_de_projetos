package log.json;

import log.model.Log;
import log.interfaces.ILog;
import log.interfaces.ILogAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LogAdapterJson implements ILogAdapter{
    public JSONArray teste = new JSONArray();
    public int qtd = 1;

    @Override
    public void escreveArquivo(){
        try{
            FileWriter writeFile = null;
            writeFile = new FileWriter("saida.json");   
            writeFile.write(this.teste.toJSONString());
            writeFile.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }  
    }

    public LogAdapterJson() {
        leArquivo();
    }
    
    @Override
    public void leArquivo(){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        File arq = new File("saida.json");
         
        try (FileReader reader = new FileReader(arq))
        {
            
            if(arq.length() != 0){
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray employeeList = (JSONArray) obj;

                //Iterate over employee array
                employeeList.forEach(log -> iterateArray ( (JSONObject) log));
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }        
    }

    private void iterateArray(JSONObject log) 
    {
        //Get employee object within list
        
         
        //Get employee first name
        String arqId = (String) log.get("log_id");    
        this.qtd = Integer.parseInt(arqId);
        //System.out.println(qtd);
         
        //Get employee last name
        String logInfo = (String) log.get("log_info");
        manipulaArquivo(new Log(logInfo));
        //System.out.println(lastName);
        

    }
    
    @Override
    public void manipulaArquivo(ILog log){                      
        JSONObject jo = new JSONObject();   

        String texto = String.valueOf(qtd);
        jo.put("log_id", texto); 
        jo.put("log_info", log.getLogInfo());
        teste.add(jo);                        
        this.qtd++;           
    
    }
    
    private void iterateArrayTrocaPersistencia(JSONObject log, ILogAdapter typeLog) 
    {

        String logInfo = (String) log.get("log_info");
        typeLog.manipulaArquivo(new Log(logInfo));
        
    }
    
    public void alteraPersistenciaLog(ILogAdapter typeLog){

        this.teste.forEach(log -> iterateArrayTrocaPersistencia ( (JSONObject) log, (ILogAdapter) typeLog));
       
    }
    
    public void limpaArquivo() {
        try{
            FileWriter writeFile = null;
            writeFile = new FileWriter("saida.json"); 
            writeFile.write("");
            writeFile.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
