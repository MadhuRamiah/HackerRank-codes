import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner readInput=new Scanner(System.in);
        int num=0;
        boolean isNumeric=false;
        ArrayList<Integer> input=new ArrayList<Integer>();
        ArrayList<Integer> output=new ArrayList<Integer>();
        while(readInput.hasNext()){
            isNumeric=false;
            try{
                int value=Integer.parseInt(readInput.nextLine());
                input.add(value);
                isNumeric=true;
                num++;
            }
            catch(NumberFormatException nfe){
                isNumeric=false;
                break;
            }
        }
        if((num==0 )|| isNumeric==false){
            System.out.println("failure");
        }
        else if(input.size()==1){
            if(input.get(0)!=0){
                System.out.println("0, out");    
            }
            else{
                System.out.println("failure");
            }
        }
        else if(input.get(0)==0){
            System.out.println("failure");
        }
        else if(input.get(0)>=num){
            System.out.println("0, "+(num-1)+", out");
        }
        else{
            output.add(0);
            int i,j,max=0,max_index,pos,nextStartPoint;
            pos=input.get(0);
            if(num>1){
                max=input.get(1);   
            }
            max_index=1;
            boolean enter=false;
            nextStartPoint=1;
            boolean neverEntered=false;
            for(i=0;;){
                enter=false;
                for(j=nextStartPoint;(j<=input.get(i)+i)&&(j<num);j++){
                    if(((input.get(j)+j)>=max)&&input.get(j)!=0){
                        max=input.get(j)+j;
                        max_index=j;
                        enter=true;
                        neverEntered=true;
                    }
                }

                pos=max;
                nextStartPoint=j-1;
                i=max_index;
                if(enter!=false){
                    output.add(nextStartPoint);    
                }

                if(pos>=num || neverEntered==false){
                    break;
                }
            }

            
            if(enter==false){
                System.out.println("failure");
            }
            else{
                System.out.print("0,");
                for(i=1;i<output.size();i++){
                    System.out.print(" "+output.get(i));
                    System.out.print(",");
                }
                System.out.println(" out");    
            }
                
        }
        
    }
}