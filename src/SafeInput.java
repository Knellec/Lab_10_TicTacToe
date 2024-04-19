import java.util.Scanner;
public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        String trash = "";

        System.out.print("\n" + prompt + ": "); // show prompt add space

        while(pipe.hasNextInt() == false)
        {

            trash = pipe.nextLine();
            System.out.print(trash + " is not a valid input.\n");
            System.out.print("\n" + prompt + ": "); // show prompt add space

        }

        retInt = pipe.nextInt();
        pipe.nextLine(); // clear buffer

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        String trash = "";

        System.out.print("\n" + prompt + ": "); // show prompt add space

        while(pipe.hasNextDouble() == false)
        {
            trash = pipe.nextLine();
            System.out.print(trash + " is not a valid input.\n");
            System.out.print("\n" + prompt + ": "); // show prompt add space
        }
        retDouble = pipe.nextDouble();
        pipe.nextLine(); // clear buffer

        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        String trash = "";
        boolean loop = true;

        do
        {
            // verify that input is an integer
            System.out.print("\n" + prompt + ": "); // show prompt add space
            while(pipe.hasNextInt() == false)
            {

                trash = pipe.nextLine();
                System.out.print(trash + " is not a valid input.\n");
                System.out.print("\n" + prompt + ": "); // show prompt add space
            }
            retInt = pipe.nextInt();
            pipe.nextLine(); // clear buffer

            // verify that input is within range
            if (retInt >= low && retInt <= high)
            {
                loop = false;
            }
            else
            {
                System.out.println(retInt + " is not with in the range.");
                loop = true;
            }
        }
        while(loop == true);

        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble = 0;
        String trash = "";
        boolean loop = true;

        do
        {
            // verify that input is a double
            System.out.print("\n" + prompt + ": "); // show prompt add space
            while(pipe.hasNextDouble() == false)
            {
                trash = pipe.nextLine();
                System.out.print(trash + " is not a valid input.\n");
                System.out.print("\n" + prompt + ": "); // show prompt add space
            }
            retDouble = pipe.nextDouble();
            pipe.nextLine(); // clear buffer

            // verify that input is within range
            if (retDouble >= low && retDouble <= high)
            {
                loop = false;
            }
            else
            {
                System.out.println(retDouble + " is not with in the range.");
                loop = true;
            }
        }
        while(loop == true);

        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retBool = false;
        boolean loop = true;
        String YN = "";

        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            YN = pipe.nextLine();

            if (YN.equalsIgnoreCase("Y") || YN.equalsIgnoreCase("N"))
            {
                loop = false;
            }
            else
            {
                System.out.print(YN + " is not a valid input.\n");
                loop = true;
            }
        }
        while(loop == true);

        if (YN.equalsIgnoreCase("Y"))
        {
            retBool = true;
        }
        else
        {
            retBool = false;
        }

        return retBool;
    }

   public static String getRegExString(Scanner pipe, String prompt, String regEx)
   {
       String retString = "";
       String trash = "";
       boolean loop = true;

       do
       {
           System.out.print("\n" + prompt + ": "); // show prompt add space
           retString = pipe.nextLine();

           if (retString.matches(regEx))
           {
               loop = false;
           }
           else
           {
               loop = true;
               System.out.println(retString + " does not match the pattern.\n");
           }

       }while(loop == true);


       return retString;
   }

}