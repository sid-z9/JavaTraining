// 10th
public class Test {
	protected void m()
	{
		
	}
	public static void main(String[] args) {
		byte b = 1;
		Byte b1 = new Byte(b);
		
		Byte b2 = new Byte((byte) 1); // line 1
		Byte b3 = 1; // line 2
		System.out.print(b1 + b2 + b3); // line 3
	}
}

class Some extends Test
{
	
	@Override
	public void m() throws Error {
		// TODO Auto-generated method stub
		super.m();
	}
}
