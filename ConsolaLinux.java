package com.dalv.carOS;
import java.util.Scanner;
import java.io.*;

public class ConsolaLinux {
	private Scanner input = new Scanner (System.in);
	private Commands cmds = new Commands();
	private String username = System.getProperty("user.name");
	
	public void start() throws IOException {
		System.out.println(username + "@" + System.getProperty("user.dir") + "$");
		String line = input.nextLine();
		String params[] = line.split(" ", 2);
		switch(params[0]) {
		case "echo": 
			String arr[] = params[1].split(">> ", 2);
			if(arr.length == 1) {
				cmds.echo(params[1]);
			}
				else {
					cmds.echo(params[0], params[1]);
				}
			
		case "ls": 
			cmds.merce();
			break;
			
		case "mkdir": 
			if(params.length <= 1){
				System.out.println("You must especify a directory to create");
				break;
			} else {
			cmds.newFolder(params[1]);
			break;
			}
			
		case "cd": 
			if(params.length == 1){
				cmds.moveTo(params[0]);
				break;
			} else {
				cmds.moveTo(params[1]);
				break;
		}
		
		case "mv": 
			if (params.length == 1){
				System.out.println("mv: missing file operand");
			} else {
				String arrayParams2 [] = params[1].split(" ", 2);
				if (arrayParams2.length == 1){
					System.out.println("mv: missing destination file operand");
				} else {
				cmds.spostalo(arrayParams2[0], arrayParams2[1]);
				} 
			}
			break;
			
		default:
			System.out.println(params[0] + ": command not found");
			break;
		
	} 
		}
	}
