package com.bjzh.ws.bookclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.xfire.client.Client;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class BookClient {
	private static Map<String, String> map = new HashMap<String, String>();

	// 动态客户端第2种访问方式
	public static void testClient2() throws MalformedURLException, Exception {
		Client client = new Client(new URL("http://localhost:8080/ws/book.ws?wsdl"));
		Object[] results2 = client.invoke("getBookById", new Object[] { 1 });
		// 返回对象解析
		Document xmlTree = (Document) results2[0];
		Element root = xmlTree.getDocumentElement();
		parseElement(root);
		
		System.out.println(map);
	}

	/**
	 * 解析返回树
	 * 
	 * @param root
	 */
	private static void parseElement(Element root) {
		String key = root.getNodeName();
		NodeList list = root.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node instanceof Element) {
				Element e = (Element) node;
				parseElement(e);
			} else if (node instanceof Text) {
				Text t = (Text) node;
				map .put(key, t.getNodeValue());
			}
		}
	}

	public static void main(String[] args) throws MalformedURLException,Exception {
		testClient2();
	}
}
