package weekyexam;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class cWE06A_Prog02_T151487_Panel01 extends JPanel{

	boolean doDraw = false;
	public void paint(Graphics g){
		super.paint(g);
		if(doDraw){
			for(int i=0; i< cRectangle_Data.getNrect();i++){
	            /*System.out.println("Rect "+ i+ ":");
	            recT= cRectangle_Data.getRect(i);
	            System.out.println("\t x1="+ recT.getXtop());
	            System.out.println("\t y1="+ recT.getYtop());
	            System.out.println("\t x2="+ recT.getXbottom());
	            System.out.println("\t y2="+ recT.getYbottom());
	            System.out.println("\t color="+ recT.getColor());*/
				cRectangle recT;
	            recT= cRectangle_Data.getRect(i);
				if(recT.getColor()==0){
					g.setColor(Color.BLUE);
				}
				else if (recT.getColor() == 1){
					g.setColor(Color.RED);
				}
				else if (recT.getColor() == 2){
					g.setColor(Color.GREEN);
				}
	            g.drawRect(recT.getXtop(), recT.getYtop(), 
	            		recT.getXbottom(), recT.getYbottom());
	        }
		}
	}
	
}
