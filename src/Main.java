import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WordsFrequently2.makeReadText("text.txt");

        /*String str;
        StringBuilder strB = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
            do {
                if((str = br.readLine()) != null) strB.append(str + " ");
            } while(str != null);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }

        System.out.println(strB);
         */
    }
}
