package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		// result
		// []
		// [1]
		// [2]---------------------------s,e
		// [1 2]
		// [2 2]
		// [1 2 2]

		int start = 0, end = 0;

		result.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			start = 0;

			if (i > 0 && nums[i] == nums[i - 1])
				start = end + 1;

			end = result.size() - 1;// 1

			int n = result.size();// 2

			for (int j = start; j < n; j++) {
				List<Integer> currentList = new ArrayList<Integer>(result.get(j));
				currentList.add(nums[i]);
				result.add(currentList);
			}
		}
		return result;

	}

	public void permutations(String up, String p) {

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);
		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			permutations(up.substring(1), first + ch + second);

		}

	}

	public List<String> permutationsArray(String up, String p, List<String> list) {

		if (up.isEmpty()) {
			list.add(p);
			return list;
		}

		char ch = up.charAt(0);

		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			permutationsArray(up.substring(1), first + ch + second, list);
		}

		return list;

	}

	public List<String> permutationsArrayInBody(String up, String p) {

		if (up.isEmpty()) {
			List<String> list = new ArrayList<String>();
			list.add(p);
			return list;
		}

		char ch = up.charAt(0);

		List<String> ans = new ArrayList<>();

		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			ans.addAll(permutationsArrayInBody(up.substring(1), first + ch + second));
		}

		return ans;

	}

	// [1 2 3]
	public List<List<Integer>> findPermuation(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();// [3 2 1] [2 3 1] [2 1 3]
		Queue<List<Integer>> permutations = new LinkedList<>();// [2 1][1 2]
		permutations.add(new ArrayList<Integer>());// []
		for (int currentNum : nums) {
			int n = permutations.size();// 1
			for (int i = 0; i < n; i++) {
				List<Integer> oldPermutation = permutations.poll();
				for (int j = 0; j <= oldPermutation.size(); j++) {
					List<Integer> newPermuation = new ArrayList<>(oldPermutation);// []
					newPermuation.add(j, currentNum);//
					if (newPermuation.size() == nums.length)
						result.add(newPermuation);
					else
						permutations.add(newPermuation);
				}
			}
		}
		return result;
	}

	public List<List<Integer>> findPermuationRecursion(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		generatePermutations(nums, 0, result, new ArrayList<>());
		return result;
	}

	public void generatePermutations(int[] nums, int index, List<List<Integer>> result,
			List<Integer> currentPermutation) {
		// TODO Auto-generated method stub
		if (index == nums.length) {
			result.add(currentPermutation);
		} else {
			for (int i = 0; i <= currentPermutation.size(); i++) {
				List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
				newPermutation.add(i, nums[index]);
				generatePermutations(nums, index + 1, result, newPermutation);
			}
		}

	}

	public List<String> findLetterCaseStringPermutations(String str) {
		// ad52
		List<String> permutations = new ArrayList<String>();
		permutations.add(str); // ad52
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {// a
				int n = permutations.size();// 1
				for (int j = 0; j < n; j++) {
					char[] chs = permutations.get(j).toCharArray();// 'a''d''5''2'
					if (Character.isLowerCase(chs[i]))
						chs[i] = Character.toUpperCase(chs[i]);// 'A''d''5''2'
					else
						chs[i] = Character.toLowerCase(chs[i]);

					permutations.add(String.valueOf(chs));// Ad52

				}
			}

		}

		return permutations;

	}

	public List<String> findLetterCaseStringPermutationsRecursion(String str) {

		List<String> permutations = new ArrayList<String>();
		permutations.add(str);// ad52
		helperFindPermutations(str, permutations, 0);
		return permutations;

	}

	public void helperFindPermutations(String str, List<String> permutations, int index) {
		// TODO Auto-generated method stub
		if (index == str.length())
			return;

		if (Character.isLetter(str.charAt(index))) {
			int n = permutations.size();// 1
			for (int j = 0; j < n; j++) {
				char[] chs = permutations.get(j).toCharArray();// 'a''d''5''2'
				if (Character.isLowerCase(chs[index]))
					chs[index] = Character.toUpperCase(chs[index]);// 'A''d''5''2'
				else
					chs[index] = Character.toLowerCase(chs[index]);
				permutations.add(String.valueOf(chs));// Ad52
			}

		}

		helperFindPermutations(str, permutations, index + 1);
	}

	class ParenthesisClass {
		String str;
		int openCount;
		int closeCount;

		public ParenthesisClass(String s, int i, int j) {
			str = s;
			openCount = i;
			closeCount = j;
		}

	}

	public List<String> generateValidParethesis(int num) {
		List<String> result = new ArrayList<>();
		Queue<ParenthesisClass> queue = new LinkedList<>();
		queue.add(new ParenthesisClass("", 0, 0));
		while (!queue.isEmpty()) {
			ParenthesisClass ps = queue.poll();
			if (ps.closeCount == num && ps.openCount == num)
				result.add(ps.str);
			else {
				if (ps.openCount < num)
					queue.add(new ParenthesisClass(ps.str + "(", ps.openCount + 1, ps.closeCount));
				if (ps.openCount > ps.closeCount)
					queue.add(new ParenthesisClass(ps.str + ")", ps.openCount, ps.closeCount + 1));
			}

		}
		return result;
	}
	
	public List<String> generateValidParenthesisRecursion(int num){
		List<String> result = new ArrayList<String>();
		helperGenerateValidParenthesis(result,new 
				ParenthesisClass("", 0, 0),num);
		return result;
	}

	public void helperGenerateValidParenthesis(List<String> result, ParenthesisClass ps, int num) {
		// TODO Auto-generated method stub
		
		if(ps.openCount == num && ps.closeCount == num)
			result.add(ps.str);
		else {
			if(ps.openCount < num)
				helperGenerateValidParenthesis(result,
						new ParenthesisClass(ps.str + "(", ps.openCount + 1, 
								ps.closeCount), num);
			
			if(ps.openCount > ps.closeCount)
				helperGenerateValidParenthesis(result,
						new ParenthesisClass(ps.str + ")", ps.openCount, 
								ps.closeCount+1), num);
			
		}
		
	}
	
	
	
	
	
	
	

}
