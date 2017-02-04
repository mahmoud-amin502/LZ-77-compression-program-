package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class decompress {
	public void decompress()throws FileNotFoundException, IOException {


//		int point4=0,len4=0;
//	    char ch = 0;
//	    
//		 String input2=null;
//		 
//		 FileInputStream file5=new FileInputStream("varinput.txt");
//		 DataInputStream data5=new DataInputStream(file5);
//		 BufferedReader bufferreader3=new BufferedReader(new InputStreamReader(data5));
//		 input2=bufferreader3.readLine();
//		 
//		 FileOutputStream file4=new FileOutputStream("compress2.txt");
//		 DataOutputStream data4=new DataOutputStream(file4);
//		 
//		 
//		 int i=0;
//		 int j=i+1;
//		 while(i<=input2.length()+1){
//			 point4=Character.getNumericValue(input2.charAt(i));
//			 data4.write(point4);
//			 len4=Character.getNumericValue(input2.charAt(i++));
//			 data4.write(len4);
//			 ch=input2.charAt(j);
//			 data4.writeChar(ch);
//			 i++;
//			 
//		 }
		 
		 
		 
		 
		 
		    FileInputStream file3=new FileInputStream("compress.txt");
		    DataInputStream data3=new DataInputStream(file3);
		    BufferedReader bufferreader2=new BufferedReader(new InputStreamReader(data3));
		    
		    
		    
		    
		    
		    
		    //input2=bufferreader2.readLine();
		  
		  //System.out.println(input2);
		  
		  FileOutputStream fileoutputstream=new FileOutputStream("decompress.txt");
		  DataOutputStream dataoutputstream=new DataOutputStream(fileoutputstream);
		  
		  
		  
		  
		  

		  int point=0,len2=0;
		  //char b1,b2;
		  //int i=0;
		  char charr;
		  String decomp = "";
		  
		  
		  
		  while(file3.available()!=0) //  i<=input2.length()+1
		  {
		     // b1=(data3.read(input2.charAt(i)));//pointer
		     //point=Character.getNumericValue(input2.charAt(i)) ;
			  
			  
			  point=data3.readInt();
		      System.out.printf("<%d ",point);
		      
		      //b2=(char) (data3.readByte());//length
		      //len=Character.getNumericValue(input2.charAt(i++));
		      
		      len2=data3.readInt();
		      System.out.printf("%d ",len2);
		      
		      
		      //charr=input2.charAt(i=i+1);
		      
		      charr=data3.readChar();
		      System.out.printf("%s>",charr);
		      System.out.println();
		      
		      
		      if(point==0)
		    	  decomp+=charr;
		     
		      else
		      {
		          if(charr!='0')
		          decomp+=(decomp.substring((decomp.length()-point),((decomp.length()-point)+len2))+charr);
		          else
		              decomp+=(decomp.substring((decomp.length()-point),((decomp.length()-point)+len2)));
		      }
		      //i++;
		      
		  }
		  dataoutputstream.writeChars(decomp);
		  System.out.println(decomp);

		  bufferreader2.close();
		  dataoutputstream.close();
		  
		
		
	
	}
	
	
	
}



