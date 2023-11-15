import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner fileIn; //Input file connection
        PrintWriter fileOut; //Html file connection
        String filenameIn; // Original files name
        String filenameOut; // New html files name
        int dotIndex; // Position of . in file name
        String line = null; // A line from the input file

        // Step 1: Ask user for a file name
        System.out.println("Enter file name or path");
        filenameIn = scanner.nextLine();

        // Step 2: Check to see if the file exists
        try {
            // Step 3: rename .txt as a .html file

            fileIn = new Scanner(new FileReader(filenameIn));
            dotIndex = filenameIn.lastIndexOf(".");
            if (dotIndex == -1){
                filenameOut = filenameIn + ".html";
            } else {
                filenameOut = filenameIn.substring(0, dotIndex) + ".html";
            }
            fileOut = new PrintWriter(filenameOut);
            try {
                line = fileIn.nextLine();
            } catch (NoSuchElementException e){
                System.out.println("Error: " + e.getMessage());
            }
            if (line==null){
                System.out.println("This file is empty : (");
            } else {
                // Step 5: Read each line and insert necessary <tags>
                fileOut.println("<html>");
                fileOut.println("<head>");
                fileOut.println("</head>");
                fileOut.println("<body>");
                fileOut.println(line);

                while(fileIn.hasNextLine()) {
                    fileOut.println("<br>");
                    line = fileIn.nextLine();

                    fileOut.println("<p>");
                    if (line.isEmpty()){
                        fileOut.println("<br>");
                    } else {
                        fileOut.println(line);
                    }
                    fileOut.println("</p>");

                }
                fileOut.println("</body>");
                fileOut.println("</html>");

                System.out.println("HTML file is processed");
            }

            fileIn.close();
            fileOut.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }






    }

}
