package org.kurikosu.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.kurikosu.lang.Substring;

public class SubstringUnitTest {

	@Test
	public void shouldReturnString() {
		
		Substring substring = new Substring("worldchampionship", 5, 13);
		
		assertEquals("champion", substring.value());
		
	}

	@Test
	public void shouldReturnPreceedingString() {
		
		Substring substring = new Substring("worldchampionship", 5, 13);
		
		assertEquals("world", substring.predecessor());
		
	}
	
	@Test
	public void shouldReturnSuccessingString() {
		
		Substring substring = new Substring("worldchampionship", 5, 13);
		
		assertEquals("ship", substring.successor());
		
	}
	
	@Test
	public void shouldAcceptSuccessingString() {
		
		Substring substring = new Substring("worldchampionship", 5, 13);

		assertTrue(substring.isFollowedBy("s"));

		assertTrue(substring.isFollowedBy("ship"));

		// Accepts all, since correct word ('ship') is part of the set (any - logic)
		assertTrue(substring.isFollowedBy("ship", "boot", "car"));
		
		assertFalse(substring.isFollowedBy("boot", "car"));
	}

	@Test
	public void shouldRejectSuccessingString() {
		
		Substring substring = new Substring("worldchampionship", 5, 13);

		// Ship is not part of the set, so return false!
		assertFalse(substring.isFollowedBy("boot", "car"));
	}

	@Test
	public void shouldAcceptPreceedingString() {
		
		Substring substring = new Substring("worldchampionship", 5, 13);
		
		assertTrue(substring.isPreceededBy("world"));

		// Accepts all, since correct word ('world') is part of the set (any - logic)
		assertTrue(substring.isPreceededBy("world", "country", "continent"));
		
	}

	@Test
	public void shouldRejectPreceedingString() {
		
		Substring substring = new Substring("worldchampionship", 5, 13);

		// World is not part of the set, so return false!
		assertFalse(substring.isPreceededBy("country", "continent"));
	}

}
