package a;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

public class sdf {
	public static void main(String[] args) {
		try{
			// Create file 
			FileWriter fstream = new FileWriter("/home/lifeix/temp/noteslog/notes.log",true);
			BufferedWriter out = new BufferedWriter(fstream);
//			out.write("new content: =========================" + new Date() );
			//Close the output stream
			out.close();
			String NL = System.getProperty("line.separator");
			System.out.println(NL);
			System.out.println(123);
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
