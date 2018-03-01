package fb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FriendsRecommendation {
	
	public List<String> reccomendation(String name) {
		List<String> result = new ArrayList<String>();
		if(name == null || name.length() == 0) return result;
		
		List<String> friends = getFriends(name); //return a list of friends
		HashSet<String> set = new HashSet<String>();
		
		for(String friend : friends) {
			set.add(friend); //marking them as your friend
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String>[] list = new ArrayList[friends.size() + 1];
		
		for(String friend : friends) { //for each  of your friends
			List<String> ffriends = getFriends(friend); //get their friend list
			for(String each : ffriends) {
				if(!set.contains(each) && !each.equals(name)) {//if they are not your friend and not you
					//to figure out how many mutual friends
					if(map.containsKey(each))
						map.put(each, map.get(each) + 1);
					else map.put(each, 1);
				
				}
			}
		}
		
		for(String each : map.keySet()) {
			int count = map.get(each);
			if(list[count] == null) list[count] = new ArrayList<String>();
			list[count].add(each);
		}
		
		for(int k =  list.length - 1; k >= 0; k--) {
			if(list[k] != null)
				result.addAll(list[k]);
		}
		
		return result;
	}
	
	public List<String> getFriends(String name) {
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		map.put("Basila", new ArrayList<String>());
		map.put("Saloni", new ArrayList<String>());
		map.put("Tanjeev", new ArrayList<String>());
		map.put("Poonam", new ArrayList<String>());
		map.put("KJ", new ArrayList<String>());
		
		map.get("Basila").add("Poonam");
		map.get("Basila").add("Saloni");
		map.get("Basila").add("Tanjeev");
		map.get("Basila").add("KJ");

		map.get("Tanjeev").add("Basila");
		map.get("Tanjeev").add("Karanvir");
		map.get("Tanjeev").add("Sameer");
		map.get("Tanjeev").add("Neal");
		map.get("Tanjeev").add("Saloni");
		map.get("Tanjeev").add("Poonam");
		
		map.get("KJ").add("Navi");
		map.get("KJ").add("Omer");
		map.get("KJ").add("Navneet");
		map.get("KJ").add("Chirag");
		map.get("KJ").add("Poonam");

		return map.get(name);
	}
	
	public static void main(String[] args) {
		FriendsRecommendation test = new FriendsRecommendation();
		List<String> recArray = test.reccomendation("Basila");
		System.out.println(recArray);
	}

}
