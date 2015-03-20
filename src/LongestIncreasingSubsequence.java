import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by menglinhe on 3/19/15.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] A={13,14,10,11,12};
        ArrayList<Integer> ans=findLongest(A);
        Iterator<Integer> it=ans.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static ArrayList<Integer> findLongest(int[] A){
        int max_count=0;
        int count=1;
        int index=-1;

        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]){
                count++;
            }else{
                count=1;
            }

            if(count>max_count){
                max_count=count;
                index=i;
            }
        }

        ArrayList<Integer> ans=new ArrayList<Integer>();
        while(max_count>0){
            ans.add(0,A[index]);
            index--;
            max_count--;
        }

        return ans;
    }
}
