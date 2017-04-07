package com.fiap.ws.exemplos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Arquivo {
	
	@WebMethod
	public void upload(String nome, byte[] imageBytes){
		String filePath = "/Users/danilopereira/Documents/" + nome;
		
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			BufferedOutputStream buffer = new BufferedOutputStream(fos);
			
			buffer.write(imageBytes);
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public byte[] download(String fileName){
		String filePath = "/Users/danilopereira/Documents/" + fileName;
		
		File file = new File(filePath);
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			BufferedInputStream buffer = new BufferedInputStream(inputStream);
			
			byte[] fileByte = new byte[(int) file.length()];
			buffer.read(fileByte);
			buffer.close();
			
			return fileByte;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
