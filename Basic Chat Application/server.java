/**
 * @(#)client.java
 *
 *
 * @author: MLR 
 * @version 1.00 2020/9/2
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
/*
//Basic Example
public class server {

    public static void main(String args[])
    {
    	try
    	{
	    	
	    	ServerSocket s=new ServerSocket(6000);
	    	Socket ss=s.accept();
	    	System.out.println("Client Connected"); 
	    	DataOutputStream out=new DataOutputStream(ss.getOutputStream());
	    	DataInputStream in=new DataInputStream(s.getInputStream());
	    	
	    	out.writeUTF("Hello");
	    	out.flush();
	    	ss.close();
	    	s.close();
    	
    	}catch(Exception e)
    	{
    		System.out.println("Unable to connect");
    	}    	
    	
    }
    
    
}
*/ 

//Using multithreading
class input extends Thread{
	DataInputStream in;
	input(DataInputStream in)
	{
		this.in=in;
	}
	public void run()
	{
		try
		{
			while(true)
			{
				String str=(String)in.readUTF();
				System.out.println("Message Received: "+str);
				Thread.sleep(500);
			}	
		}catch(Exception e)
		{
			System.out.println("Data Reading Exception Occured");
		}
	}
}
class output extends Thread{
	DataOutputStream out;
	Scanner ob=new Scanner(System.in);
	output(DataOutputStream out)
	{
		this.out=out;
	}
	public void run()
	{
		try
		{
			while(true)
			{
				String str=ob.nextLine();
				if(str!="")
					out.writeUTF(str);
				out.flush();
				Thread.sleep(500);
			}	
		}catch(Exception e)
		{
			System.out.println("Data Writing Exception Occured");
		}
	}
}


public class server {
	
	ServerSocket ss;
	Socket s;
	DataInputStream in;
	DataOutputStream out;
	
	server()
	{
		try
		{
			ss=new ServerSocket(6000);
			s=ss.accept();
			System.out.println("One client connected");
			in=new DataInputStream(s.getInputStream());
			out=new DataOutputStream(s.getOutputStream());
		}catch(Exception e)
		{
			System.out.println("server error occurred");
		}
	}
	

    public static void main(String args[])
    {
    	System.out.println("System getting ready ...");
    	server ob = new server();
    	input i=new input(ob.in);
    	output o=new output(ob.out);
    	i.start();
    	o.start();
    	System.out.println("System ready\n---------------------");
    }
}