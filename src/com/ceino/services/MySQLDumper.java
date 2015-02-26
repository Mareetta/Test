package com.ceino.services;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDumper {
	
public static void main(String[] args) throws IOException {
	


		String dbName = "test1";
		String dbUser = "admin";
		String dbPass = "admin123";
	     String path="E:\\Development\\mysql-5.6.23-winx64\\bin";
		try {
			String executeCmd = path + "\\mysqldump -u " + dbUser + " -p" + dbPass + " " + dbName + " -r" + path + "\\test.sql";

			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if (processComplete == 0) {
				System.out.println("Backup taken successfully");
			} else {
				System.out.println("Could not take mysql backup");
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(MySQLDumper.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
	
		
	


/*private static String ip="localhost";
private static String port="3306";
private static String database="test1";
private static String user="admin";
private static String pass="admin123";
private static String path="E:/Development/mysql-5.6.23-winx64/bin/";

public static void export(){
String dumpCommand = path+"mysqldump " + database + " -h " + ip + " -u " + user +" -p" + pass  + "test.sql";
Runtime rt = Runtime.getRuntime();
File test=new File(path);
PrintStream ps;

try{
Process child = rt.exec(dumpCommand);
ps=new PrintStream(test);
InputStream in = child.getInputStream();
int ch;
while ((ch = in.read()) != -1) {
ps.write(ch);
System.out.write(ch); //to view it by console
}

InputStream err = child.getErrorStream();
while ((ch = err.read()) != -1) {
System.out.write(ch);
}
}catch(Exception exc) {
exc.printStackTrace();
}
}

public static void main(String args[]){
export();
}
}*/