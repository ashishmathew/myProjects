package com.practice;

import java.util.*;

public class EvaluateExpression {

	// 1+2*3
	
	Map<String, List<Integer>> map = new HashMap<>();
	
	public List<Integer> diffWaysToEvaluateExpression(String input) {
		
		if(map.containsKey(input))
			return map.get(input);
		
		List<Integer> result = new ArrayList<Integer>();

		if (!input.contains("+") && !input.contains("-") && !input.contains("*"))
			result.add(Integer.parseInt(input));
		else {
			// 1
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (!Character.isDigit(ch)) {
					List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
					List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
					for (int leftPartNum : leftParts)
						for (int rightPartNum : rightParts) {
							if (ch == '+')
								result.add(leftPartNum + rightPartNum);
							if (ch == '-')
								result.add(leftPartNum - rightPartNum);
							if (ch == '*')
								result.add(leftPartNum * rightPartNum);
						}

				}

			}

		}
		map.put(input, result);
		return result;
	}

}
