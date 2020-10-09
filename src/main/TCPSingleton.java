package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import model.Coordenada;
import model.Generic;
import model.User;

public class TCPSingleton extends Thread{


    private static TCPSingleton unico;

    public static TCPSingleton getInstance(){
         if(unico == null){
             unico = new TCPSingleton();
             unico.start();
         }
         return unico;
    }

    private TCPSingleton(){}

    
    private Main observer;
    
    public void setObserver(Main observer) {
    	this.observer = observer;
    }
    
    public Main getObserver() {
    	return observer;
    }
    
    

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public void run(){
        try { 
        
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Perate");
		socket = server.accept();
		System.out.println("Listo mi rey");

		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		reader = new BufferedReader(isr);

		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		writer = new BufferedWriter(osw);

		while (true) {
			System.out.println("perate pue..");
			String line = reader.readLine();
			System.out.println("Recibido...");
			System.out.println("Recibido:" + line);

			Gson gson = new Gson();
			//Generic generic = gson.fromJson(line, Generic.class);
			
	
			
		if(line.contains("User")) {
			User name = gson.fromJson(line, User.class);
			String getName = name.getId();
			observer.setName(getName);
			}
	
			
		if(line.contains("Coordenada")) {
			Coordenada coordenada = gson.fromJson(line, Coordenada.class);
			int posx=coordenada.getX();
			int posy=coordenada.getY();
			observer.setCoord(posx,posy);
			
	
			}
		}
			
			
			
			
			

		

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
        
        
    	public void sendMessage(String msg) {
    		new Thread(() -> {
    			try {

    				writer.write(msg + "\n");
    				writer.flush();

    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}).start();
    	}
    }