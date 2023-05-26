package Stack_Related_Problems;

import java.util.*;

/* Reduce String */

public class ReduceString {

	
	public static void main(String args[] ) throws Exception {
        //BufferedReader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String name = br.readLine();                // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        
        Scanner sr = new Scanner(System.in);
        String str = sr.next();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(!stack.isEmpty()&&stack.peek()==str.charAt(i)){
                stack.pop();
            }
            else{
                stack.push(str.charAt(i));
            }
           
        }
    
    if(!stack.isEmpty()){
       StringBuilder sb = new StringBuilder();
        for(Character s : stack){
            sb.append(s);
        }
        
        System.out.println(sb); 
      }else{
          System.out.println("Empty String");
      }
     
    }
	
	
}


/*  Input.....
 	aaabccddd
 */
/*  Output.....
	abd
*/