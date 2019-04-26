import edu.duke.*;
import java.util.*;
import java.io.File;

public class WordsInFiles{
    
    private HashMap<String, ArrayList<String>> wordMap;
    
    public WordsInFiles(){
        this.wordMap = new HashMap<String, ArrayList<String>>();
    }

    public void addWordsFromFile(File f){
        FileResource resource = new FileResource(f);
        String filename = f.getName();
        
        for(String word : resource.words()){
            if(!wordMap.containsKey(word)){
                ArrayList<String> list = new ArrayList<String>();
                list.add(filename);
                wordMap.put(word, list);
            } else if(wordMap.containsKey(word) && !wordMap.get(word).contains(filename)){
                ArrayList<String> list = wordMap.get(word);
                list.add(filename);
                wordMap.put(word, list);
            }
        }
    }
    
    public void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dirResource = new DirectoryResource();
        for (File f : dirResource.selectedFiles()) {
            addWordsFromFile(f);
        }
        
    }
    
    public int maxNumber(){
        int maxNumber = 0;
        for(String word : wordMap.keySet()){
            ArrayList<String> list = wordMap.get(word);
            int count = list.size();
            if(maxNumber < count){
                maxNumber = count;
            }
        }
        return maxNumber;
    }
    
    
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> wordList = new ArrayList<String>();
        for (String word : wordMap.keySet()) {
            ArrayList<String> list = wordMap.get(word);
            int count = list.size();
            if (count == number) {
                wordList.add(word);
            }
        }
        return wordList;
    }
    
    
    public void printFilesIn(String word) {
        //prints the names of the files this word appears in, one filename per line
        ArrayList<String> list = wordMap.get(word);
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
                    for (String key : gladMap.keySet()) {
                        ArrayList<String> currentWordList = gladMap.get(key);
                        totalWords += currentWordList.size();
                    }
    }
    
    
    public void tester() {
        buildWordFileMap();
        int fileNum = maxNumber();
        System.out.println("Max number files any word is in: " + fileNum);

        ArrayList<String> wordsInFiles = wordsInNumFiles(fileNum);
        System.out.println("Total words in all files: " + wordsInFiles.size());
        wordsInFiles = wordsInNumFiles(4);
        System.out.println("Total words in four files: " + wordsInFiles.size());
        System.out.println("********");
        printFilesIn("laid");
        System.out.println("\n");
        printFilesIn("tree");
    }
    
    
}
