package test.basetest;

public class neibulei {
	protected void ff(){}
	int aa = 22;
	public int getAa() {
		return aa;
	}
	public void setAa(int aa) {
		this.aa = aa;
	}
	StringBuilder string = new StringBuilder("");
	public StringBuilder getString() {
		return string;
	}
	public void setString(StringBuilder string) {
		this.string = string;
	}
	private void shuchu(int rr){
		System.out.println(rr);
	}
	public class neibu{
		int ee = 11;
		public neibu(){
			System.out.println(aa);
			shuchu(ee);
		}
		
	}
	neibu dd = new neibu();
	public neibulei(){
		
	}
	public static void main(String[] args) {
		neibulei nnNeibulei = new neibulei();
		nnNeibulei.aa = 1;
		nnNeibulei.new neibu();
	}
}
