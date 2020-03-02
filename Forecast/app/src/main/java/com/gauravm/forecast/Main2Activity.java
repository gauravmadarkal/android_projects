package com.gauravm.forecast;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.pavlospt.CircleView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;


    private TextView cityCountry;

    private TextView currentDate;

    private ImageView weatherImage;

    private CircleView circleTitle;

    private TextView windResult;

    private TextView humidityResult;
    String cityName;
    TextView tvResult;

    String dummyAppid = "e0da7f01268a92248eceacac23425445";
    String queryWeather = "http://api.openweathermap.org/data/2.5/weather?q=";
    String queryDummyKey = "&appid=" + dummyAppid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        cityCountry = (TextView) findViewById(R.id.city_country);
        currentDate = (TextView) findViewById(R.id.current_date);
        weatherImage = (ImageView) findViewById(R.id.weather_icon);
        circleTitle = (CircleView) findViewById(R.id.weather_result);
        windResult = (TextView) findViewById(R.id.wind_result);
        humidityResult = (TextView) findViewById(R.id.humidity_result);

    }

    private class OpenWeatherMapTask extends AsyncTask<Void,Void,String> {


        TextView tvResult;

        String dummyAppid = "e0da7f01268a92248eceacac23425445";
        String queryWeather = "http://api.openweathermap.org/data/2.5/weather?q=";
        String queryDummyKey = "&appid=" + dummyAppid;
        Intent intent = getIntent();
        String cityname = intent.getStringExtra("cityname");

        @Override
        protected String doInBackground(Void... params) {
            String result="";
            String queryReturn;

            String query = null;
            try {
                query = queryWeather + URLEncoder.encode(cityname, "UTF-8") + queryDummyKey;
                queryReturn = sendQuery(query);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                queryReturn = e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                queryReturn = e.getMessage();
            }


            final String finalQueryReturn = query + "\n\n" + queryReturn;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });

            return result;

        }

        @Override
        protected void onPostExecute(String s) {
            tvResult.setText(s);
        }

        private String sendQuery(String query) throws IOException {
            String result = "";

            URL searchURL = new URL(query);

            HttpURLConnection httpURLConnection = (HttpURLConnection) searchURL.openConnection();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(
                        inputStreamReader,
                        8192);

                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
            }

            return result;
        }

        private void ParseJSON(String json) {

            String todayDate = getTodayDateInStringFormat();
            cityCountry.setText(cityname);
            currentDate.setText(Html.fromHtml(todayDate));
            try {
                JSONObject JsonObject = new JSONObject(json);
                String cod = jsonHelperGetString(JsonObject, "cod");

                if (cod != null) {
                    if (cod.equals("200")) {



                        JSONArray weather = jsonHelperGetJSONArray(JsonObject, "weather");
                        if (weather != null) {
                            for (int i = 0; i < weather.length(); i++) {
                                JSONObject thisWeather = weather.getJSONObject(i);

                                String weatherdesc= jsonHelperGetString(thisWeather, "description");
                                circleTitle.setSubtitleText(weatherdesc);
                            }
                        }

                        JSONObject main = jsonHelperGetJSONObject(JsonObject, "main");
                        if (main != null) {

                            String temp = jsonHelperGetString(main, "temp");
                            double temparature = Double.parseDouble(temp);
                            temparature = temparature - 273.15;
                            String tempdetails= "" + temparature + "`C";
                            circleTitle.setTitleText(tempdetails);



                           String humidity= jsonHelperGetString(main, "humidity") + "%";
                            humidityResult.setText(humidity);
                        }


                        JSONObject wind = jsonHelperGetJSONObject(JsonObject, "wind");
                        if (wind != null) {
                            String windSpeed=jsonHelperGetString(wind, "speed") + "m/s" + "\n";
                            windResult.setText(windSpeed);

                        }

                        //...incompleted

                    } else if (cod.equals("404")) {
                        String message = jsonHelperGetString(JsonObject, "message");

                    }
                } else {
                    jsonResult += "cod == null\n";
                }

            } catch (JSONException e) {
                e.printStackTrace();

            }


        }
        private String getTodayDateInStringFormat(){
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("E, d MMMM", Locale.getDefault());
            return df.format(c.getTime());
        }

        private String jsonHelperGetString(JSONObject obj, String k) {
            String v = null;
            try {
                v = obj.getString(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return v;
        }

        private JSONObject jsonHelperGetJSONObject(JSONObject obj, String k) {
            JSONObject o = null;

            try {
                o = obj.getJSONObject(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return o;
        }

        private JSONArray jsonHelperGetJSONArray(JSONObject obj, String k) {
            JSONArray a = null;

            try {
                a = obj.getJSONArray(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return a;
        }
    }
}
