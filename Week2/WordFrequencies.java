
import edu.duke.*;
import java.util.ArrayList;

/**
 * 여기에 WordFrequencies 클래스 설명을 작성하십시오.
 * 
 * @author chanho.jung
 * @version 190407
 */
public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        FileResource resource = new FileResource();
        
        myWords.clear();
        myFreqs.clear();
        
        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if( index == -1 ){
                myWords.add(s);
                myFreqs.add(1);
            } else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
                
            //if(!myWords.contains(s)){
            //    myWords.add(s);
            //}
        }
    }
    
    public int findIndexOfMax(){
        int maxValue = myFreqs.get(0);
        int maxIndex = 0;
        for(int i=1; i<myFreqs.size(); i++){
            if(maxValue < myFreqs.get(i)){
                maxValue = myFreqs.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public void test(){
        findUnique();
        
        System.out.println("Number of unique words: " + myWords.size());
        for(int i=0; i<myWords.size(); i++){
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }
        
        int maxIndex = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "
            + myWords.get(maxIndex) + " " + myFreqs.get(maxIndex));
    }
}


