

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    
    public void testUniqueIp(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        int size = la.countUniqueIps();
        System.out.println(size);
    }
    
    public void testHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPVisitesOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        ArrayList<String> list = la.uniqueIPVisitsOnDay("Sep 27");
        ArrayList<String> list2 = la.uniqueIPVisitsOnDay("Mar 24");
        
        System.out.println(list.size() + " " + list2.size());
        
    }
    
    public void testCountUniqueIPsInRange(){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("weblog2_log");
       ArrayList<String> list = la.countUniqueIPsInRange(400, 499);
       ArrayList<String> list2 = la.countUniqueIPsInRange(300, 399);
        
       System.out.println(list.size() + " " + list2.size());
    }
    
    
    
    
    
    
    
    
}
