package com.atexo.atexotechbackend.common.util;

public class StringUtil {
    /**
     * Copies a range of characters.
     * @param str
     *          the string to process
     * @param start
     *          the begin of the first character
     * @param end
     *          the final of the last caracter
     * @return a String containing the characters from start to end - 1
     */
    public static String safeSubString(String str, int start, int end) {

        String result;
        if ((start < 0) || (start > end)) {
            throw new StringIndexOutOfBoundsException(start);
        }
        else if (end > str.length()) {
            result = str.substring(start, str.length());
        }
        else {
            result = str.substring(start, end);
        }
        return result;
    }
}
