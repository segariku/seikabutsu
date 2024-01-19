package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleBooksAPI {
    //書籍検索
    public static bookBean searchISBN(String isbn){
        // APIをURL(リクエスト先)
        String urlString = "https://www.googleapis.com/books/v1/volumes?q=isbn:";


        // リクエストを受け取る変数
        String result = sendAPI(urlString + isbn);


        // JSONからデータを取得
        try {
            JSONObject resultJson = new JSONObject(result); // StringをJSONに変換

            // resultからitemsのデータを取得
            JSONObject items = resultJson.getJSONArray("items").getJSONObject(0);
            // itemsからvolumeInfoのデータを取得
            JSONObject volumeInfo = items.getJSONObject("volumeInfo");


            // titleからデータを取得
            String title = volumeInfo.getString("title");
            String author = volumeInfo.getJSONArray("author").getString(0);
            JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
            String imageUrl= imageLinks.getString("thumbnail");

            return new  bookBean(isbn, title, author, imageUrl);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static String sendAPI(String urlString){
        String result = "";


        try {
            URL url = new URL(urlString); // URL作成
            HttpURLConnection con = (HttpURLConnection) url.openConnection(); // 接続
            con.setRequestMethod("GET"); // GET通信
            con.connect(); // リクエストを送る
            try (
                    InputStream in = con.getInputStream(); // 読込装置
                    InputStreamReader inReader = new InputStreamReader(in, "UTF-8"); //　装置を動かす装置
                    BufferedReader bufferedReader = new BufferedReader(inReader);
            ) {
                String line = null;
                // レスポンスから1行ずつデータを読み込む
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
            }
            con.disconnect(); // 接続切断
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
