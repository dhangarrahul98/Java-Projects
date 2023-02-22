import java.util.*;        // Sentence Without whitespaces
public class Whitespace {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a Sentence:- ");
        String a= scn.nextLine();
        String b="";
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=' '){b=b+a.charAt(i);}
        }
        System.out.println("A Sentence Without whitespaces is:- "+b);        
    }
}
