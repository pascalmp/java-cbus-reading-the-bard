package org.wecancodeit.week3.bard;

import org.junit.Assert;
import org.junit.Test;

/**
 * TODO satisfy one test at a time and in order -- remember to do the simplest
 * thing that works.
 */
public class PunctuationStripperTest {

	@Test
	public void shouldReturnEmptyForAnEmptyString() {
		// TODO create PunctuationStripper and tell it to strip an empty string
		// arrange
		PunctuationStripper underTest = new PunctuationStripper();
		String stripFrom = "";
		// Act
		String result = underTest.strip(stripFrom);
		// Assert
		Assert.assertEquals("", result);
	}

	@Test
	public void shouldReturnStringUnchangedIfNoPunctuation() {
		// TODO create PunctuationStripper and tell it to strip a string without
		// punctuation
		// Arrange
		PunctuationStripper underTest = new PunctuationStripper();
		String stripFrom = "abc123";
		// Act
		String result = underTest.strip(stripFrom);
		// Assert
		Assert.assertEquals("abc123", result);
	}

	@Test
	public void shouldTrimWhitespaceFromTheBeginningAndEndOfAString() {
		// TODO create PunctuationStripper and tell it to strip a string with
		// leading and trailing whitespace
		PunctuationStripper underTest = new PunctuationStripper();
		String stripFrom = "  abc123  ";
		// Act
		String result = underTest.strip(stripFrom);
		// Assert
		Assert.assertEquals("abc123", result);
	}

	@Test
	public void shouldStripPunctuation() {
		// TODO create PunctuationStripper and tell it to strip a string with
		// leading and trailing whitespace
		PunctuationStripper underTest = new PunctuationStripper();
		String stripFrom = "  Oh.Man?All!These@Punctuations#Up;In'Here  ";
		// Act
		String result = underTest.strip(stripFrom);
		// Assert
		Assert.assertEquals("OhManAllThesePunctuationsUpInHere", result);
	}

	// TODO create additional tests if they make you feel more comfortable with
	// your solution
}
