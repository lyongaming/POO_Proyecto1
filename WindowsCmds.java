package com.dalv.carOS;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class WindowsCmds implements Commands {
	private String separador = System.getProperty("file.separator");
	private String home = System.getProperty("user.home");
	
	public void echo(String algo) {
		System.out.println(algo);
	}

	public void echo(String algo, String algo_parte2) {
		File file = new File(algo_parte2);
		try {
			FileWriter pencil = new FileWriter(file);
			BufferedWriter buff = new BufferedWriter(pencil);
			buff.write(algo);
			buff.flush();
			buff.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void copypaste(String src, String dst) {
		File file = new File(System.getProperty("user.dir") + separador + src);
		Path origen = file.toPath();
		File dir = new File(dst);
		Path destino = dir.toPath();
		try {
			Files.copy(origen, destino, StandardCopyOption.COPY_ATTRIBUTES);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exile(String filename) {
		File file = new File(System.getProperty("user.dir") + separador + filename);
		boolean bool = file.exists();
		if(bool) 
			file.delete();
		else
			System.out.println("No se pudo encontrar" + file.getAbsolutePath());

	}

	public void spostalo(String src, String dst) {
		File file = new File(System.getProperty("user.dir" + separador + src));
		Path origen = file.toPath();
		File dir = new File(System.getProperty("user.dir" + separador + dst));
		Path destino = dir.toPath();
		try {
			Files.move(origen, destino, StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void moveTo(String ekis) {
		switch(ekis) {
		case "cd":
			 System.setProperty("user.dir", home);
				break;
			case " ":
				System.out.println(home);
				System.setProperty("user.dir", home);
				break;
			case ".":
				break;
			case "..":
				if (System.getProperty("user.dir") == "/"){                
					break;
				} else {
					File currentDir = new File(System.getProperty("user.dir"));
					System.setProperty("user.dir", currentDir.getParent());
				}
				break;
			default:
				File dir = new File(System.getProperty("user.dir") + separador + ekis);
				Boolean bool = dir.isDirectory();
				Boolean bool2 = dir.isFile();
				String dir2 = dir.toString();
				if (bool){
					System.setProperty("user.dir", dir2);
				} else if(bool2) {
					System.out.println("El nombre del directorio no es valido");
				} else {
					System.out.println("El sistema no puede encontrar la ruta especificada");
				}
		}
}

	public void merce() {
		File file = new File(System.getProperty("user.dir"));
		String[] lista = file.list();
		for(String files:lista)
			System.out.println(files);
	}

	public void forge(String folder) {
		
	}

	public void newFolder(String folder) {
		File newFol = new File(System.getProperty("user.dir" + separador + folder));
		boolean bool = newFol.exists();
		if(!bool) 
			newFol.mkdir();
		else
			System.out.println("Ya existe el subdirectorio o el archivo" + folder);
	}

	public void eliminate(String folder) {

	}

}
