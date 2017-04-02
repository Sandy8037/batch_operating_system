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
import java.util.List;
public class Loader 
	{
		static CPU cpumod;							//CPU OBJECT
		private static int l = 0;			
		static int[] job=new int[1000];								//JOB ID
		static int[] ldar=new int[1000];							//LOAD ADDRESS
		static int[] pc=new int[1000];								//PC
		static int[] len=new int[1000];								//SIZE
		static int[] ts=new int[1000];
		static String line=null;
		static String str=null;
		static String str1=null;
		static String arg=null;
		static String[] input=new String[1000];
		static int output1;
		static int output2;
		static String[] disk=new String[2048];			//DISK
		static int[][][] PMT=new int[20][20][2];
		static int inputfrag=0;
		static int outputfrag=0;
		static int progfrag=0;
		static ArrayList<Integer> sc = new ArrayList<Integer>(6);
		static int j=0;
		static int pgno;
		static int k;
		static int segclock=0;
		static int words=0;
		static int z;
		static String[] batchinput=new String[1000];
		static String[] batchoutput=new String[1000];
		static int[] npf=new int[1000];
		/*
		 * This main method is used to check input file and to initialize Free Memory Bit Vector
		 */
		public static void main(String[] args) 
			{
				if(args.length==0)											//CHECKING FOR INPUT FILE		
					{
						try
							{
								throw new FileNotFoundException();
							} 
						catch (FileNotFoundException e) 
							{
								system.errorHandler(0);
								System.exit(0);
							}
					}
				arg = args[0];												//GETTING THE FILE NAME FROM ARGUMENT
			for(int i=0;i<32;i++)											//INITIALIZING FMBV
			{
					memory.FMBV[i]=0;
			}
			for(int i=0;i<1000;i++)											//INITIALIZING FMBV
			{
					pc[i]=-1;
			}
			}
		/*
		 * This method is used for Input Spooling, that is the job is stored in Disk
		 */
		static void ISpooling(int i)													//INPUT SPOOLING
		{
			try
			{
				FileInputStream fstream = new FileInputStream(arg);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				line=br.readLine();
				for(z=i;line.length()!=5;z++)
				{
					if(line.substring(0,5).equals("**JOB"))
					{
						batchinput[z]=line.substring(6,8);
						batchoutput[z]=line.substring(9,11);
					}
					line=br.readLine();
					if(line.length() == 13 && !line.substring(0, 2).contains("  "))					//CHECKING LOADER FORMAT
					{
						job[z]= z;
						system.pcb.add(Integer.toBinaryString(job[z]));
						ldar[z]=Integer.parseInt(line.substring(3, 5),16);
						pc[z]= Integer.parseInt(line.substring(6, 8),16);
						len[z]= Integer.parseInt(line.substring(9,11),16);
						ts[z]= Integer.parseInt(line.substring(12, 13),16);	
					}
					line=br.readLine();
					for(int j=1;!line.equals("**INPUT");j++)								//SPOOLING JOB TO DISK
					{
					for(int k=0;k<4;k++)
					{
						str1=line.substring(4*k,4*(k+1));
						str = Hex_Bin(str1);
						disk[l]=str;						
						l++; 
					}
					line=br.readLine();
					}
					if(len[z]%8==0)
					{
						l=l+16;
						npf[z]=Math.min(6,((len[z]/8)+2));
					}
					else
					{
						l=l+(len[z]%8);
						l=l+16;
						npf[z]=Math.min(6,((len[z]/8)+2));
					}
					line=br.readLine();
					input[z]=Hex_Bin(line);
					br.readLine();
					line=br.readLine();
					line=line+"l";
				}
			loadmod(pc[i],i);	
			}
		catch(FileNotFoundException fnf)
			{
				system.errorHandler(0);
				System.exit(0);
			}	
		catch(Exception e)
			{
				System.out.println(e);
			}
		}
		/*
		 * This is the Loader method, here the initial allocation of frame1 from Disk to Memory takes place 
		 */
		static void loadmod(int x,int z1)			//LOADER METHOD
			{
				int y;
				y=x/8;
				x=x/8;
				x=x*8;
				for(int i=0;i<32;i++)
				{
					if(memory.FMBV[i]==0)
					{
						sc.add(i);
						memory.FMBV[i]=1;
						if(z1==1)
						{
							for(int j=i*8;j<i*8+8;j++)
							{
								memory.memory("WRITE",j,disk[x],z1);						//LOADING FRAME1 FROM DISK TO MEMORY
								x++;
							}
						}
						else
						{
							if(len[z1-1]%8==0)
							x=x+len[z1-1]+16;
							else
							{
							x=x+len[z1-1]%8;
							x=x+len[z1-1]+16;
							}
							for(int j=i*8;j<i*8+8;j++)
							{
								memory.memory("WRITE",j,disk[x],z1);						//LOADING FRAME1 FROM DISK TO MEMORY
								x++;
							}
						}
						if(y==0)
						{
							PMT[z1][y][y]=y;
							PMT[z1][y][1]=i*8;
						}
						else
						{
							PMT[z1][y][0]=y;
							PMT[z1][y][y]=i*8;
						}
						system.pfclock=system.pfclock+10;
						break;
					}
				}
				system.pcb.add("ProgSeg");
				system.pcb.add(null);
				system.pcb.add(null);
				system.pcb.add(Integer.toBinaryString(npf[z1]));
				system.rq.add(z1);
				/*
				 * This method is used to call the CPU class
				 */
				CPU.cpumod(pc[z1],ts[z1],z1);
			}
		/*
		 * This method is used to convert from Hex to Binary
		 */
		static String Hex_Bin(String h)												//CONVERTING HEXADECIMAL TO BINARY
			{
				String hex=h;
				String b = "";
				int i;
				for(int j = 0; j < hex.length(); j+=4)
					{
						String s=hex.substring(j,j+4);
						i = Integer.parseInt(s,16);
						b = Integer.toBinaryString(i);
						if(b.length()<16)									    		 
							{
								while(b.length() < 16)
									{
										for (int k= 0; b.length() < 16; k++)
											{
												b="0"+b;
											}
									}
							}
					}
				return b;
			}
		/*
		 * This method is called for Input data segment and Output data segment
		 */
		static public void sfh(String i, int z)
		{
			if(i.equals("10011"))
			{
				system.pfclock=system.pfclock+10;
				segclock=segclock+5;
				words=words+8;
				if(len[z]%8==0)
				{
					pgno=len[z]/8;
					k=pgno*8;
				}
				else
				{
					pgno=len[z]/8+1;
					k=pgno*8;	
				}
				disk[k]=input[z];
				inputfrag=7;
				system.pcb.remove(2);
				system.pcb.add(2,"pmtin");
			}
			else if(i.equals("10100"))
			{
				system.pfclock=system.pfclock+10;
				segclock=segclock+5;
				words=words+8;
				if(len[z]%8==0)
				{
				pgno=len[z]/8;
				k=pgno*8+8;
				}
				else
				{
					pgno=len[z]/8+1;
					k=pgno*8+8;
				}
				disk[k]=Integer.toBinaryString(output1);
				outputfrag=6;
				system.pcb.remove(3);
				system.pcb.add(3,"pmtou");
			}
		}
	}