package sample.jep.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Kevin.Xiao@IBM
 *
 */
public class ConfigurationUtil {

	
	private static Map metricFormulaMap = new HashMap();
	
	private static Map<String,Map> formulaMap = new HashMap();
	
	private static Map<String,Map> labelMap = new HashMap();
	
	public static void loadCommonConfiguration() throws IOException
	{
		loadMetricFormulaMapping();
	}
	
	public static void loadUserConfiguration(String user) throws IOException
	{
		loadFormulas(user);
		loadLabels(user);
	}
	

	/**
	 * @return the metricFormulaMap
	 */
	public static Map getMetricFormulaMap() {
		return metricFormulaMap;
	}



	/**
	 * @return the formulaMap
	 */
	public static Map getFormulaMap(String user) {
		return formulaMap.get(user);
	}



	/**
	 * @return the labelMap
	 */
	public static Map getLabelMap(String user) {
		return labelMap.get(user);
	}


	/**
	 * 载入字段和公式的配置信息
	 * @throws IOException 
	 */
	public static void loadMetricFormulaMapping() throws IOException
	{
		Properties prop = new Properties();
		InputStream in = ConfigurationUtil.class.getResourceAsStream("/config/metricFormulaConfig.properties");
		try {
			prop.load(in);
			metricFormulaMap = prop;
		}
		finally
		{
			if(in!=null)
				in.close();
		}
	}
	
	

	/**
	 * 载入该用户的公式
	 * @param user
	 * @throws IOException 
	 */
	public static void loadFormulas(String user) throws IOException
	{
		Properties prop = new Properties();
		InputStream in = ConfigurationUtil.class.getResourceAsStream("/config/"+user+"/formula.properties");
		try {
			prop.load(in);		
			formulaMap.put(user, prop);
		}
		finally
		{
			if(in!=null)
				in.close();
		}
	}
	
	
	/**
	 * 载入字段标签信息
	 * @throws IOException 
	 */
	public static void loadLabels(String user) throws IOException
	{
		Properties prop = new Properties();
		InputStream in = ConfigurationUtil.class.getResourceAsStream("/config/"+user+"/label.properties");
		try {
			prop.load(in);
			labelMap.put(user, prop);
		} 
		finally
		{
			if(in!=null)
				in.close();	
		}
	}
	
	
	public static String getFormulaKey(String fieldName)
	{
		return (String)metricFormulaMap.get(fieldName);
	}
	
	public static String getFormula(String user,String formulaKey)
	{
		Map userFormulaMap = (Map)(formulaMap.get(user));
		return (String)userFormulaMap.get(formulaKey);
	}
	
	
	public static String getLabel(String user,String fieldName)
	{
		Map userLabelMap = (Map)(labelMap.get(user));
		return (String)userLabelMap.get(fieldName);
	}
	
}
