/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package longestpalindromic;

/**
 *
 * @author Reazul-System
 */
public class Solution {
    public String longestPalindrome(String s) {
    if (s.length() == 1) {
        return s;
    }

    String result = "";

    for (int i = 0; i < s.length() - 1; i++) {
        // central is 1 char
        int length = expand(s, i, i);
        // central is 2 chars
        int length2 = expand(s, i, i + 1);

        int longer = Math.max(length, length2);

        if (longer > result.length()) {
            result = s.substring(i - (longer - 1) / 2, i + longer / 2 + 1);
        }
    }

    return result;
}

// given string s, expand from given central
private int expand(String s, int start, int end) {
    int left = start;
    int right = end;

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }

    return right - left - 1;
}
}
