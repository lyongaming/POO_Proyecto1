package com.dalv.carOS;
import java.util.Scanner;
 
	public class Main {
		
		public static void main(String[] args) {
			try{
			ConsolaLinux console = new ConsolaLinux();
			console.start();
		} catch (Exception e){
			e.printStackTrace();
			}
		}
	}