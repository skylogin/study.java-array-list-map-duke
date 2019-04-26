
import java.util.*;

public class LogEntry{
    
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;
    
    public LogEntry(String ip, Date time, String req, int s, int b){
        this.ipAddress = ip;
        this.accessTime = time;
        this.request = req;
        this.statusCode = s;
        this.bytesReturned = b;
    }
    
    public String getIpAddress(){
        return this.ipAddress;
    }
    public void setIpAddress(String ip){
        this.ipAddress = ip;
    }
    
    public Date getAccessTime(){
        return this.accessTime;
    }
    public void setaAccessTime(Date time){
        this.accessTime = time;
    }
    
    public String getRequest(){
        return this.request;
    }
    public void setRequest(String req){
        this.request = req;
    }
    
    public int getStatusCode(){
        return this.statusCode;
    }
    public void setStatusCode(int s){
        this.statusCode = s;
    }
    
    public int getBytesReturned(){
        return this.bytesReturned;
    }
    public void setBytesReturned(int b){
        this.bytesReturned = b;
    }

    public String toString(){
        return this.ipAddress + " " + this.accessTime + " " + this.request
            + " " + this.statusCode + " " + this.bytesReturned;
    }
    
}
