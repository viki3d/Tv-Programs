package com.viki3d.proxiad.aci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a TV program with it's name, start and final times.
 * 
 * @author viki3d
 */
public class TvProgramItem implements Comparable<TvProgramItem> {

	private static final String ITEMS_SEPARATOR = ", ";
	
	private static final Logger logger = LoggerFactory.getLogger(TvProgramItem.class);
	
	// We intentionally break the task requirement for default access of the class members:
	private String name;
	private int beginHours;
	private int beginMinutes;
	private int endHours;
	private int endMinutes;
	
	/**
	 * @param name          the TV program name, must not be {@code null} or empty
	 * @param beginHours    the starting hour of the TV program, in range 0..23
	 * @param beginMinutes  the starting minute of the TV program, in range 0..59
	 * @param endHours      the ending hour of the TV program, in range 0..23
	 * @param endMinutes    the starting minute of the TV program, in range 0..59
	 * @throws IllegalArgumentException if some argument is out of range
	 */
	public TvProgramItem(String name, int beginHours, int beginMinutes, int endHours,
			int endMinutes) {
		
		// We first declare the unit tests, testing constructor arguments, and after that write
		// the constructor code in order to obey the TDD approach.
		
	    if ((beginHours < 0) || (beginHours > 23)) {
	    	throw new IllegalArgumentException(String.format("Invalid parameter 'beginHours' = %d. " 
	    			+ "Should be between 0 and 24 inclusive.", beginHours));
	    }
	    if ((endHours < 0) || (endHours > 23)) {
	    	throw new IllegalArgumentException(String.format("Invalid parameter 'endHours' = %d. " 
	    			+ "Should be between 0 and 24 inclusive.", endHours));
	    }
	    if ((beginMinutes < 0) || (beginMinutes > 59)) {
	    	throw new IllegalArgumentException(String.format("Invalid parameter 'beginMinutes' = %d" 
	    			+ ". Should be between 0 and 24 inclusive.", beginMinutes));
	    }
	    if ((endMinutes < 0) || (endMinutes > 59)) {
	    	throw new IllegalArgumentException(String.format("Invalid parameter 'endMinutes' = %d" 
	    			+ ". Should be between 0 and 24 inclusive.", endMinutes));
	    }
	    if ((name==null) || ("".equals(name))) {
	    	throw new IllegalArgumentException("Invalid parameter 'name': Program name can not be " 
	    			+ "empty");
	    }
	    
		this.name = name;
		this.beginHours = beginHours;
		this.beginMinutes = beginMinutes;
		this.endHours = endHours;
		this.endMinutes = endMinutes;
	}

	/**
	 * Finds the TV program(s) with longest broadcast time.<br/>
	 * 
	 * @param items	The items to be searched.
	 * @return The item(s) with the longest longest broadcast time. If there is more than one item,
	 * then return all of them, separated with comma and space (separator = ", ").
	 * @see TvProgramItem#ITEMS_SEPARATOR
	 */
	public static String findLongestItem(TvProgramItem[] items) {
		
		// We first declare the initial unit test: TvProgramItemTest.testUseCase1() and then 
		// continue to implement here in order to obey the TDD requirement. 
		
		StringBuilder result = new StringBuilder();
		TvProgramItem longestItem = null;
		
		for (TvProgramItem item : items) {
			logger.trace("Iterating: " + item.getName());
			if (longestItem == null) {
				longestItem = item;
				result = new StringBuilder(item.getName());
				logger.debug("New longest found: " + item.getName());
				continue;
			}
			
			if (item.compareTo(longestItem) == 1) {
				// item is longer than longestItem
				longestItem = item;
				result = new StringBuilder(item.getName());
			} else if (item.compareTo(longestItem) == 0) {
				result.append(TvProgramItem.ITEMS_SEPARATOR + item.getName());
				logger.debug("Additional longest found: " + item.getName());
			}
		}
			
		logger.debug("Longest program(s) found = " + result.toString() + "\r\n");
		return result.toString();
	}
	
	@Override
	public int compareTo(TvProgramItem o) {
		
		// We first declare the unit test: TvProgramItemTest.testComparaTo() and then continue to 
		// implement here in order to obey the TDD requirement.
		
		// Since we have this statement in the task definition: "Consider that no item can span  
		// through more than one day (like starts before midnight and ends next day)." leads to
		// find a solution without using date-time approaches.
		
		int diffInHours1 = this.endHours - this.beginHours;
		int diffInHours2 = o.getEndHours() - o.getBeginHours();
		
		if (diffInHours1 < diffInHours2) {
			return -1;
		} else if (diffInHours1 > diffInHours2) {
			return 1;
		} else if (diffInHours1 == diffInHours2) {
			int diffInMinutes1 = (60 - this.beginMinutes) + this.endMinutes; 
			int diffInMinutes2 = (60 - o.getBeginMinutes()) + o.getEndMinutes();
			if (diffInMinutes1 < diffInMinutes2) {
				return -1;
			} else if (diffInMinutes1 > diffInMinutes2) {
				return 1;
			} else {
				return 0;
			}
		}
		
		return 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBeginHours() {
		return beginHours;
	}

	public void setBeginHours(int beginHours) {
		this.beginHours = beginHours;
	}

	public int getBeginMinutes() {
		return beginMinutes;
	}

	public void setBeginMinutes(int beginMinutes) {
		this.beginMinutes = beginMinutes;
	}

	public int getEndHours() {
		return endHours;
	}

	public void setEndHours(int endHours) {
		this.endHours = endHours;
	}

	public int getEndMinutes() {
		return endMinutes;
	}

	public void setEndMinutes(int endMinutes) {
		this.endMinutes = endMinutes;
	}


}
