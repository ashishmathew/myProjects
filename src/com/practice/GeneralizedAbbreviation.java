package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AbbreviatedWord {
	StringBuilder str;
	int start;
	int count;

	public AbbreviatedWord(StringBuilder s, int i, int j) {
		// TODO Auto-generated constructor stub
		str = s;
		start = i;
		count = j;

	}
}

//ab
public class GeneralizedAbbreviation {

	public List<String> generateAbbreviations(String word) {

		List<String> result = new ArrayList<String>();
		Queue<AbbreviatedWord> queue = new LinkedList<>();
		queue.add(new AbbreviatedWord(new StringBuilder(), 0, 0));

		// ============================queue
		// (null,0,0)
		// ============================queue

		int wordLen = word.length();

		while (!queue.isEmpty()) {
			AbbreviatedWord ab = queue.poll();
			if (ab.start == wordLen) {
				if (ab.count != 0)
					ab.str.append(ab.count);
				result.add(ab.str.toString());

			} else {
				// abbreviate the left tree
				queue.add(new AbbreviatedWord(new StringBuilder(ab.str), ab.start + 1, ab.count + 1));

				if (ab.count != 0)
					ab.str.append(ab.count);
				queue.add(
						new AbbreviatedWord(new StringBuilder(ab.str.append(word.charAt(ab.start))), ab.start + 1, 0));
				// add to character to the right tree but reset the abbreviate count

			}

		}

		return result;

	}
	
	
	public List<String> generateGeneralizedAbbreviation(String word){
		List<String> result = new ArrayList<String>();
		generateAbbreviationRecursive(word,result, new StringBuilder(), 0, 0);
		return result;
		
	}

	//=======================================
	//
	//=======================================
	

	//result 2 
	
	
	public void generateAbbreviationRecursive(String word, List<String> result, StringBuilder str, int start,
			int count) {
		// TODO Auto-generated method stub
		
		if(start == word.length()) {
			if(count != 0)
  				str.append(count);
			result.add(str.toString());
			return;
		}else {
			//abbreviate and increase the count
			generateAbbreviationRecursive(word, result, new StringBuilder(str), start+1, count+1);
			
			//add the new character and reset the count
			if(count != 0)
				str.append(count);
			generateAbbreviationRecursive(word, result, new StringBuilder(str.append(word.charAt(start))), start+1, 0);
			
		}

	}
	
	
	

}
