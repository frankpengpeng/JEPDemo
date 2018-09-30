package sample.jep.example;

import com.singularsys.jep.Jep;

/**
 * A simple example that demonstrates the use of Jep for evaluation of a single
 * expression.
 * @author Singular Systems
 */
public class SimpleExample {
	
    public static void main(String[] args) {
        Jep jep = new Jep();
        try {
        	int x = 10;
        	//1.设置变量的值
        	jep.addVariable("x", x); 
            //2.解析公式
        	jep.parse("x+1");
        	//3.计算结果
            Object result = jep.evaluate();
            //4.输出显示
            System.out.println("x + 1 = " + result + " (When x="+x+")");
        } catch (Exception e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}
