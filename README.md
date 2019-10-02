# AutoLinkTextView
AutoLinkTextView is TextView that supports Hashtags (#), Mentions (@) , URLs (http://),
Phone and Email automatically detecting and ability to handle clicks.

The current minSDK version is API level 16 Android 4.1 (ICE CREAM SANDWICH).

## Download sample [apk][77]
[77]: https://github.com/phongnx/AutoLinkTextView/raw/master/screens/AutoLinkTextView.apk

## Features

* Default support for **Hashtag, Mention, Link, Phone number and Email**
* Support for **custom types** via regex
* Ability to set text color
* Ability to set pressed state color
* Ability to make specific modes **bold**

![](screens/screen1.png)
-----------------------

## Download

Gradle:
```groovy
implementation 'com.github.phongnx:AutoLinkTextView:1.0'
```

## Setup and usage

Add AutoLinkTextView to your layout
```xml
    <com.auto.link.textview.AutoLinkTextView
         android:id="@+id/active"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content" />
```

```java
AutoLinkTextView autoLinkTextView = (AutoLinkTextView) findViewById(R.id.active);
```

Set up mode or modes
```java
autoLinkTextView.addAutoLinkMode(AutoLinkMode.MODE_PHONE);
```

Set text to AutoLinkTextView
```java
autoLinkTextView.setText(getString(R.string.long_text));
```

Set AutoLinkTextView click listener
```java
autoLinkTextView.setAutoLinkOnClickListener(new AutoLinkOnClickListener() {
            @Override
            public void onAutoLinkTextClick(AutoLinkMode autoLinkMode, String matchedText) {

            }
        });
```

Customizing
---------

AutoLinkModes

-------------------------
#### AutoLinkMode.MODE_PHONE

![](screens/screen2.png)
-------------------------
#### AutoLinkMode.MODE_HASHTAG

![](screens/screen3.png)
-------------------------
#### AutoLinkMode.MODE_URL

![](screens/screen4.png)
-------------------------
#### AutoLinkMode.MODE_MENTION

![](screens/screen5.png)
-------------------------
#### AutoLinkMode.MODE_EMAIL

![](screens/screen6.png)
-------------------------
#### AutoLinkMode.MODE_CUSTOM

![](screens/screen7.png)

if you use custom mode, you should also add custom regex,

```java
autoLinkTextView.addCustomRegex("Allo");
```
Note:Otherwise ```MODE_CUSTOM``` will return ```MODE_URL```
-------------------------
You can also use multiple types
```java
autoLinkTextView.addAutoLinkMode(
                AutoLinkMode.MODE_HASHTAG,
                AutoLinkMode.MODE_PHONE,
                AutoLinkMode.MODE_URL,
                AutoLinkMode.MODE_MENTION,
                AutoLinkMode.MODE_CUSTOM);
```
![](screens/screen1.png)
-------------------------
You can also change text color for autoLink mode
```java
autoLinkTextView.setHashtagModeColor(ContextCompat.getColor(this, R.color.yourColor));
autoLinkTextView.setPhoneModeColor(ContextCompat.getColor(this, R.color.yourColor));
autoLinkTextView.setCustomModeColor(ContextCompat.getColor(this, R.color.yourColor));
autoLinkTextView.setUrlModeColor(ContextCompat.getColor(this, R.color.yourColor));
autoLinkTextView.setMentionModeColor(ContextCompat.getColor(this, R.color.yourColor));
autoLinkTextView.setEmailModeColor(ContextCompat.getColor(this, R.color.yourColor));
```
-------------------------
And also autoLink text pressed state color
```java
autoLinkTextView.setSelectedStateColor(ContextCompat.getColor(this, R.color.yourColor));
```
-------------------------

Set modes that should be bold

```java
autoLinkTextView.setBoldAutoLinkModes(
  AutoLinkMode.MODE_HASHTAG,
  AutoLinkMode.MODE_PHONE,
  AutoLinkMode.MODE_URL,
  AutoLinkMode.MODE_EMAIL,
  AutoLinkMode.MODE_MENTION
);
```

-------------------------
#### Enable under line

```java
autoLinkTextView.enableUnderLine();
```

![](screens/screen8.png)
-------------------------

License
--------


      Auto Link TextView library for Android
      Copyright (c) 2018 Arman Chatikyan (https://github.com/phongnx/AutoLinkTextView).

      Licensed under the Apache License, Version 2.0 (the "License");
      you may not use this file except in compliance with the License.
      You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

      Unless required by applicable law or agreed to in writing, software
      distributed under the License is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      See the License for the specific language governing permissions and
      limitations under the License.




