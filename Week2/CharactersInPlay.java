
import edu.duke.*;
import java.util.ArrayList;

/**
 * 여기에 CharactersInPlay 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
public class CharactersInPlay
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 바꾸십시오
    private ArrayList<String> characterNameList;
    private ArrayList<Integer> characterWordsCount;

    /**
     * CharactersInPlay 클래스의 객체 생성자
     */
    public CharactersInPlay()
    {
        this.characterNameList = new ArrayList<String>();
        this.characterWordsCount = new ArrayList<Integer>();
    }

    public void update(String person){
        int index = characterNameList.indexOf(person);
        if( index == -1 ){
            characterNameList.add(person);
            characterWordsCount.add(1);
        } else{
            int value = characterWordsCount.get(index);
            characterWordsCount.set(index, value+1);
        }
    }
    
    public void findAllCharacters(){
        this.characterNameList.clear();
        this.characterWordsCount.clear();
        FileResource resource = new FileResource();
        
        for(String s : resource.lines()){
            s = s.toLowerCase();
            String tempPerson = "";
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '.'){
                    update(tempPerson);
                    break;
                } else{
                    tempPerson += s.charAt(i);
                }
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2){
        for(int i=0; i<characterWordsCount.size(); i++){
            int count = characterWordsCount.get(i);
            if(count > num1 && count <= num2){
                System.out.println(characterNameList.get(i) + "\t" + characterWordsCount.get(i));
            }
        }
    }
    
    public int findIndexOfMax(){
        int maxValue = characterWordsCount.get(0);
        int maxIndex = 0;
        for(int i=1; i<characterWordsCount.size(); i++){
            if(maxValue < characterWordsCount.get(i)){
                maxValue = characterWordsCount.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    
    public void tester(){
        findAllCharacters();
        
        int maxIndex = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "
            + characterNameList.get(maxIndex) + " " + characterWordsCount.get(maxIndex));
            
            
        charactersWithNumParts(10, 15);
    }
}
