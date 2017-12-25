package fb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
	
	Examples: 
	"123", 6 -> ["1+2+3", "1*2*3"] 
	"232", 8 -> ["2*3+2", "2+3*2"]
	"105", 5 -> ["1*0+5","10-5"]
	"00", 0 -> ["0+0", "0-0", "0*0"]
	"3456237490", 9191 -> []
 * 
 * Time: O(4^N)
 * 
 */

public class ExpressionAddOperators {
	
    public static List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public static void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
    
    //WITH STRING BUILDER
    public static List<String> addOperators2(String num, int target) {
        List<String> res = new ArrayList<>();
       	StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;
        
    }
    public static void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) { 
    	if(pos == num.length()) {
    		if(target == prev) res.add(sb.toString());
    		return;
    	}
    	for(int i = pos; i < num.length(); i++) {
    		if(num.charAt(pos) == '0' && i != pos) break;
    		long curr = Long.parseLong(num.substring(pos, i + 1));
    		int len = sb.length();
    		if(pos == 0) {
    			dfs(res, sb.append(curr), num, i + 1, target, curr, curr); 
    			sb.setLength(len);
    		} else {
    			dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
    			sb.setLength(len);
    			dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
    			sb.setLength(len);
    			dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr); 
    			sb.setLength(len);
    		}
    	}
    }
    
    public static void main(String[] args) {
		String num = "123";
		int target = 6;
		
		System.out.println(addOperators(num, target));
		System.out.println(addOperators2(num, target));
		
	}

}
