// File generated by FlutterFire CLI.
// ignore_for_file: type=lint
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        return windows;
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'YOUR_API_KEY',
    appId: '1:937897345210:web:8ea80765987579b13c0283',
    messagingSenderId: '937897345210',
    projectId: 'news-5b425',
    authDomain: 'news-5b425.firebaseapp.com',
    storageBucket: 'news-5b425.firebasestorage.app',
    measurementId: 'G-YMLQYT1J44',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'YOUR_API_KEY',
    appId: '1:937897345210:android:1967690afbd45dec3c0283',
    messagingSenderId: '937897345210',
    projectId: 'news-5b425',
    storageBucket: 'news-5b425.firebasestorage.app',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'YOUR_API_KEY',
    appId: '1:937897345210:ios:0655b82d93914c0e3c0283',
    messagingSenderId: '937897345210',
    projectId: 'news-5b425',
    storageBucket: 'news-5b425.firebasestorage.app',
    iosBundleId: 'com.example.newsApp',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'YOUR_API_KEY',
    appId: '1:937897345210:ios:0655b82d93914c0e3c0283',
    messagingSenderId: '937897345210',
    projectId: 'news-5b425',
    storageBucket: 'news-5b425.firebasestorage.app',
    iosBundleId: 'com.example.newsApp',
  );

  static const FirebaseOptions windows = FirebaseOptions(
    apiKey: 'YOUR_API_KEY',
    appId: '1:937897345210:web:a7f4eab8c165c8363c0283',
    messagingSenderId: '937897345210',
    projectId: 'news-5b425',
    authDomain: 'news-5b425.firebaseapp.com',
    storageBucket: 'news-5b425.firebasestorage.app',
    measurementId: 'G-X6P19R2CD7',
  );
}
