package com.auto.link.textview;

import android.util.Patterns;

/**
 * Created by PhongNX on 2019/09/30
 */

class RegexParser {

    static final String PHONE_PATTERN = Patterns.PHONE.pattern();
    static final String EMAIL_PATTERN = Patterns.EMAIL_ADDRESS.pattern();
    static final String HASHTAG_PATTERN = "(?:^|\\s|$)#[\\p{L}0-9_]*";
    static final String MENTION_PATTERN = "(?:^|\\s|$|[.])@[\\p{L}0-9_]*";
    static final String URL_PATTERN = "(^|[\\s.:;?\\-\\]<\\(])" +
            "((https?://|www\\.|pic\\.)[-\\w;/?:@&=+$\\|\\_.!~*\\|'()\\[\\]%#,☺]+[\\w/#](\\(\\))?)" +
            "(?=$|[\\s',\\|\\(\\).:;?\\-\\[\\]>\\)])";
}
