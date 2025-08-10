
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static long count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        mergeSort(arr, 0, arr.length-1);
        pw.println(count);
        pw.flush();


    }

    static void mergeSort(int [] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    static void merge(int [] arr, int si, int mid, int ei){
        int [] left = Arrays.copyOfRange(arr, si, mid+1);
        int [] right = Arrays.copyOfRange(arr, mid+1, ei+1);

        for (int i = 0; i < left.length; i++) {
             if ( left[i]<= 0) {
                continue;
            }
            int sqrt = (int)Math.floor(Math.sqrt(left[i]-1));
            int lowerB = -sqrt;
            int upperB= sqrt;

            int idx1 = greaterEqual(right, lowerB);
            int idx2 = strictlyGreater(right,upperB);
            count+=(idx2-idx1);

        }
        int i = 0, j=0, k=si;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }else{
                arr[k++]=right[j++];
            }
        }
        while(i<left.length){
            arr[k++]=left[i++];
        }
        while(j<right.length){
            arr[k++]=right[j++];
        }
    }

    static int greaterEqual(int [] arr ,int key){
        int l = 0;
        int r = arr.length-1;
        int ans = arr.length;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]>=key){
                ans = mid;
                r= mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }

    static int strictlyGreater(int [] arr ,int key){
        int l = 0;
        int r = arr.length-1;
        int ans = arr.length;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]>key){
                ans = mid;
                r= mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}

