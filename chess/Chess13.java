import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
import java.applet.*;
import java.io.*;
import java.awt.event.*;
//<applet code="Chess13" width=600 height=600>
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
public class Chess13 extends Applet implements MouseListener
{	public class uv
		{
		int u;
		int v;
		Boolean present;
		uv(){u=-1;v=-1;present=true;}
		int getu()
			{
			return u;
			}
		int getv()
			{
			return v;
			}
		
		}
	public class PositionTable
	{	
		uv king=new uv();
		uv queen=new uv();
		uv p[]=new uv[8];
		uv rook[]=new uv[2];
		uv knight[]=new uv[2];
		uv bishop[]=new uv[2];
	}
	PositionTable blacktab=new PositionTable();
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
	int bw;
	int movescount=0;
	
	Image br,bkn,bb,bk,bp,wr,wkn,wb,wq,bq,wk,wp,p;
	public void init()
	{
	for(int m=0;m<8;m++)
		blacktab.p[m]=new uv();
	for(int m=0;m<=1;m++)
		blacktab.rook[m]=new uv();
	for(int m=0;m<=1;m++)
		blacktab.knight[m]=new uv();
	for(int m=0;m<=1;m++)
		blacktab.bishop[m]=new uv();
	
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
							{board[i][j]=12;}
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
				}/*
		for(int l=0;l<8;l++)
				for(int h=0;h<8;h++)
					board[l][h]=0;
			//board[0][5]=12;board[0][6]=16;board[0][7]=0;board[1][5]=11;board[1][6]=11;board[1][7]=11;board[0][4]=13;board[5][7]=6;board[6][6]

=5;board[2][7]=4;//board[][]=;*/	//board[5][0]=15;board[5][1]=0;board[7][5]=6;board[7][7]=16;
			for(int i=0;i<8;i++)
				{	bpn[i]=0;
					wpn[i]=0;
					for(int j=0;j<8;j++)
						System.out.print(Integer.toString(board[i][j])+"\t");
					System.out.println("");
				}
	bw=0;
	addMouseListener(this);
	
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
			if(bw==0)
				showStatus("White's move");
			else 
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
		if(bw==0)//White to move
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
									for(int j=0;j<=7;j++)							

								if(board[i][j]==6)
										{
											chx=i;
											chy=j;
										}							

						if(!check(chx,chy,bw))
							{
								if(board[c][d]==1 && c==0 )board[c][d]=5;
								movescount++;
								bw=1;int pawn11=11;
								pwa=a;pwb=b;pwc=c;pwd=d;
								repaint();
								if(GAMEON(bw))
									{	updatepostab();
										printblacktable();
										System.out.println("play on Blacks move");
										int mov[][]=new int[16][64];
										int genm[][]=new int[2000][4];
										int len;repaint();
										
										len=MovablePieces(mov,1);
										PinnedPieces(mov,bw,len);
										printpiecepos(mov,len,4);
										int lm=genmoves(mov,1,len,genm);
										int dep;
										dep=2;
										//if(movescount>=4)dep=3;
										repaint();
										//int val=maxLevel(1,dep,1);
										int val=alphabeta(1,dep,1,-1000,1000);
										int movu=genm[val][0];
										int movv=genm[val][1];
										int movw=genm[val][2];
										int movx=genm[val][3];
										if(board[movu][movv]==pawn11)bpn[movv]=1;
										board[movw][movx]=board[movu][movv];
										board[movu][movv]=0;
										System.out.println("AI moved");
										tog=0;bw=0;
										
									}
								else
									System.out.println("Black lost");	
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
								if(GAMEON(bw))
									{System.out.println("Gameon");}
								else
									{System.out.println("showStatus(White Lost)");}	
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
				c1= ((b==d)&&(c==4)&&(a==6)&&(board[c+1][d]==0) &&(board[c][d]==0) ) || ( (a-c==1) && (b-d==1 || d-b==1) && board[c]

[d]>10) || ( (a-c==1) && (b==d) &&board[c][d]==0 );
				c3=( ((d-b==1 || b-d==1)&&(c-a==2 || a-c==2)) || ((d-b==2 || b-d==2)&&(c-a==1 || a-c==1)) ) && (board[c][d]==0 || board[c][d]

>10);
				c2=(b==d || a==c);
				c4=((c-a==b-d)||(c-a==d-b));	
				c6=(( (a-c==1 || c-a==1)&& b==d ) || ( (a-c==1 || c-a==1)&& (b-d==1 || d-b==1) ) || (a==c && ((b-d==1 || d-b==1)) )) && (board[c]

[d]==0 || board[c][d]>10) ;
				c7=(wkm==0 && a==c );
				c8=(bw==0 && wrm[1]==0 && board[a][5]==0 &&  board[a][6]==0);
				c9=(bw==0 && wrm[0]==0 && board[a][1]==0 && board[a][2]==0 && board[a][3]==0);
				c10=(board[pbc][pbd]==11 && d==pbb && c==a-1 && board[c][d]==0);pval=11;px=pbc;py=pbd;
			}
		else
			{
				c8=(bw==1 && brm[1]==0 && board[a][5]==0 &&  board[a][6]==0);
				c9=(bw==1 && brm[0]==0 && board[a][1]==0 && board[a][2]==0 && board[a][3]==0);				c1= 

((b==d)&&(c==3)&&(a==1)&&(board[c][d]==0)  &&board[c-1][d]==0) || ( (a-c==-1) && (b-d==1 || d-b==1) && board[c][d]>0 && board[c][d]<10) || ( (a-c==-1) && 

(b==d) && board[c][d]==0 );
				c3=( ((d-b==1 || b-d==1)&&(c-a==2 || a-c==2)) || ((d-b==2 || b-d==2)&&(c-a==1 || a-c==1)) );
				c4=((c-a==b-d)||(c-a==d-b));	
				c2=(b==d || a==c);pval=1;
				c6=(      ( (a-c==1 || c-a==1)&& b==d ) || ( (a-c==1 || c-a==1)&& (b-d==1 || d-b==1) ) || (a==c && ((b-d==1 || d-b==1)) )        )&& 

(board[c][d]>=0 && board[c][d]<10) ;

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
							{bpn[b]=1;;System.out.println("bpn["+b+"]"+bpn[b]);}
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
						//ck=(board[a-1][b+1]==k || board[a-1][b-1]==k || board[a][b+1]==k || board[a][b-1]==k || board[a+1][b+1]==k || 

//board[a+1][b-1]==k || board[a+1][b]==k ||board[a-1][b]==k);
						}
					else
						{r=2;p=1;kn=3;bi=4;q=5;k=6;
						//c1=(board[a+1][b+1]==p || board[a+1][b-1]==p);
						//ck=(board[a-1][b+1]==k || board[a-1][b-1]==k || board[a][b+1]==k || board[a][b-1]==k || board[a+1][b+1]==k || 

//board[a+1][b-1]==k || board[a+1][b]==k ||board[a-1][b]==k);
						}
				
