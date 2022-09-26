package sourceryAnswer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) throws IOException{
        File strings = new File("./strings.txt");
        FileReader reader = new FileReader(strings);
        BufferedReader buffReader = new BufferedReader(reader);
        String line = buffReader.readLine();
        
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher;
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while(line != null){
            matcher = pattern.matcher(line);
            while(matcher.find()){
                numbers.add(Integer.parseInt(matcher.group()));
                numbers.removeIf(number -> number < 10);
                if(numbers.size() > 0){
                    numbers.clear();
                    System.out.println(line);
                    break;
                }
            }
            line = buffReader.readLine();
        }
        buffReader.close();
    }

}
