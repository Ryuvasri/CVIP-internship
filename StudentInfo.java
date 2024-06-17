import java.io.Console;
import java.util.*;
import java.io.*;
public class StudentInfo 
{
    private static String[][] stu;
    private static int[][] aca;
    String use;
    int n=2,user;
    public static void main(String args[])
    {
        stu = new String[10][8];
        stu[0] = new String[]{"abi","abi123","ABI","111", "abi@gmail.com", "9909823458","6, a street, new city","7th"};
        stu[1] = new String[]{"jerry","jerry123","JERRY","112", "jerry@gmail.com", "9383568921","8, tn street, new city","10th"};
        aca = new int[10][5];
        aca[0] = new int[]{80,88,90,97,91};
        aca[1] = new int[]{90,98,97,87,89};
        StudentInfo si = new StudentInfo();
        si.login();
    }
    public  void login()
    {
        Scanner sc = new Scanner(System.in);
        Console console = System.console();
        System.out.println("================================");
        System.out.println("  STUDENT INFORMATION SYSTEM");
        System.out.println("================================");
        System.out.print("Please enter your username:");
        use = sc.nextLine();
        char[] passwordArray = console.readPassword("Enter your password: *masked*");
        System.out.print("enter 1 to login:");
        int h = sc.nextInt();
        if(h==1)
        {
            int logIn = 0;
            String pass = new String(passwordArray);
            for (int i = 0; i < stu.length; i++) {
                if (stu[i] != null && stu[i][0].equals(use) && stu[i][1].equals(pass)) {
                    logIn = 1;
                    user = i;
                    break;
                }
            }
            if (logIn==1) 
            {
                home( user);
            } 
            else 
            {
                System.out.println("Invalid username or password.");
            }
        }
    }
    public  void home(int user)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("  STUDENT INFORMATION SYSTEM");
        System.out.println("              HOME ");
        System.out.println("================================");
        System.out.println("1. VIEW PROFIL\n2. VIEW ACADEMIC RECORD\n3. MANAGE PASSWORD\n4. LOGOUT");
        System.out.print("ENTER : ");
        int c = sc.nextInt();
        switch(c)
        {
            case 1:
                profil( user);
                break;
            case 2:
                accademic( user);
                break;
            case 3:
                settings( user);
                break;
            case 4:
                System.out.println("THANKYOU FOR VISITING!");
                return;
            default:
                System.out.println("INVALID INPUT!");
        }
    }
    public  void profil(int user)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("  STUDENT INFORMATION SYSTEM");
        System.out.println("              PROFIL ");
        System.out.println("================================");
        if(use.equals(stu[user][0]))
        {
            System.out.println("NAME : "+stu[user][2]+"\nSTUDENT ID: "+stu[user][3]+"STANDARD : "+stu[user][7]+"\nEMAIL : "+stu[user][4]+"\nPHONE NUMBER : "+stu[user][5]+"\nADDRESS : "+stu[user][6]);
        }
        System.out.println("ENTER :(1 - to go back/2 - to logout)");
        int c = sc.nextInt();
        switch(c)
        {
            case 1:
            home( user);
            break;
            case 2:
            System.out.println("THANKYOU FOR VISITING!");
            return;
            default:
            System.out.println("INVALID INPUT!");    
        }

    }
    public  void accademic(int user)
    {
        System.out.println("================================");
        System.out.println("  STUDENT INFORMATION SYSTEM");
        System.out.println("        ACADEMIC RECORD ");
        System.out.println("================================");
        Scanner sc = new Scanner(System.in);
        String[] sub = {"ENGLISH","LANGUAGE","MATH","SCIENCE","SOCIAL"} ;
        System.out.println("GRADE SPLITUP:\nMARK >= 90 --> A\nMARK >= 80 -->B \nMARK >= 70 --> C \nMARK >= 60 --> D\nMARK >= 50 --> E \nMARK < 50 --> F \n");
        for(int i=0; i<5; i++)
        {
            char g;
            if (aca[user][i] >= 90) 
            {
             g = 'A';
            } 
            else if (aca[user][i]>= 80) 
            {
                g = 'B';
            } 
            else if (aca[user][i] >= 70) 
            {
                g = 'C';
            } 
            else if (aca[user][i] >= 60) 
            {
                g = 'D';
            } 
            else if (aca[user][i] >= 50) 
            {
                g = 'E';
            } 
            else 
            {
                g = 'F';
            }
            System.out.println("SUBJECT : "+sub[i]+"   MARKS : "+aca[user][i]+"   GRADE : "+g);
        }
        System.out.println("ENTER :(1 - to go back/2 - to logout)");
        int c = sc.nextInt();
        switch(c)
        {
            case 1:
            home( user);
            break;
            case 2:
            System.out.println("THANKYOU FOR VISITING!");
            return;
            default:
            System.out.println("INVALID INPUT!");

        }
    }
    public  void settings(int user)
    {
        System.out.println("================================");
        System.out.println("  STUDENT INFORMATION SYSTEM");
        System.out.println("        MANAGE PASSWORD ");
        System.out.println("================================");
        System.out.println("CHANGE PASSWORD:");
        System.out.println("enter current password:");
        Scanner sc = new Scanner(System.in);
        String cpass = sc.nextLine();
        Console console = System.console();
        if(cpass.equals(stu[user][1]))
        {
            char[] passwordArray = console.readPassword("enter new password:*new password wont be visible* ");
            String pass = new String(passwordArray);
            char[] passwordArray2 = console.readPassword("enter conform password:*new password wont be visible* ");
            String pass2 = new String(passwordArray2);
            if(pass.equals(pass2))
            {
                System.out.println("SUCCESSFULLY UPDATED!");
            }
            else
            {
                System.out.println("INCORRECT CONFIRM PASSWORD");
            }
        }
        else
        {
            System.out.println("INCORRECT PASSSWORD!");
        }
        System.out.println("ENTER :(1 - to go back/2 - to logout)");
        int c = sc.nextInt();
        switch(c)
        {
            case 1:
            home( user);
            break;
            case 2:
            System.out.println("THANKYOU FOR VISITING!");
            return;
            default:
            System.out.println("INVALID INPUT!");

        }
    }

}
