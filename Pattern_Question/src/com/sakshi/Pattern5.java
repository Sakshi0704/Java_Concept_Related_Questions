package com.sakshi;

public class Pattern5 {

	public static void main(String[] args) {
		int n = 10;
		for(int i=1;i<n;i++) {
			if(i<=n/2) {
				for(int j=1;j<=i;j++) {
					
					System.out.print("* ");
				}
			}
			else{
				for(int j=1;j<=n-i;j++) {
					System.out.print("* ");
				}
			}
			
			System.out.println();
		}
	}
	
}


//i=1  ==> j=1
//i=2 ==> j=2
//i=3 ==> j=3
//i=4 ==> j=4
//i=5 ===> j=5
//i=6 == j=4
