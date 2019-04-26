
import java.util.*;

public class HashTester{
    public void testCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
    }
    
    public void testMostCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        int count = la.mostNumberVisitsByIP(counts);
        System.out.println(count);
    }
    
    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        ArrayList<String> list = la.iPsMostVisits(counts);
        for(String s : list){
            System.out.println(s);
        }
    }
    
    public void testIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String,ArrayList<String>> counts = la.iPsForDays();
        System.out.println(counts);
    }
    
    public void testDayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        String date = la.dayWithMostIPVisits(la.iPsForDays());
        System.out.println(date);
    }
    
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");

        ArrayList<String> list = la.iPsWithMostVisitsOnDay(
            la.iPsForDays(), "Sep 30");
            
        for(String s : list){
            System.out.println(s);
        }

        
        
    }
}
