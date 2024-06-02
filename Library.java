import java.io.*;
import java.util.*;
public class Library 
{
    private static String[][] book;
    int bno = 3;

    public static void main(String args[])
    {
    book = new String[10][3];
    book[0] = new String[]{"1", "Clean Code", "Robert C. Martin"};
    book[1] = new String[]{"2", "Introduction to Algorithms", "Thomas H. Cormen"};
    book[2] = new String[]{"3", "Thinking in Java", "Bruce Eckel"};
    home();
    }
    public static void home()
    {
      System.out.println("***************************");
      System.out.println("LIBRARY MANAGEMENT SYSTEM");
      System.out.println("***************************");
      System.out.println("1. USER\n2. EMPLOYEE\n3. EXIT");
      System.out.println("ENTER YOUR MODE:");
      Scanner sc = new Scanner(System.in);
      int mode = sc.nextInt();
      switch(mode)
      {
        case 1 :
        new Library().user();
        break;
        case 2 :
        new Library().employee();
        break;
        case 3 :
        System.out.println("THANKYOU FOR VISITING!");
        return;
        default : System.out.println("INVALID MODE!");
      }
    }
    public  void user()
    {
        System.out.println("***************************");
        System.out.println("\t   USER MODE");
        System.out.println("***************************");
        System.out.println("WHAT DO YOU WANT TO DO? \n1. SEARCH A BOOK \n2. ISSUE A BOOK\n3. RETURN A BOOK\n4. GO BACK ");
        System.out.println("ENTER YOUR ACTIVITY:");
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();
        switch(mode)
        {
          case 1 :
          search();
          break;
          case 2 :
          get();
          break;
          case 3 :
          returnb();
          break;
          case 4:
          home();
          break;
          default : System.out.println("INVALID MODE!");
  
        }
    }
    public  void search()
    {
        System.out.println("***************************");
        System.out.println("\tSEARCH A BOOK");
        System.out.println("***************************");
        System.out.println("ENTER THE BOOK NAME:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("RESULT :");
        System.out.println(name);
        int f=0;
        for (int i = 0; i < book.length; i++) 
        {
            if (book[i] != null && book[i][1] != null && book[i][1].trim().equalsIgnoreCase(name)) //trim() is used to remove extra white space
            { 
                System.out.println("BOOK  FOUNT!");
                System.out.println("ID: " + book[i][0]);
                System.out.println("Book Name: " + book[i][1]);
                System.out.println("Author: " + book[i][2]);
                f=1;
                break;
            }
        }
        if(f==0)
        {
            System.out.println("BOOK NOT FOUNT!");
        }
        
        System.out.println("ENTER 0 (EXIT) OR 1 (TO GO BACK):");
        int m = sc.nextInt();
        switch(m)
        {
            case 0:
            return;
            case 1:
            user();
            break;
            default: System.out.println("invaid operation");
        }
    }
    public  void get()
    {
        System.out.println("***************************");
        System.out.println("\tISSUE A BOOK");
        System.out.println("***************************");
        System.out.println("ENTER THE BOOK NAME:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int f=0;
        for (int i = 0; i < book.length; i++) 
        {
            if (book[i] != null && book[i][1] != null && book[i][1].trim().equalsIgnoreCase(name)) //trim() is used to remove extra white space
            { 
                System.out.println("ID: " + book[i][0]);
                System.out.println("Book Name: " + book[i][1]);
                System.out.println("Author: " + book[i][2]);
                f=1;
                break;
            }
        }
        if(f==0)
        {
            System.out.println("BOOK NOT FOUNT!");
        }
        if(f==1)
        {
            System.out.println("CONFIRM THIS BOOK? (yes/no):");
            String n = sc.nextLine();
            if(n.equalsIgnoreCase("yes")) 
            {
                System.out.println("BOOK ISSUED SUCCESSFULLY!");

            }
            System.out.println("ENTER 0 (EXIT) OR 1 (TO GO BACK):");
            int m = sc.nextInt();
            switch(m)
            {
                case 0:
                return;
                case 1:
                user();
                break;
                default: System.out.println("invaid operation");
            }
        }

    }
    public  void returnb()
    {
        System.out.println("***************************");
        System.out.println("\tRETURN A BOOK");
        System.out.println("***************************");
        System.out.println("ENTER USER ID:");
        Scanner sc = new Scanner(System.in);
        int u = sc.nextInt();
        System.out.println("ENTER BOOK ID:");
        int b = sc.nextInt();
        System.out.println("BOOK RETURNED SUCCESSFULLY!");
        System.out.println("ENTER 0 (EXIT) OR 1 (TO GO BACK):");
        int m = sc.nextInt();
        switch(m)
        {
            case 0:
            return;
            case 1:
            user();
            break;
            default: System.out.println("invaid operation");
        }

    }
    public  void employee()
    {
        System.out.println("***************************");
        System.out.println("\t   EMPLOYEE MODE");
        System.out.println("***************************");
        System.out.println("WHAT DO YOU WANT TO DO? \n1. ADD A NEW BOOK \n2. VIEW ALL BOOK\n3. GO BACK ");
        System.out.println("ENTER YOUR ACTIVITY:");
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();
        switch(mode)
        {
          case 1 :
          addnew();
          break;
          case 2 :
          viewall();
          break;
          case 3 :
          home();
          break;
          default : System.out.println("INVALID MODE!");
  
        }
    }
    public void addnew()
    {
        System.out.println("***************************");
        System.out.println("\tADD A NEW BOOK");
        System.out.println("***************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER BOOK NAME:");
        String name = sc.nextLine();
        System.out.println("ENTER AUTHOR NAME:");
        String aut = sc.nextLine();
        System.out.println("ENTER BOOK ID:");
        String bid = sc.nextLine();
        book[bno] = new String[]{bid, name, aut};
        System.out.println("BOOK ADDED SUCCESSFULLY!");
        bno++;
        System.out.println("ENTER 0 (EXIT) OR 1 (TO GO BACK):");
        int m = sc.nextInt();
        switch(m)
        {
            case 0:
            return;
            case 1:
            employee();
            break;
            default: System.out.println("invaid operation");
        }

    }
    public void viewall()
    {
        System.out.println("***************************");
        System.out.println("\tALL BOOK");
        System.out.println("***************************");
        for(int i=0; i<bno; i++)
        {
            System.out.println("BOOK ID : "+book[i][0]+
            "\nBOOK NAME : "+book[i][1]+"\nBOOK AUTHOR : "+book[i][2]);
            System.out.println("------------------------------------------------");
        }
        System.out.println("ENTER 0 (EXIT) OR 1 (TO GO BACK):");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        switch(m)
        {
            case 0:
            return;
            case 1:
            employee();
            break;
            default: System.out.println("invaid operation");
        }
    }
    
}
