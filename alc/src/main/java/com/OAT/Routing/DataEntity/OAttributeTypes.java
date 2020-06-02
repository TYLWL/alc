package com.OAT.Routing.DataEntity;
import java.util.*;

public class OAttributeTypes
{		
	public static String AttributeTypeInteger = "Integer";
	public static String AttributeTypeDouble = "Double";
	public static String AttributeTypeString = "String";
	public static String AttributeTypeDate = "Date";
	public static String AttributeTypeBoolean = "boolean";

	/*
	 * this class stores the type of data for each attribute
	 */
	private Hashtable<String,String> _attributeTypes = new Hashtable<String,String>();
		
	public String getType(String attrId)
	{
		return _attributeTypes.get(attrId);
		
	}
	public void addType(String attrId, String type)
	{
		_attributeTypes.put(attrId, type);
	}

}
