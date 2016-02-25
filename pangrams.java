import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
        //System.out.println("Enter your string");
        String pan=in.nextLine();
        pan=pan.toLowerCase();
        if(pan.length()<26){
            //System.out.println("not pangram");
        }
        else{
            for(int i=0;i<pan.length();i++){
                char ch=pan.charAt(i);
                if(Character.isLetter(ch)){
                    if(hmap.get(ch)!=null){
                        hmap.put(ch,hmap.get(ch)+1);
                    }
                    else{
                        hmap.put(ch,1);
                    }
                }
            }
        }
        
        if(hmap.size()<26){
            System.out.println("not pangram");
        }
        else{
            System.out.println("pangram");
        }
    }
}
