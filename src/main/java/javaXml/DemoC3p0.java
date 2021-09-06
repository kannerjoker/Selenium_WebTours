package javaXml;

import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.List;

public class DemoC3p0 {
    public static void main(String[] args) throws Exception {
        String url = DemoC3p0.class.getClassLoader().getResource("demoC3p0.xml").getPath();
        Document doc = Jsoup.parse(new File(url),"utf-8");
        Elements eles = doc.getElementsByTag("property");
        int num = 0;
        for(Element e:eles){
            num++;
            System.out.println(num + "------------>\r\n" + e);
        }
        System.out.println("----------JXNode--------------");
        JXDocument jxDocument = new JXDocument(doc);
        List<JXNode> jxNodes = jxDocument.selN("//named-config/property[@name$='er']");
        for (int i = 0; i < jxNodes.size(); i++) {
            System.out.println(i + "------------->");
            System.out.println(jxNodes.get(i));
        }
    }
}
