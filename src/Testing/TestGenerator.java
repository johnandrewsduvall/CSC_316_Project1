/*
 * Author:     John Andrew S Duvall
 * Date:       27 September 2015
 * Project:    CSC 316 Project 1
 */

package Testing;

import csc_316_project1.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestGenerator {
   
    
    public static void main(String[] args) throws Exception
    {
        String file;
        double dropFactor;
        ArrayList<MessageBuilder> messageList;
        Scanner in = new Scanner(System.in);
        Scanner fileReader = null;
        
        //For time savings;
        if(args.length == 0)
         {
                file = null;
                JFileChooser fc = new JFileChooser(".");
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnVal = fc.showOpenDialog(fc);
                if(returnVal== JFileChooser.APPROVE_OPTION)
                {
                    file = fc.getSelectedFile().getName();
                    fileReader = new Scanner(new File(file));
                }
                else if(file == null)
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No file selected", "No File Selected", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            }
        else
                   {
                     // Parse the input file
                     file = args[0];
                     fileReader = new Scanner(new File(file));
                     
                   }
        messageList = MessageBuilder.listBuilder(fileReader);
        
        System.out.print("What percentage of packs to drop? Enter a value from "
                + "0[no dropped packets] to 100 [all packets lost]:\t");
        dropFactor = Double.parseDouble(in.nextLine());
        messageList = packetDistorter(messageList,dropFactor);
        
        createTest(file, messageList);
        
        String[] newArgs = {"currentTest.txt","out.txt"};
        Receiver.main(newArgs);
        
        }
        
       public static ArrayList<MessageBuilder> packetDistorter(ArrayList<MessageBuilder> messageList, double dropFactor)
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
           MessageBuilder swap = messageList.get(i);
           messageList.remove(i);
           messageList.add((int)(Math.random()*messageList.size()), swap);
        }
        return messageList;
    }
       public static void createTest(String filename, ArrayList<MessageBuilder> messages) throws FileNotFoundException
    {
        PrintStream testWriter = new PrintStream(new File("currentTest.txt"));
        
        int i = 0;
        for(MessageBuilder packet: messages)
        {
           i++;
           testWriter.println(packet.toString());
        }
    }
}
class MessageBuilder
{
    public int messageNum, id;
    public String content;
    
    public MessageBuilder(int num,int i, String c)
            {
                messageNum = num;
                id = i;
                content = c;
            }
    @Override
    public String toString()
    {
        String s = "" + messageNum + " " + id + " " + content;
        return s;
    }
    
    public static ArrayList<MessageBuilder> listBuilder(Scanner file)
    {
        ArrayList<MessageBuilder> list = new ArrayList<>();
        int j = 0;
        while(file.hasNext())
        {
            String [] line = file.nextLine().split(" ");
            for(int i = 0; i < line.length ; i++)
            {
                list.add(new MessageBuilder(j,i,line[i]));               
            }
            j++;
        }
        return list;
    }
}