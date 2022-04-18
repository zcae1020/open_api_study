package data.api.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiJson {
    public static void main(String[] args) {
        BufferedReader br = null;

        try{
            String urlStr = "http://apis.data.go.kr/3740000/suwonEvChrstn/getdatalist?serviceKey=033N%2Fclu5wO9iSA%2FIwTkOaXO4zp3MQ707sWmnYC6E2dPjkqGSmna1XHJYB5gCfIXeq4vMf7l8z64kckLQ3xSoA%3D%3D&numOfRows=10&pageNo=0&sortKey=chrstnType&filterKey=chrstnType&filterValues=DC%EC%BD%A4%EB%B3%B4&type=Json";

            URL url = new URL(urlStr);

            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.setRequestProperty("Context-type", "application/data.api.json");
            System.out.println(urlConn.getResponseCode());

            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            System.out.println(stringBuilder.toString());

            br.close();
            urlConn.disconnect();
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}