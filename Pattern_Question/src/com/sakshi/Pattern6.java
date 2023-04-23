package com.sakshi;

//***** == i=1,j>=1
// **** == i=2,j>=2
//  ***  == i=3,j>=3
//   **
//    *
public class Pattern6 {
	public static void main(String[] args) {
		int n = 5;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i<=j) {
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
