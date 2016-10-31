package org.wecancodeit.week3.bard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ShakespeareReadingApp {

	/**
	 * This is how we create a constant in Java.
	 * 
	 * TODO Replace this with the location of the Yorick.txt file in the
	 * src/main/resources folder of your local computer.
	 */
	public static String SHAKESPEARE_FILEPATH = "C:\\Users\\WeCanCodeIT\\java-cbus-reading-the-bard\\src\\main\\resources\\Yorick.txt";

	/**
	 * TODO load the file at SHAKESPEARE_FILEPATH via a {@link BufferedReader}
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		readAndWriteToSystemOut();
		writeFileStrippingPunctuation();
		tryToReadAFileThatDoesntExist();
		writeFileReplacingPunctuationWithLinebreaks();
	}

	/**
	 * <p>
	 * TODO load the file at SHAKESPEARE_FILEPATH via a {@link BufferedReader}
	 * </p>
	 * 
	 * <p>
	 * TODO read each line of text, then write each line to System.out
	 * </p>
	 * 
	 * *
	 * <p>
	 * TODO Close the {@link BufferedReader} you use in a finally block (call
	 * {@link BufferedReader#close()}).
	 * <p>
	 */
	private static void readAndWriteToSystemOut() throws IOException {
		// copied from stackoverflow

		BufferedReader br = new BufferedReader(new FileReader(
				SHAKESPEARE_FILEPATH));
		try {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			System.err.println("FINALLY BLOCK");
		}

	}

	/**
	 * <p>
	 * TODO read the input file and write a new file
	 * </p>
	 * 
	 * <p>
	 * TODO create and use an instance of {@link PunctuationStripper} to strip
	 * punctuation
	 * </p>
	 * 
	 * <p>
	 * TODO Close the {@link BufferedReader} you use in a finally block
	 * </p>
	 * 
	 * <p>
	 * Example:
	 * </p>
	 * 
	 * <pre>
	 * Now get you to my lady's chamber, and tell her, let her paint an
	 * inch thick, to this favour she must come; make her laugh at that.
	 * </pre>
	 * 
	 * <p>
	 * would become:
	 * </p>
	 * 
	 * <pre>
	 * Now get you to my ladys chamber and tell her let her paint an
	 * inch thick to this favour she must come make her laugh at that
	 * </pre>
	 * 
	 * @throws IOException
	 */
	private static void writeFileStrippingPunctuation() throws IOException {

		PrintWriter writer = new PrintWriter("TheNewYorick.txt", "UTF-8");
		PunctuationStripper ps = new PunctuationStripper();

		try (BufferedReader br = new BufferedReader(new FileReader(
				SHAKESPEARE_FILEPATH))) {

			String line;

			while ((line = br.readLine()) != null) {
				 System.out.println(ps.strip(line)); //This prints on console
				// for test only

				writer.println(ps.strip(line));
			}
		}
		writer.close();
	}

	/**
	 * <p>
	 * TODO try to read a file that doesn't exist, catch the exception that is
	 * thrown, then write an error to {@link System#err} (same syntax as writing
	 * to {@link System#out})
	 * </p>
	 * 
	 * <p>
	 * TODO Close the {@link BufferedReader} you use in a finally block
	 * </p>
	 * @throws IOException 
	 * 
	 * @throws FileNotFoundException
	 */
	private static void tryToReadAFileThatDoesntExist() throws IOException 
			 {

		
        String fileName = "FileAintThere.txt";

       
        String line;

        try {
           
            FileReader fileReader =  new FileReader(fileName);

            
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.err.println("UNABLE TO OPEN '" +  fileName + "'" + "BECAUSE IT DOES NOT EXIST");  }              
        
}
	

	/**
	 * 
	 * Extension!
	 * 
	 * <p>
	 * TODO Create a test and a class (this is an exception to not creating new
	 * classes).
	 * </p>
	 * 
	 * <p>
	 * TODO read the input file and write a new file
	 * </p>
	 * 
	 * <p>
	 * TODO create and use an instance of {@link PunctionationReplacer} to
	 * replace punctuation with newlines and write these to System.out
	 * </p>
	 * 
	 * <p>
	 * TODO Close the {@link BufferedReader} you use in a finally block
	 * </p>
	 * 
	 * <p>
	 * Example:
	 * </p>
	 * 
	 * <pre>
	 * Now get you to my lady's chamber, and tell her, let her paint an
	 * inch thick, to this favour she must come; make her laugh at that.
	 * </pre>
	 * 
	 * <p>
	 * would become:
	 * </p>
	 * 
	 * <pre>
	 * Now get you to my lady
	 * s chamber
	 * and tell her
	 * let her paint an inch thick
	 * to this favour she must come
	 * make her laugh at that
	 * </pre>
	 * 
	 * @throws IOException
	 */
	private static void writeFileReplacingPunctuationWithLinebreaks()
			throws IOException {

		int lineNumber = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					SHAKESPEARE_FILEPATH));
			String line;
			while ((line = br.readLine()) != null) {

				lineNumber++;
				System.out.println("line" + lineNumber + " : " + line);
			}
		} catch (IOException ex) {
 
			System.out.println("Error caught");
			
		} finally {
			System.err.println("FINALLY BLOCK");
		}

	}
}