package sortingalgorithmsimulator;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.JOptionPane;

class ReadThread1 extends ClassLoader implements Runnable {

    private Thread thread1;
    private DataInputStream in;
    boolean receive=true;
    String sortName;
    public ReadThread1(DataInputStream in,String sortName) {
        this.sortName=sortName;
        this.in=in;
        this.thread1 = new Thread(this);
        thread1.start();
    }
    
    public void findClass(byte [][] classData,String []classNames) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
       
        
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Class res=null;
                Class resinner=null;
                Class resinner1=null;
                Class resinner2=null;
                
                int length=classNames.length;
                switch (length) {
                    case 1:
                        res = defineClass(classData[0], 0, classData[0].length);
                        break;
                    case 2:
                        res = defineClass( classData[0], 0, classData[0].length);
                        resinner = defineClass(classData[1], 0, classData[1].length);
                        break;
                    case 3:
                        res = defineClass( classData[0], 0, classData[0].length);
                        resinner = defineClass( classData[1], 0, classData[1].length);
                        resinner1 = defineClass(classData[2], 0, classData[2].length);
                        break;
                    case 4:
                        res = defineClass( classData[0], 0, classData[0].length);
                        resinner = defineClass(classData[1], 0, classData[1].length);
                        resinner1 = defineClass(classData[2], 0, classData[2].length);
                        resinner2 = defineClass(classData[3], 0, classData[3].length);
                        break;
                    default:
                        break;
                }
                try {
                    res.getMethod("start").invoke(res.newInstance());
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
                }
                
            }

        
        });
    }
   
    public void createfile(byte[][] classdata, String[] classNames) throws FileNotFoundException, IOException {
        for (int i = 0; i < classNames.length; i++) {
            String filename = classNames[i]+"_Data"+".txt";///
            File file=new File(filename);
            FileOutputStream fi = new FileOutputStream(file);
            fi.write(classdata[i], 0, classdata[i].length);
            fi.close();
        }
    }

    @Override
    public void run() {
        try {
            
            while (receive) {
                int len=in.readInt();
                byte [] data_name = new byte[len];
                in.read(data_name, 0, len);
                String names=new String(data_name,"UTF-8");
                String [] className=names.split(" ");
                int classnumbers = className.length;
                byte[][] totalldata =new byte[classnumbers][];
                for (int i = 0; i < className.length; i++) {
                    int length = in.readInt();
                    totalldata [i] = new byte[length];
                    in.readFully(totalldata[i], 0, length);
                }
                if(len==0){
                    JOptionPane.showMessageDialog(null, "Data is Unavailable.Try Later");
                } else {
                    String trim = sortName.trim();
                    String newtrim = trim + "_Information";
                    String filename =  newtrim + ".txt";////
                    File f = new File(filename);
                    if (f.createNewFile()) {
                        FileWriter filereader = new FileWriter(f);
                        BufferedWriter buffer = new BufferedWriter(filereader);
                        buffer.write(names);
                        buffer.close();

                        createfile(totalldata, className);
                    }

                    findClass(totalldata, className);
                }
                receive = false;
            }
        } catch (IOException e) {
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
            Logger.getLogger(ReadThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            in.close();
        } catch (IOException ex) {
            System.out.println("Interrupted");
        }
    }
    
    
}

class SimpleClassLoader1 extends ClassLoader{
    private Hashtable classes = new Hashtable();

    public SimpleClassLoader1() {
    }
    byte getClassImplFromDataBase(String className)[] {
    	System.out.println("        >>>>>> Fetching the implementation of "+className);
    	byte result[];
    	try {
    	    String filename=className+"_Data.txt";
            FileInputStream fi = new FileInputStream(filename);
    	    result = new byte[fi.available()];
    	    fi.read(result);
    	    return result;
    	} catch (Exception e) {
            e.printStackTrace();
    	    return null;
    	}
    }
    
    public void findClass(byte[] [] classData,int length){
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Class res=null;
                Class resinner=null;
                Class resinner1=null;
                Class resinner2=null;
                switch (length) {
                    case 1:
                        res = defineClass(classData[0], 0, classData[0].length);
                        break;
                    case 2:
                        res = defineClass( classData[0], 0, classData[0].length);
                        resinner = defineClass(classData[1], 0, classData[1].length);
                        break;
                    case 3:
                        res = defineClass( classData[0], 0, classData[0].length);
                        resinner = defineClass( classData[1], 0, classData[1].length);
                        resinner1 = defineClass(classData[2], 0, classData[2].length);
                        break;
                    case 4:
                        res = defineClass( classData[0], 0, classData[0].length);
                        resinner = defineClass(classData[1], 0, classData[1].length);
                        resinner1 = defineClass(classData[2], 0, classData[2].length);
                        resinner2 = defineClass(classData[3], 0, classData[3].length);
                        break;
                    default:
                        break;
                }
                try {
                    res.getMethod("start").invoke(res.newInstance());
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
                    Logger.getLogger(SimpleClassLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}


class WriteThread1 implements Runnable {
    
    private Thread thr;
    DataOutputStream out;
    private boolean sendMessage=true;
    String sortName;
    public WriteThread1(DataOutputStream out,String sortName) {
        this.sortName=sortName;
        this.out=out;
        this.thr = new Thread(this);
        thr.start();
    }
    @Override
    public void run() {
        try {
            while (true) {
                if(sendMessage){
                    out.write(sortName.getBytes());
                    sendMessage=false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        try {
            out.close();
        } catch (IOException ex) {
            System.out.println("Interrupted");
        }
    }
}

public class Client {
    String sortName;
    String serveraddress;
    Client(String sortName,String serveraddress){
        this.sortName=sortName;
        this.serveraddress=serveraddress;
    }
    public void start() {
        try {
            
                String trim = sortName.trim();
                String newtrim=trim+"_Information";
                String filename = newtrim+".txt";///
                File f = new File(filename);
                if((f.exists())){
                    FileReader filereader = new FileReader(f);
                    BufferedReader buffer = new BufferedReader(filereader);
                    String names=buffer.readLine();
                    String [] classnames=names.split(" ");
                    int length=classnames.length;
                 
                    byte[][] totalldata = new byte[length][];
                    SimpleClassLoader1 ob=new SimpleClassLoader1 ();
                    for (int i = 0; i <length; i++) {
                        totalldata[i] =ob.getClassImplFromDataBase(classnames[i]);
                    }
                    buffer.close();
                    ob.findClass(totalldata, length);
                    System.out.println("Data Exist");
                } 
                else {
                    System.out.println("Data doesn't exist");
                    JOptionPane.showMessageDialog(null, "File does not exist.Load it from server.");
                    int serverPort = 33333;
                    Socket clientSock = new Socket(serveraddress, serverPort);
                    DataInputStream in = new DataInputStream(clientSock.getInputStream());
                    DataOutputStream out = new DataOutputStream(clientSock.getOutputStream());
                    ReadThread1 readThread = new ReadThread1(in, sortName);
                    WriteThread1 writeThread = new WriteThread1(out, sortName);
                }
        } catch (IOException | HeadlessException e) {
            System.out.println(e);
        }
    }
}
