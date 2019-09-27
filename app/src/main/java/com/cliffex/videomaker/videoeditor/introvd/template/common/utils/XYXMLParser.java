package com.introvd.template.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XYXMLParser {
    private Document ciT = null;

    /* renamed from: a */
    private boolean m14571a(Node node, String[] strArr) {
        boolean z = false;
        for (int length = strArr.length - 2; length >= 0; length--) {
            node = node.getParentNode();
            if (node == null || !strArr[length].endsWith(node.getNodeName())) {
                return false;
            }
            z = true;
        }
        return z;
    }

    /* renamed from: ac */
    private String m14572ac(String str, String str2) {
        String trim = str.trim();
        int length = trim.length();
        int i = trim.startsWith(str2) ? 1 : 0;
        if (trim.endsWith(str2)) {
            length--;
        }
        return trim.substring(i, length);
    }

    public ArrayList<String> getAttributeValue(String str, String str2) {
        if (str == null || this.ciT == null) {
            return null;
        }
        String[] split = m14572ac(str, "/").split("/");
        if (split.length < 2) {
            return null;
        }
        Element documentElement = this.ciT.getDocumentElement();
        ArrayList<String> arrayList = new ArrayList<>();
        NodeList elementsByTagName = documentElement.getElementsByTagName(split[split.length - 1]);
        int length = elementsByTagName.getLength();
        for (int i = 0; i < length; i++) {
            Element element = (Element) elementsByTagName.item(i);
            if (m14571a(element, split)) {
                String attribute = element.getAttribute(str2);
                if (attribute != null) {
                    arrayList.add(attribute);
                }
            }
        }
        return arrayList;
    }

    public boolean parserXmlEx(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }
        try {
            this.ciT = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
            return true;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (SAXException e3) {
            e3.printStackTrace();
            return false;
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public boolean parserXmlEx(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                if (!parserXmlEx((InputStream) fileInputStream)) {
                    try {
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
