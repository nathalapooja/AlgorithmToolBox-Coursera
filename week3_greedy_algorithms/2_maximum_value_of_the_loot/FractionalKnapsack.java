import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class FractionalKnapsack {
    
    
    private static double getOptimalValue(int capacity,
                                          int[] values,
                                          int[] weights) {
        double value = 0;
        // build val-per-unit for each item
        Item[] items = new Item[values.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        // sort items by vi/wi
        Arrays.sort(items, new Comparator<Item>(){
            @Override
            public int compare (Item i1, Item i2) {
                return i1.val_per_unit > i2.val_per_unit ? -1 : 1;
            }
        });
        
        int i = 0;
        // either no items left or no room left
        while(i < items.length && capacity > 0) {
            // if item fits into knapsack, take all of it;
            // o.w. take so much as to fill the knapsack
            int fraction = Math.min(items[i].weight, capacity);
            value += items[i].val_per_unit * fraction;
            capacity -= fraction;
            i++;
        }
        return value;
    }
    
    private static class Item {
        int weight;
        int value;
        double val_per_unit;
        public Item (int val, int wgt) {
            this.weight = wgt;
            this.value = val;
            val_per_unit= (double)val/wgt;
            //val_per_unit = Math.round( ((double) val) / ((double) wgt) * 10000.0) / 10000.0;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(String.format("%.4f",getOptimalValue(capacity, values, weights)));
        scanner.close();
    }
} 
