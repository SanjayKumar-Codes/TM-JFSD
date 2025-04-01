import 'package:flutter/material.dart';
import '../services/weather_service.dart';

class WeatherScreen extends StatefulWidget {
  @override
  _WeatherScreenState createState() => _WeatherScreenState();
}

class _WeatherScreenState extends State<WeatherScreen> {
  final List<String> cities = ["Chennai", "New York", "London", "Tokyo", "Paris"];
  String selectedCity = "Chennai";
  Map<String, dynamic>? weatherData;
  bool isLoading = false;

  void fetchWeather() async {
    setState(() {
      isLoading = true;
    });

    WeatherService weatherService = WeatherService();
    var data = await weatherService.fetchWeather(selectedCity);

    setState(() {
      weatherData = data;
      isLoading = false;
    });
  }

  @override
  void initState() {
    super.initState();
    fetchWeather();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Weather Tracker")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            DropdownButton<String>(
              value: selectedCity,
              onChanged: (String? newValue) {
                setState(() {
                  selectedCity = newValue!;
                  fetchWeather();
                });
              },
              items: cities.map<DropdownMenuItem<String>>((String city) {
                return DropdownMenuItem<String>(
                  value: city,
                  child: Text(city),
                );
              }).toList(),
            ),
            SizedBox(height: 20),
            isLoading
                ? CircularProgressIndicator()
                : weatherData != null
                    ? Column(
                        children: [
                          Text(
                            "${weatherData!['location']['name']}, ${weatherData!['location']['country']}",
                            style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                          ),
                          SizedBox(height: 10),
                          Image.network("https:${weatherData!['current']['condition']['icon']}"),
                          Text(
                            "${weatherData!['current']['temp_c']}°C",
                            style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
                          ),
                          Text(
                            weatherData!['current']['condition']['text'],
                            style: TextStyle(fontSize: 18),
                          ),
                          SizedBox(height: 10),
                          Text("Humidity: ${weatherData!['current']['humidity']}%"),
                          Text("Wind Speed: ${weatherData!['current']['wind_kph']} km/h"),
                        ],
                      )
                    : Text("Failed to load weather data."),
          ],
        ),
      ),
    );
  }
}
