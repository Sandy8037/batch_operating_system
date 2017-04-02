import java.util.ArrayList;
import java.util.List;
public class memory
	{
		private static String[] mem1 = new String[256];								//MAIN MEMORY
		static int[] FMBV=new int[32];
		private static int l = 0;	
		static String r;
		static int words=0;
		/*
		 * This method is used to set and get values from memory
		 */
		static String memory(String X, int Y,String Z1,int z)								//MAIN MEMORY METHOD
			{
				if(X.equals("WRITE"))												//PERFORMING WRITE OPERATION
					{
						mem1[Y]=Z1;
						words++;
						return null;
					}
				else if(X.equals("READ"))											// PERFORMING READ OPERATION
					{		
						l=system.virtualtoreal(Y,z);
						Z1 = mem1[l];
						return Z1;
					}
				return null;
			}
	}