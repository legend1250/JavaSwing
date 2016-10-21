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
public class cRectangle_Sample {
    public static void main(String[] a){
        cRectangle_Data.init(5);
        cRectangle recT;
        for(int i=0; i< cRectangle_Data.getNrect();i++){
            System.out.println("Rect "+ i+ ":");
            recT= cRectangle_Data.getRect(i);
            System.out.println("\t x1="+ recT.getXtop());
            System.out.println("\t y1="+ recT.getYtop());
            System.out.println("\t x2="+ recT.getXbottom());
            System.out.println("\t y2="+ recT.getYbottom());
            System.out.println("\t colot="+ recT.getColor());
            
            
        }
    }
}
