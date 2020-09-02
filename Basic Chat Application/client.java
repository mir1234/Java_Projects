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
public class client {

    public static void main(String args[])
    {
    	try
    	{
	    	
	    	Socket s=new Socket("localhost",6000);
	    	System.out.println("Server Accepted"); 
	    	DataInputStream in=new DataInputStream(s.getInputStream());
	    	DataOutputStream out=new DataOutputStream(s.getOutputStream());
	    	
	    	String str=(String)in.readUTF();
	    	System.out.println(str);
	    	s.close();
    	
    	}catch(Exception e)
    	{
    		System.out.println("Unable to connect");
    	}    	
    	
    }
    
    
}
*/
//Using Multithreading
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


public class client{
	
	Socket s;
	DataInputStream in;
	DataOutputStream out;
	
	client()
	{
		try
		{
			s=new Socket("localhost",6000);
			System.out.println("Server connected");
			in=new DataInputStream(s.getInputStream());
			out=new DataOutputStream(s.getOutputStream());
		}catch(Exception e)
		{
			System.out.println("client error occurred");
		}
	}
	

    public static void main(String args[])
    {
    	System.out.println("System getting ready ...");
    	client ob = new client();
    	input i=new input(ob.in);
    	output o=new output(ob.out);
    	i.start();
    	o.start();
    	System.out.println("System ready\n-----------------------------");
    	
    }
}