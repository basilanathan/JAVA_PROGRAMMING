package fb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author basila
 * 
 * https://leetcode.com/problems/course-schedule/description/
 *
 */

public class CourseSchedule {
	
	/*
	 * DFS
	 * For DFS, it will first visit a node, then one neighbor of it, then one neighbor of this 
	 * neighbor... and so on. If it meets a node which was visited in the current process of DFS 
	 * visit, a cycle is detected and we will return false. Otherwise it will start from another 
	 * unvisited node and repeat this process till all the nodes have been visited. Note that you 
	 * should make two records: one is to record all the visited nodes and the other is to record the 
	 * visited nodes in the current DFS visit.
	 * 
	 * The code is as follows. We use a vector<bool> visited to record all the visited nodes and 
	 * another vector<bool> onpath to record the visited nodes of the current DFS visit. 
	 * Once the current visit is finished, we reset the onpath value of the starting node to false.
	 * 
	 * */
	
	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
	    if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; //??
	    
	    // create the array lists to represent the courses
	    List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
	    for(int i=0; i<numCourses; i++) {
	        courses.add(new ArrayList<Integer>());
	    }
	    
	    // create the dependency graph
	    for(int i=0; i<prerequisites.length; i++) {
	        courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
	    }

	    int[] visited = new int[numCourses]; 
	    
	    // dfs visit each course
	    for(int i=0; i<numCourses; i++) {
	           if (!dfs(i,courses, visited)) return false; 
	    }
	    
	    return true;
	}

	private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {
	    
	    visited[course] = 1; // mark it being visited
	    
	    List<Integer> eligibleCourses = courses.get(course); // get its children
	    
	    // dfs its children
	    for(int i=0; i<eligibleCourses.size(); i++) {
	        int eligibleCourse = eligibleCourses.get(i).intValue();
	        
	        if(visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
	        if(visited[eligibleCourse]  == 0) { // not visited
	           if (!dfs(eligibleCourse,courses, visited)) return false; 
	        }

	    }
	    
	    visited[course] = 2; // mark it done visiting
	    return true;
	    
	}
	
	/*
	 * BFS uses the indegrees of each node. We will first try to find a node with 0 indegree. 
	 * If we fail to do so, there must be a cycle in the graph and we return false. Otherwise we have 
	 * found one. We set its indegree to be -1 to prevent from visiting it again and reduce the indegrees 
	 * of all its neighbors by 1. This process will be repeated for n (number of nodes) times. 
	 * If we have not returned false, we will return true.
	 * */
	
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else    
            return false;
    }
    
    public boolean canFinishBFS2(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int[] pair:prerequisites){
            indegree[pair[1]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int select = 0;
        while(!queue.isEmpty()){
            numCourses--;
            int course = queue.poll();
            for(int[] pair:prerequisites){
                if(pair[0]==course){
                    indegree[pair[1]]--;
                    if(indegree[pair[1]]==0){
                        queue.add(pair[1]);
                    }
                }
            }
        }
        return numCourses==0;
    }
	
}



//public class CourseSchedule {
//	
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		if(numCourses <= 1) {
//			return true;
//		}
//		if(prerequisites.length == 0 || prerequisites[0].length == 0) {
//			return true;
//		}
//		
//		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
//		
//		//BUILD GRAPH
//		for(int i = 0; i < numCourses; i++) {
//			graph.put(i, new HashSet<Integer>());
//		}
//		
//		for(int i = 0; i < prerequisites.length; i++) {
//			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
//		}
//		
//		Queue<Integer> queue = new LinkedList<Integer>();
//		int courseRemaining = numCourses;
//		
//		for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
//			if(entry.getValue().size() == 0) {
//				queue.offer(entry.getKey());
//				courseRemaining--;
//			}
//		}
//		while(!queue.isEmpty()) {
//			int key = queue.poll();
//			
//			for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
//				if (entry.getValue().contains(key)) {
//					entry.getValue().remove(key);
//					if (entry.getValue().size() == 0) {
//						queue.offer(entry.getKey());
//						courseRemaining--;
//					}
//				}
//			}
//		}
//		return courseRemaining == 0;
//	}
//	
//	public static void main(String[] args) {
//		CourseSchedule inSchedule = new CourseSchedule();
//		int[][] test1 = {{0, 1}, {1, 2}, {2, 3}};
//		
//		System.out.println(inSchedule.canFinish(3, test1));
//	}
//
//}
