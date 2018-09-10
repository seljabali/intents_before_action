# Intents Before Action
#### Android Intents made easy, inorder for action to ensue.

## What's in it?
#### An app show casing the intent builders in use. App made in a separate module to allow for ProGaurd removal.
#### The following Intent builders:

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
startActivity(PhoneIntentsKt.getDialNumberIntent("1800-424-1444"));
```
Kotlin:
```kotlin
startActivity(getPlayYouTubeQueryIntent(context, "Never Gonna Give You Up"))
```
