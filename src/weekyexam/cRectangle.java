package weekyexam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vostro 1310
 */
public class cRectangle {
    private int xT=0,
            yT=0,
            xB=0,
            yB=0;
    private int w,h;
    private int iColor =0;
    
    public cRectangle(){
        w=0;
        h=0;
    }
    
    public cRectangle( int x1, int y1, int x2, int y2){
        xT = x1<x2? x1:x2;
        xB = x1+x2 - xT;
        yT = y1>y2? y1:y2;
        yB = y1+y2 - yT;
        w= xB-xT;
        h= yB - yT;
    }
    
    public cRectangle( int x1, int y1, int x2, int y2, int c){
        xT = x1<x2? x1:x2;
        xB = x1+x2 - xT;
        yT = y1>y2? y1:y2;
        yB = y1+y2 - yT;
        w= xB-xT;
        h= yB - yT;
        iColor =c;
    }
    
   public void setXtop(int x){
       xT = x<xB? x:xB;
       xB = x+xB -xT;
       w= xB-xT;
   }
   
   public void setYtop(int y){
       yT = y<yB? y:yB;
       yB = y+yB -yT;
       h= yB-yT;
   }
   
   public void setXYtop(int x, int y){
       setXtop(x);
       setYtop(y);
   }

   public void setXbottom(int x){
       xB = x>xT? x:xT;
       xT = x+xT -xB;
       w= xB-xT;
   }
   
   public void setYbottom(int y){
       yB = y>yT? y:yT;
       yT = y+yT -yB;
       h= yB-yT;
   }
   
   public void setXTbottom( int x, int y){
       setXbottom(x);
       setYbottom(y);
   }
   
   public void setColor( int c){
       iColor = c;
   }
   
   public int getXtop(){
        return xT;
    }
    
    public int getYtop(){
        return yT;
    } 
    
    public int getXbottom(){
        return xB;
    }
    
    public int getYbottom(){
        return yB;
    }
    
    public int getWidth(){
        return w;
    }
    
    public int getHeight(){
        return h;
    }
    public int getColor(){
        return iColor;
    }
}
