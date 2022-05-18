package org.marianaduarte.singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBCSingletonDemo {
    static int count=1;
    static int op;

    public static void main(String[] args) throws IOException {
        JDBCSingleton jdbc = JDBCSingleton.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("DATABASE OPERATIONS");
            System.out.println(" --------------------- ");
            System.out.println(" 1. Insertion ");
            System.out.println(" 2. View      ");
            System.out.println(" 3. Delete    ");
            System.out.println(" 4. Update    ");
            System.out.println(" 5. Exit      ");
            System.out.println("\n");
            op = Integer.parseInt(br.readLine());

            switch (op){
                case 1:{
                    System.out.print("Enter the username you want to insert data into the database: ");
                    String username=br.readLine();
                    System.out.print("Enter the password you want to insert data into the database: ");
                    String password=br.readLine();

                    try {
                        int i = jdbc.insert(username,password);
                        if(i>0){
                            System.out.println((count++) + " Data has been inserted successfully");
                        }else{
                            System.out.println("Data has not been inserted ");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();}
                break;

                case 2:{
                    System.out.print("Enter the username : ");
                    String username=br.readLine();

                    try  {
                        jdbc.viewData(username);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                break;

                case 3:{
                    System.out.print("Enter the userid,  you want to delete: ");
                    int userid=Integer.parseInt(br.readLine());

                    try {
                        int i= jdbc.delete(userid);
                        if (i>0) {
                            System.out.println((count++) + " Data has been deleted successfully");
                        }else{
                            System.out.println("Data has not been deleted");
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                break;

                case 4:{
                    System.out.print("Enter the username,  you want to update: ");
                    String username=br.readLine();
                    System.out.print("Enter the new password ");
                    String password=br.readLine();

                    try {
                        int i= jdbc.update(username, password);
                        if (i>0) {
                            System.out.println((count++) + " Data has been updated successfully");
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                break;

                default:
                    return;
            }
        }while(op != 5);


    }

}

