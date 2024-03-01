package maximum_profit;

import java.util.HashMap;
import java.util.Scanner;

public class Max_profit {

    public static long findMaximumProfit(int[] category, int[] price) {
    	int n = category.length;
        long profit = 0;
        HashMap<Integer, Integer> itemsSoldPerCategory = new HashMap<>();
        int uniqueCategories = 0;

        for (int i = 0; i < n; i++) {
            int currCategory = category[i];
            int currPrice = price[i];

            // Calculate the profit for the current item
            long currProfit = currPrice * (uniqueCategories - itemsSoldPerCategory.getOrDefault(currCategory, 0) + 1);
            profit += currProfit;

            // Update the count of items sold for the current item's category
            itemsSoldPerCategory.put(currCategory, itemsSoldPerCategory.getOrDefault(currCategory, 0) + 1);

            // If it's a new category, increment the count of unique categories
            if (itemsSoldPerCategory.get(currCategory) == 1) {
                uniqueCategories++;
            }
        }

        return profit;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();

        int[] category = new int[n];
        int[] price = new int[n];

        System.out.println("Enter category of items: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the category of item " + (i + 1) + ": ");
            category[i] = sc.nextInt();
        }

        System.out.println("Enter price of items: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the price of item " + (i + 1) + ": ");
            price[i] = sc.nextInt();
        }

        long maxProfit = findMaximumProfit(category, price);
        System.out.println("Maximum profit is: " + maxProfit);
    }
}
