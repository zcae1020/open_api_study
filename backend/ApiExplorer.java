/* Java 1.8 샘플 코드 */
package data.api.json;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/3740000/suwonEvChrstn/getdatalist"); /*URL*/

        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=033N%2Fclu5wO9iSA%2FIwTkOaXO4zp3MQ707sWmnYC6E2dPjkqGSmna1XHJYB5gCfIXeq4vMf7l8z64kckLQ3xSoA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*기본값은 10.*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("sortKey","UTF-8") + "=" + URLEncoder.encode("chrstnType", "UTF-8")); /*항목명 (오름차순)*/
        urlBuilder.append("&" + URLEncoder.encode("filterKey","UTF-8") + "=" + URLEncoder.encode("chrstnType", "UTF-8")); /*검색할 필드명. 여러 번 지정할 수 있으며 and 조건으로 검색함*/
        urlBuilder.append("&" + URLEncoder.encode("filterValues","UTF-8") + "=" + URLEncoder.encode("DC콤보", "UTF-8")); /*검색할 필드값. 여러 번 지정할 수 있으며 한 필드에 대해 여러 값을 세미콜론(;)으로 구별해 지정할 수 있음 */
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("Json", "UTF-8")); /*데이터 호출 타입 설정. Json 또는 xml 호출 가능*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}