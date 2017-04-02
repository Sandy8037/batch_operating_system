public class IntegertoBinary
{
	/*
	 * Converting from decimal to binary 
	 */
	public static String convertDecimalToBinary(int n)
	{	
		String str = Integer.toBinaryString(n);
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		if(str.length()< 16)
		{		
			for(int i = 0; i < 16 - str.length(); i++) 
			{
				sb.append("0");
			}
			for(char c : ch)
			{
				sb.append(String.valueOf(c));
			}
		} 
		else if(str.length()==16)
		{
			for(char c : ch) 
			{
				sb.append(String.valueOf(c));
			}
		}
		else
		{
			int j=0;
			for(char c : ch) 
			{
				if(j<16)
				{
					sb1.append(String.valueOf(c));
				}
				else
				{
					sb.append(String.valueOf(c));	
				}
				j++;
			}
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}