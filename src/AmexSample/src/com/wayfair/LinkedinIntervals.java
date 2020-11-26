package com.wayfair;

/* Intervals Coverage 
 * Linkedin questions
 * */

import java.util.*;

interface IntervalsInterface {
 
    /**
     * Adds an interval [from, to) into an internal structure.
     */
    void addInterval(int from, int to);
 
    /**
     * Returns a total length covered by the added intervals.
     * If several intervals intersect, the intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6) -- 6-3 = 3
     * addInterval(8, 9) -- 9 -8 = 1
     = 4
     * addInterval(1, 5)  --5-1 = 4
     -- 1, 2, 6, 8, 9
     *
     * getTotalCoveredLength() -> 6
     *
     * i.e. [1,5) and [3,6) intersect and give a total covered interval [1,6) with a length of 5.
     *      [1,6) and [8,9) don't intersect, so the total covered length is a sum of both intervals, that is 5+1=6.
     *
     *          |__|__|__|                  (3,6)
     *                         |__|         (8,9)
     *    |__|__|__|__|                     (1,5)
     *
     * 0  1  2  3  4  5  6  7  8  9  10
     *
     */
    int getTotalCoveredLength();
 
}


class LinkedinIntervals implements IntervalsInterface {
  
  HashSet<Integer> set = new HashSet<>();
  
  public static void main(String[] args) {
  
	  LinkedinIntervals intervals = new LinkedinIntervals();
    
    intervals.addInterval(3,6); //3
    //[4,5,6];
    intervals.addInterval(8, 9); //1
    //[4,5,6,9]
    intervals.addInterval(1, 5); //4
    //[4,5,6,9,2,3]
    
    //intervals.addInterval(0, 4);
    //[4,5,6,9,2,3,1] = 7
    //intervals.addInterval(6, 9);
    //[4,5,6,9,2,3,1,7,8]  = 9
    //intervals.addInterval(4, 6);
    
    
    System.out.println(intervals.getTotalCoveredLength());
  
  }
  
  public void addInterval(int from, int to) {
  
    for(int i = from+1; i <= to; i ++) {
      set.add(i);
    }
    System.out.println(set);
  }

  
  
  public int getTotalCoveredLength() {
    return set.size();
  }

}
