
import edu.duke.*;
import java.util.*;

public class GladLibMap{
    private HashMap<String, ArrayList<String>> myMap;
    private Random myRandom;
    
    private String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private String dataSourceDirectory = "data";
    
    
    /**
     * GladLib 클래스의 객체 생성자
     */
    public GladLibMap(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source){
        String[] labels = {"country", "noun", "animal", 
            "adjective", "name", "color", "timeframe"};
            
        myMap = new HashMap<String, ArrayList<String>>();
        
        for(String s : labels){
            ArrayList<String> list = readIt(source + "/" + s + ".txt");
            myMap.put(s, list);
        }
    }
    
        

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label){
        if(label.equals("number")){
            return "" + myRandom.nextInt(50)+5;
        }
        
        
        return randomFrom(myMap.get(label));
    }
        
    
            
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if(first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1));
        return prefix+sub+suffix;
    }
        
    public void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if(charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
             
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if(source.startsWith("http")){
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        
        return story;
    }
    
    
    
    public ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        
        if(source.startsWith("http")){
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        
        
        return list;
    }
    
    public void makeStory(){
        String template = fromTemplate(dataSourceDirectory + "/madtemplate.txt");
        printOut(template, 60);
    }
    
}
