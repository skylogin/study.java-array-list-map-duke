
/**
 * 여기에 TestCaesarCipher 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
import edu.duke.*;

public class TestCaesarCipher
{
    private int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k<message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    private int maxIndex(int[] values){
        int max=0;
        for(int i=0; i< values.length;i++){
            if(values[i] > values[max]){
                max = i;
            }  
        }    
        return max;
    }
    
    public void breakCaesarCipher(String input){
        int[] letterFreqs = countLetters(input);
        int maxindex = maxIndex(letterFreqs);
        int dkey = maxindex - 4;
        if (maxindex < 4) {
            dkey = 26 - (4-maxindex);
        }
        OOCaesarCipher c = new OOCaesarCipher(dkey);
        System.out.println("Encrypted message:\n" + input);
        System.out.println("\nkey:" + dkey);
        System.out.println("\nDecrypted message:\n" + c.decrypt(input));
    }
    
    public void simpleTests(){
       FileResource fr = new FileResource();
        String message = fr.asString();
        OOCaesarCipher c = new OOCaesarCipher(18);
        String encrypted = c.encrypt(message);
        System.out.println(encrypted);
        System.out.println(c.decrypt(encrypted));
        breakCaesarCipher("XJWW USCW AF LZW UGFXWJWFUW JGGE!");
        
    }
}
