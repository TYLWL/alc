package com.OAT.Routing.Engine.OptiData;
import java.util.*;

public class EngineTDM {
	private HashMap _engineTM = new HashMap();
	private HashMap _engineDM = new HashMap();
	private int _nonexistValue = 99999999;

	
	public void addT(String key1, String key2, double t)
	{
		HashMap m = (HashMap)_engineTM.get(key1);
		if(m==null)
		{
			m = new HashMap();
			_engineTM.put(key1, m);
		}
		
		m.put(key2, t);
	}
	public void addD(String key1, String key2, double d)
	{
		HashMap m = (HashMap)_engineDM.get(key1);
		if(m==null)
		{
			m = new HashMap();
			_engineDM.put(key1, m);
		}
		m.put(key2, d);
	}
	
	public double getT(String key1, String key2)
	{
		HashMap m = (HashMap)_engineTM.get(key1);
		if(m!=null)
		{
			Double T = (Double)m.get(key2);
			if(T!=null)
			{
				return T.doubleValue();
			}
		}
		
		return _nonexistValue;
	}
	
	public double getD(String key1, String key2)
	{
		HashMap m = (HashMap)_engineDM.get(key1);
		if(m!=null)
		{
			Double D = (Double)m.get(key2);
			if(D!=null)
			{
				return D.doubleValue();
			}
		}
		
		return _nonexistValue;
	}

}