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

        String url = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":9425,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":943,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"society/2016/dec/26/care-funding-crisis-needs-national-debate\",\"type\":\"article\",\"sectionId\":\"society\",\"sectionName\":\"Society\",\"webPublicationDate\":\"2016-12-26T17:01:14Z\",\"webTitle\":\"Care funding crisis needs national debate | Letters\",\"webUrl\":\"https://www.theguardian.com/society/2016/dec/26/care-funding-crisis-needs-national-debate\",\"apiUrl\":\"https://content.guardianapis.com/society/2016/dec/26/care-funding-crisis-needs-national-debate\",\"isHosted\":false},{\"id\":\"politics/blog/live/2017/jan/31/article-50-debate-brexit-government-lying-about-how-easy-brexit-will-be-says-owen-smith-politics-live\",\"type\":\"liveblog\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2017-02-01T00:18:03Z\",\"webTitle\":\"Brexit: MPs debate article 50 bill - as it happened\",\"webUrl\":\"https://www.theguardian.com/politics/blog/live/2017/jan/31/article-50-debate-brexit-government-lying-about-how-easy-brexit-will-be-says-owen-smith-politics-live\",\"apiUrl\":\"https://content.guardianapis.com/politics/blog/live/2017/jan/31/article-50-debate-brexit-government-lying-about-how-easy-brexit-will-be-says-owen-smith-politics-live\",\"isHosted\":false},{\"id\":\"politics/2017/jan/31/a-ludicrous-farce-readers-on-parliaments-brexit-debate\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2017-01-31T17:35:31Z\",\"webTitle\":\"'A ludicrous farce': readers on parliament's Brexit debate\",\"webUrl\":\"https://www.theguardian.com/politics/2017/jan/31/a-ludicrous-farce-readers-on-parliaments-brexit-debate\",\"apiUrl\":\"https://content.guardianapis.com/politics/2017/jan/31/a-ludicrous-farce-readers-on-parliaments-brexit-debate\",\"isHosted\":false},{\"id\":\"us-news/2017/jan/30/boris-johnson-to-face-mps-over-uk-exemptions-to-us-travel-ban\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2017-01-30T10:29:14Z\",\"webTitle\":\"MPs call for emergency Commons debate about Trump's travel ban\",\"webUrl\":\"https://www.theguardian.com/us-news/2017/jan/30/boris-johnson-to-face-mps-over-uk-exemptions-to-us-travel-ban\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2017/jan/30/boris-johnson-to-face-mps-over-uk-exemptions-to-us-travel-ban\",\"isHosted\":false},{\"id\":\"politics/2017/jan/31/parliament-debate-donald-trump-state-visit-16m-sign-petition\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2017-01-31T16:23:38Z\",\"webTitle\":\"Parliament to debate Trump state visit after 1.6m sign petition\",\"webUrl\":\"https://www.theguardian.com/politics/2017/jan/31/parliament-debate-donald-trump-state-visit-16m-sign-petition\",\"apiUrl\":\"https://content.guardianapis.com/politics/2017/jan/31/parliament-debate-donald-trump-state-visit-16m-sign-petition\",\"isHosted\":false},{\"id\":\"commentisfree/2017/jan/30/the-guardian-view-on-the-brexit-debate-listen-mrs-may\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2017-01-30T19:08:56Z\",\"webTitle\":\"The Guardian view on the Brexit debate: listen, Mrs May | Editorial\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2017/jan/30/the-guardian-view-on-the-brexit-debate-listen-mrs-may\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2017/jan/30/the-guardian-view-on-the-brexit-debate-listen-mrs-may\",\"isHosted\":false},{\"id\":\"money/2017/jan/12/saints-and-sinners-in-the-pay-cap-debate\",\"type\":\"article\",\"sectionId\":\"money\",\"sectionName\":\"Money\",\"webPublicationDate\":\"2017-01-12T19:21:02Z\",\"webTitle\":\"Saints and sinners in the pay cap debate | Letters\",\"webUrl\":\"https://www.theguardian.com/money/2017/jan/12/saints-and-sinners-in-the-pay-cap-debate\",\"apiUrl\":\"https://content.guardianapis.com/money/2017/jan/12/saints-and-sinners-in-the-pay-cap-debate\",\"isHosted\":false},{\"id\":\"politics/2017/jan/09/keir-starmer-commons-debate-victims-law-labour\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2017-01-09T19:36:10Z\",\"webTitle\":\"Keir Starmer gagged in Commons debate on victims' law\",\"webUrl\":\"https://www.theguardian.com/politics/2017/jan/09/keir-starmer-commons-debate-victims-law-labour\",\"apiUrl\":\"https://content.guardianapis.com/politics/2017/jan/09/keir-starmer-commons-debate-victims-law-labour\",\"isHosted\":false},{\"id\":\"uk-news/2017/jan/13/opportunity-or-threat-stonehenge-tunnel-plan-revives-long-running-debate\",\"type\":\"article\",\"sectionId\":\"uk-news\",\"sectionName\":\"UK news\",\"webPublicationDate\":\"2017-01-13T16:52:13Z\",\"webTitle\":\"Opportunity or threat? Stonehenge tunnel plan revives long-running debate\",\"webUrl\":\"https://www.theguardian.com/uk-news/2017/jan/13/opportunity-or-threat-stonehenge-tunnel-plan-revives-long-running-debate\",\"apiUrl\":\"https://content.guardianapis.com/uk-news/2017/jan/13/opportunity-or-threat-stonehenge-tunnel-plan-revives-long-running-debate\",\"isHosted\":false},{\"id\":\"uk-news/2016/dec/21/andy-burnham-and-labours-position-in-the-immigration-debate\",\"type\":\"article\",\"sectionId\":\"uk-news\",\"sectionName\":\"UK news\",\"webPublicationDate\":\"2016-12-21T18:27:18Z\",\"webTitle\":\"Andy Burnham and Labour’s position in the immigration debate | Letters\",\"webUrl\":\"https://www.theguardian.com/uk-news/2016/dec/21/andy-burnham-and-labours-position-in-the-immigration-debate\",\"apiUrl\":\"https://content.guardianapis.com/uk-news/2016/dec/21/andy-burnham-and-labours-position-in-the-immigration-debate\",\"isHosted\":false}]}}";

        idTextView = (TextView) findViewById(R.id.webTitle_text_view);

        NewsTask newsTask = new NewsTask();
        newsTask.execute(url);
    }

    private class NewsTask extends AsyncTask<String, Void, ArrayList<News>> {

        @Override
        protected ArrayList<News> doInBackground(String... urls) {

            ArrayList<News> arrayList = new ArrayList<>();

            String jsonResponse = "";
            try {
                JSONObject jsonObject = new JSONObject(urls[0]);
                JSONObject responseObject = jsonObject.getJSONObject("response");
                JSONArray jsonArray = responseObject.getJSONArray("results");

                for(int i=0; i<jsonArray.length(); i++) {
                    JSONObject resultObject = jsonArray.getJSONObject(i);
                    String sectionName = resultObject.getString("sectionName");
                    String webTitle = resultObject.getString("webTitle");
                    Log.v("MainActivity.this", webTitle);
                    jsonResponse = webTitle;

                    arrayList.add(new News(sectionName, webTitle));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return arrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<News> list) {

            NewsAdapter itemsAdapter = new NewsAdapter(MainActivity.this, list);
            ListView listView = (ListView) findViewById(R.id.list_item);
            listView.setAdapter(itemsAdapter);

            //idTextView.setText(s);
            //Log.v("MainActivity.this", s);
            //super.onPostExecute(s);
        }
    }
}

