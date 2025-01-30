import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
O propósito por trás do desafio é criar um algoritmo que receba um texto em um arquivo "text.txt", e a partir disso ele consegue separar
cada palavra do texto de forma alfabética com a quantidade de vezes que aparece.

Nessa primeira versão ele só vai lê o arquivo text.txt e criar um arquivo com cada palavra do texto de forma alfabética com a quantidade de vezes que aparece.
Nessa versão pode ele vai lê linha por linha.
 */

public class WordsFrequently2 {
    private static StringBuilder text = new StringBuilder();
    private static String[] wordsSeparate;
    private static Map<String, Integer> listWords = new HashMap<>();

    public static void makeReadText(String nameFile) {
        try(BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            do {
                if(br.readLine() != null) text.append(br.readLine());
            } while(br.readLine() != null);

            wordsSeparate = text.toString().split(" ");
            Arrays.sort(wordsSeparate); // Deixa em ordem as palavras.
            System.out.println(Arrays.toString(wordsSeparate));

            createHashMap(wordsSeparate);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }

    private static void createHashMap(String[] words) {
        int cont;

        for(String str: wordsSeparate) {
            if(listWords.containsKey(str)) {
               // Caso contenha a palavra já eu quero que aumente do value da quantidade em 1, a qual é Integer nesse caso.
                cont = listWords.get(str);
                listWords.replace(str, cont + 1);
                continue;
            }

            listWords.put(str, 1); // Caso seja a primeira vez adiciona a palavra e o valor do Value será 1, pois só uma palavra foi
            // achada.
        }

        try(FileWriter fw = new FileWriter("analyseText.txt")) {
            for(Map.Entry<String, Integer> entry : listWords.entrySet()) {
                fw.write(entry.getKey() + " → " + entry.getValue() + "\n");
            }
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}
