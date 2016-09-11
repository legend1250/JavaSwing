package Beginner;

/**
*
* @author Michael Vu 
* 9600278
*/
public class cStringLib {
   private static final String s123Digits = "123";
   private static final String sDigits = "1234567890";
   private static final String sBinaryDigits = "01" ;
    /**
    * 
    * @param s a String input
    * @return true if all character in s is number (1,2,3), otherwise false
    */
   public static boolean isBinaryString( String s){
       boolean blResult = true;
       String s1= s.trim(),s0;
       if( s1.length()>0){
           for(int i=0; i<s1.length(); i++){
               s0= s1.substring(i,i+1);
               if( cStringLib.sBinaryDigits.indexOf(s0)<0){
                   blResult= false;
               }
           }
       }
       else{
           blResult= false;
       }
       return blResult;
   }
   /**
    * 
    * @param s a String input
    * @return true if all character in s is number (1,2,3), otherwise false
    */
   public static boolean is123String( String s){
       boolean blResult = true;
       String s1= s.trim(),s0;
       if( s1.length()>0){
           for(int i=0; i<s1.length(); i++){
               s0= s1.substring(i,i+1);
               if( cStringLib.s123Digits.indexOf(s0)<0){
                   blResult= false;
               }
           }
       }
       else{
           blResult= false;
       }
       return blResult;
   }
   /**
    * 
    * @param s a String input
    * @return true if all character in s is number (0,1,2,...,9), otherwise false
    */
   public static boolean isNumberString( String s){
       boolean blResult = true;
       String s1= s.trim(),s0;
       if( s1.length()>0){
           for(int i=0; i<s1.length(); i++){
               s0= s1.substring(i,i+1);
               if( cStringLib.sDigits.indexOf(s0)<0){
                   blResult= false;
               }
           }
       }
       else{
           blResult= false;
       }
       return blResult;
   }
  
    /**
    * 
    * @param s a String input
    * @return true if all character in s is number (0,1,2,...,9), otherwise false
    */
   public static boolean isIntegerNumbers( String s){
       boolean blResult = true;
       String s1= s.trim(),s0;
       if( s1.length()>0){
           if( s1.substring(0,1).equals("-")){
               s1= s1.substring(1);
           }
           if( s1.length()>0){
               for(int i=0; i<s1.length(); i++){
                   s0= s1.substring(i,i+1);
                   if( cStringLib.sDigits.indexOf(s0)<0){
                       blResult= false;
                   }
               }
           }
           else{
               blResult =false;
           }
       }
       else{
           blResult=false;
       }
       return blResult;
   }
   
   
}