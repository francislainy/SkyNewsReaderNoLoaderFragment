package com.example.android.newsreader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private class NewsTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            return HttpUtil.makeHttpRequest(urls[0]);
        }

        @Override
        protected void onPostExecute(String jsonResponse) {

            ArrayList<News> arrayList = new ArrayList<>();

            try {
                JSONObject jsonObject = new JSONObject(jsonResponse);
                JSONArray jsonArray = jsonObject.getJSONArray("articles");

                if (jsonArray != null) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject resultObject = jsonArray.getJSONObject(i);
                        String title = resultObject.getString("title");
                        String description = resultObject.getString("description");
                        Log.v("MainActivity.this", title);

                        arrayList.add(new News(title, description));
                    }
                }
                else {
                    Log.v("MainActivity.this","Json array null");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            NewsAdapter itemsAdapter = new NewsAdapter(MainActivity.this, arrayList);
            ListView listView = (ListView) findViewById(R.id.list_item);
            listView.setAdapter(itemsAdapter);

        }
    }
}