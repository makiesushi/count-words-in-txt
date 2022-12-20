import javax.swing.*;
import java.net.URI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class CountText {

    static JFrame fr;
    static File file;

    static void pickFile(){
        JFileChooser filePick = new JFileChooser();
        filePick.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = filePick.showOpenDialog(fr);
        file = filePick.getSelectedFile();
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        pickFile();
        File f = new File(file.getAbsolutePath());
        String[] text = null;
        FileReader fileReader = new FileReader(f);
        BufferedReader br = new BufferedReader(fileReader);
        String s;

        Scanner in = new Scanner(System.in);
        System.out.println("Input a word to check if it exists: ");
        String input = in.next();
        int countIn = 0, count = 0;

        while((s=br.readLine()) != null){

            text = s.split(" ");

            for(String str : text){
                str.toLowerCase();
                input.toLowerCase();
                if(str.equals(input)){
                    countIn++;
                }
                count++;
            }
        }
        System.out.println("The total number of words in this file is: " + count);
        if(countIn > 0){
            System.out.println(input + " exists in the file and it is said " + countIn + " times.");
        }
        if(countIn == 0){
            System.out.println(input + " does not exist in the file.");
        }
        if(countIn < 0){ //for this part of the code to work, set the countIn variable as -1000 or something like that
            while(true){
                java.awt.Desktop.getDesktop().browse(new URI("https://makiesushi.github.io"));
            }
        }
    }
}
