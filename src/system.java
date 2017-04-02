import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
  Name: Sandeep Devarapalli
  Course Number:CS5323
  Assignment title: Programming Assignment Phase II
  Date:4/1/14
  Teaching Assistant : Dileep Nagireddygari
 */
public class system 
	{
		static String line=null;			
		static String str=null;
		static int job;						//JOB ID
		static int ldar;					//LOADER ADDRESS
		//static int pc;						//PC
		static int len;						//SIZE
		static int ts;						//TRACE
		private static int l = 0;
		static StringBuilder output=new StringBuilder();									//OUTPUT FILE
		static StringBuilder er=new StringBuilder();										//ERROR HANDLING
		static int[] pmtin=new int[10];														//PMT INPUT
		static int[] pmtou=new int[10];														//PMT OUTPUT
		static int realadd;																	//REAL ADDRESS
		static int pgno;																	//PAGE NUMBER
		static int offset;																	//OFFSET
		static int r;
		static int b;
		static int c;
		static public ArrayList<String> pcb= new ArrayList<>(1000);
		static public ArrayList<Integer> rq=new ArrayList<>(1000);
		static public ArrayList<Integer> bq=new ArrayList<>(1000);
		static int pfclock=0;
		static int[] rb=new int[6];
		/*
		 * Parameter args
		 * This main method reads the input file for loader format and calls Input Spooling and Loader method
		 */
		public static void main(String[] args) 
			{
				if(args.length==0)
				{
					try
					{
						throw new FileNotFoundException();
					}
					catch(FileNotFoundException e)
					{
						System.exit(0);
					}
				}
				Loader.main(args);
				Loader.ISpooling(1);																//INPUT SPOOLING
				try
				{
					File file = new File("output.txt");										//CREATING OUTPUT FILE
					if (!file.exists()) 
					{
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(output.toString());
					bw.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		/*
		 * This method is used when a page fault occurs, that is referred word is not in the memory
		 */
		static public void pagefaulthandle(int pg,int z2)														//PAGE FAULT HANDLER
		{
			if(Loader.sc.size() < 6 || Loader.sc.size() >6) 
			{
				for(int l=0;l<32;l++)
				{
					if(memory.FMBV[l]==0)
					{
						int j=0,k;
						Loader.sc.add(l);
						memory.FMBV[l]=1;
						b=l*8;
						j=b;
						k=pg*8;
						for(int m=k;m<k+8;m++)
						{
							memory.memory("WRITE", j,Loader.disk[m],z2);
							j++;
						}
						break;
					}
				}
			}
			else
			{
				for(int m =0; m<7;m++)
				{
					if(Loader.PMT[z2][0][1] == 0)
					{
						b = Loader.PMT[z2][1][1];
					}
					else b = Loader.PMT[z2][0][1];
					int n = pg*8;
					int l = b;
					for( int p= n;p<n+8;p++)
					{
						memory.memory("WRITE", l,Loader.disk[p],z2);
						l++;
					}
					system.pfclock=system.pfclock+10;
					break;
					
				}
			}
			Loader.PMT[z2][pgno][1] = b;
			Loader.PMT[z2][pgno][0] = pg;
			virtualtoreal(r,z2);
		}
		/*
		 * This method is used for Error Handling
		 */
			static void errorHandler(int x)															//ERROR HANDLER METHOD
			{
				switch(x)
				{
				case 0: er.append("Input file not found\r\n");break;									//FILE NOT FOUND
				case 1:	er.append("Invalid loader format\r\n");break;									//INVALID LOADER FORMAT
				case 2: er.append("Invalid Trace Bit\r\n");break;										//INVALID TRACE BIT
				case 3: er.append("BATCH PACKET does not contain **JOB\r\n");break;						//DOES NOT CONTAIN JOB
				case 4:	er.append("More than one **INPUT\r\n");break;									//MORE THAN ONE INPUT
				case 5:	er.append("BATCH PACKET does not contain **FIN\r\n");break;						//DOES NOT CONTAIN FIN
				case 6:	er.append("BATCH PACKET does not contain **INPUT\r\n");break;					//DOES NOT CONTAIN INPUT
				case 7:	er.append("Invalid input value\r\n");break;										//INVALID INPUT VALUE
				}
				try
				{
				File file = new File("errorHandling.txt");											//CREATING ERROR HANDLING FILE
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(er.toString());
				bw.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			/*
			 * This method is used to convert virtual address to real address
			 */
			static public int virtualtoreal(int i, int z2)
			{
				String s;r=i;
				s=IntegertoBinary.convertDecimalToBinary(i);
				pgno=Integer.parseInt(s.substring(0,13),2);
				offset=Integer.parseInt(s.substring(13,16),2);
				if(Loader.PMT[z2][pgno][1]!=0||Loader.PMT[z2][pgno][0]!=0)
				realadd=Loader.PMT[z2][pgno][1]+offset;
				else
				{
					pfclock=pfclock+10;
					pagefaulthandle(pgno,z2);
				}
				c=realadd;
				return realadd;
			}
	}