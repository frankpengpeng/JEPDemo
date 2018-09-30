package sample.jep.data;

/**
 * @author Kevin.Xiao@IBM
 *
 */
public class ProductDeal {
	/**标识*/
	private String productId;
	/**名称*/
	private String productName;
	/**售价*/
	private Double unitPrice;
	/**单位减价*/
	private Double unitPriceOff;
	/**销量*/
	private Integer volume;
	/**零售商经营成本*/
	private Double unitOperationCost;
	/**供应商价格*/
	private Double unitSupplierPrice;
	/**供应商成本*/
	private Double unitSupplierCost;
	/**自定义字段A*/
	private Double customMetricA;
	/**自定义字段B*/
	private Double customMetricB;
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the unitPrice
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	/**
	 * @return the unitPriceOff
	 */
	public Double getUnitPriceOff() {
		return unitPriceOff;
	}
	/**
	 * @param unitPriceOff the unitPriceOff to set
	 */
	public void setUnitPriceOff(Double unitPriceOff) {
		this.unitPriceOff = unitPriceOff;
	}
	/**
	 * @return the unitOperateCost
	 */
	public Double getUnitOperationCost() {
		return unitOperationCost;
	}
	/**
	 * @param unitOperateCost the unitOperateCost to set
	 */
	public void setUnitOperationCost(Double unitOperationCost) {
		this.unitOperationCost = unitOperationCost;
	}
	/**
	 * @return the unitSupplierPrice
	 */
	public Double getUnitSupplierPrice() {
		return unitSupplierPrice;
	}
	/**
	 * @param unitSupplierPrice the unitSupplierPrice to set
	 */
	public void setUnitSupplierPrice(Double unitSupplierPrice) {
		this.unitSupplierPrice = unitSupplierPrice;
	}
	/**
	 * @return the unitSupplierCost
	 */
	public Double getUnitSupplierCost() {
		return unitSupplierCost;
	}
	/**
	 * @param unitSupplierCost the unitSupplierCost to set
	 */
	public void setUnitSupplierCost(Double unitSupplierCost) {
		this.unitSupplierCost = unitSupplierCost;
	}
	/**
	 * @return the volume
	 */
	public Integer getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	/**
	 * @return the customMetricA
	 */
	public Double getCustomMetricA() {
		return customMetricA;
	}
	/**
	 * @param customMetricA the customMetricA to set
	 */
	public void setCustomMetricA(Double customMetricA) {
		this.customMetricA = customMetricA;
	}
	
	/**
	 * @return the customMetric
	 */
	public Double getCustomMetricB() {
		return customMetricB;
	}
	/**
	 * @param customMetric the customMetric to set
	 */
	public void setCustomMetricB(Double customMetricB) {
		this.customMetricB = customMetricB;
	}
	
}
