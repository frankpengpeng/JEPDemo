package sample.jep.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sample.jep.valuebean.IValuable;

/**
 * @author Kevin.Xiao@IBM
 *
 */
public class JepUtil {
	
	/**存储公式和对应的Jep计算器对象*/
	private static Map<String,JepFormulaEvaluator> formulaEvaluatorMap;
	
	/**存储计算结果*/
	protected Set<String> calculationOrder;
	
	private String user;
	
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 初始化
	 * @throws Exception
	 */
	public void init(String user) throws Exception
	{
		setUser(user);
		formulaEvaluatorMap = new HashMap<String,JepFormulaEvaluator>();
		calculationOrder = new LinkedHashSet<String>();
		initCalculatorOrder();
	}
	
	/**
	 * 初始化计算顺序，当存在字段的循环引用时会抛出异常
	 * @throws Exception
	 */
	private void initCalculatorOrder() throws Exception
	{
		
		if(ConfigurationUtil.getMetricFormulaMap()==null 
				|| ConfigurationUtil.getMetricFormulaMap().keySet().isEmpty() 
				|| ConfigurationUtil.getFormulaMap(user)==null 
				|| ConfigurationUtil.getFormulaMap(user).keySet().isEmpty())
			return;
		
		List<String> order = new ArrayList<String>();
		for(Object fieldName:ConfigurationUtil.getMetricFormulaMap().keySet())
		{
			this.addFormulaFields((String)fieldName, order,(String)fieldName);
		}
		calculationOrder.addAll(order);
	}
	
	/**
	 * 添加公式的字段
	 * @param fieldName
	 * @param order
	 * @param childFieldName
	 * @throws Exception
	 */
	private void addFormulaFields(String fieldName, List<String> order,String childFieldName) throws Exception{
		
		String formulaKey = (String)ConfigurationUtil.getMetricFormulaMap().get(childFieldName);
		
		if (formulaKey!=null && !"".equals(formulaKey)) {
			// The current column has a formula, add it in the order
			order.add(0, childFieldName);
			String formula = ConfigurationUtil.getFormula(user, formulaKey);
			JepFormulaEvaluator jep = new JepFormulaEvaluator(formula);
			jep.parse();
			formulaEvaluatorMap.put(formulaKey, jep);
			Set<String> children = jep.findChildren();
			for (String child: children) {
				if (child.equals(fieldName)) {
					throw new Exception("Circular formula on field: " + fieldName);
				}
				addFormulaFields(fieldName, order, child);
			}
		}
	}

	

	/**
	 * 对每一行记录进行处理，包括如下步骤
	 * a)公式解析
	 * b)变量赋值
	 * c)计算
	 * d)存储计算结果
	 * @param valuable
	 * @throws Exception 
	 */
	public void processRow(IValuable valuable) throws Exception
	{
		for(String fieldName : calculationOrder)
		{			
			if(ConfigurationUtil.getMetricFormulaMap().keySet().contains(fieldName))
			{
				String formulaKey = (String)ConfigurationUtil.getMetricFormulaMap().get(fieldName);
				JepFormulaEvaluator jep = formulaEvaluatorMap.get(formulaKey);
				jep.addVariables(valuable);
				Double result = jep.evaluate();
				valuable.setValue(fieldName, result);
			}
		}
	}
}
