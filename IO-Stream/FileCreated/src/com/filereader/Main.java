package com.filereader;

import java.io.*;

//File class constructors:------

//File f = new File(String fname); //we can provide relative of absolute path.
//File f=new File(String subdir,String fname);
//File f =new File(File subdir,String fname);


//File class methods -----

// f.mkdir(); //to create folder
//f.createNewFile(); // it will create a abc.txt file in the current location
//System.out.println(f.exists()); //true


public class Main {
public static void main(String[] args) {
		try {
			File file = new File("abc.txt");
			if (file.createNewFile()) {
				System.out.println("New File is created!");
			} else {
				System.out.println("File already exists.");
			}
		}catch (IOException e) {
				e.printStackTrace();
			}
		}
}