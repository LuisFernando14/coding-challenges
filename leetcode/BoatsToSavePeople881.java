package leetcode;

import java.util.*;

/*
 * Leetcode: 881. Boats to save people
 * https://leetcode.com/problems/boats-to-save-people
 * 
 * This is a medium problem, however, if you read carefully the instructions and the constraints, you can solve this
 * problem pretty easy by sorting the array an using two pointers approach.
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
