package com.ceino.services;

public class RestoreDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbName = "test1";
		String dbUser = "admin";
		String dbPass = "admin123";
	     String path="E:\\Development\\mysql-5.6.23-winx64\\bin";
	     String path1="E:\\Development\\mysql-5.6.23-winx64\\bin\\customers.sql";
	 try
	 {
    String executeCmd = path + "\\mysql -u " + dbUser + " -p" + dbPass + " " + dbName + " -e " +  path1;
    System.out.println("command : "+ executeCmd);
    Process runtimeProcess;
    

        runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();
        System.out.println(processComplete);
        if (processComplete == 0) {
            System.out.println("Backup restored successfully");
            
        } else {
            System.out.println("Could not restore the backup");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
}
