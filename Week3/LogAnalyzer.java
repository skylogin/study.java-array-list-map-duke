
import edu.duke.*;
import java.util.*;

public class LogAnalyzer{
    
    private ArrayList<LogEntry> records;
    public LogAnalyzer(){
        this.records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
         FileResource resource = new FileResource("data/" + filename);
         
         for(String s : resource.lines()){
             LogEntry le = WebLogParser.parseEntry(s);
             this.records.add(le);
         }
     }
     
    public int countUniqueIps(){
         ArrayList<String> uniqueIp = new ArrayList<String>();
         
         for(LogEntry le : records){
            String ipAddr = le.getIpAddress();
            
            if(!uniqueIp.contains(ipAddr)){
                uniqueIp.add(ipAddr);
            }
         }
         
         
         return uniqueIp.size();
    }
     
    public void printAllHigherThanNum(int num){
         for(LogEntry le : records){
             int status = le.getStatusCode();
             
             if(status > num){
                 System.out.println(le);
             }
         }
    }
        
    public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
    }
     
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> list = new ArrayList<String>();
        
        for(LogEntry le : records){
             String dateTime = le.getAccessTime().toString();
             String ip = le.getIpAddress();
             
             if(dateTime.indexOf(someday)!=-1 && !list.contains(ip)){
                 list.add(ip);
             }
        }
        
        return list;
    }
    
    
    public ArrayList<String> countUniqueIPsInRange(int low, int high){
       ArrayList<String> list = new ArrayList<String>();
        
        for(LogEntry le : records){
             int status = le.getStatusCode();
             String ip = le.getIpAddress();
             
             if(status >= low && status <= high && !list.contains(ip)){
                 list.add(ip);
             }
        }
        
        return list;
    }
    
    public HashMap<String,Integer> countVisitsPerIP(){
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
         
        for(LogEntry le : records){
            String ipAddr = le.getIpAddress();
            
            if(!counts.containsKey(ipAddr)){
                counts.put(ipAddr, 1);
            } else{
                counts.put(ipAddr, counts.get(ipAddr)+1);
            }
        }
        
        return counts;
    }
    
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> map){
        int max = 0;
        for(String key : map.keySet()){
            int temp = map.get(key);
            if(max < temp){
                max = temp;
            }
        }
        
        return max;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map){
        ArrayList<String> list = new ArrayList<String>();
        int maxValue = mostNumberVisitsByIP(map);
        
        for(String key : map.keySet()){
            int temp = map.get(key);
            if(temp == maxValue){
                list.add(key);
            }
        }
        
        
        return list;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> map 
            = new HashMap<String, ArrayList<String>>();
            
        for(LogEntry le : records){
             String dateTime = le.getAccessTime().toString().substring(4,10);
             String ip = le.getIpAddress();
             
             if(!map.containsKey(dateTime)){
                 ArrayList<String> list = new ArrayList<String>();
                 list.add(ip);
                 map.put(dateTime, list);
             } else{
                 //if(!map.get(dateTime).contains(ip)){
                     map.get(dateTime).add(ip);
                 //}
             }
        }
        
        return map;
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
        int max = 0;
        String result = null;
        for(String key : map.keySet()){
            int temp = map.get(key).size();
            if(max < temp){
                max = temp;
                result = key;
            }
        }
        
        return result;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(
        HashMap<String, ArrayList<String>> map, 
        String date){
        
        ArrayList<String> list = map.get(date);
        
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for(String s : list){
            if(!counts.containsKey(s)){
                counts.put(s, 1);
            } else{
                counts.put(s, counts.get(s)+1);
            }
        }
        
        
        int max = 0;
        for(String s : counts.keySet()){
            int temp = counts.get(s);
            if(max <= temp){
                max = temp;
                list.clear();
                list.add(s);
            }
        }
        
        
        return list;
    }
    
    
    
    
}
