import edu.duke.*;
import java.util.*;

public class CodonFrequencies{
    
    private HashMap<String,Integer> codonMap;
    
    public CodonFrequencies(){
        this.codonMap = new HashMap<String,Integer>();
    }

    public void buildCodonMap(int start, String dna){
        codonMap.clear();
        
        
        for(int i = start; dna.length()-i > 3; i += 3) {
            String codon = dna.substring(i, i+3);
   
            if(codonMap.containsKey(codon)){
                codonMap.put(codon, codonMap.get(codon)+1);
            } else{
                codonMap.put(codon, 1);
            }
        }
        
      
    }
    
    
    public String getMostCommonCodon(){
        int maxValue = 0;
        String maxKey = null;
        for(String s : codonMap.keySet()){
            int count = codonMap.get(s);
            if(maxValue < count){
                maxValue = count;
                maxKey = s;
            }
        }
        
        return maxKey;
    }
    
    public void printCodonCounts(int start, int end){
        System.out.println("Counts of codons between 1 and 5 inclusive are:");
        for(String s : codonMap.keySet()){
            int count = codonMap.get(s);
            if(count >= start && count <= end){
                System.out.println(s + "\t" + count);
            }
        }
    }
    
    public void test(){
        
        FileResource resource = new FileResource();
        String dna = resource.asString();
        dna = dna.toUpperCase();
        
        for(int i=0; i<3; i++){
            System.out.println("Reading frame starting with " + i 
                + " results in 3 unique codons");
                
            buildCodonMap(i, dna);
            
            String mostCommonCodon = getMostCommonCodon();
            
            System.out.println("and most common codon is");
            System.out.println(mostCommonCodon + " with count " 
                + codonMap.get(mostCommonCodon));
        
            System.out.println("Total: ");
            printCodonCounts(0, 1000);
            System.out.println("*******************************");
        }
        
        
        
        
        
        
    }
    
}
