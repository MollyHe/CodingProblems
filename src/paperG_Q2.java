/**
 * Created by menglinhe on 3/2/15.
 */
import java.util.*;
import java.io.*;

public class paperG_Q2 {

    public static void main(String[] args){
        Q2 ans2=new Q2();
        try {
            //read from brackets file
            File brackets = new File("brackets.txt");
            BufferedReader bufferreader = new BufferedReader(new FileReader(brackets));
            String line;

            //create new file brackets-matched.txt
            File brackets_matched = new File("brackets-matched.txt");

            FileWriter writer = new FileWriter(brackets_matched, true);
            while ((line = bufferreader.readLine()) != null) {
                // process line
                boolean ln = ans2.isMatched(line);
                if(ln){
                    writer.write(line);
                    //writer.write(System.lineSeparator());
                    writer.write(System.getProperty("line.separator"));
                }
            }
            bufferreader.close();
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//Question 2: Matching Brackets
class Q2{
    public boolean isMatched(String str) {
        if(str==null){
            return true;
        }

        Stack<Character> stack = new Stack<Character>();
        int count=0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
                count++;
            } else if (str.charAt(i) == ')' ) {
                count++;
                if(count==1){
                    return false;
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else if (str.charAt(i) == ']') {
                count++;
                if(count==1){
                    return false;
                }
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }
            } else if(str.charAt(i) == '}') {
                count++;
                if(count==1){
                    return false;
                }
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }
            }
        }

        if(count%2!=0){
            return false;
        }else {

            return stack.isEmpty();
        }
    }
}
