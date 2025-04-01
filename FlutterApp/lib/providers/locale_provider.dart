import 'package:flutter/material.dart';

class LocaleProvider extends ChangeNotifier {
  Locale _locale = Locale('en');

  Locale get locale => _locale;

  void setLocale(Locale locale) {
    if (!['en', 'es', 'ta', 'te', 'ma', 'hi'].contains(locale.languageCode)) return;
    _locale = locale;
    notifyListeners();
  }
}
