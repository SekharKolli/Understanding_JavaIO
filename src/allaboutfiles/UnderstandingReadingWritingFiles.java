/**
 * Helps us understand how to read and write to files 
 */

package allaboutfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingReadingWritingFiles {

	public static void main(String[] args) {

		UnderstandingReadingWritingFiles uRef = new UnderstandingReadingWritingFiles();

//		uRef.readFile();
//		uRef.readFileAgain();
//		uRef.writeFile();
		uRef.writeFileAgain();

	} // EOMain

	@SuppressWarnings("unused")
	private void writeFile() {
		File file = new File(
				"C:\\Users\\SekharMaster\\Documents\\MyJavaRefresh\\src\\allaboutfiles\\NewTextFile.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);

			fos.write("Alls awesome that ends awesome!".getBytes()); // Since we can write bytes only getting bytes of string
			fos.write("More goodies can get added...".getBytes());	// in append mode. Items added to end of file
			
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Unable to read file : " + e.getMessage());
		}
		
		System.out.println("File Written");
	}

	private void writeFileAgain() {
		File file = new File(
				"C:\\Users\\SekharMaster\\Documents\\MyJavaRefresh\\src\\allaboutfiles\\NewTextFile.txt");
		
		try {
			FileWriter writer = new FileWriter(file);

			writer.write("Here we can simply write to the file");
			writer.write("Previous content has been overwritten by this one!"); // Just checked, contents did not get overwritten - got to run to a class
			writer.append("To append info, use the append method");
			
			writer.close(); // always close resources
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Unable to read file : " + e.getMessage());
		}
		System.out.println("File Written");
	}

	private void readFile() {
		File file = new File(
				"C:\\Users\\SekharMaster\\Documents\\MyJavaRefresh\\src\\allaboutfiles\\SampleTextFile.txt");

		try {
			
			if (!(file.exists())) { // if file does not exist, show message and throw exception
				throw new FileNotFoundException(file.getName());
			}

			FileInputStream fis = new FileInputStream(file);

			int i=0;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}

			fis.close(); // Close the used resources

		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Unable to read file : " + e.getMessage());
		}
	}

	private void readFileAgain() {

		try {
			File file = new File(
					"C:\\Users\\SekharMaster\\Documents\\MyJavaRefresh\\src\\allaboutfiles\\SampleTextFile.txt");

			if (!(file.exists())) { // if file does not exist, show message and throw exception
				throw new FileNotFoundException(file.getName());
			}

			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			
			String s = "";
			
			while ((s=buffer.readLine()) != null) { // Efficient Way to read a file as opposed to each byte
				System.out.println(s);
			}

			buffer.close(); // closing buffer once done
			reader.close(); // always close the block
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Unable to read file : " + e.getMessage());
		}
	}// readFile

}// UnderstandingReadingWritingFiles
