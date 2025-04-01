import 'dart:convert';
import 'package:http/http.dart' as http;

class WeatherService {
  static const String apiKey = "YOUR_WEATHER_API_KEY";
  static const String baseUrl = "http://api.weatherapi.com/v1/current.json";

  Future<Map<String, dynamic>?> fetchWeather(String city) async {
    final String url = "$baseUrl?key=$apiKey&q=$city&aqi=yes";

    try {
      final response = await http.get(Uri.parse(url));

      if (response.statusCode == 200) {
        return json.decode(response.body);
      } else {
        print("Error fetching weather: ${response.body}");
        return null;
      }
    } catch (e) {
      print("Exception: $e");
      return null;
    }
  }
}
