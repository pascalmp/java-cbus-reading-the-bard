package org.wecancodeit.week3.bard;

public class PunctuationStripper {

	public String strip(String stripFrom) {
		
		
		return stripFrom.replaceAll("[\\.\\?\\!\\@\\#\\;\\'\\,\\:]","").trim();
	
	
	}

	
}
