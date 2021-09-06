package javaXml;

import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

import java.io.File;
import java.util.List;

public class DemoXml {
    public static void main(String[] args) throws Exception {
        DemoXml dx = new DemoXml();
//        dx.getElementById();
//        dx.getElementsByTag();
//        dx.getElementsByAttribute();
//        dx.getElementsByAttributeValue();
//        dx.getElementsBySelector();
        dx.getElementsByXpath();
    }
    public Element getElementById() throws Exception{
        String file = this.getClass().getClassLoader().getResource("demoXml.xml").getPath();
        Document doc = Jsoup.parse(new File(file),"utf-8");
        Element ele = doc.getElementById("u1");
        System.out.println(ele.html());
        return ele;
    }
    public Elements getElementsByTag() throws Exception{
        String file = this.getClass().getClassLoader().getResource("demoXml.xml").getPath();
        Document doc = Jsoup.parse(new File(file),"utf-8");
        Elements eles = doc.getElementsByTag("name");
        for (int i = 0; i < eles.size(); i++) {
            System.out.println(i + ":");
            System.out.println(eles.get(i).text());
            System.out.println("-------------");
        }
        return eles;
    }
    public Elements getElementsByAttribute() throws Exception{
        String file = this.getClass().getClassLoader().getResource("student.xml").getFile();
        Document doc = Jsoup.parse(new File(file),"utf-8");
        Elements eles = doc.getElementsByAttribute("number");
        int num = 0;
        for (Element ele : eles) {
            System.out.println(num + ":");
            System.out.println(ele.html());
            System.out.println("-------------");
            num++;
        }
        return eles;
    }
    public Elements getElementsByAttributeValue() throws Exception{
        String file = this.getClass().getClassLoader().getResource("DemoXml.xml").getFile();
        Document doc = Jsoup.parse(new File(file),"utf-8");
        Elements eles = doc.getElementsByAttributeValue("id","u1");
        for (int i = 0; i < eles.size(); i++) {
            System.out.println(i + ":");
            System.out.println(eles.get(i).text());
            System.out.println("-----------------");
        }
        return eles;
    }
    public Elements getElementsBySelector() throws Exception{
        String file = this.getClass().getClassLoader().getResource("demoXml.xml").getPath();
        Document doc = Jsoup.parse(new File(file), "utf-8");
        Elements eles = doc.select("users user:nth-child(1)");
        int num = 0;
        for (Element ele : eles) {
            System.out.println(num + ":");
            ++num;
            System.out.println(ele.html());
            System.out.println("-------------");
        }
        return eles;
    }
    public List<JXNode> getElementsByXpath() throws Exception{
        String file = this.getClass().getClassLoader().getResource("demoXml.xml").getPath();
        Document doc = Jsoup.parse(new File(file),"utf-8");
        JXDocument jxDocument = new JXDocument(doc);
//        性对路径用"//",不仅是开头,中间有省略路径的情况也可以用"//"
        List<JXNode> jxNodes = jxDocument.selN("//users//name");    //"/users/user/name"
        int num = 0;
        for(JXNode jn:jxNodes){
            System.out.println(num + ":");
            num++;
            System.out.println(jn);
            System.out.println("------------");
        }
        return jxNodes;
    }
}
