package sample.jep.valuebean;

/**
 * @author Kevin.Xiao@IBM
 *
 */
public interface IValuable{
	/**
	 * 通过字段名称获取字段值
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public Double getValue(String fieldName)throws Exception;
	/**
	 * 设置字段名称和计算结果
	 * @param fieldName
	 * @param result
	 * @throws Exception
	 */
	public void setValue(String fieldName,Double result)throws Exception;
}
