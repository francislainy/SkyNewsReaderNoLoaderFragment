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
        
        String url = "http://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test";

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
                JSONObject responseObject = jsonObject.getJSONObject("response");
                JSONArray jsonArray = responseObject.getJSONArray("results");

                for(int i=0; i<jsonArray.length(); i++) {
                    JSONObject resultObject = jsonArray.getJSONObject(i);
                    String sectionName = resultObject.getString("sectionName");
                    String webTitle = resultObject.getString("webTitle");
                    Log.v("MainActivity.this", webTitle);

                    arrayList.add(new News(sectionName, webTitle));
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

