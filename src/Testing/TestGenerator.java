/*
 * Author:     John Andrew S Duvall
 * Date:       date
 * Project:    project
 */
package Testing;

import java.util.Scanner;

public class TestGenerator {
    public static Scanner in;
    public static void main(String[] args)
    {
        in = new Scanner(System.in);
        MessageBuilder m1 =  MessageBuilder.createMessage("lorem.txt",in);
        System.out.print("What percentage of packs to drop? Enter a value from "
                + "0[no dropped packets] to 1.0 [all packets lost]:\t");
        
    }
    
}

class MessageBuilder
{
    private int id ,length;
    private String[] message;
    public MessageBuilder(int id, int length,String[] message )
    {
        this.id = id;
        this.length = length;
        this.message = message;
    }
    
    
    public static MessageBuilder createMessage(String filename, Scanner in)
    {
        
        String messages[]  = new String[50];
        Scanner file = new Scanner(filename);
        int i = 0;
        while(file.hasNextLine())
        {
            messages[i++] = file.nextLine();
        }
        
    
     
        return new MessageBuilder();
    }
}
