package com.androidpeople.xml.parsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyXMLHandler extends DefaultHandler {

	Boolean currentElement = false;
	String currentValue = null;
	public static SitesList sitesList = null;

	public static SitesList getSitesList() {
		return sitesList;
	}

	public static void setSitesList(SitesList sitesList) {
		MyXMLHandler.sitesList = sitesList;
	}

	/** Called when tag starts ( ex:- <name>AndroidPeople</name> 
	 * -- <name> )*/
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		currentElement = true;

		if (localName.equals("FlashScreen"))
		{
			/** Start */ 
			sitesList = new SitesList();
		} 

	}

	/** Called when tag closing ( ex:- <name>AndroidPeople</name> 
	 * -- </name> )*/
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		currentElement = false;
		
		System.out.println("into the tag change");

		/** set value */ 
		if (localName.equalsIgnoreCase("imageurl"))
			sitesList.setImageUrl(currentValue);
		else if (localName.equalsIgnoreCase("description"))
			sitesList.setDescription(currentValue);
		else if (localName.equalsIgnoreCase("value"))
			sitesList.setCategory(currentValue);
//		System.out.println("current value"+currentValue);
//		System.out.println("Image URL:"+sitesList.getImageUrl());
//		System.out.println("Image Descrption:"+sitesList.getDescription());
//		System.out.println("category array:"+sitesList.getCategory());
	}

	/** Called to get tag characters ( ex:- <name>AndroidPeople</name> 
	 * -- to get AndroidPeople Character ) */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (currentElement) {
			currentValue = new String(ch, start, length);
			currentElement = false;
		}

	}

}
