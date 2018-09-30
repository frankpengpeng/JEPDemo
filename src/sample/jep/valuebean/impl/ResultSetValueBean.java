package sample.jep.valuebean.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import sample.jep.valuebean.IValuable;

/**
 * @author Kevin.Xiao@IBM
 *
 */
public class ResultSetValueBean implements IValuable{

	public ResultSet rs;
	public Map<String,Double> resultMap = new HashMap<String,Double>();
	
	/* (non-Javadoc)
	 * @see sample.jep.IValuable#getValue(java.lang.String)
	 */
	@Override
	public Double getValue(String fieldName) throws SQLException {
		// TODO Auto-generated method stub
		if(resultMap.containsKey(fieldName))
			return resultMap.get(fieldName);
		else
			return rs.getDouble(fieldName);
	}

	/* (non-Javadoc)
	 * @see sample.jep.IValuable#setValue(java.lang.String, java.lang.Double)
	 */
	@Override
	public void setValue(String fieldName, Double result) {
		// TODO Auto-generated method stub
		resultMap.put(fieldName, result);
	}

}
