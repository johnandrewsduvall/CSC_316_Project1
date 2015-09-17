/*
 * Author:     John Andrew S Duvall
 * Date:       date
 * Project:    project
 */
package Testing;

import java.util.Scanner;

public class TestGenerator {
    public static Scanner in, file;
    public static void main(String[] args)
    {
        in = new Scanner(System.in);
        
        System.out.print("What percentage of packs to drop? Enter a value from 0[no dropped packets] to 1.0 [all packets lost]:\t");
    }
    
    /**
     *
     * @param message
     * @param dropFactor
     * @return
     */
    
}
class Message
{
    private int id ,length;
    private String[] message;
    public Message(int id, int length,String[] message )
    {
        this.id = id;
        this.length = length;
        this.message = message;
    }
    
    public static Message createMessage(String filename, Scanner in)
    {
        System.out.print("How many words?:\t");
        int length = in.nextInt();
        in.nextLine();
        String[] message  = new String[length];
        Scanner file = new Scanner(filename);
        for(int i = 0; i < length; i++)
        {
            message[i] = file.next();
        }
        
    
     
        return null;
    }
}
