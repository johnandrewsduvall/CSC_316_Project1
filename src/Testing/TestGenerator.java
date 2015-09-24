/*
 * Author:     John Andrew S Duvall
 * Date:       date
 * Project:    project
 */
/**
package Testing;

import csc_316_project1.*;
import java.util.Scanner;

public class TestGenerator {
    public static Scanner in;
    public static void main(String[] args)
    {
        in = new Scanner(System.in);
        Message m1 =  MessageBuilder.createMessage("lorem.txt",in);
        System.out.print("What percentage of packs to drop? Enter a value from "
                + "0[no dropped packets] to 1.0 [all packets lost]:\t");
        
    }
    
}

class MessageBuilder
{

    
    
    public static MessageBuilder createMessage(String filename, Scanner in)
    {
        
        String messages[]  = new String[50];
        Scanner file = new Scanner(filename);
        int i = 0;
        while(file.hasNextLine())
        {
            messages[i++] = file.nextLine();
        }
        
    
     
        return new Message();
    }
}
*/