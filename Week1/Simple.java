
/**
 * 여기에 Simple 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
public class Simple
{
   
     private String word; 
     private String phrase; 
     public Simple(int number, String w) { 	
          word = w; 	
          phrase = mystery(number, w);          
     }   
     private String mystery(int num, String s) {  	
          String answer = "";  	
          for (int k=0; k<num; k++) {     	
               answer = answer + s;  	
          }  	
          return answer; 
     } 

     public String toString() { 	
          return phrase + " is " + word + " repeated";
     }
     

}
