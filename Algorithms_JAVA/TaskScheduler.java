package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * https://leetcode.com/problems/task-scheduler/solution/
 * https://discuss.leetcode.com/topic/92966/java-o-n-time-o-1-space-1-pass-no-sorting-solution-with-detailed-explanation/11
 * 
 * O(n) time O(1) space 1 pass
 *
 */

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] times = new int[26];
        for(char t: tasks){
          times[t - 'A']++;
        }
        
        int max = 0;
        for(int t: times){
          max = Math.max(max, t);
        }
        
        max--;
        System.out.println(max);
        int space = max * (n + 1);
        for(int t: times){
          space -= Math.min(max, t);
        }
        
        if(space <= 0){
          return tasks.length;
        } else {
          return tasks.length + space; 
        }
      }
    
    public static void main(String[] args) {
		TaskScheduler test = new TaskScheduler();
		char[] tasks = {'A','A','A', 'B','B', 'C'};
		System.out.println(test.leastInterval(tasks, 2));
		
	}
    
    /* A, B, C
     * A, B, #
     * A,
     * 
     * 
     * */
	
	

}
