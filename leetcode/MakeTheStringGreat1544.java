package leetcode;

/*
 * Leetcode: 1544. Make the string great
 * https://leetcode.com/problems/make-the-string-great
 * 
 * This problem is about removing two consecutive characters, one is lower case and the other is upper case, and keep doing that
 * until the string is free of consecutive characters with the above criteria.
 * 
 * Aproach:
 * My aproach to solve this problem is to have two pointers, one will point to the character at position i
 * and the other will point to the character at position i+1. Remember that i must be less than the length
 * of the string.
 * Once we have the two pointers with valida character we will verify if the character at position i
 * is the lower or upper case version of the character at position i+1.
 * If that's the case, we remove these two character from the string, assign 0 to the index that is iterating
 * the string and repeat the process.
 * We keep doing this until i is equal to the length of the string and after that we return the string.
 * 
 * 
 * Some questions:
 * Why using a StringBuilder?
 * Remember that in Java, String are immutable, so if we want to delete some characters of a String,
 * a new String will be created with those characters removed and this is an expensive operation that
 * could result in a TLE if we do this many times. Even if we don't we a TLE, the execution could take
 * very long.
 * 
 * Why not using a Stack?
 * I think that using a stack is overkill for this problem. The idea of this problem is to use a Stack,
 * but I think for this simple problem, using two pointers is more than enough. There are other problems
 * more interesting in leetcode about stacks.
 * 
 * Why the 32 in the if condition?
 * Remeber that if we substract the ascii value of an alphabetic character of another alpabethic character,
 * take the absolut value of the result and if the value is equals to 32, it means that one character was upper case
 * and the other was lower case and they are the same character.
 * You can take a look at the ascii table for more information.
 * 
 * Why the if condition at the begining of the method?
 * If the length of the string is less than 2, it is not necesarry to make any verification of a great String.
 * Just return the string itself.
*/

public class MakeTheStringGreat1544 {
    public static void main(String[] args) {
        String str = "leEeetcode";
        String result = new MakeTheStringGreat1544().makeGood(str);
        System.out.println(result);
    }

    public String makeGood(String s) {
        if (s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);

        char prev;
        char curr;
        int i = 1;
        prev = sb.charAt(0);
        while (i < sb.length()) {
            curr = sb.charAt(i);
            if (Math.abs(prev - curr) == 32) {
                sb.delete(i - 1, i + 1);
                i = 0;
                prev = ' ';
                continue;
            }

            prev = sb.charAt(i);
            i++;
        }
        return sb.toString();
    }
}