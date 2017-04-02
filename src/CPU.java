import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class CPU
	{
		static memory mem;
		static int[] sclock=new int[1000];								//SYSTEM CLOCK
		static int[] ioclock=new int[1000];								//I/O CLOCK
		static int pc;										//PC
		static int[] pc1=new int[1000]; 
		static int ts;										//TRACE
		static int tos=0;									//TOP OF STACK
		static String[] tos1=new String[1000];
		static String[] s = new String[7];					//STACK
		static String r;
		static String ir;									//INSTRUCTION REGISTER
		static String ir1;
		static String ir2;
		static String[] ir3=new String[1000];
		static String opc;									//OPCODE
		static String ea;									//EFFECTIVE ADDRESS
		static String br="0";								//BASE REGISTER
		static String r1;
		static String r2="";
		static boolean halt=true;							//HALT 
		static StringBuilder sb=new StringBuilder();
		static int count=0;
		static int count1=0;
		static int count2=1;
		static int count3=2;
		static int count4=3;
		static int count5=4;
		static int count6=5;
		static int count7=6;
		static int count8=7;
		static int count9=8;
		static int[] eio=new int[200];
		static boolean[][] flag=new boolean[20][20];
		/*
		 * This is method, once virtual address is converted to real address it is used in memory to execute 
		 */
		static public void cpumod(int x,int y,int z)				//CPU METHOD
			{
				pc = x;
				ts = y;
				sb.append("\t(PC)(hex)\t(BR)(hex)\t(IR)(hex)\t(TOS)(hex)\t(S[TOS])(hex)\t\tEA(hex)\t\t(EA)(hex)\t(TOS)(hex)\tS[TOS](hex)\tEA(hex)\t(EA)(hex)\r\n");
				memory mem = new memory();
					while(halt==true)							
					{	
						if(sclock[z]>=20&&sclock[z]<40)
						{
						if(flag[z][count1]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count1]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						else if(sclock[z]>=40&&sclock[z]<60)
						{
						if(flag[z][count2]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count2]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						else if(sclock[z]>=60&&sclock[z]<80)
						{
						if(flag[z][count3]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count3]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						else if(sclock[z]>=80&&sclock[z]<100)
						{
						if(flag[z][count4]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count4]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						else if(sclock[z]>=100&&sclock[z]<120)
						{
						if(flag[z][count5]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count5]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						else if(sclock[z]>=120&&sclock[z]<140)
						{
						if(flag[z][count6]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count6]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						else if(sclock[z]>=140&&sclock[z]<160)
						{
						if(flag[z][count7]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count7]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						else if(sclock[z]>=160&&sclock[z]<180)
						{
						if(flag[z][count8]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count8]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						else if(sclock[z]>=180&&sclock[z]<200)
						{
						if(flag[z][count9]==false)
						{
							int k;
							k=system.rq.size();
							for(int i=1;i<=k;k++)
							{
								flag[z][count9]=true;
								int l;
								l=system.rq.get(i-1);
								pc1[l]=pc;
								ir3[l]=ir;
								tos1[l]=s[tos];
								system.rq.remove(i-1);
								system.rq.add(l);
								l=system.rq.get(i-1);
								cpumod(pc1[l],Loader.ts[l],l);
							}
						}
						}
						ir=mem.memory("READ",pc,r,z);					//ACCESSING MEMORY
						pc++;
						if(ir.charAt(0)=='0')
							{
							ir1=ir.substring(0,8);
							ir2=ir.substring(8,16);
							for(int i=0;i<2;i++)
								{
									sb.append("\t\t"+Integer.toHexString((pc-1))+"\t\t"+Integer.toHexString(Integer.parseInt(br,2))+"\t\t"+Integer.toHexString(Integer.parseInt(ir,2))+"\t\t"+Integer.toHexString(tos)+"\t\t");
									if(s[tos] == null)
										{
											sb.append("null\t\t");
										} 
									else
										{
											sb.append(Integer.toHexString(Integer.parseInt(s[tos],2))+"\t\t");
										}	
									if(i==0)
										{
											ir=ir1;
											ir=ir.substring(3,8);
										}
									else
										{
											ir=ir2;
											ir=ir.substring(3,8);
										}
									if(ir.equals("00000"))																		//NOP
										{
											sclock[z]++;
										}
									else if(ir.equals("00001"))																	//OR	
										{
											s[tos-1]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) | Integer.parseInt(s[tos-1],2)));
											s[tos] = null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("00010"))																	//AND	
										{
											s[tos-1]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) & Integer.parseInt(s[tos-1],2)));
											s[tos] = null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("00011"))																	//NOT
										{
											s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) ^ Integer.parseInt("1111111111111111",2)));
											sclock[z]++;
										}	
									else if(ir.equals("00100"))																	//XOR
										{
											s[tos-1]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) ^ Integer.parseInt(s[tos-1],2)));
											s[tos] = null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("00101"))																	//ADD
										{
											s[tos-1]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) + Integer.parseInt(s[tos-1],2)));
											s[tos] = null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("00110"))																	//SUB
										{
											s[tos-1]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos-1],2) - Integer.parseInt(s[tos],2)));
											s[tos] = null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("00111"))																	//MUL
										{
											s[tos-1]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) * Integer.parseInt(s[tos-1],2)));
											s[tos] = null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("01000"))																	//DIV
										{
											s[tos-1]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos-1],2) / Integer.parseInt(s[tos],2)));
											s[tos] = null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("01001"))																	//MOD
										{
											s[tos-1]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos-1],2) % Integer.parseInt(s[tos],2)));
											s[tos] = null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("01010"))																	//SL
										{
										String k = s[tos];
										int a =Integer.parseInt(s[tos],2) << 1;
										String sl=Integer.toBinaryString( a);
											s[tos]=IntegertoBinary.convertDecimalToBinary(a);
											sclock[z]++;
										}
									else if(ir.equals("01011"))																	//SR
										{
											s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) >> 1));
											sclock[z]++;
										}
									else if(ir.equals("01100"))																	//CPG
										{	
										if((Integer.parseInt(s[tos-1],2) > Integer.parseInt(s[tos],2)))
											{
												s[tos+1]="1111111111111111";
											}
										else 
											{
												s[tos+1] = "0000000000000000";
											}
										tos=tos+1;
										sclock[z]++;
										}
									else if(ir.equals("01101"))																	//CPL
										{
											if((Integer.parseInt(s[tos-1],2) < Integer.parseInt(s[tos],2)))
												{
													s[tos+1]="1111111111111111";
												}
											else 
												{
													s[tos+1] = "0000000000000000";
												}
											tos=tos+1;
											sclock[z]++;
										}
									else if(ir.equals("01110"))																	//CPE
										{
											if((Integer.parseInt(s[tos-1],2) == Integer.parseInt(s[tos],2)))
												{
													s[tos+1]=IntegertoBinary.convertDecimalToBinary(Integer.parseInt(s[tos],2));
												}
											else 
												{
													System.out.println("not equal");
												}
											tos=tos+1;
											sclock[z]++;
										}
									else if(ir.equals("01111"))																	//BR
										{
											sclock[z]++;
										}
									else if(ir.equals("10000"))																	//BRT
										{
											sclock[z]++;
										}
									else if(ir.equals("10001"))																	//BRF
										{
											sclock[z]++;
										}
									else if(ir.equals("10010"))																	//CALL
										{
											sclock[z]++;
										}
									else if(ir.equals("10011"))																	//RD
										{
										int k=system.rq.size();											
										system.rq.remove(k-1);
										system.bq.add(z);
										eio[z]=20;
										Loader.sfh(ir,z);
										tos=tos+1;
										s[tos]=Loader.input[z];
										sclock[z]=sclock[z]+15+1;
										ioclock[z]=ioclock[z]+15;
										pc1[z]=pc;
										ir3[z]=ir;
										tos1[z]=s[tos];
										system.pcb.add(Integer.toBinaryString(pc1[z]));
										system.pcb.add(ir3[z]);
										system.pcb.add(tos1[z]);
										if(Loader.pc[z+1]!=-1)
										Loader.loadmod(Loader.pc[z+1],z+1);
										else if(system.rq.size()==0)
										{
											k=system.bq.size();
											for(int j=1;j<=k;j++)
											{
												int l;
												l=system.bq.get(j-1);
												system.rq.add(l);
												system.bq.remove(j-1);
												cpumod(pc1[j], Loader.ts[j], j);
											}
										}
										}
									else if(ir.equals("10100"))																	//WR
										{
										if(count==0)
										{
										Loader.output1=Integer.parseInt(s[tos],2);
										Loader.sfh(ir,z);
										system.pfclock=system.pfclock+10;
										count++;
										}
										else
										{
										Loader.output2=Integer.parseInt(s[tos],2);
										}
											s[tos]=null;
											tos=tos-1;
											sclock[z]=sclock[z]+15+1;
											ioclock[z]=ioclock[z]+15;
										}
									else if(ir.equals("10101"))																	//RTN
										{
											pc=Integer.parseInt(s[tos],2);
											s[tos]=null;
											tos=tos-1;
											sclock[z]++;
										}
									else if(ir.equals("10110"))																	//PUSH
									{
										sclock[z]++;
									}
									else if(ir.equals("10111"))																	//POP
									{
										sclock[z]++;
									}
									else if(ir.equals("11000"))																	//HLT
									{
										halt=false;
										sclock[z]++;
									}
									sb.append("--\t\t--\t\t"+Integer.toHexString(tos)+"\t\t");
									if(s[tos] == null)
									{
										sb.append("null\t\t");
									} 
									else 
									{
										sb.append(Integer.toHexString(Integer.parseInt(s[tos],2))+"\t\t");
									}
									sb.append("--\t\t--\t\t\r\n");
								}
							}
						else
						{
							if(ir.charAt(6)=='0')
							{
								ea=ir.substring(9,16);
							}
							else
							{
								ea=ir.substring(9,16)+s[tos];
							}
							sb.append("\t\t"+Integer.toHexString((pc-1))+"\t\t"+Integer.toHexString(Integer.parseInt(br,2))+"\t\t"+Integer.toHexString(Integer.parseInt(ir,2))+"\t\t"+Integer.toHexString(tos)+"\t\t");
							if(s[tos] == null)
							{
								sb.append("null\t\t");
							} 
							else 
							{
								sb.append(Integer.toHexString(Integer.parseInt(s[tos],2))+"\t\t");
							}
							sb.append(Integer.toHexString(Integer.parseInt(ea,2))+"\t\t"+Integer.toHexString(Integer.parseInt(mem.memory("READ", Integer.parseInt(ea,2), r2,z),2))+"\t\t");
							ir=ir.substring(1,6);
							if(ir.equals("00000"))																		//NOP
							{
								sclock[z]+=4;
							}
							else if(ir.equals("00001"))																	//OR
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);
								s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) | Integer.parseInt(r1,2)));
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("00010"))																	//AND
							{
								r1=mem.memory("READ", Integer.parseInt(ea,2), r2,z);
								s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) & Integer.parseInt(r1,2)));
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("00011"))																	//NOT
							{
								sclock[z]+=4;
							}
							else if(ir.equals("00100"))																	//XOR
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);
								s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) ^ Integer.parseInt(r1,2)));
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("00101"))																	//ADD
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);	
								s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) + Integer.parseInt(r1,2)));
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("00110"))																	//SUB
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);	
								s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) - Integer.parseInt(r1,2)));
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("00111"))																	//MUL
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);	
								s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) * Integer.parseInt(r1,2)));
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("01000"))																	//DIV
							{
								r1  =mem.memory("READ", Integer.parseInt(ea,2), r2,z);	
								s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) / Integer.parseInt(r1,2)));
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("01001"))																	//MOD
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);
								s[tos]=IntegertoBinary.convertDecimalToBinary((Integer.parseInt(s[tos],2) % Integer.parseInt(r1,2)));
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("01010"))																	//SL
							{
								sclock[z]+=4;
							}
							else if(ir.equals("01011"))																	//SR
							{
								sclock[z]+=4;
							}
							else if(ir.equals("01100"))																	//CPG
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);	
								if((Integer.parseInt(s[tos],2) > Integer.parseInt(r1,2)))
								{
									s[tos+1]="1111111111111111";
								}
								else 
								{
									s[tos+1] = "0000000000000000";
								}
								tos=tos+1;
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("01101"))																	//CPL
							{
							r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);
								if((Integer.parseInt(s[tos],2) < Integer.parseInt(r1,2)))
								{
									s[tos+1]="1111111111111111";
								}
								else 
								{
									s[tos+1] = "0000000000000000";
								}
								tos=tos+1;
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("01110"))																	//CPE
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);	
								if((Integer.parseInt(s[tos],2) == Integer.parseInt(r1,2)))
								{
									s[tos+1]=IntegertoBinary.convertDecimalToBinary(Integer.parseInt(r1,2));
								}
								else 
								{
									System.out.println("not equal");
								}
								tos=tos+1;
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("01111"))																	//BR
							{
								pc=Integer.parseInt(ea,2);
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("10000"))																	//BRT
							{
								if(s[tos]=="1111111111111111")
								{
									pc=(Integer.parseInt(ea,2));
									s[tos]=null;
									tos=tos-1;
								}
								else
								{
									tos=tos-1;
								}
								sclock[z]+=4;
							}
							else if(ir.equals("10001"))																	//BRF
							{
								if(s[tos]=="0000000000000000")
								{
									pc=Integer.parseInt(ea,2);
									s[tos]=null;
									tos=tos-1;	
								}
								else
								{
									tos=tos-1;
								}
								sclock[z]+=4;
							}
							else if(ir.equals("10010"))																	//CALL
							{
								tos=tos+1;
								s[tos]=IntegertoBinary.convertDecimalToBinary(pc);
								pc=Integer.parseInt(ea,2);
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("10011"))																	//RD
							{
								sclock[z]+=4;
							}
							else if(ir.equals("10100"))																	//WR
							{
								sclock[z]+=4;
							}
							else if(ir.equals("10101"))																	//RTN
							{
								sclock[z]+=4;
							}
							else if(ir.equals("10110"))																	//PUSH
							{
								r1  = mem.memory("READ", Integer.parseInt(ea,2), r2,z);	 
								tos=tos+1;
								s[tos]=r1;
								sclock[z]=sclock[z]+4;
							}
							else if(ir.equals("10111"))																	//POP
							{
								try
								{
									system.virtualtoreal(Integer.parseInt(ea,2),z);
									int ch= system.c;
									mem.memory("WRITE", ch, s[tos],z);
									s[tos]=null;
									tos=tos-1;
									sclock[z]=sclock[z]+4;
								}
								catch(NullPointerException e)
								{
									System.out.println("");
								}
							}
							else if(ir.equals("11000"))																	//HLT
							{
								halt=false;
								sclock[z]+=4;
							}
							sb.append(Integer.toHexString(tos)+"\t\t");
							if(s[tos] == null)
							{
								sb.append("null\t\t");
							}
							else
							{
								sb.append(Integer.toHexString(Integer.parseInt(s[tos],2))+"\t\t");
							}
							sb.append(Integer.toHexString(Integer.parseInt(ea,2))+"\t\t"+Integer.toHexString(Integer.parseInt(mem.memory("READ", Integer.parseInt(ea,2), r2,z),2))+"\t\t\r\n");
						}
					}
				system.output.append("Job Id(decimal):"+system.job+"\r\n");	
				system.output.append("Input-Data Segment for job"+system.job+"(decimal):"+Integer.parseInt(Loader.input[z],2)+"\r\n");
				system.output.append("Output-Data Segment for job"+system.job+"(decimal):"+Loader.output1+"\r\n");
				system.output.append("Output-Data Segment for job"+system.job+"(decimal):"+Loader.output2+"\r\n");
				system.output.append("Nature of termination:normal\r\n");
				system.output.append("Clock value(virtual time units):"+Integer.toHexString((sclock[z]+system.pfclock+Loader.segclock))+"\r\n");
				system.output.append("Runtime for the job(virtual time units):"+(sclock[z]+system.pfclock+Loader.segclock)+"\r\n");
				system.output.append("I/O time(virtual time units):"+ioclock+"\r\n");
				system.output.append("Execution time(virtual time units):"+(sclock[z]-ioclock[z])+"\r\n");
				system.output.append("Page-fault handling time(virtual time units):"+system.pfclock+"\r\n");
				system.output.append("Segment-fault handling time(virtual time units):"+Loader.segclock+"\r\n");
				system.output.append("Memory Utilization- Number of words used over total number of words:"+((Loader.sc.size()*8)-6)+"/"+(Loader.sc.size()*8)+"\r\n");
				system.output.append("Memory Utilization- Number of frames used over total number of frames:"+Loader.sc.size()+"/32\r\n");
				system.output.append("Disk Utilization- Number of words used over total number of words:"+(Loader.words-(Loader.inputfrag+Loader.outputfrag+Loader.progfrag))+"/"+Loader.words+"\r\n");	
				system.output.append("Disk Utilization- Number of frames used over total number of frames:"+(Loader.pgno+2)+"/256\r\n");
				system.output.append("Memory Fragmentation- Number of words unused in the last allocated page:"+(Loader.inputfrag+Loader.outputfrag)+"\r\n");
				system.output.append("Disk Fragmentation- Number of words unused in the last allocated page:"+(Loader.inputfrag+Loader.outputfrag+Loader.progfrag)+"\r\n");
				if(ts==1)
				{
					try
					{
						File file = new File("trace.txt");
						if (!file.exists())
						{
							file.createNewFile();
						}
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(sb.toString());
						bw.close();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				else if(ts==0)
				{
				}
				else
				{
					system.errorHandler(2);
				}
			}
		
	}