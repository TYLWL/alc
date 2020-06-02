package com.OAT.Routing.Engine.OptiData;

import java.util.*;
import com.OAT.Routing.DataEntity.*;

public class EngineOrder {
	private OLocation _representingLocation;

	private HashSet  _rawOrders= new HashSet();
	private HashMap<DailyOrder, Double> _orderQuantityIncluded= new HashMap();
	
	private double _totalQuantity=0;
	
	
	public int getNumOrders() {return _rawOrders.size();}
	public HashSet getRawOrders() {return _rawOrders;}
	public double getTotalQuantity() {return _totalQuantity;}
	
	public void addOrderQuantity(DailyOrder o, Double q)
	{
		_rawOrders.add(o);
		_orderQuantityIncluded.put(o, q);
	}
	public double getIncludedOrderQuantity(DailyOrder o)
	{
		
		double d = _orderQuantityIncluded.get(o);
		return d;
	}
	
	
	
	
}
