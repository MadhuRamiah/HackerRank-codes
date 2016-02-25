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
        for(int i=0;i<num;i++){
            String str=read.nextLine();
            String strnew[]=str.split("\\s+");
            int k=Integer.parseInt(strnew[1]);
            int n=Integer.parseInt(strnew[0]);
            //System.out.println(n+" "+k);
            str=read.nextLine();
            String numArray[]=str.split("\\s+");
            //int arr[]=new int[numArray.length];
            int arr1[]=new int[n];
            int arr2[]=new int[n];
            for(int j=0;j<n;j++){
               arr1[j]=Integer.parseInt(numArray[j]);
               //System.out.println(arr1[j]);
            }
            str=read.nextLine();
            numArray=str.split("\\s+");
            for(int j=0;j<n;j++){
               arr2[j]=Integer.parseInt(numArray[j]);
               //System.out.println(arr2[j]);
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int m=n-1;
            for(int j=0;j<m;j++){
                int temp=arr2[m];
                arr2[m]=arr2[j];
                arr2[j]=temp;
                m--;
            }
            
            boolean yes=true;
            for(int j=0;j<n;j++){
               // System.out.println(arr1[j]+"   "+arr2[j]);
                if((arr1[j]+arr2[j])<k)
                {
                    yes=false;
                    break;
                }
            }
            if(yes==false){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
