package resort_furama.until;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {


    public static void writeFile(String pathFile, List<String> stringList, boolean append) {
        try (
                FileWriter fileWriter = new FileWriter(pathFile, append);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {

            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readFile(String pathFile){
        List<String> stringList = new ArrayList<>();
        try(
                FileReader fileReader = new FileReader(pathFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                stringList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }

}
