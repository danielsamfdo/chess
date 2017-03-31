import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//<applet code="ChessFinal" width=600 height=600>
//<param name="br" value="br.gif" >
/*
<param name="bkn" value="bn.gif" >
<param name="bb" value="bb.gif" >
<param name="bq" value="bq.gif" >
<param name="bk" value="bk.gif" >
<param name="wr" value="wr.gif" >
<param name="wkn" value="wn.gif" >
<param name="wb" value="wb.gif" >
<param name="wk" value="wk.gif" >
<param name="wq" value="wq.gif" >
<param name="wp" value="wp.gif" >
<param name="bp" value="bp.gif" >
*/
//</applet>
public class ChessFinal extends Applet implements MouseListener
{
	int xsize,ysize,size;
	int wkm,bkm;
	int wrm[]=new int[2];
	int brm[]=new int[2];
	int t1,t2,t3,t4;
	int darken;
	int tog;
	int board[][]=new int[8][8];
	int wpn[]=new int[8];
	int bpn[]=new int[8];
	int a,b,c,d,pwa,pwb,pwc,pwd,pba,pbb,pbc,pbd;
	int bw,f;
	Image br,bkn,bb,bk,bp,wr,wkn,wb,wq,bq,wk,wp,p;
	public void init()
	{
		darken=1;
		tog=0;
		xsize=72;
		ysize=64;
		t1=0;wrm[0]=wrm[1]=brm[0]=brm[1]=wkm=bkm=0;
		t2=0;
		t3=0;
		t4=0;
		bp=getImage(getDocumentBase(),getParameter("bp"));
		bkn=getImage(getDocumentBase(),getParameter("bkn"));
		bb=getImage(getDocumentBase(),getParameter("bb"));
		br=getImage(getDocumentBase(),getParameter("br"));
		bk=getImage(getDocumentBase(),getParameter("bk"));
		bq=getImage(getDocumentBase(),getParameter("bq"));
		wp=getImage(getDocumentBase(),getParameter("wp"));
		wkn=getImage(getDocumentBase(),getParameter("wkn"));
		wb=getImage(getDocumentBase(),getParameter("wb"));
		wr=getImage(getDocumentBase(),getParameter("wr"));
		wk=getImage(getDocumentBase(),getParameter("wk"));
		wq=getImage(getDocumentBase(),getParameter("wq"));
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				{
				if(i==0)
					{
						if(j==0 || j==7)
							board[i][j]=12;
						if(j==1 || j==6)
							board[i][j]=13;
						if(j==2 || j==5)
							board[i][j]=14;
						if(j==3)
							board[i][j]=15;
						if(j==4)
							board[i][j]=16;
									
					}	
				else if(i==1)
					board[i][j]=11;
				else if(i==6)	
					board[i][j]=1;
				else if(i==7)	
					{
						if(j==0 || j==7)
							board[i][j]=2;
						if(j==1 || j==6)
							board[i][j]=3;
						if(j==2 || j==5)
							board[i][j]=4;
						if(j==3)
							board[i][j]=5;
						if(j==4)
							board[i][j]=6;
									
					}
				else 
					board[i][j]=0;
				}
			for(int i=0;i<8;i++)
				{	bpn[i]=0;
					wpn[i]=0;
					for(int j=0;j<8;j++)
						System.out.print(Integer.toString(board[i][j])+"\t");
					System.out.println("");
				}
	bw=0;f=0;
	addMouseListener(this);
	/*for(int i=0;i<=7;i++)
		for(int j=0;j<=7;j++)
			board[i][j]=0;
	board[2][3]=6;
	board[0][3]=16;
	//board[1][2]=11;
	//board[1][3]=11;
	//board[1][4]=11;
	board[1][7]=12;
	board[1][6]=12;
	//board[5][2]=2;
	//board[5][7]=5;
	*/
	}
	void printbd()
	{
			for(int i=0;i<8;i++)
				{	
					for(int j=0;j<8;j++)
						System.out.print(Integer.toString(board[i][j])+"\t");
					System.out.println("");
				}
	}
	public void paint(Graphics g)
	{
		int i,j,t;
		for(i=0;i<8;i++)
			{
				if(i%2==0)
					t=1;
				else 
					t=0;
				for(j=0;j<8;j++)
					{
					g.setColor(Color.green.darker());
					g.drawRect(j*xsize,i*ysize,xsize,ysize);
					if(t==0)
						{
						g.fillRect(j*xsize,i*ysize,xsize,ysize);
						t=1;
						}
					else 
						t=0;
					if(board[i][j]==0);
					else if(board[i][j]==11)
						g.drawImage(bp,j*xsize,i*ysize,this);
					else if(board[i][j]==12)
						g.drawImage(br,j*xsize,i*ysize,this);
					else if(board[i][j]==13)
						g.drawImage(bkn,j*xsize,i*ysize,this);
					else if(board[i][j]==14)
						g.drawImage(bb,j*xsize,i*ysize,this);
					else if(board[i][j]==15)
						g.drawImage(bq,j*xsize,i*ysize,this);
					else if(board[i][j]==16)
						g.drawImage(bk,j*xsize,i*ysize,this);	
					else if(board[i][j]==1)
						g.drawImage(wp,j*xsize,i*ysize,this);
					else if(board[i][j]==2)
						g.drawImage(wr,j*xsize,i*ysize,this);
					else if(board[i][j]==3)
						g.drawImage(wkn,j*xsize,i*ysize,this);
					else if(board[i][j]==4)
						g.drawImage(wb,j*xsize,i*ysize,this);
					else if(board[i][j]==5)
						g.drawImage(wq,j*xsize,i*ysize,this);
					else if(board[i][j]==6)
						g.drawImage(wk,j*xsize,i*ysize,this);		
					
					}
							
				}
			
			if(f==1)
			        g.drawString("Game over",0,590);
                    
			if(bw==0 && f==0)
				showStatus("White's move");
			else if(bw==0 && f==0)
				showStatus("Black's move");				
	}
	public void mouseClicked(MouseEvent e)
	{
		int x=e.getX();
		int y=e.getY();
		x/=xsize;
		y/=ysize;
		int temp=x;
		x=y;
		y=temp;
		System.out.println("("+x+","+y+")");
		int piece=board[x][y];
		if(x>=0 && x<8 && y>=0 && y<8)
		{
		if(bw==0)
			{int chx,chy;chx=chy=0;
				for(int i=0;i<=7;i++)
					for(int j=0;j<=7;j++)
						if(board[i][j]==6)
							{
							chx=i;
							chy=j;
							}
				
				if(piece>0 && piece<10 && tog==0)
					{
					tog=1;
					
					a=x;
					b=y;
					showStatus("white selected piece");
					}
				else if((piece==0 || piece>10) && tog==1)
					{
					showStatus("moving to pls prnt");
					c=x;
					d=y;
					//printbd();
					if(valid(a,b,c,d,bw,chx,chy))
						{
							int change;
							System.out.println("moving to");
							change=board[c][d];				
							board[c][d]=board[a][b];
							board[a][b]=0;
								for(int i=0;i<=7;i++)
									for(int j=0;j<=7;j++)															if(board[i][j]==6)
										{
											chx=i;
											chy=j;
										}													if(!check(chx,chy,bw))
							{
								if(board[c][d]==1 && c==0 )board[c][d]=5;
								
								bw=1;
								pwa=a;pwb=b;pwc=c;pwd=d;
								repaint();
								if(GAMEON(bw,1))
									System.out.println("play on Blacks move");
								else
									{System.out.println("Black lost");fini();}
                                if(GAMEON(bw,2))
									System.out.println("play on Blacks move");
								else
									{System.out.println("Stale mate");fini();}
                                	
							}
							else 
							{	board[a][b]=board[c][d];
								board[c][d]=change;
								showStatus("White king under check");
							}
							
						}
					tog=0;
					}

				else
					{tog=0;showStatus("white's move");		}
			}
		else
			{
			int chx,chy;chx=chy=0;
				for(int i=0;i<=7;i++)
					for(int j=0;j<=7;j++)
						if(board[i][j]==16)
							{
							chx=i;
							chy=j;
							}
				
			
				if(piece>10 && tog==0)
					{
					tog=1;
					a=x;
					b=y;
					showStatus("black selected piece");
					}
				else if((piece>=0 && piece<10) && tog==1)
					{
					c=x;
					d=y;
					//printbd();
					if(valid(a,b,c,d,bw,chx,chy))
						{
							int change;
							System.out.println("moving to");
							change=board[c][d];				
							board[c][d]=board[a][b];
							board[a][b]=0;
								for(int i=0;i<=7;i++)
									for(int j=0;j<=7;j++)
										if(board[i][j]==16)
											{
											chx=i;
											chy=j;
											}
			
							if(!check(chx,chy,bw))
							{
								if(board[c][d]==11 && c==7)board[c][d]=15;
								bw=0;
								
								pba=a;pbb=b;pbc=c;pbd=d;
								repaint();
							
							 	if(GAMEON(bw,1))
									System.out.println("White play on");
								else
									{System.out.println("White lost");	fini();}
								if(GAMEON(bw,2))
									System.out.println("White play on");
								else
									{System.out.println("Stalemate");	fini();}
							}
							else 
							{	board[a][b]=board[c][d];
								board[c][d]=change;
								showStatus("Black king under check");
							}
						}
					tog=0;
					}
				else
					{tog=0;showStatus("blacks move");}
			}
		}	
	}
	public void mouseReleased(MouseEvent e)
	{
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
	public void mousePressed(MouseEvent e)
	{
	}
	boolean valid(int a,int b,int c,int d,int bw,int chx,int chy)
	{
		boolean c1,c2,c3,c4,c6,c7,c8,c9,c10;int pval,px,py;
		c1=false;
		if(bw==0)
			{
				c1= ((b==d)&&(c==4)&&(a==6)&&(board[c+1][d]==0) &&(board[c][d]==0) ) || ( (a-c==1) && (b-d==1 || d-b==1) && board[c][d]>10) || ( (a-c==1) && (b==d) &&board[c][d]==0 );
				c3=( ((d-b==1 || b-d==1)&&(c-a==2 || a-c==2)) || ((d-b==2 || b-d==2)&&(c-a==1 || a-c==1)) ) && (board[c][d]==0 || board[c][d]>10);
				c2=(b==d || a==c);
				c4=((c-a==b-d)||(c-a==d-b));	
				c6=(( (a-c==1 || c-a==1)&& b==d ) || ( (a-c==1 || c-a==1)&& (b-d==1 || d-b==1) ) || (a==c && ((b-d==1 || d-b==1)) )) && (board[c][d]==0 || board[c][d]>10) ;
				c7=(wkm==0 && a==c );
				c8=(bw==0 && wrm[1]==0 && board[a][5]==0 &&  board[a][6]==0);
				c9=(bw==0 && wrm[0]==0 && board[a][1]==0 && board[a][2]==0 && board[a][3]==0);
				c10=(board[pbc][pbd]==11 && d==pbb && c==a-1 && board[c][d]==0);pval=11;px=pbc;py=pbd;
			}
		else
			{
				c8=(bw==1 && brm[1]==0 && board[a][5]==0 &&  board[a][6]==0);
				c9=(bw==1 && brm[0]==0 && board[a][1]==0 && board[a][2]==0 && board[a][3]==0);				c1= ((b==d)&&(c==3)&&(a==1)&&(board[c][d]==0)  &&board[c-1][d]==0) || ( (a-c==-1) && (b-d==1 || d-b==1) && board[c][d]>0 && board[c][d]<10) || ( (a-c==-1) && (b==d) && board[c][d]==0 );
				c3=( ((d-b==1 || b-d==1)&&(c-a==2 || a-c==2)) || ((d-b==2 || b-d==2)&&(c-a==1 || a-c==1)) );
				c4=((c-a==b-d)||(c-a==d-b));	
				c2=(b==d || a==c);pval=1;
				c6=(      ( (a-c==1 || c-a==1)&& b==d ) || ( (a-c==1 || c-a==1)&& (b-d==1 || d-b==1) ) || (a==c && ((b-d==1 || d-b==1)) )        )&& (board[c][d]>=0 && board[c][d]<10) ;

				c7=(bkm==0 && a==c );
				c10=(board[pwc][pwd]==1 && d==pwb && c==a+1 && board[c][d]==0);px=pwc;py=pwd;
			}System.out.println("coming in "+ bw);
		switch(board[a][b]%10)
			{
				case 1:
					if(c1)
						{
						if(bw==0)
							{wpn[b]=1;System.out.println("wpn["+b+"]"+wpn[b]);}
						else
							bpn[b]=1;
						return true;
						}
					else if(c10)
						{	printbd();
							int cv=board[a][b];
							board[a][b]=board[c][d];
							board[c][d]=0;
							board[px][py]=0;
							
							if( !check(chx,chy,bw) )
								{	board[c][d]=board[a][b];
									board[a][b]=cv;
									printbd();
									return true;
								}
							else
								{
									board[c][d]=board[a][b];	
									board[a][b]=cv;
									board[px][py]=pval;
								}
						}

					break;
				case 2:
					if(c2)
						{	
						if(rook(a,b,c,d))
								{
								if(a==0 && b==0 && bw==1)
									brm[0]=1;
								else if(a==0 && b==7 && bw==1) 
									brm[1]=1;
								else if(a==7 && b==0 && bw==0)
									wrm[0]=1;
								else if(a==7 && b==7 && bw==0) 
									wrm[1]=1;
								return true;
								}
						}
					break;
				case 3:
					if(c3)
						return true;
					break;
				case 4:
					if(c4)
						{if(bishop(a,b,c,d)) return true;
						}
					break;	
				case 5:
					System.out.println("entering");
					if(c4)
						{
						System.out.println("entered c4");
						if(bishop(a,b,c,d)){ return true;}
						}
					else if(c2)
						{	
						if(rook(a,b,c,d)) {if(a==0 && bw==0)wrm[a]=0;if(a==7 && bw==0)wrm[1]=0;
								if(a==0 && bw==1)brm[a]=0;if(a==7 && bw==1)brm[1]=0
								;return true;}
						}
					break;
				case 6:	System.out.println("enteringgggggggggggggggg");
					if(!check(c,d,bw))
					{System.out.println("enteringgggggg   "+ bw+"  cond" +c6);
					if(c6)
						{
						if(bw==0)
							wkm=1;
						else 
							bkm=1;
						return true;
						}
					else if(c7)
						{System.out.println("enteringgggggggggggggggg");
						if(d-b==2)
							{System.out.println("enteringgggggg");
							if(c8)
								{
								if(!check(a,7,bw) && !check(a,b,bw) && !check(c,d,bw)) 
									{System.out.println("enteringggg");
									board[a][5]=board[a][7];
									board[a][7]=0;
									if(bw==0)
										{
										wkm=1;
										wrm[1]=1;
										}
									else
										{bkm=1;
										brm[1]=1;
										}
									return true;
									}
								}
							}
						else if(b-d==2)
							{
							if(c9)
								{
								if(!check(a,0,bw) && !check(a,b,bw) && !check(c,d,bw)) 
									{
									board[a][3]=board[a][0];
									board[a][0]=0;
									if(bw==0)
										{
										wkm=1;
										wrm[0]=1;
										}
									else
										{bkm=1;
										brm[0]=1;
										}
									return true;
									}
								}
							}
				
						}
						}
					break;
			}
			showStatus("false");
			return false;
	}
	int lim(int a,int b)
	{	int val=0;
		for(int i=a+1;i<=b-1;i++)
			val+=1;
		return val;
	}
	boolean rook(int a,int b,int c,int d)
		{
							int min,max,m;min=0;max=0;
							if(a>c&& b==d)
								{min=c;max=a;}
							else if(a==c && b>d)
								{min=d;max=b;}	
							else if(c>a && b==d)
								{min=a;max=c;}
							else if(a==c && d>b)
								{min=b;max=d;}	
							int v=0;
							for(m=min+1;m<=max-1;m++)
								{//System.out.println("entered");
								if(b==d)
									{if(board[m][b]!=0)
										{v=1;break;}
									}
								else if(a==c)
									{if(board[a][m]!=0)
										{v=1;System.out.println(v);break;}
									}
								}
							System.out.println("max ,min,a,b,c,d"+max+min+a+b+c+d);
							if(v==0)
								return true;
							else return false;
					
		}
	boolean bishop(int a,int b,int c,int d)
		{
							int limit=0;
							if(a>c)
								{
									if(b>d)
										{
											limit=lim(d,b);
											t1=1;
										}
									else
										{
											limit=lim(b,d);
											t2=1;
										}
								}
							else if(c>a)
								{
									if(b>d)
										{
											limit=lim(d,b);
											t3=1;
										}
									else
										{
											limit=lim(b,d);
											t4=1;
										}
								}
							System.out.println("limit t1 to t4   "+limit+"    "+t1+t2+t3+t4);
							int v=0;
							for(int m=1;m<=limit;m++)
								{
									if(t1==1)
										{
											if(board[a-m][b-m]!=0)
												{v=1;break;}
										}
									else if(t2==1)
										{
											if(board[a-m][b+m]!=0)
												{v=1;break;}	
										}
									else if(t3==1)
										{
											if(board[a+m][b-m]!=0)
												{v=1;break;}	
										}
									else if(t4==1)
										{
											if(board[a+m][b+m]!=0)
												{v=1;break;}	
										}
								}
							t1=t2=t3=t4=0;
							if(v==0)
								return true;
							else return false;
		}
	boolean check(int a,int b,int bw)
		{			int r,kn,bi,q,p,k,i;
					boolean c1,ck;
					System.out.println("checking the move");
					if(bw==0)
						{r=12;p=11;kn=13;bi=14;q=15;k=16;
						//c1=(board[a-1][b+1]==p || board[a-1][b-1]==p);
						//ck=(board[a-1][b+1]==k || board[a-1][b-1]==k || board[a][b+1]==k || board[a][b-1]==k || board[a+1][b+1]==k || board[a+1][b-1]==k || board[a+1][b]==k ||board[a-1][b]==k);
						}
					else
						{r=2;p=1;kn=3;bi=4;q=5;k=6;
						//c1=(board[a+1][b+1]==p || board[a+1][b-1]==p);
						//ck=(board[a-1][b+1]==k || board[a-1][b-1]==k || board[a][b+1]==k || board[a][b-1]==k || board[a+1][b+1]==k || board[a+1][b-1]==k || board[a+1][b]==k ||board[a-1][b]==k);
						}
				
					if(bw==0)
						{if(a-1>=0 && a-1<=7 && b+1>=0 && b+1<=7)
							{if(board[a-1][b+1]==p )
								return true;
							}
						if(a-1>=0 && a-1<=7 && b-1>=0 && b-1<=7)
							{if(board[a-1][b-1]==p)
								return true;
							}
						}
					else
						{
						if(a+1>=0 && a-1<=7 && b+1>=0 && b+1<=7)
							{if(board[a+1][b+1]==p)
								return true;
							}
						if(a+1>=0 && a-1<=7 && b-1>=0 && b-1<=7)
							{if(board[a+1][b-1]==p)
								return true;
							}
						}
					if(a-1>=0 )
						{
							if(board[a-1][b]==k)
								return true;
							if(b-1>=0)
								if(board[a-1][b-1]==k)
									return true;
							if(b+1<=7)
								if(board[a-1][b+1]==k)
									return true;	
						}	
					if(a+1<=7)
						{
							if(board[a+1][b]==k)
								return true;
							if(b-1>=0)
								if(board[a+1][b-1]==k)
									return true;
							if(b+1<=7)
								if(board[a+1][b+1]==k)
									return true;
						}
					if(b+1<=7)
						if(board[a][b+1]==k)
							return true;
					if(b-1>=0)
						if(board[a][b-1]==k)
							return true;
					for(i=a-1;i>=0;i--)				//rook /queen
						{
						if(board[i][b]==0)continue;
						else if(board[i][b]==r || board[i][b]==q)
								return true;
						else break;
						}
					for(i=a+1;i<=7;i++)
						{
						if(board[i][b]==0)continue;
						else if(board[i][b]==r || board[i][b]==q)
								return true;
						else break;
						}
					for(i=b+1;i<=7;i++)
						{
						if(board[a][i]==0)continue;
						else if(board[a][i]==r || board[a][i]==q)
								return true;
						else break;
						}
					for(i=b-1;i>=0;i--)
						{
						if(board[a][i]==0)continue;
						else if(board[a][i]==r || board[a][i]==q)
								return true;
						else break;
						}
					int j=b+1;
					for(i=a+1;i<=7 && j<=7;i++)
						{
							if(board[i][j]==0);
								//continue;
							else if(board[i][j]==bi || board[i][j]==q)
								return true;
							else
								break;
							j++;
						}
					j=b-1;
					for(i=a+1;i<=7 && j>=0;i++)
						{
							if(board[i][j]==0);
								//continue;
							else if(board[i][j]==bi || board[i][j]==q)
								return true;
							else
								break;
							j--;
						}
					j=b+1;
					for(i=a-1;i>=0 && j<=7;i--)
						{
							if(board[i][j]==0);
								//continue;
							else if(board[i][j]==bi || board[i][j]==q)
								return true;
							else
								break;
							j++;
						}
					j=b-1;
					for(i=a-1;i>=0 && j>=0;i--)
						{
							if(board[i][j]==0);
								//continue;
							else if(board[i][j]==bi || board[i][j]==q)
								return true;
							else
								break;
							j--;
						}	
					/* knight */
					if(a+2>=0 && a+2<8 )
						{
						if(b+1>=0 && b+1<8)
							if(board[a+2][b+1]==kn)return true;
						if(b-1>=0 && b-1<8)
							if(board[a+2][b-1]==kn)return true;
						}
					if(a-2>=0 && a-2<8 )
						{
						if(b+1>=0 && b+1<8)
							if(board[a-2][b+1]==kn)return true;
						if(b-1>=0 && b-1<8)
							if(board[a-2][b-1]==kn)return true;
						}
					if(a+1>=0 && a+1<8 )
						{
						if(b+2>=0 && b+2<8)
							if(board[a+1][b+2]==kn)return true;
						if(b-2>=0 && b-2<8)
							if(board[a+1][b-2]==kn)return true;
						}
					if(a-1>=0 && a-1<8 )
						{
						if(b+2>=0 && b+2<8)
							if(board[a-1][b+2]==kn)return true;
						if(b-2>=0 && b-2<8)
							if(board[a-1][b-2]==kn)return true;
						}
					
					showStatus("Safe");
					return false;
		}
boolean GAMEON(int bw,int ty)
		{int xp,yp;xp=0;yp=0;int p,r,kn,bi,q,k,rp,rq,rkn,rbi,rr,rk;
		boolean cx;
			if(bw==0)
				{p=1;r=2;kn=3;bi=4;q=5;k=6;
				rp=11;rr=12;rkn=13;rbi=14;rq=15;rk=16;
					
				}
			else
				{p=11;r=12;kn=13;bi=14;q=15;k=16;
				rp=1;rr=2;rkn=3;rbi=4;rq=5;rk=6;
				}
			printbd();
				for(int i=0;i<=7;i++)
					for(int j=0;j<=7;j++)
					{
						if(board[i][j]==k)
						{xp=i;yp=j;}
					}	
			
			if(ty==1)
                     cx=check(xp,yp,bw);
            else
                     cx=!check(xp,yp,bw);
					
				
			if(cx)
			{	int e,f,g,h,t1;

									System.out.println("came here ...#1");
			e=xp-1;f=xp+1;g=yp-1;h=yp+1;
			if(e>=0)
						{	if(yp-1>=0)
								if(board[e][g]>=0 && board[e][g]<=10 && bw==1) 
									{
										
									t1=board[e][g];
									board[e][g]=k;
									board[xp][yp]=0;
									if(!check(e,g,bw))
										{board[e][g]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[e][g]=t1;
										board[xp][yp]=k;
										}
									
								
									}	
								else if((board[e][g]==0 || board[e][g]>10 )&& bw==0)
									{
										
									t1=board[e][g];
									board[e][g]=k;
									board[xp][yp]=0;
									if(!check(e,g,bw))
										{board[e][g]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[e][g]=t1;
										board[xp][yp]=k;
										}
									
								
									}
							if(yp+1<=7)
								if(board[e][h]>=0 && board[e][h]<=10 && bw==1) 
									{
										
									t1=board[e][h];
									board[e][h]=k;
									board[xp][yp]=0;
									if(!check(e,h,bw))
										{board[e][h]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[e][h]=t1;
										board[xp][yp]=k;
										}
									
								
									}
									else if((board[e][h]==0 || board[e][h]>10 )&& bw==0)
									{
										
									t1=board[e][h];
									board[e][h]=k;
									board[xp][yp]=0;
									if(!check(e,h,bw))
										{board[e][h]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[e][h]=t1;
										board[xp][yp]=k;
										}
									
								
									}
							
								if(board[e][yp]>=0 && board[e][yp]<=10 && bw==1) 
									{
										
									t1=board[e][yp];
									board[e][yp]=k;
									board[xp][yp]=0;
									if(!check(e,yp,bw))
										{board[e][yp]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[e][yp]=t1;
										board[xp][yp]=k;
										}
									
								
									}
								else if((board[e][yp]==0 || board[e][yp]>10 )&& bw==0)
									{
										
									t1=board[e][yp];
									board[e][yp]=k;
									board[xp][yp]=0;
									if(!check(e,yp,bw))
										{board[e][yp]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[e][yp]=t1;
										board[xp][yp]=k;
										}
									
								
									}

									System.out.println("came here ...#2");
						}
			if(f<=7)
						{	if(yp-1>=0)
								if(board[f][g]>=0 && board[f][g]<=10 && bw==1) 
									{
										
									t1=board[f][g];
									board[f][g]=k;
									board[xp][yp]=0;
									if(!check(f,g,bw))
										{board[f][g]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[f][g]=t1;
										board[xp][yp]=k;
										}
									
								
									}	
								else if((board[f][g]==0 || board[f][g]>10 )&& bw==0)
									{
										
									t1=board[f][g];
									board[f][g]=k;
									board[xp][yp]=0;
									if(!check(f,g,bw))
										{board[f][g]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[f][g]=t1;
										board[xp][yp]=k;
										}
									
								
									}
							if(yp+1<=7)
								if(board[f][h]>=0 && board[f][h]<=10 && bw==1) 
									{
										
									t1=board[f][h];
									board[f][h]=k;
									board[f][h]=0;
									if(!check(f,h,bw))
										{board[f][h]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[f][h]=t1;
										board[xp][yp]=k;
										}
									
								
									}
								else if((board[f][h]==0 || board[f][h]>10 )&& bw==0)
									{
										
									t1=board[f][h];
									board[f][h]=k;
									board[xp][yp]=0;
									if(!check(f,h,bw))
										{board[f][h]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[f][h]=t1;
										board[xp][yp]=k;
										}
									
								
									}
								
								if(board[f][yp]>=0 && board[f][yp]<=10 && bw==1) 
									{
										
									t1=board[f][yp];
									board[f][yp]=k;
									board[xp][yp]=0;
									if(!check(f,yp,bw))
										{board[f][yp]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[f][yp]=t1;
										board[xp][yp]=k;
										}
									
								
									}
								else if((board[f][yp]==0 || board[f][yp]>10 )&& bw==0)
									{
										
									t1=board[f][yp];
									board[f][yp]=k;
									board[xp][yp]=0;
									if(!check(f,yp,bw))
										{board[f][yp]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[f][yp]=t1;
										board[xp][yp]=k;
										}
									
								
									}
									System.out.println("came here ...#3");				
						}
			if(yp-1>=0)
						{
							if(board[xp][g]>=0 && board[xp][g]<=10 && bw==1) 
								{
										
									t1=board[xp][g];
									board[xp][g]=k;
									board[xp][yp]=0;
									if(!check(xp,g,bw))
										{board[xp][g]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[xp][g]=t1;
										board[xp][yp]=k;
										}
									
								
								}
							else if((board[xp][g]==0 || board[xp][g]>10 )&& bw==0)
								{
										
									t1=board[xp][g];
									board[xp][g]=k;
									board[xp][yp]=0;
									if(!check(xp,g,bw))
										{board[xp][g]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[xp][g]=t1;
										board[xp][yp]=k;
										}
									
								
								}
							System.out.println("came here ...#4");								
						}
			if(h<=7)
						{
							
								if(board[xp][h]>=0 && board[xp][h]<=10 && bw==1) 
								{
									t1=board[xp][h];
									board[xp][h]=k;
									board[xp][yp]=0;
									if(!check(xp,h,bw))
										{board[xp][h]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[xp][h]=t1;
										board[xp][yp]=k;
										}
									
								}
								else if((board[xp][h]==0 || board[xp][h]>10 )&& bw==0)
								{
									t1=board[xp][h];
									board[xp][h]=k;
									board[xp][yp]=0;
									if(!check(xp,h,bw))
										{board[xp][h]=t1;
										board[xp][yp]=k;
										return true;
										}
									else
										{
										board[xp][h]=t1;
										board[xp][yp]=k;
										}
									
								}

									System.out.println("came here ...#5");
						}
					
			for(int i=0;i<=7;i++)
				{	
				for(int j=0;j<=7;j++)
					{
					if(board[i][j]>0)
						{	int t;
							if(board[i][j]==p)
							{boolean c1=(i==6&&p==1&& board[i-1][j]==0 && board[i-2][j]==0);
							boolean c2= ( i==1&&p==11 && board[i+1][j]==0 && board[i+2][j]==0) ;
								if(c1||c2)
									{int inx;

									System.out.println("came here ...#6");
										if(c1)inx=i-2;
										else inx=i+2;
										board[inx][j]=p;
										board[i][j]=0;
										if(!check(xp,yp,bw))
											{
											board[i][j]=p;
											board[inx][j]=0;
											return true;
											}
										else
											{board[i][j]=p;
											board[inx][j]=0;
											}
									}
								if( (board[i-1][j]==0&&bw==0 &&i-1>=0) || (board[i+1][j]==0&&bw==1&& i+1<=7) )
									{

									System.out.println("came here ...#7");
										int inx=0;
										if(bw==0)inx=i-1;
										else inx=i+1;
										board[inx][j]=p;
										board[i][j]=0;
										if(!check(xp,yp,bw))
											{
											board[i][j]=p;
											board[inx][j]=0;
											return true;
											}
										else
											{board[i][j]=p;
											board[inx][j]=0;
											}
									}
								
									{int inx,iny;
									System.out.println("came here ...#8");
										if(bw==0)
										{inx=i-1;}
										else inx=i+1;
										iny=j-1;
										if(inx>=0 && iny>=0 && inx<=7 && iny<=7)
											if(board[inx][iny]==rp || board[inx][iny]==rr || board[inx][iny]==rkn || board[inx][iny]==rbi || board[inx][iny]==rq)
												{t=board[inx][iny]	;
												board[inx][iny]=p;
												board[i][j] =0;
												if(!check(xp,yp,bw))
												{
												board[i][j]=p;
												board[inx][iny]=t;
												return true;
												}
											else
												{board[i][j]=p;
												board[inx][iny]=t;
												}
												}
										iny=j+1;
										if(inx>=0 && iny>=0 && inx<=7 && iny<=7)
											if(board[inx][iny]==rp || board[inx][iny]==rr || board[inx][iny]==rkn || board[inx][iny]==rbi || board[inx][iny]==rq)
												{t=board[inx][iny]	;
												board[inx][iny]=p;
												board[i][j] =0;
												if(!check(xp,yp,bw))
												{
												board[i][j]=p;
												board[inx][iny]=t;
												return true;
												}
											else
												{board[i][j]=p;
												board[inx][iny]=t;
												}

									System.out.println("came here ...#9");
												}
									}
								}
								if(board[i][j]==r || board[i][j]==q)
								{
									int m,n;int ex=board[i][j];
									m=i;n=j;
									for(m=i-1;m>=0;m--)		//rook /queen
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || board[m][n]==rbi || board[m][n]==rq)
										{t=board[m][n];
										board[m][n]=ex;
										board[i][j]=0;
										if(!check(xp,yp,bw))
											{
											board[i][j]=ex;
											board[m][n]=t;	
											return true;
											}	
										else
											{
											board[i][j]=ex;
											board[m][n]=t;	
											}			
										}
									else break;
									}m=i;n=j;
									for(m=i+1;m<=7;m++)		//rook /queen
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || board[m][n]==rbi || board[m][n]==rq)
										{t=board[m][n];
										board[m][n]=ex;
										board[i][j]=0;
										if(!check(xp,yp,bw))
											{
											board[i][j]=ex;
											board[m][n]=t;	
											return true;
											}	
										else
											{
											board[i][j]=ex;
											board[m][n]=t;	
											}

									System.out.println("came here ...10");			
										}
									else break;
									}m=i;n=j;
									for(n=j+1;n<=7;n++)		//rook /queen
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || board[m][n]==rbi || board[m][n]==rq)
										{t=board[m][n];
										board[m][n]=ex;
										board[i][j]=0;
										if(!check(xp,yp,bw))
											{
											board[i][j]=ex;
											board[m][n]=t;	
											return true;
											}	
										else
											{
											board[i][j]=ex;
											board[m][n]=t;	
											}			
										}
									else break;
									}m=i;n=j;
									for(n=j-1;n>=0;n--)		//rook /queen
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || board[m][n]==rbi || board[m][n]==rq)
										{t=board[m][n];
										board[m][n]=ex;
										board[i][j]=0;
										if(!check(xp,yp,bw))
											{
											board[i][j]=ex;
											board[m][n]=t;	
											return true;
											}	
										else
											{
											board[i][j]=ex;
											board[m][n]=t;	
											}			
										}
									else break;
									}
								}
								if(board[i][j]==bi || board[i][j]==q)
								{
									int m,n;m=i;n=j+1;int ex=board[i][j];
									for(m=i+1;m<=7 && n<=7;m++)
									{
										if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || board[m][n]==rbi || board[m][n]==rq)
										{t=board[m][n];
										board[m][n]=ex;
										board[i][j]=0;System.out.println("here only.....1");
											if(!check(xp,yp,bw))
											{
											board[i][j]=ex;
											board[m][n]=t;	
											return true;
											}	
											else
											{
											board[i][j]=ex;
											board[m][n]=t;	
											}n++;			
										}
									else break;
									}
									n=j-1;
									for(m=i+1;m<=7 && n>=0;m++)
									{
										if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || board[m][n]==rbi || board[m][n]==rq)
										{t=board[m][n];
										board[m][n]=ex;
										board[i][j]=0;
											if(!check(xp,yp,bw))
											{
											board[i][j]=ex;
											board[m][n]=t;	
											return true;
											}	
											else
											{
											board[i][j]=ex;
											board[m][n]=t;	
											}n--;			
										}
									else break;
									System.out.println("came here ...1");
									}		
									n=j+1;
									for(m=i-1;m>=0 && n<=7;m--)
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || board[m][n]==rbi || board[m][n]==rq)
										{t=board[m][n];
										board[m][n]=ex;
										board[i][j]=0;
											if(!check(xp,yp,bw))
											{
											board[i][j]=ex;
											board[m][n]=t;	
											return true;
											}	
											else
											{
											board[i][j]=ex;
											board[m][n]=t;	
											}		n++;	
										}
									else break;
									}
									n=j-1;
									for(m=i-1;m>=0 && n>=0;m--,n--)
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || board[m][n]==rbi || board[m][n]==rq)
										{t=board[m][n];
										board[m][n]=ex;
										board[i][j]=0;
											if(!check(xp,yp,bw))
											{
											board[i][j]=ex;
											board[m][n]=t;	
											return true;
											}	
											else
											{
											board[i][j]=ex;
											board[m][n]=t;	
											}			
										}
									else break;
									}
									
								}
								else if(board[i][j]==kn)
								{int a,b;a=i;b=j;
									if(a+2>=0 && a+2<8 )
									{
										if(b+1>=0 && b+1<8)
											if(board[a+2][b+1]==0 || board[a+2][b+1]==rkn || board[a+2][b+1]==rp  || board[a+2][b+1]==rbi || board[a+2][b+1]==rq)				{
												t=board[a+2][b+1];
                                                board[a+2][b+1]=kn;	
												board[i][j]=0;
												if(!check(xp,yp,bw))
													{
													board[i][j]=kn;
													board[a+2][b+1]=t;
													return true;
													}
												else
													{
													board[i][j]=kn;
													board[a+2][b+1]=t;
													}
												}
										if(b-1>=0 && b-1<8)
											if(board[a+2][b-1]==0 || board[a+2][b-1]==rkn || board[a+2][b-1]==rp  || board[a+2][b-1]==rbi || board[a+2][b-1]==rq)				{
												t=board[a+2][b-1];
                                                board[a+2][b-1]=kn;      	
												board[i][j]=0;
												if(!check(xp,yp,bw))
													{
													board[i][j]=kn;
													board[a+2][b-1]=t;
													return true;
													}
												else
													{
													board[i][j]=kn;
													board[a+2][b-1]=t;
													}
												}
									}
									if(a-2>=0 && a-2<8 )
									{
										if(b+1>=0 && b+1<8)
											if(board[a-2][b+1]==0 || board[a-2][b+1]==rkn || board[a-2][b+1]==rp  || board[a-2][b+1]==rbi || board[a-2][b-1]==rq)				{
												t=board[a-2][b+1];
                                                board[a-2][b+1]=kn;	
												board[i][j]=0;
												if(!check(xp,yp,bw))
													{
													board[i][j]=kn;
													board[a-2][b+1]=t;
													return true;
													}
												else
													{
													board[i][j]=kn;
													board[a-2][b+1]=t;
													}
												}
										if(b-1>=0 && b-1<8)
											if(board[a-2][b-1]==0 || board[a-2][b-1]==rkn || board[a-2][b-1]==rp  || board[a-2][b-1]==rbi || board[a-2][b-1]==rq)				{
												t=board[a-2][b-1];
                                                board[a-2][b-1]=kn;	
												board[i][j]=0;
												if(!check(xp,yp,bw))
													{
													board[i][j]=kn;
													board[a-2][b-1]=t;
													return true;
													}
												else
													{
													board[i][j]=kn;
													board[a-2][b-1]=t;
													}
												}
									}

									System.out.println("came here ...2");
									printbd();
									if(a+1>=0 && a+1<8 )
									{
										if(b+2>=0 && b+2<8)
											if(board[a+1][b+2]==0 || board[a+1][b+2]==rkn || board[a+1][b+2]==rp  || board[a+1][b+2]==rbi || board[a+1][b+2]==rq)				{
												t=board[a+1][b+2];
                                                board[a+1][b+2]=kn;
												board[i][j]=0;
												if(!check(xp,yp,bw))
													{
													board[i][j]=kn;
													board[a+1][b+2]=t;
													return true;
													}
												else
													{
													board[i][j]=kn;
													board[a+1][b+2]=t;
													}
												}
										if(b-2>=0 && b-2<8)
											if(board[a+1][b-2]==0 || board[a+1][b-2]==rkn || board[a+1][b-2]==rp  || board[a+1][b-2]==rbi || board[a+1][b-2]==rq)				{
												t=board[a+1][b-2];
                                                board[a+1][b-2]=kn;	
												board[i][j]=0;
												if(!check(xp,yp,bw))
													{
													board[i][j]=kn;
													board[a+1][b-2]=t;
													return true;
													}
												else
													{
													board[i][j]=kn;
													board[a+1][b-2]=t;
													}
												}
									}	
									if(a-1>=0 && a-1<8 )
									{
										if(b+2>=0 && b+2<8)
											if(board[a-1][b+2]==0 || board[a-1][b+2]==rkn || board[a-1][b+2]==rp  || board[a-1][b+2]==rbi || board[a-1][b+2]==rq)				{
												t=board[a-1][b+2];
                                                board[a-1][b+2]=kn;	
												board[i][j]=0;
												if(!check(xp,yp,bw))
													{
													board[i][j]=kn;
													board[a-1][b+2]=t;
													return true;
													}
												else
													{
													board[i][j]=kn;
													board[a-1][b+2]=t;
													}
												}
										if(b-2>=0 && b-2<8)
											if(board[a-1][b-2]==0 || board[a-1][b-2]==rkn || board[a-1][b-2]==rp  || board[a-1][b-2]==rbi || board[a-1][b-2]==rq)				{
												t=board[a-1][b-2];
                                                board[a-1][b-2]=kn;	
												board[i][j]=0;
												if(!check(xp,yp,bw))
													{
													board[i][j]=kn;
													board[a-1][b-2]=t;
													return true;
													}
												else
													{
													board[i][j]=kn;
													board[a-1][b-2]=t;
													}
												}
										}
								}

									System.out.println("came here ...3");
									printbd();
							}			
						}
					}
				}else return true; 
				
									System.out.println("came here ...4");
				return false;
				
			
			
		}
    void fini()
    {
     
     showStatus("game over");
     f=1;
    }
}
