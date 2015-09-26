/*
 * Author:     John Andrew S Duvall
 * Date:       27 September 2015
 * Project:    CSC 316 Project 1
 */

package Testing;

import csc_316_project1.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestGenerator {
    public static Scanner in;
    
    public static void main(String[] args)
    {
        String file;
        double dropFactor;
        ArrayList<String> messageList = new ArrayList<>();
        
        //For time savings;
        file = args[0];
        
        in = new Scanner(file);
        while(in.hasNext())
        {
            messageList.add(in.nextLine());
        }
       
        System.out.print("What percentage of packs to drop? Enter a value from "
                + "0[no dropped packets] to 100 [all packets lost]:\t");
        dropFactor = in.nextDouble();
        messageList = packetDistorter(messageList,dropFactor);
        
        }
        
       public static ArrayList<String> packetDistorter(ArrayList<String> messageList, double dropFactor)
    {
        for(int i = 0; i < messageList.size(); i++)
        {
            if(Math.random()*100 < dropFactor)
            {
                messageList.remove(i);
                i--;
            }
        }
        for(int i = 0; i < messageList.size(); i++)
        {
            //do something
        }
        return messageList;
    }
}
    
    
    


class MessageBuilder
{

    public static Message createMessage(String filename, Scanner in)
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
