import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../services/api_service.dart';
import '../models/news_model.dart';
import '../providers/news_provider.dart';
import '../screens/details_screen.dart';
import '../widgets/news_tile.dart';
import '../screens/saved_news_screen.dart';
import '../screens/weather_screen.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final List<String> categories = ["", "business", "entertainment", "health", "sports", "technology"];
  final List<String> countries = ["", "us", "in", "gb", "ca", "au"];
  
  String selectedCategory = "";
  String selectedCountry = "";
  String keyword = "";
  
  late Future<List<News>> _newsFuture;

  void fetchFilteredNews() {
    setState(() {
      _newsFuture = ApiService().fetchNews(
        category: selectedCategory.isNotEmpty ? selectedCategory : null,
        country: selectedCountry.isNotEmpty ? selectedCountry : null,
        keyword: keyword.isNotEmpty ? keyword : null,
      );
    });
  }

  @override
  void initState() {
    super.initState();
    _newsFuture = ApiService().fetchNews(country: "in"); // Default to India's news
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Latest News"),
        actions: [
          IconButton(
            icon: Icon(Icons.cloud),
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => WeatherScreen()),
              );
            },
          ),
          IconButton(
            icon: Icon(Icons.bookmark),
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => SavedNewsScreen()),
              );
            },
          ),
        ],
      ),
      body: Column(
        children: [

          Positioned.fill(
            child: Image.network(
              "https://i.pinimg.com/736x/6c/c3/4a/6cc34a566016468a62fa52947f723659.jpg", // Paste your image URL here
              fit: BoxFit.cover,
            ),
          ),
          // Category Dropdown
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: DropdownButton<String>(
              value: selectedCategory,
              isExpanded: true,
              onChanged: (String? newValue) {
                setState(() {
                  selectedCategory = newValue!;
                });
              },
              items: categories.map((String category) {
                return DropdownMenuItem<String>(
                  value: category,
                  child: Text(category.isEmpty ? "All Categories" : category.toUpperCase()),
                );
              }).toList(),
            ),
          ),
          
          // Country Dropdown
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: DropdownButton<String>(
              value: selectedCountry,
              isExpanded: true,
              onChanged: (String? newValue) {
                setState(() {
                  selectedCountry = newValue!;
                });
              },
              items: countries.map((String country) {
                return DropdownMenuItem<String>(
                  value: country,
                  child: Text(country.isEmpty ? "All Countries" : country.toUpperCase()),
                );
              }).toList(),
            ),
          ),

          // Keyword Input Field
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              decoration: InputDecoration(
                labelText: "Search Keyword (Optional)",
                border: OutlineInputBorder(),
              ),
              onChanged: (value) {
                keyword = value;
              },
            ),
          ),

          // Fetch News Button
          ElevatedButton(
            onPressed: fetchFilteredNews,
            child: Text("Fetch News"),
          ),

          Expanded(
            child: FutureBuilder<List<News>>(
              future: _newsFuture,
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Center(child: CircularProgressIndicator());
                } else if (snapshot.hasError) {
                  return Center(child: Text("Error loading news"));
                } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
                  return Center(child: Text("No news available"));
                }

                List<News> newsList = snapshot.data!;
                return ListView.builder(
                  itemCount: newsList.length,
                  itemBuilder: (context, index) {
                    return NewsTile(news: newsList[index]);
                  },
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
