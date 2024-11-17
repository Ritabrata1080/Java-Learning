/**
 * Created by Ritabrata, 17/11/2024
 */

package practice;

import java.util.*;
public class cf_round984_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int price = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            int k = sc.nextInt();

            // Build the map
            for (int i = 0; i < k; i++) {
                int l = sc.nextInt();
                int c = sc.nextInt();
                map.put(l, map.getOrDefault(l, 0) + c);
            }

            // Use a max-heap to efficiently get the largest costs
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            maxHeap.addAll(map.values());

            // Pick top `n` values from the heap
            while (n > 0 && !maxHeap.isEmpty()) {
                price += maxHeap.poll(); // Get and remove the largest value
                n--;
            }

            System.out.println(price);
        }
        sc.close();
    }
}
