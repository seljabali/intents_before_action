# Intents Before Action
[![](https://jitpack.io/v/seljabali/intents_before_action.svg)](https://jitpack.io/#seljabali/intents_before_action)
#### Android Intents made easy, inorder for action to ensue.

![Demo](https://github.com/seljabali/intents_before_action/blob/master/app/src/main/res/mipmap-mdpi/intents_before_action.gif)

## What's in it?
#### An `app` module show casing the intent builders in use.
#### A `library` module having the following Intent builders:

### Google Maps
- Native Maps 
- Web Maps
### Email
- Send Email
- Open Inbox
### Media
- Files
- Sounds
- Images
- Videos
### Phone
- Call
- SMS
- Contacts
### Stores
- Google Play Store (Native & Web)
- Amazon Store (Native & Web)
### Youtube
- Open Youtube Video Id (Native & Web)
- Search Youtube (Native & Web)
### Share Text
- Builder with addresses, subjects, attachements
### System Settings
- Open Wifi Settings, Airplane Mode, etc

## Examples
Java:
```java
startActivity(IntentsUtil.getDialNumber("1800-424-1444"));
```
Kotlin:
```kotlin
startActivity(Intents.getPlayYouTubeQuery(context, "Never Gonna Give You Up"))
```

## Installation
In your module's `build.gradle`:
```
dependencies {
    implementation 'com.github.seljabali:intents_before_action:v1.0.1'
}
```

## LICENSE
This is absolutely FREE. Feel free to include and in our own app without credit. If you liked this app however, do give the repo a star please!
