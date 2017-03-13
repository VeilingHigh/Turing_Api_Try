package TuringQA;

/**
 * Created by gaojun on 17-3-13.
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class TuringQA
{
    public static void main(String [] args)
    {
        JsonParser parse =new JsonParser();

        while (true){
            String s=get_html();
            JsonObject json=(JsonObject) parse.parse(s);
            System.out.println(json.get("text").getAsString());

        }
    }
    public static String get_request() {
        String key ="e71b7e3082cb4612bdd9c8b9eb6212a3";
        String api="http://www.tuling123.com/openapi/api?key="+key+"&info=";

        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        //nextLine方式接收字符串
        System.out.println("尤里卡：\n");
        // 判断是否还有输入
        if(scan.hasNextLine()){
            String str = scan.nextLine();

            return api+str;
        }
        else
            return "你搞错了！";


    }
    public static String get_html(){
        try
        {

            String request=get_request();
            URL url = new URL(request);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                connection = (HttpURLConnection) urlConnection;
            }
           /* else
            {
                System.out.println("请输入 URL 地址");

            }*/
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;
            while((current = in.readLine()) != null)
            {
                urlString += current;
            }
            return urlString;



        }
        catch(IOException e)
        {
            e.printStackTrace();
            return "解析页面出错";
        }


    }

}

