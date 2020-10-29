package com.intelliviz.springhttp.controller;;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class HttpController {
    @GetMapping("/data")
    public List<Earthquake> getData() throws IOException {
        return readData(6, 8, "2020-06-01", "2020-06-30");
    }

    @GetMapping("/data/{id}")
    public String getDataById(@PathVariable int id) {
        return "The Data: " + id;
    }

    @DeleteMapping("/data/{id}")
    public String deleteDataById(@PathVariable int id) {
        System.out.println("We are here");
        return "Deleting data: " + id;
    }

    private List<Earthquake> readData(float minMag, float maxMag, String startDate, String endDate) {
        final String baseUrl = "https://earthquake.usgs.gov/fdsnws/event/1/query?";
        final String format = "format=geojson";
        StringBuilder sb = new StringBuilder();
        sb.append(baseUrl);
        sb.append(format);
        sb.append("&starttime=");
        sb.append(startDate);
        sb.append("&endtime=");
        sb.append(endDate);
        sb.append("&minmagnitude=");
        sb.append(Float.toString(minMag));
        sb.append("&maxmagnitude=");
        sb.append(Float.toString(maxMag));
        URL url = null;
        try {
            url = new URL(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        HttpURLConnection conn = null;
        List<Earthquake> earthquakeList = new ArrayList<>();
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return parseJson(earthquakeList, content.toString());
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(conn != null) {
                conn.disconnect();
            }
        }

        return Collections.emptyList();
    }

    /*
        int status = conn.getResponseCode();
        if(status > 299) { // failed
             BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
             String line;
             while((line = reader.readLine()) != null) {
                content.append(line);
             }
             reader.close();
        } else { // success
            // see code above
        }
     */

    private List<Earthquake> parseJson(List<Earthquake> earthquakes, String content) {
        JSONObject jsonObject = new JSONObject(content);
        JSONArray array = jsonObject.getJSONArray("features");

        for(Object obj : array) {
            JSONObject jsonObj = (JSONObject)obj;
            jsonObj = jsonObj.getJSONObject("properties");
            String place = jsonObj.getString("place");
            float mag = jsonObj.getFloat("mag");
            String type = jsonObj.getString("type");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(jsonObj.getLong("time"));
            String dat = df.format(date);
            Earthquake earthquake = new Earthquake(place, type, mag, dat);
            earthquakes.add(earthquake);
        }
        return earthquakes;
    }

    class Earthquake {
        private String place;
        private String type;
        private float mag;
        private String date;

        public Earthquake() {
        }

        public Earthquake(String place, String type, float mag, String date) {
            this.place = place;
            this.type = type;
            this.mag = mag;
            this.date = date;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public float getMag() {
            return mag;
        }

        public void setMag(float mag) {
            this.mag = mag;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
