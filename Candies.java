
//TC - O(3N)
//SC - O(N)
import java.util.*;

class Solution {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);
		// forward pass
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) { // left neighbor
				candies[i] = 1 + candies[i - 1];
			}
		}
		// backward pass
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) { // right neighbor
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}
		int sum = 0;
		for (int i : candies) {
			sum += i;
		}
		return sum;
	}
}