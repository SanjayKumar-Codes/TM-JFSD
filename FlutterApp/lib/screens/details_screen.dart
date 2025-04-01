import 'package:flutter/material.dart';
import '../models/news_model.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:provider/provider.dart';
import '../providers/news_provider.dart';

class DetailsScreen extends StatelessWidget {
  final News news;

  const DetailsScreen({Key? key, required this.news}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var newsProvider = Provider.of<NewsProvider>(context);

    return Scaffold(
      appBar: AppBar(
        title: Text("News Details"),
        actions: [
          IconButton(
            icon: Icon(
              newsProvider.isSaved(news) ? Icons.bookmark : Icons.bookmark_border,
              color: newsProvider.isSaved(news) ? Colors.red : null,
            ),
            onPressed: () {
              newsProvider.toggleSaveNews(news);
            },
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            if (news.imageUrl != null)
              Image.network(news.imageUrl!, height: 200, width: double.infinity, fit: BoxFit.cover),
            SizedBox(height: 10),
            Text(news.title, style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
            SizedBox(height: 10),
            Text(news.description, style: TextStyle(fontSize: 16)),
            SizedBox(height: 20),
            Center(
              child: ElevatedButton(
                onPressed: () async {
                  if (await canLaunch(news.url)) {
                    await launch(news.url);
                  } else {
                    ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Could not open the news link")));
                  }
                },
                child: Text("Read More"),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
