//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getOddOccurrence(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    int getOddOccurrence(int[] arr, int n) {
        Map<Integer,Boolean> mp = new HashMap<>();
        for(int i =0;i<n;i++){
            if(mp.containsKey(arr[i]))
                mp.put(arr[i],!mp.get(arr[i]));
            else
                mp.put(arr[i],false);
        }
        int result=0;
        Set<Map.Entry<Integer,Boolean>> setEntries = mp.entrySet();
        for(Map.Entry<Integer,Boolean> entry : setEntries){
            if(!entry.getValue()){
                result = entry.getKey();
                break;
            }
        }
        return result;
        /*
        Set<Map.Entry<Integer,Boolean>> setEntries = mp.entrySet();
        Stream<Map.Entry<Integer,Boolean>> str1 = setEntries.stream();
        Stream<Map.Entry<Integer,Boolean>> str2 = str1.filter((k,v)-> !v);
        Optional<Map.Entry<Integer,Boolean>> opt = str2.findFirst();
        Map.Entry<Integer,Boolean> entry = opt.get();
        return entry.getKey();
        */
        //Map.Entry<Integer,Boolean> val= mp.entrySet().parallelStream().filter((k,v)-> !v).findFirst().get();
        //return val.getKey();
    }
}
