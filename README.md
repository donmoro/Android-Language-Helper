Change Language Programmatically in Android
==============================

This is a helper library to change the language programmatically in Android.

> Android by default uses the locale of the device to select the
> appropriate language dependent resources. And most of the time this
> behaviour is enough for common applications.

However, there are cases where you would want to change the language of your app and the UI of the app. As a result, ```LocaleHelper``` has emerged.

**Download**
=
```groovy

maven { 
	url 'https://jitpack.io' 
}

implementation 'com.github.donmoro:Android-Language-Helper:1.0.0'
```
**Features**
=
1. Changes language on-the-fly
2. Persists the changes in `Preferences` automatically
3. Detects changes when activity loads from backstack
4. Detects Right-To-Left (RTL) languages and updates layout direction
5. Small footprint (~3KB, ~50 methods), easy to use
