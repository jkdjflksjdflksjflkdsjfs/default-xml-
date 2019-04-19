import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.io.*;


public class Window
{
    private ArrayList<DataModel> data;
    private File xml;
    public static JFrame window;
    public JTextArea text_area;
    public static void main(String[] args)
    {
        new Window();
    }
    public String parseRelist1(HashMap<String,ArrayList<DataModel>> list) {
    	String re = new String("        ");
    	Iterator iterator = list.keySet().iterator();
    	while(iterator.hasNext()) {
    		String country = (String) iterator.next();
    		re += "##" + country + "##\n        ";
    		ArrayList<DataModel> list2 = list.get(country);
    		for(DataModel dm : list2) {
    			re += "动漫名称: " + dm.name + "\n                ";
    			re += "导演列表: " + dm.director + "\n                ";
    			re += "声优列表: " + dm.cv + "\n        ";
    		}
    		//re += country + "\n";
    	}
		return  re;
    	
    }
    public String parseRelist2(HashMap<Integer,ArrayList<DataModel>> list) {
    	String re = new String("        ");
    	Iterator iterator = list.keySet().iterator();
    	while(iterator.hasNext()) {
    		Integer score = (Integer) iterator.next();
    		re += "##评分：" + String.valueOf(score) + "##\n        ";
    		ArrayList<DataModel> list2 = list.get(score);
    		for(DataModel dm : list2) {
    			re += "动漫名称: " + dm.name + "\n                ";
    			re += "导演列表: " + dm.director + "\n                ";
    			re += "声优列表: " + dm.cv + "\n        ";
    		}
    		//re += country + "\n";
    	}
		return  re;
    	
    }
    public Window()
    {
    	xml = new File("src/in.xml");
        //data = new ArrayList<DataModel>();
        window = new JFrame();
        window.setTitle("DOM");
        window.setBounds(600, 300, 800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        window.getContentPane().add(panel, BorderLayout.NORTH);
        JButton query3 = new JButton("问题3");
        JButton query4 = new JButton("问题4");
        query3.addActionListener((ActionEvent e)->
        {
        	try {
        		HashMap<String,ArrayList<DataModel>> re = ParseXml.parse3(xml);
        		//System.out.println(parseRelist(re));;
        		//this.text_area.setText("");
        		this.text_area.setText(parseRelist1(re));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        query4.addActionListener((ActionEvent e)->
        {
           	try {
        		HashMap<Integer,ArrayList<DataModel>> re = ParseXml.parse4(xml);
        		//System.out.println(parseRelist(re));;
        		//this.text_area.setText("");
        		this.text_area.setText(parseRelist2(re));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        panel.add(query3);
        panel.add(query4);
        JScrollPane scrollPane = new JScrollPane();
        window.getContentPane().add(scrollPane, BorderLayout.CENTER);
        text_area = new JTextArea();
        scrollPane.setViewportView(text_area);
        text_area.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        window.setVisible(true);
    }
}