import java.io.*;

public class Main {
    public static void main(String[] args) {

        File myFile = new File("test1.txt");

        try{
            myFile.createNewFile();

            //Write in the file
            FileWriter writer1 = new FileWriter("test1.txt");
            writer1.write("Writting in a file");
            writer1.flush();
            writer1.close();

            //Read the file
            FileReader reader1 = new FileReader("test1.txt");
            BufferedReader myBuffReader = new BufferedReader(reader1);
            String message = myBuffReader.readLine();
            myBuffReader.close();
            System.out.println("I read from the file this: " + message);

            //File Characteristics
            System.out.println("File name: " + myFile.getName() );
            System.out.println("Path: " + myFile.getPath() );
            System.out.println("Number characteres in file: "+ myFile.length());
        }catch(IOException ex){
            System.out.println("ERROR CREATING FILE ");
        }



    }
}