/* Sample program illustrating input/output methods */
import java.util.*;

class Solution{
   public static void main( String args[] ){
      
// helpers for input/output      

      Scanner in = new Scanner(System.in);
      
      int N, K;
      N = in.nextInt();
      K = in.nextInt();
      int m=6;
      int C[] = new int[N];
      for(int i=0; i<N; i++){
         C[i] = in.nextInt();
      }
      
      Arrays.sort(C);
      
      int result = 0;
      if(N==K){
          for(int i=0;i<N;i++){
              result+=C[i];
          }
      }
      else{
          int i=N-1;
          int mult=1;
          for(i=N-1;;){
              for(int j=0;j<K;j++){
                result+=C[i]*mult;   
                i--;
                if(i<0){
                    break;
                }
              }
              mult++;
              if(i<0) break;
          }
      }
      System.out.println( result );
      
   }
}
