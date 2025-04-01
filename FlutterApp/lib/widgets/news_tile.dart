import 'package:flutter/material.dart';
import '../models/news_model.dart';
import '../screens/details_screen.dart';
import 'package:provider/provider.dart';
import '../providers/news_provider.dart';

class NewsTile extends StatelessWidget {
  final News news;

  const NewsTile({Key? key, required this.news}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var newsProvider = Provider.of<NewsProvider>(context);

    return Card(
      margin: EdgeInsets.symmetric(horizontal: 10, vertical: 5),
      child: ListTile(
        leading: news.imageUrl != null
            ? Image.network(news.imageUrl!, width: 80, fit: BoxFit.cover)
            : Icon(Icons.image_not_supported, size: 50),
        title: Text(news.title, maxLines: 2, overflow: TextOverflow.ellipsis),
        trailing: IconButton(
          icon: Icon(
            newsProvider.isSaved(news) ? Icons.bookmark : Icons.bookmark_border,
            color: newsProvider.isSaved(news) ? Colors.red : null,
          ),
          onPressed: () {
            newsProvider.toggleSaveNews(news);
          },
        ),
        onTap: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => DetailsScreen(news: news)),
          );
        },
      ),
    );
  }
}