					if(bw==0)
						{if(a-1>=0 && a-1<=7 && b+1>=0 && b+1<=7)
							{if(board[a-1][b+1]==p)
								return true;
							}
						if(a-1>=0 && a-1<=7 && b-1>=0 && b-1<=7)
							{if(board[a-1][b-1]==p)
								return true;
							}
						}
					else
						{
						if(a+1>=0 && a+1<=7 && b+1>=0 && b+1<=7)
							{if(board[a+1][b+1]==p)
								return true;
							}
						if(a+1>=0 && a+1<=7 && b-1>=0 && b-1<=7)
							{if(board[a+1][b-1]==p)
								return true;
							}
						}
						
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
					
					for(i=a+1;i<=7&&j<=7;i++)
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
boolean GAMEON(int bw)
		{int xp,yp;xp=0;yp=0;int p,r,kn,bi,q,k,rp,rq,rkn,rbi,rr,rk;
		boolean con;BufferedReader brk = new BufferedReader(new InputStreamReader(System.in));
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
			
					
					
				
			if(check(xp,yp,bw))
			{	int e,f,g,h;

									System.out.println("came here ...#1");
			e=xp-1;f=xp+1;g=yp-1;h=yp+1;
			if(e>=0)
						{	if(yp-1>=0)
							{
							Boolean c1;int p1,p2;p1=p2=-1;
							if(board[e][g]>=0 && board[e][g]<=10 && bw==1)  {p1=board[xp][yp];p2=board[e][g];}
							else if((board[e][g]==0 || board[e][g]>10 )&& bw==0){p1=board[xp][yp];p2=board[e][g];}
							if(p1>=0 && p2>=0)
							{
							board[e][g]=board[xp][yp];board[xp][yp]=0;
							if(!check(e,g,bw))
								c1=true;
							else 
								c1=false;
							board[xp][yp]=p1;board[e][g]=p2;
							
							if(c1==true)
								return true;
							}
							}
							if(yp+1<=7)
							{
							Boolean c1;int p1,p2;p1=p2=-1;
							if(board[e][h]>=0 && board[e][h]<=10 && bw==1)  {p1=board[xp][yp];p2=board[e][h];}
							else if((board[e][h]==0 || board[e][h]>10 )&& bw==0){p1=board[xp][yp];p2=board[e][h];}
							if(p1>=0 && p2>=0)
							{
							board[e][h]=board[xp][yp];board[xp][yp]=0;
							if(!check(e,h,bw))
								c1=true;
							else 
								c1=false;
							board[xp][yp]=p1;board[e][h]=p2;
							
							if(c1==true)
								return true;
							}
							}
							{
							Boolean c1;int p1,p2;p1=p2=-1;
							if(board[e][yp]>=0 && board[e][yp]<=10 && bw==1)  {p1=board[xp][yp];p2=board[e][yp];}
							else if((board[e][yp]==0 || board[e][yp]>10 )&& bw==0){p1=board[xp][yp];p2=board[e][yp];}
							if(p1>=0 && p2>=0)
							{
							board[e][yp]=board[xp][yp];board[xp][yp]=0;
							if(!check(e,yp,bw))
								c1=true;
							else 
								c1=false;
							board[xp][yp]=p1;board[e][yp]=p2;
							
							if(c1==true)
								return true;
							}
							}
									System.out.println("came here ...#2");
						}
			if(f<=7)
						{	if(yp-1>=0)
							{
							Boolean c1;int p1,p2;p1=p2=-1;
							if(board[f][g]>=0 && board[f][g]<=10 && bw==1)  {p1=board[xp][yp];p2=board[f][g];}
							else if((board[f][g]==0 || board[f][g]>10 )&& bw==0){p1=board[xp][yp];p2=board[f][g];}
							if(p1>=0 && p2>=0)
							{
							board[f][g]=board[xp][yp];board[xp][yp]=0;
							if(!check(f,g,bw))
								c1=true;
							else 
								c1=false;
							board[xp][yp]=p1;board[f][g]=p2;
							
							if(c1==true)
								return true;
							}
							}	
							if(yp+1<=7)
							{
							Boolean c1;int p1,p2;p1=p2=-1;
							if(board[f][h]>=0 && board[f][h]<=10 && bw==1)  {p1=board[xp][yp];p2=board[f][h];}
							else if((board[f][h]==0 || board[f][h]>10 )&& bw==0){p1=board[xp][yp];p2=board[f][h];}
							if(p1>=0 && p2>=0)

							{
							board[f][h]=board[xp][yp];board[xp][yp]=0;
							if(!check(f,h,bw))
								c1=true;
							else 
								c1=false;
							board[xp][yp]=p1;board[f][h]=p2;
							
							if(c1==true)
								return true;
							}
							}
							{
							Boolean c1;int p1,p2;p1=p2=-1;
							if(board[f][yp]>=0 && board[f][yp]<=10 && bw==1)  {p1=board[xp][yp];p2=board[f][yp];}
							else if((board[f][yp]==0 || board[f][yp]>10 )&& bw==0){p1=board[xp][yp];p2=board[f][yp];}
							if(p1>=0 && p2>=0)
							{
							board[f][yp]=board[xp][yp];board[xp][yp]=0;
							if(!check(f,yp,bw))
								c1=true;
							else 
								c1=false;
							board[xp][yp]=p1;board[f][yp]=p2;
							
							if(c1==true)
								return true;
							}
							}
									System.out.println("came here ...#3");				
						}
			if(yp-1>=0)
						{	System.out.println("came here ... #4.1");
							printbd();
							Boolean c1;int p1,p2;p1=p2=-1;
							if(board[xp][g]>=0 && board[xp][g]<=10 && bw==1)  {p1=board[xp][yp];p2=board[xp][g];}
							else if((board[xp][g]==0 || board[xp][g]>10 )&& bw==0){p1=board[xp][yp];p2=board[xp][g];}
							if(p1>=0 && p2>=0)
							{
							board[xp][g]=board[xp][yp];board[xp][yp]=0;
							if(!check(xp,g,bw))
								c1=true;
							else 
								c1=false;
							board[xp][yp]=p1;board[xp][g]=p2;
							
							if(c1==true)
								return true;
							}		System.out.println("came here ...#4.2");					

			
						}
			if(h<=7)
						{	System.out.println("came here ... #5.1");
							printbd();Boolean c1;int p1,p2;p1=p2=-1;
							if(board[xp][h]>=0 && board[xp][h]<=10 && bw==1) {p1=board[xp][yp];p2=board[xp][h];}
							else if((board[xp][h]==0 || board[xp][h]>10 )&& bw==0){p1=board[xp][yp];p2=board[xp][h];}
							if(p1>=0 && p2>=0)
							{
							board[xp][h]=board[xp][yp];board[xp][yp]=0;
							if(!check(xp,h,bw))
								c1=true;
							else 
								c1=false;
							board[xp][h]=p2;board[xp][yp]=p1;
							if(c1==true)
								return true;
							}		System.out.println("came here ...#5.2");
						}
			System.out.println("came here ...King moves over");
					
			for(int i=0;i<=7;i++)
				{	
				for(int j=0;j<=7;j++)
					{
					if(board[i][j]>0)
						{	int t;try{
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
											if(board[inx][iny]==rp || board[inx][iny]==rr || board[inx]

[iny]==rkn || board[inx][iny]==rbi || board[inx][iny]==rq)
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
											if(board[inx][iny]==rp || board[inx][iny]==rr || board[inx]

[iny]==rkn || board[inx][iny]==rbi || board[inx][iny]==rq)
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
								}catch(Exception e1){System.out.println("Pawn");try{brk.readLine();}catch(Exception e2){}}
								
								if(board[i][j]==r || board[i][j]==q)
								{
									int m,n;int ex=board[i][j];
									m=i;n=j;
									try{
									for(m=i-1;m>=0;m--)		//rook /queen
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || 

board[m][n]==rbi || board[m][n]==rq)
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
									}catch(Exception e1){System.out.println("rol1");try{brk.readLine();}catch(Exception e2){}}
									m=i;n=j;
									try{
									for(m=i+1;m<=7;m++)		//rook /queen
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || 

board[m][n]==rbi || board[m][n]==rq)
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
									}
									}catch(Exception e1){System.out.println("rok2");try{brk.readLine();}catch(Exception e2){}}
									m=i;n=j;
									try{
									for(n=j+1;n<=7;n++)		//rook /queen
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || 

board[m][n]==rbi || board[m][n]==rq)
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
									}catch(Exception e1){System.out.println("rook 3");try{brk.readLine();}catch(Exception e2){}}
									m=i;n=j;try{
									for(n=j-1;n>=0;n--)		//rook /queen
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || 

board[m][n]==rbi || board[m][n]==rq)
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
									}catch(Exception e1){System.out.println("rook4");try{brk.readLine();}catch(Exception e2){}}
								}
								if(board[i][j]==bi || board[i][j]==q)
								{
									int m,n;m=i;n=j+1;int ex=board[i][j];
									try{
									for(m=i+1;m<=7 && n<=7;m++)
									{
										if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m]

[n]==rkn || board[m][n]==rbi || board[m][n]==rq)
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
										n++;
									}
									}catch(Exception e1){System.out.println("bishop1");try{brk.readLine();}catch(Exception e2){}}
									n=j-1;
									try{
									for(m=i+1;m<=7 && n>=0;m++)
									{
										if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m]

[n]==rkn || board[m][n]==rbi || board[m][n]==rq)
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
									else break;n--;
									System.out.println("came here ...1");
									}
									}catch(Exception e1){System.out.println("bishop2");try{brk.readLine();}catch(Exception e2){}}		
									n=j+1;
									try{printbd();
									for(m=i-1;m>=0 && n<=7;m--)
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || 

board[m][n]==rbi || board[m][n]==rq)
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
									else break;n++;
									}
									}catch(Exception e1){System.out.println("bishop3"+e1);try{brk.readLine();}catch(Exception e2){}}
									n=j-1;
									try{printbd();
									for(m=i-1;m>=0 && n>=0;m--)
									{
									if(board[m][n]==0 || board[m][n]==rp || board[m][n]==rr || board[m][n]==rkn || 

board[m][n]==rbi || board[m][n]==rq)
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
									else break;n--;
									}
									}catch(Exception e1){System.out.println("bishop4"+e1);try{brk.readLine();}catch(Exception e2){}}
									
								}
								else if(board[i][j]==kn)
								{int a,b;a=i;b=j;
									if(a+2>=0 && a+2<8 )
									{
										if(b+1>=0 && b+1<8)
											if(board[a+2][b+1]==0 || board[a+2][b+1]==rkn || board[a

+2][b+1]==rp  || board[a+2][b+1]==rbi || board[a+2][b+1]==rq)				{
												t=board[a+2][b+1];	
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
											if(board[a+2][b-1]==0 || board[a+2][b-1]==rkn || board[a

+2][b-1]==rp  || board[a+2][b-1]==rbi || board[a+2][b-1]==rq)				{
												t=board[a+2][b-1];	
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
											if(board[a-2][b+1]==0 || board[a-2][b+1]==rkn || board[a-2]

[b+1]==rp  || board[a-2][b+1]==rbi || board[a-2][b-1]==rq)				{
												t=board[a-2][b+1];	
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
											if(board[a-2][b-1]==0 || board[a-2][b-1]==rkn || board[a-2]

[b-1]==rp  || board[a-2][b-1]==rbi || board[a-2][b-1]==rq)				{
												t=board[a-2][b-1];	
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
											if(board[a+1][b+2]==0 || board[a+1][b+2]==rkn || board[a

+1][b+2]==rp  || board[a+1][b+2]==rbi || board[a+1][b+2]==rq)				{
												t=board[a+1][b+2];	
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
											if(board[a+1][b-2]==0 || board[a+1][b-2]==rkn || board[a

+1][b-2]==rp  || board[a+1][b-2]==rbi || board[a+1][b-2]==rq)				{
												t=board[a+1][b-2];	
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
											if(board[a-1][b+2]==0 || board[a-1][b+2]==rkn || board[a-1]

[b+2]==rp  || board[a-1][b+2]==rbi || board[a-1][b+2]==rq)				{
												t=board[a-1][b+2];	
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
											if(board[a-1][b-2]==0 || board[a-1][b-2]==rkn || board[a-1]

[b-2]==rp  || board[a-1][b-2]==rbi || board[a-1][b-2]==rq)				{
												t=board[a-1][b-2];	
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
				}
					else{return true;} 
				
									System.out.println("came here ...4");
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));try{br.readLine();}catch(Exception e){}
				return false;
				
			
			
		}
		public int MovablePieces(int [][]mov,int bw)
		{
			int start,end,pawn,bishop,knight,rook,queen,king,ope,ops,x=0;
			int i,j;
			start=1;end=6;pawn=1;rook=2;knight=3;bishop=4;queen=5;king=6;ops=11;ope=16;			
			if(bw==1){start+=10;end+=10;rook+=10;pawn+=10;knight+=10;bishop+=10;queen+=10;king+=10;ops=1;ope=6;}		
			for(i=0;i<8;i++)
				{
				for(j=0;j<8;j++)
					{
						if(board[i][j]>=start && board[i][j]<=end)
								{mov[x][0]=i;
								  mov[x][1]=j;
								  mov[x][2]=board[i][j];
								  mov[x][3]=0;
								  x++;
								 }
							
					}
				}
			return x;
		}
		public void printpiecepos(int [][]mov,int l,int k)
		{
			for(int i=0;i<l;i++)
			{	System.out.println("");
				for(int m=0;m<k;m++)
				{	
					System.out.print(mov[i][m]+ "         " );
				}
			}
		}
		public void printpieceposm(int [][]mov,int l,int k)
		{k=4;int pie;
			for(int i=0;i<l;i++)
			{	System.out.println("");
				
				pie=board[mov[i][0]][mov[i][1]]%10;
				switch(pie){
					case 2:
					System.out.print("R");
					break;
					case 3:
					System.out.print("N");
					break;
					case 4:
					System.out.print("B");
					break;
					case 5:
					System.out.print("Q");
					break;
					case 6:
					System.out.print("K");
					break;

				}
				int d=mov[i][3]+97;
				System.out.print(Character.toChars(d));//System.out.print(mov[i][2]);
				switch(mov[i][2])
				{
					case 0:
					System.out.print("8");
					break;
				
					case 1:
					System.out.print("7");
					break;
					case 2:
					System.out.print("6");
					break;
					case 3:
					System.out.print("5");
					break;
					case 4:
					System.out.print("4");
					break;
					case 5:
					System.out.print("3");
					break;
					case 6:
					System.out.print("2");
					break;
					case 7:
					System.out.print("1");
					break;}
				
			}
		}
		public int genmoves(int [][]mov,int bw,int l,int [][]genm)
		{
			int s,s1,piece,start,end,pawn,bishop,knight,rook,queen,king,ope,ops,checkmovevalid;
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			int j,ik,lm=0,k1,k2;k1=k2=0;
			checkmovevalid=0;
			start=1;end=6;pawn=1;rook=2;knight=3;bishop=4;queen=5;king=6;ops=11;ope=15;s=-2;s1=-1;			
			if(bw==1){start+=10;end+=10;rook+=10;pawn+=10;knight+=10;bishop+=10;queen+=10;king+=10;ops=1;ope=5;s=2;s1=1;}	
			for(ik=0;ik<8;ik++)
				{
				for(j=0;j<8;j++)
					{
						if(board[ik][j]==king)
							{
							k1=ik;k2=j;
							}
					}
				}
			if(check(k1,k2,bw)) checkmovevalid=1;
			else checkmovevalid=0;
			for(ik=0;ik<l;ik++)
			{	int u,v,w,x,pin,first=0;
				u=mov[ik][0];
				v=mov[ik][1];
				piece=mov[ik][2];	
				pin=mov[ik][3];	
				if(pin==1) checkmovevalid=1;	try{	
				if(piece==pawn)
					{
						if(bw==0)
							{if(wpn[v]!=1)
								first=1;
							}
						else
							{
							if(bpn[v]!=1)first=1;
							}
						if(first==1)
							{
								if(board[u+s][v]==0 && board[u+s1][v]==0 && u+s>=0 && u+s<=7)
									{
										if(checkvalid(checkmovevalid,bw,u,v,u+s,v,k1,k2))
										{
											try{
											genm[lm][0]=u;
											genm[lm][1]=v;
											genm[lm][2]=u+s;
											genm[lm][3]=v;	
											lm++;}
											catch(Exception e){System.out.println("err dan");try{br1.readLine();}catch(Exception r){}}
										}
									}
							}
						if(board[u+s1][v]==0 && u+s1>=0 && u+s1<=7)
							{
								if(checkvalid(checkmovevalid,bw,u,v,u+s1,v,k1,k2))
								{
											genm[lm][0]=u;
											genm[lm][1]=v;
											genm[lm][2]=u+s1;
											genm[lm][3]=v;	
											lm++;
								}
							}
						if(v+1<=7 && u+s1>=0 && u+s1<=7 )
							{if(board[u+s1][v+1]>=ops && board[u+s1][v+1]<=ope)
								if(checkvalid(checkmovevalid,bw,u,v,u+s1,v+1,k1,k2))
								{
											genm[lm][0]=u;
											genm[lm][1]=v;
											genm[lm][2]=u+s1;
											genm[lm][3]=v+1;	
											lm++;
								}
							}
						if(v-1>=0 && u+s1>=0 && u+s1<=7 )
							{if(board[u+s1][v-1]>=ops && board[u+s1][v-1]<=ope)
								if(checkvalid(checkmovevalid,bw,u,v,u+s1,v-1,k1,k2))
								{
											genm[lm][0]=u;
											genm[lm][1]=v;
											genm[lm][2]=u+s1;
											genm[lm][3]=v-1;	
											lm++;
								}
							}

							
					}
					}catch(Exception t1){System.out.println("pawn in gm");try{br1.readLine();}catch(Exception r){}}
					try
					{if(piece==knight)
					{
						int posxy[][]=new int[8][2];
						int i;
						
						posxy[0][0]=2;
						posxy[0][1]=-1;
						posxy[1][0]=2;
						posxy[1][1]=1;
						posxy[2][0]=1;
						posxy[2][1]=2;
						posxy[3][0]=1;
						posxy[3][1]=-2;
						posxy[4][0]=-1;
						posxy[4][1]=2;
						posxy[5][0]=-2;
						posxy[5][1]=1;
						posxy[6][0]=-1;
						posxy[6][1]=-2;
						posxy[7][0]=-2;
						posxy[7][1]=-1;
						for(i=0;i<8;i++)
						{
							int p1,p2;
							p1=u+posxy[i][0];
							p2=v+posxy[i][1];
							if(p1>=0 && p1<=7 && p2>=0 && p2<=7 &&  (board[p1][p2]==0 || (board[p1][p2]>=ops && 

board[p1][p2]<=ope) ))						{
								if(checkvalid(checkmovevalid,bw,u,v,p1,p2,k1,k2))
									{
										genm[lm][0]=u;
										genm[lm][1]=v;
										genm[lm][2]=p1;
										genm[lm][3]=p2;
										lm++;
									}
								}
						}
					}
					}catch(Exception t1){System.out.println("kn in gm");try{br1.readLine();}catch(Exception r){}}
				try
				{
				if(piece==bishop)
					{
						int posxy[][]=new int[4][2];
						int i;
						
						posxy[0][0]=1;
						posxy[0][1]=1;
						posxy[1][0]=-1;
						posxy[1][1]=1;
						posxy[2][0]=-1;
						posxy[2][1]=-1;
						posxy[3][0]=1;
						posxy[3][1]=-1;		
						lm=cp(genm,lm,posxy,4,bw,u,v,k1,k2,checkmovevalid);		
					}
				}catch(Exception t1){System.out.println("bishop in gm");try{br1.readLine();}catch(Exception r){}}
				try{
				if(piece==rook)
					{
						int posxy[][]=new int[4][2];
						int i;
						
						posxy[0][0]=0;
						posxy[0][1]=1;
						posxy[1][0]=1;
						posxy[1][1]=0;
						posxy[2][0]=-1;
						posxy[2][1]=0;
						posxy[3][0]=0;
						posxy[3][1]=-1;		
						lm=cp(genm,lm,posxy,4,bw,u,v,k1,k2,checkmovevalid);	
					}
				}catch(Exception t1){System.out.println("rook in gm");try{br1.readLine();}catch(Exception r){}}
				try
				{
				if(piece==queen)
					{
						int posxy[][]=new int[8][2];
						int i;
						
						posxy[0][0]=1;
						posxy[0][1]=1;
						posxy[1][0]=-1;
						posxy[1][1]=1;
						posxy[2][0]=-1;
						posxy[2][1]=-1;
						posxy[3][0]=1;
						posxy[3][1]=-1;
						posxy[4][0]=0;
						posxy[4][1]=1;
						posxy[5][0]=1;
						posxy[5][1]=0;
						posxy[6][0]=-1;
						posxy[6][1]=0;
						posxy[7][0]=0;
						posxy[7][1]=-1;
						lm=cp(genm,lm,posxy,8,bw,u,v,k1,k2,checkmovevalid);
					}
				}catch(Exception t1){System.out.println("queen in gm");try{br1.readLine();}catch(Exception r){}}
				try
				{
				if(piece==king)
					{	int posxy[][]=new int[8][2];
						int i;
						
						posxy[0][0]=1;
						posxy[0][1]=1;
						posxy[1][0]=-1;
						posxy[1][1]=1;
						posxy[2][0]=-1;
						posxy[2][1]=-1;
						posxy[3][0]=1;
						posxy[3][1]=-1;
						posxy[4][0]=0;
						posxy[4][1]=1;
						posxy[5][0]=1;
						posxy[5][1]=0;
						posxy[6][0]=-1;
						posxy[6][1]=0;
						posxy[7][0]=0;
						posxy[7][1]=-1;
						lm=cp(genm,lm,posxy,8,bw,u,v,u,v,1);
					}
				}catch(Exception t1){System.out.println("king in gm");try{br1.readLine();}catch(Exception r){}}
			}printpieceposm(genm,lm,4);	return lm;
		}
		public Boolean checkvalid(int checkmovevalid,int bw,int u,int v,int w,int x,int k1,int k2)
		{	int c1=0;
			if(checkmovevalid==0)
				return true;
			else
			{
				int n=board[w][x];
				int p=board[u][v];
				board[u][v]=0;
				board[w][x]=p;
				if(check(k1,k2,bw))
					c1=1;
				board[w][x]=n;
				board[u][v]=p;
				if(c1==1)
					return false;
				else			
					return true;
			}
		}
		public int cp(int [][]genm,int lm,int [][]posxy,int max,int bw,int u,int v,int k1,int k2 ,int checkmovevalid)
		{
			int s,e,ops,ope,l,kingmove;
			l=lm;
			int p1,p2,i;p1=0;p2=0;
			if(bw==0){ops=11;ope=15;s=1;e=6;}
			else{ops=1;ope=5;s=11;e=16;}
			if(board[u][v]%10==6)
				kingmove=1;
			else
				kingmove=0;
			System.out.println("len:"+ lm);
			/*for(i=0;i<lm;i++)
				for(int j=0;j<4;j++)
					System.out.println(genm[i][j]);
			for(i=0;i<max;i++){System.out.println(posxy[i][0]+","+posxy[i][1]);}
			*/
			for(i=0;i<max;i++)
				{int tog=0;	try{
					Boolean c1=true;
					while(c1)
					{
					if(tog==0)
					{
					p1=u+posxy[i][0];
					p2=v+posxy[i][1];
					tog=1;
					if(kingmove==1){c1=false;k1=p1;k2=p2;}
					}
					else
					{
					p1+=posxy[i][0];
					p2+=posxy[i][1];
					}
					if(p1>=0 && p1<=7 && p2>=0 && p2<=7)
						{if(kingmove==1 && !check(p1,p2,bw) && (board[p1][p2]==0 || (board[p1][p2]>=ops && board[p1][p2]

<=ope)))
						   {           genm[l][0]=u;
							genm[l][1]=v;
							genm[l][2]=p1;
							genm[l][3]=p2;			
							l++;
						    }	
						else{
							if(board[p1][p2]>=ops && board[p1][p2]<=ope)
							{
							c1=false;
							if( (checkvalid(checkmovevalid,bw,u,v,p1,p2,k1,k2)) )
							{genm[l][0]=u;
							genm[l][1]=v;
							genm[l][2]=p1;
							genm[l][3]=p2;			
							l++;
							}}
							else if(board[p1][p2]>=s && board[p1][p2]<=e)
							{
							c1=false;
							}
							else if(board[p1][p2]==0)
							{
							if( (checkvalid(checkmovevalid,bw,u,v,p1,p2,k1,k2)) )
							{genm[l][0]=u;
							genm[l][1]=v;
							genm[l][2]=p1;
							genm[l][3]=p2;			
							l++;
							}
							else{c1=false;}
							}
						  }

						}
					else {c1=false;}
					}
					}catch(Exception e2){System.out.println("err dan");}
				}
			return l;
			
		}
		public void PinnedPieces(int [][]mov,int bw,int length)
		{
						int posxy[][]=new int[8][2];
						
						int king,k1,k2,ops,ope,ups,upe;k1=0;k2=0;
						if(bw==0)
						{
							king=6;ups=1;upe=6;
							ops=11;ope=16;
						}
						else
						{
							king=16;ups=11;upe=16;
							ops=1;ope=6;
						}
						posxy[0][0]=1;
						posxy[0][1]=1;
						posxy[1][0]=-1;
						posxy[1][1]=1;
						posxy[2][0]=-1;
						posxy[2][1]=-1;
						posxy[3][0]=1;
						posxy[3][1]=-1;
						posxy[4][0]=0;
						posxy[4][1]=1;
						posxy[5][0]=1;
						posxy[5][1]=0;
						posxy[6][0]=-1;
						posxy[6][1]=0;
						posxy[7][0]=0;
						posxy[7][1]=-1;
						int fnd=0;
						for(int h=0;h<8;h++)
							{
								for(int l=0;l<8;l++)
									if(board[h][l]==king)
										{fnd=1;k1=h;k2=l;break;}
								if(fnd==1)break;
							}
						for(int i=0;i<8;i++)
							{	int start=1,p1,p2;
								Boolean c1=true;p2=0;p1=0;
								while(c1)
								{
									if(start==0)
										{p1+=posxy[i][0];
										 p2+=posxy[i][1];
										
										}
									else
										{
										p1=k1+posxy[i][0];
										p2=k2+posxy[i][1];
										start=0;
										}	
									if(p1>=0 && p1<=7 &&p2>=0 && p2<=7)
										{
										if(board[p1][p2]>=ops && board[p1][p2]<=ope)
											{
												c1=false;
											}
										else if(board[p1][p2]>=ups && board[p1][p2]<=upe)
											{
												search(p1,p2,mov,length);
												c1=false;	
											}
										}
									else
										c1=false;
								}
							}	
						
		}
		public void search(int x,int y,int [][]mov,int l)
		{
			for(int i=0;i<l;i++)
			{
				if(mov[i][0]==x && mov[i][1]==y)
					{mov[i][3]=1;
					break;
					}
			}	
		}
public int maxLevel(int bw,int depth,int y)
{	System.out.println("Inside max level"+bw+"& depth:"+depth);
	int value,x1;x1=0;BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//try{br.readLine();}catch(Exception e){}
	if(depth==0)
		return evaluate(bw);
	int len;int mov[][]=new int [16][64];
	int genm[][]=new int[2000][4];
	int best = -10000;
	len=MovablePieces(mov,bw);
	PinnedPieces(mov,bw,len);
	printpiecepos(mov,len,4);
	if(y==1){printbd();System.out.println("");
			//	try{br.readLine();}catch(Exception e){}
		}

	int lm=genmoves(mov,bw,len,genm);
	System.out.println("Length of moves list"+lm);//try{br.readLine();}catch(Exception e){}
	for(int i=0;i<lm;i++)
	{	value=0;
		
		//try{br.readLine();}catch(Exception e){}
		printbd();
		int u=genm[i][0];int v=genm[i][1];
		int w=genm[i][2];int x=genm[i][3];
		System.out.println(i+"choice moving from  "+ u+v+"to"+w+x);
		
		int p1=board[u][v];
		int p2=board[w][x];
		//if(check(w,x,(bw+1)%2))value-=10;
		board[u][v]=0;
		board[w][x]=p1;
		printbd();
		//if(check(w,x,bw))value+=20;
		
		value=minLevel(depth-1,(bw+1)%2);
		//System.out.println("value"+value);try{br.readLine();}catch(Exception e){}
		board[u][v]=p1;
		board[w][x]=p2;
		if(value>best)
			{best=value;x1=i;System.out.println("Best"+best+"move no"+x1);}
		
	}
	System.out.println("Best"+best+"move no"+x1+"y"+y);
	if(y==1)return x1;
	else
	return best;
	
}
int minLevel(int depth,int bw)
{	System.out.println("Inside min level of "+bw+"& depth:"+depth);BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//try{br.readLine();}

	int value,x;
	if(depth==0)
		return evaluate((bw+1)%2);
	int len;int mov[][]=new int [16][64];
	int genm[][]=new int[2000][4];
	int best = 10000;
	len=MovablePieces(mov,bw);
	PinnedPieces(mov,bw,len);
	printpiecepos(mov,len,4);
	int lm=genmoves(mov,bw,len,genm);
	for(int i=0;i<lm;i++)
	{	
		//try{br.readLine();}catch(Exception e){}
		printbd();
		int u=genm[i][0];int v=genm[i][1];
		int w=genm[i][2];x=genm[i][3];
		System.out.println(i+"choice moving from  "+ u+v+"to"+w+x);
		int p1=board[u][v];
		int p2=board[w][x];
		board[u][v]=0;
		board[w][x]=p1;
		printbd();
		value=maxLevel((bw+1)%2,depth-1,0);
		System.out.println("Value from min depth"+depth+"is "+value);
		board[u][v]=p1;
		board[w][x]=p2;
		if(value<best)
			{best=value;x=i;}
		
	}
	return best;		
}
int evaluate(int bw)
{
	int queen,pawn,knight,bishop,rook;
	queen=900;pawn=100;knight=300;bishop=300;rook=500;
	int value=0;updatepostab();
	//if(bw==0){}else{}
	int pos[][]=new int[8][8];
	int king,k1,k2;
	
	k1=k2=0;int ops,ope;
	if(bw==1)
		{ops=1;ope=6;}
	else{ops=11;ope=16;}
	for(int i=0;i<8;i++)
		{
		for(int j=0;j<8;j++)
			{	int piece=board[i][j];
				if(piece==6 && bw==1){k1=i;k2=j;}
				else if(piece==16 && bw==0){k1=i;k2=j;}
			}
		}
				
										
	Boolean gameon=GAMEON((bw+1)%2);
	
	
	Boolean checkforrivalking=check(k1,k2,(bw+1)%2);
	System.out.println("Game on for"+((bw+1)%2)+"is"+gameon+"There is "+checkforrivalking);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//try{br.readLine();}catch(Exception e){}
	if(!gameon &&checkforrivalking)return 10000;
	if(!gameon &&!checkforrivalking)return -10000;
	if(checkforrivalking)value+=20;
	for(int i=0;i<8;i++)
		{
		for(int j=0;j<8;j++)
			{
				if(i==0 || i==1 || i==6 || i==7)
					pos[i][j]=0;
				else if(i==2 && bw==1)
					pos[i][j]=1;
				else if(i==6 && bw==0)
					pos[i][j]=1;
				else if(i==3 && (j==3||j==4) && bw==0 )
					pos[i][j]=3;
				else if(i==4 && (j==3||j==4) && bw==0 )
					pos[i][j]=2;
				else if(i==3 && (j==3||j==4) && bw==1 )
					pos[i][j]=2;
				else if(i==4 && (j==3||j==4) && bw==1 )
					pos[i][j]=3;
				else
					pos[i][j]=1;
			}
		}
	for(int i=0;i<8;i++)
		{for(int j=0;j<8;j++)
			System.out.print(pos[i][j]+ "   ");
		System.out.println("");
		}
	for(int i=0;i<8;i++)
		{for(int j=0;j<8;j++)
			{	int piece =board[i][j];
				switch(board[i][j]%10)
				{
				case 1:
				if(bw==0 &&  piece==11)
					value-=pawn;
				else if(bw==0 && piece==1)
					value+=pawn;
				else if(bw==1 &&  piece==11)
					value+=pawn;
				else if(bw==1 && piece==1)
					value-=pawn;
				break;
				case 2:
				if(bw==0 &&  piece==12)
					value-=rook;
				else if(bw==0 && piece==2)
					value+=rook;
				else if(bw==1 &&  piece==12)
					value+=rook;
				else if(bw==1 && piece==2)
					value-=rook;
				break;
				case 3:
				if(bw==0 &&  piece==13)
					value-=knight;
				else if(bw==0 && piece==3)
					value+=knight;
				else if(bw==1 &&  piece==13)
					value+=knight;
				else if(bw==1 && piece==3)
					value-=knight;
				break;
				case 4:
				if(bw==0 &&  piece==14)
					value-=bishop;
				else if(bw==0 && piece==4)
					value+=bishop;
				else if(bw==1 &&  piece==14)
					value+=bishop;
				else if(bw==1 && piece==4)
					value-=bishop;
				break;
				case 5:
				if(bw==0 &&  piece==15)
					value+=queen;
				else if(bw==0 && piece==5)
					value+=queen;
				else if(bw==1 &&  piece==15)
					value+=queen;
				else if(bw==1 && piece==5)
					value-=queen;
				break;
					
				}
				if(bw==1){if(board[i][j]==11)value+=pos[i][j];}
				else{if(board[i][j]==1)value+=pos[i][j];}
				//System.out.println("value"+value);
			}
		}
	/*	if(movescount<=10 &&blacktab.queen.u!=0 &&blacktab.queen.v!=3)value-=15;//Early queen
		for(int i=0;i<=6;i++)
			{for(int j=i+1;j<=7;j++)
				{
					if(blacktab.p[i].present && blacktab.p[j].present)
					{
						if(blacktab.p[i].v == blacktab.p[j].v)
							value-=10;//Doubled pawn
						if(blacktab.p[i].u == blacktab.p[j].u && ( (blacktab.p[i].v == blacktab.p[j].v+1) ||(blacktab.p[i].v == blacktab.p

[j].v-1) ))
							value-=5;//pawn on side of another pawn
					}
				}
			}
		for(int k=0;k<=1;k++)
			{
					int u =blacktab.knight[k].u;
					int v=blacktab.knight[k].v;
					if(blacktab.knight[k].present)
					{
						int posxy[][]=new int[8][2];
						int i;
						
						posxy[0][0]=2;
						posxy[0][1]=-1;
						posxy[1][0]=2;
						posxy[1][1]=1;
						posxy[2][0]=1;
						posxy[2][1]=2;
						posxy[3][0]=1;
						posxy[3][1]=-2;
						posxy[4][0]=-1;
						posxy[4][1]=2;
						posxy[5][0]=-2;
						posxy[5][1]=1;
						posxy[6][0]=-1;
						posxy[6][1]=-2;
						posxy[7][0]=-2;
						posxy[7][1]=-1;
						for(i=0;i<8;i++)
						{
							int p1,p2;
							p1=u+posxy[i][0];
							p2=v+posxy[i][1];
							if(p1>=0 && p1<=7 && p2>=0 && p2<=7 &&  (board[p1][p2]==0 || (board[p1][p2]>=ops && 

board[p1][p2]<=ope) ))						{
									if(!check(p1,p2,bw))
										value+=1;
									else value-=1;
									
								}
						}
					}
				
				}

		if(check(blacktab.king.u,blacktab.king.v,bw))
			value-=20;
		{			//Bishop mobility
			for(int p=0;p<=1;p++)
				{
					if(blacktab.bishop[p].present)
						{
						int posxy[][]=new int[4][2];
						int i;
						
						posxy[0][0]=1;
						posxy[0][1]=1;
						posxy[1][0]=-1;
						posxy[1][1]=1;
						posxy[2][0]=-1;
						posxy[2][1]=-1;
						posxy[3][0]=1;
						posxy[3][1]=-1;value+=(ccp(posxy,bw,blacktab.bishop[p].u,blacktab.bishop[p].v,4));
						}
						
				}
		}
		for(int k=0;k<2;k++)
					{if(blacktab.rook[k].present)
						{
						int posxy[][]=new int[4][2];
						int i;
						
						posxy[0][0]=0;
						posxy[0][1]=1;
						posxy[1][0]=1;
						posxy[1][1]=0;
						posxy[2][0]=-1;
						posxy[2][1]=0;
						posxy[3][0]=0;
						posxy[3][1]=-1;		
						value+=2*(ccp(posxy,bw,blacktab.rook[k].u,blacktab.rook[k].v,4));
						}	
					}
				if(blacktab.queen.present)
					{
						int posxy[][]=new int[8][2];
						int i;
						
						posxy[0][0]=1;
						posxy[0][1]=1;
						posxy[1][0]=-1;
						posxy[1][1]=1;
						posxy[2][0]=-1;
						posxy[2][1]=-1;
						posxy[3][0]=1;
						posxy[3][1]=-1;
						posxy[4][0]=0;
						posxy[4][1]=1;
						posxy[5][0]=1;
						posxy[5][1]=0;
						posxy[6][0]=-1;
						posxy[6][1]=0;
						posxy[7][0]=0;
						posxy[7][1]=-1;
						value+=2*(ccp(posxy,bw,blacktab.queen.u,blacktab.queen.v,8));
					}
				
				*//*	{	int posxy[][]=new int[8][2];
						int i;
						//King mobility
						posxy[0][0]=1;
						posxy[0][1]=1;
						posxy[1][0]=-1;
						posxy[1][1]=1;
						posxy[2][0]=-1;
						posxy[2][1]=-1;
						posxy[3][0]=1;
						posxy[3][1]=-1;
						posxy[4][0]=0;
						posxy[4][1]=1;
						posxy[5][0]=1;
						posxy[5][1]=0;
						posxy[6][0]=-1;
						posxy[6][1]=0;
						posxy[7][0]=0;
						posxy[7][1]=-1;
						value+=2*(ccp(posxy,bw,blacktab.king.u,blacktab.king.v,8));
					}*/

		
		System.out.println("Evaluation of Board "+bw+"value  "+value);
		printbd();
	//	try{br.readLine();}catch(Exception e){}
		return value;
}

public int alphabeta(int bw,int depth,int y,int alpha,int beta)
{	System.out.println("Inside alphabeta level bw:"+bw+"& depth:"+depth);int BLACK=1;
	int value,x1;x1=0;BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//if(movescount==4)try{br.readLine();}catch(Exception e){}
	if(depth==0)
		return evaluate(BLACK);
	int len;int mov[][]=new int [16][64];
	int genm[][]=new int[2000][4];
	int best = -10001;
	len=MovablePieces(mov,bw);
	PinnedPieces(mov,bw,len);
	printpiecepos(mov,len,4);
	if(y==1){printbd();System.out.println("");
			//	try{br.readLine();}catch(Exception e){}
		}

	int lm=genmoves(mov,bw,len,genm);
	System.out.println("Length of moves list"+lm);//try{br.readLine();}catch(Exception e){}
	for(int i=0;i<lm;i++)
	{	value=0;
		
		//try{br.readLine();}catch(Exception e){}
		printbd();
		int u=genm[i][0];int v=genm[i][1];
		int w=genm[i][2];int x=genm[i][3];
		System.out.println(i+"choice moving from  "+ u+v+"to"+w+x);
		//if(movescount==4)try{br.readLine();}catch(Exception e){}
		int p1=board[u][v];
		int p2=board[w][x];
	//	if(check(w,x,(bw+1)%2))value-=10;
		board[u][v]=0;
		board[w][x]=p1;
		printbd();
	//	if(check(w,x,bw))value+=20;
			
		value=-alphabeta((bw+1)%2,depth-1,0,-beta,-alpha);
		
		if(value>best)
			{best=value;x1=i;System.out.println("Best move is "+x1+"vslue "+value);printbd();
			//if(movescount==4)try{br.readLine();}catch(Exception e){}
			}
		if(value>alpha)
			alpha=best;
		board[u][v]=p1;
		board[w][x]=p2;
		if(value>=beta)
			break;
		
	}if(y==1)return x1;
	else
	return best;
	
}
	public void updatepostab()
	{	int bpc,bbc,bknc,brc;
		bpc=bbc=bknc=brc=0;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{try{
				int piece=board[i][j];
				if(piece==11)
				{
				blacktab.p[bpc].u=i;
				blacktab.p[bpc].v=j;
				blacktab.p[bpc].present=true;
				bpc++;	
				}
				else if(piece==12)
				{
				blacktab.rook[brc].u=i;
				blacktab.rook[brc].v=j;
				blacktab.rook[brc].present=true;
				brc++;
				}
				else if(piece==13)
				{
				blacktab.knight[bknc].u=i;
				blacktab.knight[bknc].v=j;
				blacktab.knight[bknc].present=true;
				bknc++;
				}
				else if(piece==14)
				{
				blacktab.bishop[bbc].u=i;
				blacktab.bishop[bbc].v=j;
				blacktab.bishop[bbc].present=true;
				bbc++;
				}
				else if(piece==15)
				{
				blacktab.queen.u=i;
				blacktab.queen.v=j;
				blacktab.queen.present=true;
				}
				else if(piece==16)
				{
				blacktab.king.u=i;
				blacktab.king.v=j;
				blacktab.king.present=true;
				}
			}catch(Exception e){System.out.println(bpc+bknc+bbc+brc);}	
			}
		}
		for(int i=bpc;i<=7;i++)
		{
				blacktab.p[i].u=-1;
				blacktab.p[i].v=-1;
				blacktab.p[i].present=false;
		}
		for(int i=bknc;i<=1;i++)
		{
				blacktab.knight[i].u=-1;
				blacktab.knight[i].v=-1;
				blacktab.knight[i].present=false;
		}
		for(int i=bbc;i<=1;i++)
		{
				blacktab.bishop[i].u=-1;
				blacktab.bishop[i].v=-1;
				blacktab.bishop[i].present=false;
		}
		for(int i=brc;i<=1;i++)
		{
				blacktab.rook[i].u=-1;
				blacktab.rook[i].v=-1;
				blacktab.rook[i].present=false;
		}
		
	}
	public void printblacktable()
	{
		for(int i=0;i<=7;i++)
			System.out.println(blacktab.p[i].u+","+blacktab.p[i].v+blacktab.p[i].present);
		for(int i=0;i<=1;i++)
			System.out.println(blacktab.bishop[i].u+","+blacktab.bishop[i].v+blacktab.bishop[i].present);
		for(int i=0;i<=1;i++)
			System.out.println(blacktab.knight[i].u+","+blacktab.knight[i].v+blacktab.knight[i].present);
		for(int i=0;i<=1;i++)
			System.out.println(blacktab.rook[i].u+","+blacktab.rook[i].v+blacktab.rook[i].present);
		System.out.println(blacktab.king.u+","+blacktab.king.v+blacktab.king.present);
		System.out.println(blacktab.queen.u+","+blacktab.queen.v+blacktab.queen.present);
	}
	public int ccp(int [][]posxy,int bw,int u,int v,int max)
		{
			int s,e,ops,ope,l,kingmove;
			
			int p1,p2,i;p1=0;p2=0;int cnt=0;
			if(bw==0){ops=11;ope=16;s=1;e=6;}
			else{ops=1;ope=6;s=11;e=16;}
			if(board[u][v]%10==6)
				kingmove=1;
			else
				kingmove=0;
			for(i=0;i<max;i++)
				{int tog=0;	try{
					Boolean c1=true;
					while(c1)
					{
					if(tog==0)
						{
						p1=u+posxy[i][0];
						p2=v+posxy[i][1];
						tog=1;
						if(kingmove==1){c1=false;}
						}
					else
						{
						p1+=posxy[i][0];
						p2+=posxy[i][1];
						}
					if(p1>=0 && p1<=7 && p2>=0 && p2<=7)
						{if(kingmove==1 && !check(p1,p2,bw) && (board[p1][p2]==0 || (board[p1][p2]>=ops && board[p1][p2]

<=ope)))
						   {          cnt++;
						    }	
						else{	Boolean ch=check(p1,p2,bw);
							if(board[p1][p2]>=ops && board[p1][p2]<=ope && !ch)
							{
							c1=false;
							cnt++;
							}
							else if(board[p1][p2]>=s && board[p1][p2]<=e)
							{
							c1=false;
							}
							else if(board[p1][p2]==0 && !ch)
							{
							cnt++;
							}
							}
						  }

						
					else {c1=false;}
					}
					}catch(Exception e2){System.out.println("err dan");}
				}
			return cnt;
			
		}
}
