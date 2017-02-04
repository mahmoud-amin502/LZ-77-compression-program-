package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class compress {
	
	public void compress()throws FileNotFoundException, IOException{
	
	
	String input=null;
    try
    {
    FileInputStream file1=new FileInputStream("input.txt"); //takes the chars from my input file and puts it in a file system in java
    DataInputStream data1=new DataInputStream(file1); //this creates a datainputstream that uses the specified underlying InputStream.

    //BufferedWriter
    BufferedReader bufferreader=new BufferedReader(new InputStreamReader(data1)); //reads a stream of chars 

    input=bufferreader.readLine(); //read a string of chars
    
    System.out.println(input);
    
    // prints what is inside the file and stores it in a buffer reader.
    
    
    
    
//////////// compressing////////////
    FileOutputStream file2=new FileOutputStream("compress.txt");
    DataOutputStream data2=new DataOutputStream(file2);

    int pointer=0,len1=0;
    char nextchar='0';
    String width=null,x1=null;//x=null
    int c1,c2=0;
    
    
  

    for(int i=0;i<=input.length();i++)
    {
        width=input.substring(0,i);
        //System.out.println(w);
        int j=0;
        j=i+1;
       do{
           x1=input.substring(i,j);
           //System.out.println(y);
           c1=width.lastIndexOf(x1);
           //System.out.println(z);
           if(c1!=-1)
           {
               c2=c1;
                j++;

                if(j>input.length())
                {
                    i=input.length();
                    pointer=width.length()-c2;
                    len1=x1.length();// length of characters 
                    nextchar='0';
                    
                    
//                    String h="";
//                    h=String.valueOf(pointer)+String.valueOf(len1)+String.valueOf(nextchar);
//                    //h = new String (h.getBytes( "ISO-8859-1" ));
//                    data2.writeBytes(h);
                    
                    
                    data2.writeInt(pointer);
                    data2.writeInt(len1);
                    data2.writeChar(nextchar);
                    break;
                }
           }
           else
           {
               i=width.length()+(x1.length()-1);
               if(x1.length()==1)
               {
                   pointer=0;
                   len1=0;
               }
               else
               {
                   pointer=width.length()-c2;
                   len1=x1.length()-1;// length of characters copied

               }
               nextchar=x1.charAt(x1.length()-1);//next character
              
               
//               String h="";
//               h=String.valueOf(pointer)+String.valueOf(len1)+String.valueOf(nextchar);
//               data2.writeBytes(h);
               
               data2.writeInt(pointer);
               data2.writeInt(len1);
               data2.writeChar(nextchar);
               break;
           }
          }while(c1!=-1);
    }
   data2.close();
   data1.close();
    }
    catch (Exception ex){
    	
    }
	}
    
	

	
	
	

}
