import 'package:flutter/material.dart';
import '../models/news_model.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class NewsProvider extends ChangeNotifier {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;
  final List<News> _savedNews = [];

  List<News> get savedNews => _savedNews;

  bool isSaved(News news) {
    return _savedNews.any((item) => item.url == news.url);
  }

  void toggleSaveNews(News news) {
    if (isSaved(news)) {
      _savedNews.removeWhere((item) => item.url == news.url);
      _firestore.collection("saved_news").where("url", isEqualTo: news.url).get().then((snapshot) {
        for (var doc in snapshot.docs) {
          doc.reference.delete();
        }
      });
    } else {
      _savedNews.add(news);
      _firestore.collection("saved_news").add({
        "title": news.title,
        "description": news.description,
        "imageUrl": news.imageUrl,
        "url": news.url,
      });
    }
    notifyListeners();
  }
}
