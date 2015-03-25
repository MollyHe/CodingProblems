/**
 * Created by menglinhe on 3/24/15.
 */
public class FindPeak {
    public static void main(String[] args){
        int[] A={1,2,3,4,5,8,5,4};
        int[][] AA={{10,8,10,10},{14,13,12,11},{15,9,10,21},{16,17,19,20}};
        //int[][] AA={{1,2,5}};
        //System.out.println(findPeak_1D_alg1(A));
        //System.out.println(findPeak_1D_alg2(A));
        System.out.println(findPeak_2D(AA,0,AA[0].length));
    }

    //O(n) solution
    public static int findPeak_1D_alg1(int[] A){
        if(A==null || A.length==0){
            return Integer.MIN_VALUE;
        }

        //One element
        if(A.length==1){
            return A[0];
        }

        //two sides
        if(A[0]>=A[1]){
            return A[0];
        }
        if(A[A.length-1]>=A[A.length-2]){
            return A[A.length-1];
        }

        for(int i=1;i<A.length-1;i++){
            if(A[i]>=A[i-1] && A[i]>=A[i+1]){
                return A[i];
            }
        }

        return Integer.MIN_VALUE;
    }

    //O(logn) solution using Binary Search Concept
    public static int findPeak_1D_alg2(int[] A){
        if(A==null || A.length==0){
            return Integer.MIN_VALUE;
        }

        //One element
        if(A.length==1){
            return A[0];
        }

        //two sides
        if(A[0]>=A[1]){
            return A[0];
        }
        if(A[A.length-1]>=A[A.length-2]){
            return A[A.length-1];
        }

        int left=0, right=A.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(A[mid]<A[mid-1]){
                //go left
                right=mid-1;
            }else if(A[mid]<A[mid+1]){
                left=mid+1;
            }else{
                return A[mid];
            }
        }

        return Integer.MIN_VALUE;
    }

    public static int findPeak_2D(int[][] A, int left, int right){
        int m=A.length;//row
        int n=A[0].length;//col

        if(left<=right) {
            //find global max in column j
            int i = -1;
            int j = (left + right) / 2;
            int global_max_j = Integer.MIN_VALUE;
            for (int a = 0; a < m; a++) {
                if (A[a][j] > global_max_j) {
                    global_max_j = A[a][j];
                    i = a;
                }
            }

            //check if its left and right are smaller
            if(j-1<0 && j+1>=n){
                return A[i][j];
            }else if(j-1<0){
                return A[i][j + 1] > A[i][j]?findPeak_2D(A, j+1, right):A[i][j];
            }else if(j+1>=n){
                return A[i][j - 1] > A[i][j]?findPeak_2D(A, left, j-1): A[i][j];
            }else{
                if(A[i][j + 1] < A[i][j] && A[i][j - 1] > A[i][j]){
                    return A[i][j];
                }else if(A[i][j + 1] > A[i][j]){
                    return findPeak_2D(A, j+1, right);
                }else{
                    return findPeak_2D(A, left, j-1);
                }
            }

        }

        return Integer.MIN_VALUE;
    }

}
