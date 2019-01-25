/**
 * Purpose : Learn how to read from a file. 
 */

package allaboutfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyReadFromFile {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\SekharMaster\\Documents\\MyJavaRefresh\\src\\allaboutfiles\\SampleTextFile.txt");

		FileInputStream finpstream = null;
		

			try {
				finpstream = new FileInputStream(file);
				
				int input;
				while ((input = finpstream.read()) != -1) {
					System.out.print((char) input);
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find the file. Ensure correctness of path");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Unable to find read from file. check if file is accessable");
				e.printStackTrace();
			} finally {
				try {
					finpstream.close();
				} catch (IOException e) {
					System.out.println("Unable to close the file");
					e.printStackTrace();
				}
			}

	}

}
