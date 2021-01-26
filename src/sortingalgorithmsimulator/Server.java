package sortingalgorithmsimulator;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

 
class SimpleClassLoader {
    private Hashtable classes = new Hashtable();

    public SimpleClassLoader() {
    }
    byte getClassImplFromDataBase(String className)[] {
    	System.out.println("        >>>>>> Fetching the implementation of "+className);
    	byte result[];
    	try {
    	    //String filename="D:\\Rajib\\SortingAlgorithmSimulator\\build\\classes\\sortingalgorithmsimulator\\"+className+".class";
            String curdic=System.getProperty("user.dir");
            System.out.println(curdic);
            String filename=curdic+"\\build\\classes\\sortingalgorithmsimulator\\"+className+".class";
            //String filename=className+".class";
            FileInputStream fi = new FileInputStream(filename);
            result = new byte[fi.available()];
    	    fi.read(result);
    	    return result;
    	} catch (Exception e) {
            e.printStackTrace();
    	    return null;
    	}
    }
}
class echoServer implements Runnable{
    DataOutputStream out;
    DataInputStream in;
    private Thread t;
    String sortName; 
    boolean send=true;
    echoServer(DataInputStream in,DataOutputStream out){
        this.in=in;
        this.out=out;
        this.t=new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        try {
            while (send) {
                byte []message=new byte[14];
                in.read(message);
                sortName = new String(message, "UTF-8");
                String trim = sortName.trim();
                
//                if(trim.equals("Insertion_Sort")){
//                    out.writeInt(0);
//                    out.write(0);
//                    out.writeInt(0);
//                    out.write(0);
//                }
//                else {
                    String curdic=System.getProperty("user.dir");
                    System.out.println(curdic);
                    String filename = curdic+"\\Files\\"+trim + ".txt";
                    File f = new File(filename);
                    FileReader filereader = new FileReader(f);
                    BufferedReader buffer = new BufferedReader(filereader);
                    String data = buffer.readLine();
                    buffer.close();
                    int len = data.length();
                    out.writeInt(len);
                    out.write(data.getBytes());
                    String[] className = data.split(" ");
                    int filedatalength = className.length;

                    SimpleClassLoader ob = new SimpleClassLoader();
                    for (int i = 0; i < filedatalength; i++) {
                        byte[] classData = ob.getClassImplFromDataBase(className[i]);
                        int length = classData.length;
                        out.writeInt(length);
                        out.write(classData, 0, classData.length);
                    }
                    System.out.println("Data send successfull");
              //  }
                send = false;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("null");
        }
        try {
            in.close();
        } catch (IOException ex) {
            System.out.println("Interrupted");
        }
    }
}

public class Server {

	private ServerSocket ServSock;
	
	Server() {
        try {
            ServSock = new ServerSocket(33333);
            while (true) {
                Socket clientSock = ServSock.accept();
                DataInputStream in = new DataInputStream(clientSock.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSock.getOutputStream());
                echoServer ob=new echoServer(in,out);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        Server objServer = new Server();
    }
}
