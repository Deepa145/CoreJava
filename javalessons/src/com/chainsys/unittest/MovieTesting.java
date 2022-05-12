/**
 * 
 */
package com.chainsys.unittest;

import com.chainsys.classesandmethods.Movie;

/**
 * @author deep3108
 *
 */
public class MovieTesting {

	/**
	 * @param args
	 */
	public static void testMovie()
	{
		Movie firstMovie=new Movie();
		firstMovie.setTitleName("Beast");
		firstMovie.setNoOfSongs(6);
		firstMovie.setDurationOfTime(3);
		firstMovie.setNoOfActors(2);
		firstMovie.setNoOfActrees(4);
		System.out.println(firstMovie.getTitleName());
		System.out.println(firstMovie.getNoOfSongs());
		System.out.println(firstMovie.getDurationOfTime());
		System.out.println(firstMovie.getNoOfActors());
		System.out.println(firstMovie.getNoOfActrees());
	}

	
}
