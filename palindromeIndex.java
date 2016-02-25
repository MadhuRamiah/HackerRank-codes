import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner read=new Scanner(System.in);
        int num=Integer.parseInt(read.nextLine());
        String set[]=new String[num];
        for(int i=0;i<num;i++){
            set[i]=read.nextLine();
            String reverse=new StringBuilder(set[i]).reverse().toString();
            //System.out.println(reverse);
            if(reverse.equals(set[i])){
                System.out.println("-1");
            }
            else{
                set[i]=set[i].trim();
                int length=set[i].length();
                //int isEven=false;
                boolean ispal=false;
                for(int j=0,k=length-1;j<k;j++,k--){
                    if(set[i].charAt(j)!=set[i].charAt(k)){
                        int m,n;
                        for(m=j,n=k-1;m<n;m++,n--){
                        	//System.out.println(m+" "+n+" "+set[i].charAt(m));
                            if(set[i].charAt(m)!=set[i].charAt(n)){
                                //System.out.println(m+" "+n+" "+set[i].charAt(m));
                                ispal=true;
                                break;
                            }
                        }
                        if(ispal==true){
                            System.out.println(m);
                        }
                        else{
                            System.out.println(k);
                        }
                        break;
                    }
                }
            }
        }
    }
}
