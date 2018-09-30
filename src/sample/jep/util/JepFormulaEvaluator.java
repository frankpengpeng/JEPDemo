package sample.jep.util;

import java.util.LinkedHashSet;
import java.util.Set;

import sample.jep.valuebean.IValuable;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;
import com.singularsys.jep.ParseException;
import com.singularsys.jep.parser.Node;

/**
 * @author Kevin.Xiao@IBM
 *
 */
public class JepFormulaEvaluator {
	
	/***/
	private Jep jep = new Jep();
	/***/
	private String formula;
	
	/** The root node of the formula */
	protected Node node;
	
	protected Double result;
	
	
	
	public JepFormulaEvaluator(String formula)
	{
		this.formula = formula;
	}
	
	
	/**
	 * 解析公式表达式
	 * @return
	 * @throws ParseException
	 */
	public boolean parse() throws ParseException
	{
		if (formula == null) {
			return false;
		}
		node = jep.parse(formula);
		return true;
	}

	/**
	 * This method returns a set of column definition name for each
	 * of the field used in the formula.
	 */
	public Set<String> findChildren() {
        Set<String> children = new LinkedHashSet<String>(); 
		return findChildren(node, children);
	}
	
    /**
     * Finds recursively every children of a node.
     * @param node The node to find the children for
     * @param children
     */
    private Set<String> findChildren(Node node, Set<String> children) {
    	if (node.jjtGetNumChildren() ==0){
    		if (node.getOperator() == null) {  
				children.add(node.getName());
    		}
    	}else {
    		for (Node child: node.children()) {
	    		if (child.getName() != null) {
		    		if (child.getOperator() == null) {  
						children.add(child.getName());
		    		} else {
		    			findChildren(child, children);
		    		}
	    		}
	    	}
    	}
    	return children;
    }

	/**
	 * 变量赋值
	 * @throws Exception 
	 */
	public void addVariables(IValuable valuable) throws Exception
	{
		Set<String> children = this.findChildren();
		for(String child : children)
		{
			jep.addVariable(child, valuable.getValue(child));
		}
	}
	
	/**
	 * 计算结果
	 * @throws EvaluationException 
	 */
	public Double evaluate() throws EvaluationException
	{
		result = (Double)jep.evaluate();
		return result;
	}
}
