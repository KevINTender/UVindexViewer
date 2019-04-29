package com.example.user.uvindexviewer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView UVindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UVindex = (TextView) findViewById(R.id.homeUVIndex);
        NewParsing test = new NewParsing();
        test.info = UVindex;
        test.execute();
    }
}
class NewParsing extends AsyncTask<String,String ,String >
{
    public TextView info;
    public String list="";
    public String[] uvIndexValue = new String[4];
    @Override
    protected String doInBackground(String... strings) {
        try
        {
            //info.append("try2");
            Document doc = Jsoup.connect("https://www.weatheronline.co.uk/Belarus/Minsk/UVindex.htm").get();
            //info.append("try3");
            Element table = doc.select("table[class=gr1]").first();

            Iterator<Element> ite = table.select("td[height=38]").iterator();
            int i = 0;
            while(ite.hasNext())
            {
                Element tablerow = ite.next();
                Elements data = tablerow.select("td");
                for (Element link : data) {
                    uvIndexValue[i]=link.text();
                }
                i++;
            }



        }
        catch (Exception e)
        {
            Log.e("PARSING",e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        info.setText(uvIndexValue[0]);
        super.onPostExecute(s);
    }
}

