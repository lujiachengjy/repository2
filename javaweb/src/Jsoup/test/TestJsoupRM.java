package Jsoup.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


public class TestJsoupRM {
    public static void main(String[] args) throws IOException {
        String path = TestJsoupRM.class.getClassLoader().getResource("students.xml").getPath();
        //获取Document对象
        Document parse = Jsoup.parse(new File(path),"utf-8");
        //获取Element对象 返回一个arrayList<Element>
        Elements name = parse.getElementsByTag("name");
        System.out.println(name.size());
        for (Element e:name) {
            System.out.println(e.text());
        }
    }
}
