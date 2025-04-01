import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../models/news_model.dart';
import '../screens/details_screen.dart';

class SavedNewsScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Saved News")),
      body: StreamBuilder<QuerySnapshot>(
        stream: FirebaseFirestore.instance.collection("saved_news").snapshots(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          } else if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return Center(child: Text("No saved news yet."));
          }

          var savedNewsList = snapshot.data!.docs.map((doc) {
            return News(
              title: doc["title"],
              description: doc["description"],
              imageUrl: doc["imageUrl"],
              url: doc["url"],
            );
          }).toList();

          return ListView.builder(
            itemCount: savedNewsList.length,
            itemBuilder: (context, index) {
              var news = savedNewsList[index];
              return ListTile(
                leading: news.imageUrl != null
                    ? Image.network(news.imageUrl!, width: 80, fit: BoxFit.cover)
                    : Icon(Icons.image_not_supported, size: 50),
                title: Text(news.title, maxLines: 2, overflow: TextOverflow.ellipsis),
                trailing: IconButton(
                  icon: Icon(Icons.delete, color: Colors.red),
                  onPressed: () {
                    FirebaseFirestore.instance
                        .collection("saved_news")
                        .where("url", isEqualTo: news.url)
                        .get()
                        .then((snapshot) {
                      for (var doc in snapshot.docs) {
                        doc.reference.delete();
                      }
                    });
                  },
                ),
                onTap: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => DetailsScreen(news: news)),
                  );
                },
              );
            },
          );
        },
      ),
    );
  }
}
