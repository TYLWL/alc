package com.OAT.Routing.DataEntity.Attribute;
import java.util.*;

public class OAttribueTypes 
{		
	public static String AttributeTypeInteger = "Integer";
	public static String AttributeTypeDouble = "Double";
	public static String AttributeTypeString = "String";
		
		/*
		 * this class stores the type of data for each attribute
		 */
	private Hashtable<String,String> _attribueTypes = new Hashtable();
		
	public String getType(String attrId)
	{
		return _attribueTypes.get(attrId);
		
	}
	public void addType(String attrId, String type)
	{
		_attribueTypes.put(attrId, type);
	}
	
	public String getType(String attrId, String productId)
	{
		return _attribueTypes.get(attrId+"/"+productId);
		
	}
	public void addType(String attrId, String productId, String type)
	{
		_attribueTypes.put(attrId+"/"+productId, type);
	}


}
