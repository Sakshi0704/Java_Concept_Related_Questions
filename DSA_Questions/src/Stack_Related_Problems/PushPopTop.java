package Stack_Related_Problems;
import java.util.*;


/* Push, Pop and Top */

public class PushPopTop {
	 public static void main(String args[] ) throws Exception {
	        //BufferedReader
	        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        // String name = br.readLine();                // Reading input from STDIN
	        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
	        
	        Scanner sr = new Scanner(System.in);
	        int n = sr.nextInt();
	        Stack<Integer> stack = new Stack<>();
	        for(int i=0;i<n;i++){
	            int c = sr.nextInt();
	            switch(c){
	                case 1 : 
	                        stack.add(sr.nextInt());
	                        break;
	                        
	                case 2 : 
	                        if(!stack.isEmpty()){
	                            stack.pop();
	                        }
	                        break;
	                case 3 :
	                        if(!stack.isEmpty()){
	                            System.out.println(stack.peek());
	                        }else{
	                            System.out.println("Empty!");
	                        }
	                        break;
	            }
	        }
	        
	    }
}


/*  Input...
6
1 15
1 20
2
3
2
3
*/

/* Output...
 15
 Empty!
*/
