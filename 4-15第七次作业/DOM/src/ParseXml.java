import java.io.File;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseXml {
    static public HashMap<String,ArrayList<DataModel>> 
    	parse3(File xmlFile)throws Exception
    {
    	HashMap<String,ArrayList<DataModel>> relist = new HashMap<>(); 
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	Document document = builder.parse(xmlFile);
    	Element root = document.getDocumentElement();
    	NodeList list = root.getElementsByTagName("cartoon");
    	System.out.println(list.getLength());
    	for(int i=0;i<list.getLength();++i) {
    		if(list.item(i).getNodeType() == Node.ELEMENT_NODE){
    			Element n = (Element)list.item(i);
        		NodeList each_list = n.getChildNodes();
        		DataModel dModel = new DataModel();
        		String country = new String();
        		for(int j=0;j<each_list.getLength();++j) {
        			if(each_list.item(j).getNodeType() == Node.ELEMENT_NODE){
        				Element m = (Element)each_list.item(j);
            			if(m.getNodeName().equals("name") )
            				dModel.name = m.getTextContent();
            			if(m.getNodeName().equals("made_info"))
            			{
            				NodeList ll = m.getChildNodes();
            				for(int x=0;x<ll.getLength();++x) {
            					if(ll.item(x).getNodeType() == Node.ELEMENT_NODE){
            						Element element = (Element)ll.item(x);
                					if(element.getNodeName().equals("director"))
                						dModel.director = element.getTextContent();
                					if(element.getNodeName().equals("dubbingor"))
                						dModel.cv = element.getTextContent();
            					}	
            				}
            			}
            			if(m.getNodeName().equals("country")) {
            				country = m.getTextContent();
            			}
        			}	
        		}
        		if(!relist.containsKey(country))
        			relist.put(country, new ArrayList<>());
        		relist.get(country).add(dModel);
    		}
    	}
    	return relist;	
    }
    static public HashMap<Integer,ArrayList<DataModel>> parse4(File xmlFile)throws Exception
    {
    	HashMap<Integer,ArrayList<DataModel>> relist = new HashMap<>(); 
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	Document document = builder.parse(xmlFile);
    	Element root = document.getDocumentElement();
    	NodeList list = root.getElementsByTagName("cartoon");
    	System.out.println(list.getLength());
    	for(int i=0;i<list.getLength();++i) {
    		if(list.item(i).getNodeType() == Node.ELEMENT_NODE){
    			Element n = (Element)list.item(i);
        		NodeList each_list = n.getChildNodes();
        		DataModel dModel = new DataModel();
        		Integer score = 0;
        		for(int j=0;j<each_list.getLength();++j) {
        			if(each_list.item(j).getNodeType() == Node.ELEMENT_NODE){
        				Element m = (Element)each_list.item(j);
            			if(m.getNodeName().equals("name") )
            				dModel.name = m.getTextContent();
            			if(m.getNodeName().equals("made_info"))
            			{
            				NodeList ll = m.getChildNodes();
            				for(int x=0;x<ll.getLength();++x) {
            					if(ll.item(x).getNodeType() == Node.ELEMENT_NODE){
            						Element element = (Element)ll.item(x);
                					if(element.getNodeName().equals("director"))
                						dModel.director = element.getTextContent();
                					if(element.getNodeName().equals("dubbingor"))
                						dModel.cv = element.getTextContent();
            					}	
            				}
            			}
            			if(m.getNodeName().equals("comments")) {
            				double db = Double.parseDouble(m.getAttribute("score"));
            				score = (int) db;
            			}
        			}	
        		}
        		if(!relist.containsKey(score))
        			relist.put(score, new ArrayList<>());
        		relist.get(score).add(dModel);
    		}
    	}
    	return relist;	
    }
}
