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
public class cRectangle_Data {
    private static int nRect=20;
    private static cRectangle[] aRect= null;
    static{
        init(nRect);
    }
    
    public static boolean init( int nR){
        if(nR<=0){
            return false;
        }
        nRect = nR;
        aRect = new cRectangle[nRect];
        for(int i=0; i<nRect; i++){
            aRect[i]= genRect();
        }
        return true;
    }
    
    private static cRectangle genRect(){
        int x1 = ((int) (Math.random()*1000))% 200;
        int y1 = ((int) (Math.random()*1000))% 200;    
        int x2 = ((int) (Math.random()*1000))% 200;
        int y2 = ((int) (Math.random()*1000))% 200;
        int c = ((int) (Math.random()*1000))% 3;
        return (new cRectangle(x1, y1, x2, y2, c));
    }
    
    public static cRectangle getRect(int i){
        if( i<0 || i>=nRect){
            return null;
        }
        return aRect[i];
    }
    
    public static int getXtop( int i){
        if( i<0 || i>=nRect){
            return 0;
        }
        return aRect[i].getXtop();
    }
    
    public static int getYtop( int i){
        if( i<0 || i>=nRect){
            return 0;
        }
        return aRect[i].getYtop();
    }

    public static int getXbottom( int i){
        if( i<0 || i>=nRect){
            return 0;
        }
        return aRect[i].getXbottom();
    }
    
    public static int getYbottom( int i){
        if( i<0 || i>=nRect){
            return 0;
        }
        return aRect[i].getYbottom();
    }
    
    public static int getColor( int i){
        if( i<0 || i>=nRect){
            return 0;
        }
        return aRect[i].getColor();
    }

    public static int getNrect(){
        return nRect;
    }
}
