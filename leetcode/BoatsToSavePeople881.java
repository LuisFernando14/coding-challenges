package leetcode;

import java.util.*;

/*
 * Leetcode: 881. Boats to save people
 * https://leetcode.com/problems/boats-to-save-people
 * 
 * This is a medium problem, however, if you read carefully the instructions and the constraints, you can solve this
 * problem pretty easy by sorting the array an using two pointers approach.
 * 
 * The problem description is very short, so there are some point to note:
 * - We have an infinite number of boats.
 * - A boat can carry at most two people at the same time.
 * - The sum of the weight of the two people must be less or equal than "limit"
 * - The weight if the person at index i (people[i]) is less or equal than "limit".
 * 
 * With these notes, we can be able to create a simple solution using sorting and two pointers.
 * I will explain the solution below:
 * 1. Sort the array in ascending order.
 * 2. Define the pointers, I am using a left pointer to point at the begining of the array and a right pointer to point at the end of the array.
 * 3. Iterate over the array while left pointer is equal or less than right pointer.
 * 4. If the sum of the person at index[left] and index[right] is less of equal than limit, we sum 1 to the boats needed variable and move pointers.
 * Left pointer is incremented by one and right pointer is decremented by one.
 * 5. If The sum of the right and left pointer is greater than limit, we just sum the right pointer, increment the boats needed variable and
 * decrement the right pointer by one. The left pointer stays the same.
 * We keep doing this until we reach the exit condition of the while loop.
 * At the end, just return the boatsNeeded variable.
 * 
 */

public class BoatsToSavePeople881 {

    public static void main(String[] args) {
        int[] people = { 1, 2 };
        int limit = 3;
        int min = new BoatsToSavePeople881().numRescueBoats(people, limit);

        System.out.println(min);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int min = 0;

        while (left <= right) {
            int f = people[left];
            int s = people[right];

            if (f + s <= limit) {
                min++;
                left++;
                right--;
                continue;
            }
            min++;
            right--;
        }
        return min;
    }

}
