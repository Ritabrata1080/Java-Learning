package practice;

import java.util.*;

public class cf_968_div2_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0;i<n;i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            List<Integer> list = new ArrayList<>();
            for(int p : a) {
                list.add(p);
            }
            boolean alice = true;
            while(list.size() > 1){
                if(alice) {
                    int i = 0;
                    int j = i+1;
                    list.set(i, Math.max(list.get(i), list.get(j)));
                    list.remove(j);
                    alice = false;
                }
                else {
                    int i = list.size() - 1;
                    int j = i-1;
                    list.set(i, Math.min(list.get(i), list.get(j)));
                    list.remove(j);
                    alice = true;
                }
            }
            System.out.println(list.get(0));
        }
    }
}
