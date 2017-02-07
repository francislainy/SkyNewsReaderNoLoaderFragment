package com.example.android.newsreader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView idTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://newsapi.org/v1/articles?source=sky-news&sortBy=top&apiKey=956bea4d81884c1a94dbc84f344c9e43";

        NewsTask newsTask = new NewsTask();
        newsTask.execute(url);
    }

    private class NewsTask extends AsyncTask<String, Void, ArrayList<News>> {


        String url = "";

        @Override
        protected ArrayList<News> doInBackground(String... urls) {
            ArrayList<News> arrayList = new ArrayList<>();
            String jsonResponse = HttpUtil.makeHttpRequest(urls[0]);

            try {
                JSONObject jsonObject = new JSONObject(jsonResponse);
                JSONArray jsonArray = jsonObject.getJSONArray("articles");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject resultObject = jsonArray.getJSONObject(i);
                    String title = resultObject.getString("title");
                    String description = resultObject.getString("description");
                    String imageUrl = resultObject.getString("urlToImage");
                    Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());

//                    arrayList.add(new News(title, description));

                    arrayList.add(new News(title, description, bitmap));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return arrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<News> arrayList) {

            NewsAdapter itemsAdapter = new NewsAdapter(MainActivity.this, arrayList);
            ListView listView = (ListView) findViewById(R.id.list_item);
            listView.setAdapter(itemsAdapter);

        }
    }
}