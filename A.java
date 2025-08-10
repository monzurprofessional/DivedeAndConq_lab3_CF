
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        long x= mergeSort(arr, 0, arr.length-1);
        pw.println(x);
        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i]+" ");
        }
        pw.flush();

    }
    static long mergeSort(int[]arr, int si, int ei){
        if(si>=ei){
            return 0;
        }
        long count = 0;
        int mid= si+(ei-si)/2;
        int[]left=Arrays.copyOfRange(arr, si, mid+1 );
        int [] right = Arrays.copyOfRange(arr, mid+1, ei+1);
        
        count+= mergeSort(left, 0, left.length-1);
        count += mergeSort(right, 0, right.length-1);
        count+= merge(arr, left,right);


        return count;
    }

    static long merge( int []arr, int[]left, int[]right){
       // int [] temp = new int[left.length+right.length];
        long count =0;

        int i =0, j=0, k=0;
        while(i<left.length && j < right.length){
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            } else{
                arr[k++]= right[j++];
                count+=(left.length-i);
            }
        }
        while(i<left.length){
             arr[k++]=left[i++];
        }
        while(j<right.length){
             arr[k++]=right[j++];
        }
        //arr=Arrays.copyOfRange(temp, 0, temp.length);
       // System.arraycopy(temp, 0, arr, 0, temp.length);
        return count;
    }
}
