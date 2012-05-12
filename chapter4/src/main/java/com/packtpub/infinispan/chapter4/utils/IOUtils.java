package com.packtpub.infinispan.chapter4.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {
	static InputStreamReader istream;

	static BufferedReader bufRead;

	static {
	 istream = new InputStreamReader(System.in) ;

	 bufRead = new BufferedReader(istream) ;
	}
	public static String readLine(String s) {
		System.out.print(s);
		String returnval = null;
		try {
			returnval =  bufRead.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnval;
	}
	public static void dumpWelcomeMessage() {
		System.out.println("Ticket booking system");
		System.out.println("=====================");
		System.out.println("Commands: book, pay, list");
		
	}
}
