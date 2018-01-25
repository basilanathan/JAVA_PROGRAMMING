package fb.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

 * https://www.careercup.com/question?id=17727664
 */

/*
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class FlattenNestedListIterator implements Iterator<Integer> {
	
	Stack<FlattenNestedListIterator> stack = new Stack<>();
	
	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		for(int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}
	
	public Integer next() {
		return stack.pop().getInteger;
	}
	
	public boolean hasNext( ) {
		while(!stack.isEmpty()) {
			NestedInteger current = stack.peek();
			if (current.isInteger()) {
				return true;
			}
			stack.pop();
			for(int i = current.getList().size - 1; i >= 0; i--) {
				stack.push(current.getList().get(i));
			}
		}
		return false;
	}

}

//USING ARRAYLIST (CARRERCUP)

//public class FlattenList {
//	int index = 0;
//	List<Integer> flattenedList = new ArrayList<>();
//	
//	private FlattenList(){
//	}
//	
//	public static FlattenList getList(List<List<Integer>> lists){
//		FlattenList flattenList = new FlattenList();
//		flattenList.flatten(lists);
//		return flattenList;
//	}
//
//	private void flatten(List<List<Integer>> lists) {
//		for(List<Integer> list : lists){
//			flattenedList.addAll(list);
//		}
//	}
//	
//	public boolean hasNext(){
//		return flattenedList.size() > index; 
//	}
//	
//	public Integer next(){
//		Integer result = flattenedList.get(index);
//		index++;
//		return result;
//	}
//}
