/**
 * Created by menglinhe on 3/2/15.
 */
import java.util.*;
import java.io.*;

public class paperG_Q1 {
    public static void main(String[] args) {
        Q1 ans1 = new Q1();
        try {
            //read from wordlist file
            File brackets = new File("wordlist.txt");
            BufferedReader bufferreader = new BufferedReader(new FileReader(brackets));
            String line;

            //create new file brackets-matched.txt
            File brackets_matched = new File("wordlist-substituted.txt");

            FileWriter writer = new FileWriter(brackets_matched, true);
            while ((line = bufferreader.readLine()) != null) {
                // process line
                Set<String> set = ans1.substitute(line);
                //iterate through the result set to write each line into the target file
                Iterator set_it = set.iterator();
                while (set_it.hasNext()) {
                    writer.write(String.valueOf(set_it.next()));
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

//Question 1: Word Substitutions
class Q1{
    public Set<String> substitute(String s){
        //Use a hash set to make sure that there is no duplication in the result
        Set<String> ans=new HashSet<String>();
        String repl;

        char[] tar={'e','f','i','o'};
        String[] sub={"3","ph","!","0"};
        //use a hashmap for those values that are easily substitutable
        HashMap<Character,String> map=new HashMap<Character, String>();

        for(int j=0;j<tar.length;j++){
            map.put(tar[j],sub[j]);
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                //replace the value using the String.replace method
                repl=s.replace("a", "4");
                ans.add(repl);
                repl=s.replace("a","@");
                ans.add(repl);

                if(i+3<s.length() && s.substring(i,i+3).equals("and")){
                    repl=s.replace("and","&");
                    ans.add(repl);
                }
            }else if(s.charAt(i)=='s'){
                repl=s.replace("s", "5");
                ans.add(repl);
                repl=s.replace("s","$");
                ans.add(repl);
            }else if(s.charAt(i)=='t'){
                repl=s.replace("t", "7");
                ans.add(repl);
                repl=s.replace("t","+");
                ans.add(repl);
            }else if(map.containsKey(s.charAt(i))){
                repl=s.replace(s.charAt(i)+"",map.get(s.charAt(i)));
                ans.add(repl);
            }
        }

        return ans;
    }
}
