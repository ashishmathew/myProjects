package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Revision {

	public void skipCharacter(String str) {
		helperSkipCharacter(str, "");
	}

	public void helperSkipCharacter(String up, String p) {
		// TODO Auto-generated method stub
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);

		if (ch == 'a')
			helperSkipCharacter(up.substring(1), p);
		else
			helperSkipCharacter(up.substring(1), p + ch);

	}

	public String skipCharacterString(String up, String p) {
		if (up.isEmpty()) {
			return p;
		}
		char ch = up.charAt(0);

		if (ch == 'a')
			return skipCharacterString(up.substring(1), p);
		else
			return skipCharacterString(up.substring(1), p + ch);
	}

	public String skipCharacterPassingOneString(String up) {
		if (up.isEmpty()) {
			return "";
		}
		char ch = up.charAt(0);

		if (ch == 'a')
			return skipCharacterPassingOneString(up.substring(1));
		else
			return ch + skipCharacterPassingOneString(up.substring(1));

	}

	public String skipApple(String up) {

		// Myappleisastring
		// Myisastring
		if (up.isEmpty()) {
			return "";
		}
		char ch = up.charAt(0);

		if (up.startsWith("apple"))
			return skipApple(up.substring(5));
		else
			return ch + skipApple(up.substring(1));

	}

	public void subsequence(String up, String p) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);
		subsequence(up.substring(1), p + ch);
		subsequence(up.substring(1), p);
	}

	public List<String> subsequenceArray(String up, String p, List<String> list) {
		if (up.isEmpty()) {
			list.add(p);
			return list;
		}
		char ch = up.charAt(0);
		subsequenceArray(up.substring(1), p + ch, list);
		subsequenceArray(up.substring(1), p, list);
		return list;

	}

	public List<String> subsequenceArrayBody(String up, String p) {

		if (up.isEmpty()) {
			List<String> list = new ArrayList<String>();
			list.add(p);
			return list;
		}

		char ch = up.charAt(0);

		List<String> left = subsequenceArrayBody(up.substring(1), p + ch);
		List<String> right = subsequenceArrayBody(up.substring(1), p);

		left.addAll(right);
		return left;
	}

	public List<List<Integer>> subset(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// [1 2 3]
		// []
		// [1]
		// [2]
		// [1 2]
		// [3]
		// [1 3]
		// [2 3]
		// [1 2 3]
		result.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			int n = result.size();
			for (int j = 0; j < n; j++) {
				List<Integer> currentList = new ArrayList<Integer>(result.get(j));
				currentList.add(nums[i]);
				result.add(currentList);
			}
		}
		return result;
	}

	// 122

	public List<List<Integer>> subsetDuplicate(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
		//result
		//[]
		//[1]
		//[2]---------------------------s,e
		//[1 2]
		//[2 2]
		//[1 2 2]
		
		
		int start = 0, end = 0;

		result.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			start = 0;

			if (i > 0 && nums[i] == nums[i - 1])
				start = end + 1;
			
			end = result.size() - 1;//1
			
			int n = result.size();//2
			
			for (int j = start; j < n; j++) {
				List<Integer> currentList = new ArrayList<Integer>(result.get(j));
				currentList.add(nums[i]);
				result.add(currentList);
			}
		}
		return result;

	}

}
