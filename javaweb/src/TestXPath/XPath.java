package TestXPath;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class XPath {
    public static void main(String[] args) throws XpathSyntaxErrorException, IOException {
        String path = XPath.class.getClassLoader().getResource("students.xml").getPath();
        Document parse = Jsoup.parse(new File(path),"UTF-8");
        JXDocument jxDocument = new JXDocument(parse);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        System.out.println(jxNodes);
        System.out.println("---------------------------------------------");
        List<Object> sel = jxDocument.sel("//student/name");
        System.out.println(sel);
        System.out.println("---------------------------------------------");
        List<JXNode> jxNodes1 = jxDocument.selN("//student[@number=\'heima_0001\']");
        System.out.println(jxNodes1);

    }
}
