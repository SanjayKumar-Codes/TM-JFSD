import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/news_model.dart';

class ApiService {
  static const String apiKey = "pub_74461fd52fae65627963a2d474894860582c1";
  static const String baseUrl = "https://newsdata.io/api/1/latest";

  Future<List<News>> fetchNews({String? category, String? country, String? keyword}) async {
    String url = "$baseUrl?apikey=$apiKey";

    if (category != null && category.isNotEmpty) {
      url += "&category=$category";
    }
    if (country != null && country.isNotEmpty) {
      url += "&country=$country";
    }
    if (keyword != null && keyword.isNotEmpty) {
      url += "&q=$keyword";
    }

    try {
      final response = await http.get(Uri.parse(url));

      if (response.statusCode == 200) {
        final Map<String, dynamic> data = json.decode(response.body);
        if (data['results'] != null) {
          List<dynamic> articles = data['results'];
          return articles.map((article) => News.fromJson(article)).toList();
        }
      }
      return [];
    } catch (e) {
      print("Error fetching news: $e");
      return [];
    }
  }
}
