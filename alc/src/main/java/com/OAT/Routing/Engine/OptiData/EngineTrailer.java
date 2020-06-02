package com.OAT.Routing.Engine.OptiData;

import java.util.*;
import com.OAT.Routing.DataEntity.*;
public class EngineTrailer {
	//private int _numTrailers = 0;
	private HashSet  _rawTrailers = new HashSet();
	private OTrailer _representingTrailer = null;
	
	public int getNumTrailers() {return _rawTrailers.size();}
	public HashSet getRawTrailers() {return _rawTrailers;}
	
	public void addRawTrailer(OTrailer t)
	{
		_representingTrailer=t;
		_rawTrailers.add(t);
	}
	
	public boolean isRawTrailerIncluded(OTrailer t)
	{
		return _rawTrailers.contains(t);
	}
	public OTrailer getRepresentingTrailer() {return _representingTrailer;}
}
