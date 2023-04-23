package com.sakshi;

//
//********* i =1 ==> 1<=j<=9
// ******* i = 2 ==> 2<=j<=8
//  *****   i = 3 ==> 3<=j<=7
//   ***    i = 4 ==> 4<=j<=6
//    *     i= 5 ===> 5<=j<=5
  //                  i<=j, j<=2*n-1
public class Pattern9 {
	public static void main(String[] args) {
		int n = 5;
		for(int i=1;i<=n;i++) { 
			for(int j = 1;j<2*n;j++) {
				 if(i<=j&&j<=2*n-i) {  // 2<=1 || 1<=9
					System.out.print("*"); 
				 }
				 else {
					 System.out.print(" ");
				 }
			}
		  System.out.println();
		}
	}
}
