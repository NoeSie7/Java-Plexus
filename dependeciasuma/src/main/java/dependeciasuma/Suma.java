package dependeciasuma;

public class Suma {
	
	private Integer op;
	private Integer op1;
	
	
	
	public Suma() {
		this.op = 0;
		this.op1=0;
	}
	
	public Suma(Integer a, Integer b) {
		this.op = a;
		this.op1=b;
		
	}
	
	public Integer sumita() {
		return op + op1;
	}
}
