//TC - O(2N)
//SC - O(1) Since we are using a hashmap of alphabets, space would be constant

import java.util.*;

class Solution1 {
	public int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int maxFreq = 0;
		int maxCount = 0;
		for (char task : tasks) {
			int cnt = map.getOrDefault(task, 0);
			maxFreq = Math.max(maxFreq, cnt + 1);
			map.put(task, cnt + 1);
		}
		for (char key : map.keySet()) {
			if (map.get(key) == maxFreq) {
				maxCount++;
			}
		}
		int partitions = maxFreq - 1;
		int empty = (n - (maxCount - 1)) * partitions;
		int pending = tasks.length - (maxFreq * maxCount);
		int idle = Math.max(0, empty - pending);
		return idle + tasks.length;
	}
}