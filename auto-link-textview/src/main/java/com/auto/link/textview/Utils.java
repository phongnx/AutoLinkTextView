package com.auto.link.textview;

import android.util.Log;

/**
 * Created by PhongNX on 2019/09/30
 */

class Utils {

    private static boolean isValidRegex(String regex, int customRegexMinLength) {
        return regex != null && !regex.isEmpty() && regex.length() >= customRegexMinLength;
    }

    static String getRegexByAutoLinkMode(AutoLinkMode anAutoLinkMode, String customRegex, int customRegexMinLength) {
        switch (anAutoLinkMode) {
            case MODE_HASHTAG:
                return RegexParser.HASHTAG_PATTERN;
            case MODE_MENTION:
                return RegexParser.MENTION_PATTERN;
            case MODE_PHONE:
                return RegexParser.PHONE_PATTERN;
            case MODE_EMAIL:
                return RegexParser.EMAIL_PATTERN;
            case MODE_CUSTOM:
                if (!Utils.isValidRegex(customRegex, customRegexMinLength)) {
                    Log.e(AutoLinkTextView.TAG, "Your custom regex is not valid, returning URL_PATTERN");
                    return RegexParser.URL_PATTERN;
                } else {
                    return customRegex;
                }
            default:
                return RegexParser.URL_PATTERN;
        }
    }

}
