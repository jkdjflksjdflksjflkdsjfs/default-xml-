import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.io.*;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;


public class Window 
{
	private ArrayList<DataModel> data;
	private File f1, f2, f3, qs;
	public static JFrame window;
	
	public JTextArea text_area;
	public static void main(String[] args)
	{
		new Window();
	}
	public Window() 
	{
		data = new ArrayList<DataModel>();
		window = new JFrame();
		window.setTitle("SAX");
		window.setBounds(600, 300, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		window.getContentPane().add(panel, BorderLayout.NORTH);
		JButton file_1 = new JButton("选择文件1");
		JButton file_2 = new JButton("选择文件2");
		JButton file_3 = new JButton("选择文件3");
		JButton query_script = new JButton("选择查询脚本文件");
		JButton query = new JButton("查询");
		file_1.addActionListener((ActionEvent e)->
		{
			JFileChooser jfc = new JFileChooser();
			jfc.showSaveDialog(window);
			f1 = jfc.getSelectedFile();
		});
		file_2.addActionListener((ActionEvent e)->
		{
			JFileChooser jfc = new JFileChooser();
			jfc.showSaveDialog(window);
			f2 = jfc.getSelectedFile();
		});
		file_3.addActionListener((ActionEvent e)->
		{
			JFileChooser jfc = new JFileChooser();
			jfc.showSaveDialog(window);
			f3 = jfc.getSelectedFile();
		});
		query_script.addActionListener((ActionEvent e)->
		{
			JFileChooser jfc = new JFileChooser();
			jfc.showSaveDialog(window);
			qs = jfc.getSelectedFile();
		});
		query.addActionListener((ActionEvent e)->
		{
			text_area.setText(null);
			data.clear();
			try
			{
				SAXParserFactory factory = SAXParserFactory.newInstance();
				factory.setValidating(false);
				SAXParser sax_parser = factory.newSAXParser();
				DefaultHandler handler = new DefaultHandler()
				{
					public StringBuilder buffer = new StringBuilder();
					public DataModel data_unit;
					public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
					{
						buffer.setLength(0);
						switch(qName)
						{
						case "cartoon":
							data_unit=new DataModel();
							break;
						case "serials":
							data_unit.series = Integer.parseInt(attributes.getValue("nums"));
							break;
						case "comments":
							data_unit.rating = Float.parseFloat(attributes.getValue("score"));
						}
					}
					public void endElement(String uri, String localName, String qName) throws SAXException 
					{
						String context = buffer.toString();
						switch(qName)
						{
						case "cartoon":
							data.add(data_unit);
							break;
						case "name":
							data_unit.name = context;
							break;
						case "director":
							data_unit.director = context;
							break;
						case "dubbingor":
							data_unit.vocal = context;
							break;
						case "context":
							data_unit.intro = context;
							break;
						}
					}
					public void characters(char ch[], int start, int length) throws SAXException
					{
						buffer.append(ch,start,length);
					}
				};
				QueryScript script = new QueryScript();
				if(qs != null)
				{					
					try(BufferedReader script_reader = new BufferedReader(new FileReader(qs)))
					{
						script.name_contains = script_reader.readLine();
						script.director_contains = script_reader.readLine();
						script.vocal_contains = script_reader.readLine();
						script.intro_contains = script_reader.readLine();
						script.series_geq = Integer.parseInt(script_reader.readLine());
						script.series_leq = Integer.parseInt(script_reader.readLine());
						script.rating_geq = Float.parseFloat(script_reader.readLine());
						script.rating_leq = Float.parseFloat(script_reader.readLine());
						
						script.name_r = Integer.parseInt(script_reader.readLine());
						script.director_r = Integer.parseInt(script_reader.readLine());
						script.vocal_r = Integer.parseInt(script_reader.readLine());
						script.intro_r = Integer.parseInt(script_reader.readLine());
						script.series_r = Integer.parseInt(script_reader.readLine());
						script.rating_r = Integer.parseInt(script_reader.readLine());
					}
				}
				if(f1 != null)
				{
					sax_parser.parse(f1, handler);
				}
				if(f2 != null)
				{
					sax_parser.parse(f2, handler);					
				}
				if(f3 != null)
				{					
					sax_parser.parse(f3, handler);
				}
				data.removeIf(script);
				data.sort(script);
				for(DataModel it : data)
				{
					text_area.append
					(
						"动漫名:" + it.name + "\n" +
						"导演:" + it.director + "\n" +
						"声优:" + it.vocal + "\n" +
						"集数:" + it.series + "\n" +
						"评分:" + it.rating + "/10\n" + 
						"简介:" + it.intro + "\n" + 
						"\n"
					);
				}
			}
			catch (SAXException | IOException | ParserConfigurationException e1) 
			{
				
				e1.printStackTrace();
			}
			
		});
		panel.add(file_1);
		panel.add(file_2);
		panel.add(file_3);
		panel.add(query_script);
		panel.add(query);
		JScrollPane scrollPane = new JScrollPane();
		window.getContentPane().add(scrollPane, BorderLayout.CENTER);
		text_area = new JTextArea();
		scrollPane.setViewportView(text_area);
		window.setVisible(true);
	}
}