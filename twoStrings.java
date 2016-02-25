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
            String str1=in.nextLine();
            String str2=in.nextLine();
            boolean substring=false;
            int len=0;
            int str_num=0;
            HashSet<Character> h1=new HashSet<Character>();
            HashSet<Character> h2=new HashSet<Character>();
            for(int j=0;j<str1.length();j++){
                h1.add(str1.charAt(j));
            }
            for(int j=0;j<str2.length();j++){
                h2.add(str2.charAt(j));
            }
            h1.retainAll(h2);
            if(h1.isEmpty()){
                System.out.println("NO");    
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
