import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        int num=Integer.parseInt(in.nextLine());
        for(int i=0;i<num;i++){
            String s=in.nextLine();
            if(s.length()%2!=0){
                System.out.println("-1");
            }
            else{
                int len=s.length();
                String s1=s.substring(0,len/2);
                String s2=s.substring(len/2,len);
                HashMap<Character,Integer> hset1=new HashMap<Character,Integer>();
                HashMap<Character,Integer> hset2=new HashMap<Character,Integer>();
                HashSet<Character> h1=new HashSet<Character>();
                HashSet<Character> h2=new HashSet<Character>();
                HashSet<Character> h3=new HashSet<Character>();
                HashSet<Character> h4=new HashSet<Character>();
                for(int j=0;j<s1.length();j++){
                    if(hset1.get(s1.charAt(j))!=null){
                        hset1.put(s1.charAt(j),hset1.get(s1.charAt(j))+1);   
                    }
                    else{
                        hset1.put(s1.charAt(j),1);
                    }
                    h1.add(s1.charAt(j));
                }
                for(int j=0;j<s2.length();j++){
                    if(hset2.get(s2.charAt(j))!=null){
                        hset2.put(s2.charAt(j),hset2.get(s2.charAt(j))+1);   
                    }
                    else{
                        hset2.put(s2.charAt(j),1);
                    }
                    h2.add(s2.charAt(j));
                }
                //System.out.println(s1+" "+s2);
                h3.addAll(h1);
                h3.addAll(h2);
                int count1=0;
                int count2=0;
                Character[] ch=h3.toArray(new Character[h3.size()]);
                for(int j=0;j<h3.size();j++)
                {
                    if(hset1.get(ch[j])==null){
                        count2+=hset2.get(ch[j]);
                    }
                    else if(hset2.get(ch[j])==null){
                        count1+=hset1.get(ch[j]);
                    }
                    else if(hset1.get(ch[j])>hset2.get(ch[j])){
                        count1+=hset1.get(ch[j])-hset2.get(ch[j]);
                    }
                    else if(hset2.get(ch[j])>hset1.get(ch[j])){
                        count2+=hset2.get(ch[j])-hset1.get(ch[j]);
                    }
                    
                }
                System.out.println(count1);
            }
        }
    }
}
