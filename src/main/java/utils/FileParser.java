package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;



public class FileParser {
	public boolean doesFileExist(String filePath){
		  
		try{
			  File file = new File(filePath);
	          FileReader fileReader = new FileReader(file);
	          BufferedReader reader = new BufferedReader(fileReader);
	          if(file.exists()) {
				  System.out.println("FILE EXIST");
				  return true;
			  }
		  }catch(FileNotFoundException  e){
			  System.out.println("FILE DOESN'T EXIST");
			  e.printStackTrace();
		  }
		  
		  return false;
	  }
	public void parseFile(String file) {
		  HashMap<String, List<String>> dictionary = new HashMap<String, List<String>>();
	      List<String> meanings ;
	      BufferedReader reader;
		  try {
			  reader = new BufferedReader(new FileReader(file));
			  String currentLine = reader.readLine();
		      while (currentLine != null) {
		          System.out.println(currentLine);
		          String str[] = currentLine.split("–");
		          String word = str[0].trim();
		          StringTokenizer st = new StringTokenizer(str[1],","); 
		          meanings = new ArrayList<String>();
		          while(st.hasMoreTokens()) {
		        	  meanings.add(st.nextToken().trim());
		          }
		          dictionary.put(word, meanings);
		          currentLine = reader.readLine();
		      }
		      for(String word : dictionary.keySet()) {
		    	  System.out.println(word);
		    	  for(String m : dictionary.get(word)) {
		    		  System.out.println(m);
		    	  }
		      }
		      reader.close();
		  }catch (IOException e) {

		  }
	  }
}
