import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner read=new Scanner(System.in);
        String str=read.nextLine();
        int length=str.length();
        HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
        for(int i=0;i<length;i++){
            char c=str.charAt(i);
            if(hmap.get(c)==null){
                hmap.put(c,1);
            }
            else{
                hmap.put(c,hmap.get(c)+1);
            }
        }
        //aadbbcc
        //int min=Integer.MAX_VALUE;
        HashMap<Integer,Integer> countmap=new HashMap<Integer,Integer>();
        for(Integer value:hmap.values()){
            if(countmap.get(value)==null){
                countmap.put(value,1);
            }
            else{
                countmap.put(value,countmap.get(value)+1);
            }
        }
        if(countmap.size()>2){
            System.out.println("NO");
        }
        else if(countmap.size()==1){
            System.out.println("YES");
        }
        else{
            int first=0;
            int second=0;
            /*for(Integer value:countmap.keySet()){
                   if(first==0){
                       first=value;
                   }
                    else{
                        second=value;
                    }
            }  
            //System.out.println(first+" "+second);
            int diff=first-second;*/
            int count=0;
            
            for(Integer value:countmap.values())
            {
                    //System.out.println(value);
                    if(value>1){
                       count++; 
                    }
            }
            if(count>1){
                    System.out.println("NO");
            }
            else{
                    System.out.println("YES");
            }
        }  
    }
}
