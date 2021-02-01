package Jsoup.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.net.URL;


public class TestJsoupParse {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");
        //获取Document对象
        Document parse = Jsoup.parse(url,10000);
        //获取Element对象 返回一个arrayList<Element>
        System.out.println(parse);
    }
}
