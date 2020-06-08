package com.OAT.Routing.Engine.OptiData;


import com.OAT.Routing.DataAccess.*;
import java.util.*;
import com.OAT.Routing.DataEntity.*;

public class EngineDataAccess {
	private DataContainer _rawDataContainer;
	
	private Vector <EngineTrailer> engineTrailer = new Vector();
	private HashMap<OTrailer, EngineTrailer> engineTrailerRawTrailer =  new HashMap();
	private EngineTDM _tdm = new EngineTDM();
	
	public EngineDataAccess (DataContainer d)
	{
		_rawDataContainer =d;
	}
	
	

}