import java.util.*;
public class TicTacToe {
    public static void main(String args[]) {
        Scanner in= new Scanner(System.in);
      String [][] board= new String [3][3]  ;
     // initializes board
     for(int i=0;i<3;i++){
           for(int j=0; j<3;j++){
           board[i][j]="[" +i+","+j +  "]";
          System.out.print(board[i][j]);
       }
       
           
           System.out.println();
       }
        
        // boolean b=false;
        int choice=0;
      //  System.out.println("1 player or 2 player?");
        //choice=in.nextInt();
    // while(b==false) {
      //  if(choice==1){
        //tic(board);
        //}else if(choice==2){
            mpTicTacToe(board);
        //}
        //else {
        	
        	//System.out.println("ERROR please put 1 or 2");
          //  choice=in.nextInt();
        //}
        	
     
     //}
    
        
        
    }
// vs computer
    public static void tic(String [][]b){
      
      
      Scanner in= new Scanner(System.in);
       // displays empty board
      String symbol="";
        String compSymbol="";
        System.out.println("Choose a symbol X or O");
        symbol=in.next();
       
       if(symbol.equalsIgnoreCase("x"))
       compSymbol="O";
       else
       compSymbol="X";
      
       int cX=0;// coordinates for computer
       int cY=0;
       
       //int x= (int) (Math.random()*10)+0 ;// random number between 0-10
     /*  
       for(int i=0;i<3;i++){
           for(int j=0; j<3;j++){
           b[i][j]="[ ]";
           System.out.print(b[i][j]);
       }
       
           
           System.out.println();
       }
       */
       
        
       int x=0;
       int y=0;
        
      ArrayList <Integer> usedX= new ArrayList();
      ArrayList <Integer> usedY= new ArrayList();
boolean unique=false;// checks if the coordinates are allready used
       
       boolean finished=false;
      //  b[x][y]=symbol;
        while(finished==false){
              
        System.out.println("Put in X coordinate");
        
        x=in.nextInt();
        System.out.println("Put in Y coordinate");
        y=in.nextInt();
               b[x][y]="[ "+symbol+" ]";
               
               usedX.add(x);
               usedY.add(y);
             /*  
               for(int i=0;i<3;i++){
           for(int j=0; j<3;j++){
           //b[i][j]="[]";
           System.out.print(b[i][j]);
       }
           System.out.println();
       }
       */
      
            while(unique== false){
            
            	cX= (int) (Math.random()*3)+0;
            	cY=(int) (Math.random()*3)+0;
            
       if( !(usedX.contains(cX))&&!(usedY.contains(cY))){
            	
            	unique=true;
            }else {
                cX= (int) (Math.random()*3)+0;
       
                cY=(int) (Math.random()*3)+0;
                
            }
                    
            }
            unique=false;
            
           b[cX][cY]="[ "+compSymbol+" ]"; 
       //
           for(int i=0;i<3;i++){
               for(int j=0; j<3;j++){
               //b[i][j]="[]";
               System.out.print(b[i][j]);
           }
               System.out.println();
           }
           
           System.out.println("----------");
           
           if((b[0][0]==symbol) &&(b[1][1]==symbol)&&(b[2][2]==symbol))
            finished=true;
            
        }
      
      
      System.out.println("end");
      /*
         for(int i=0;i<3;i++){
           for(int j=0; j<3;j++){
           //b[i][j]="[]";
           System.out.print(b[i][j]);
       }
       
           
           System.out.println();
       }
        */
    }
    // multiplayer
    public static void mpTicTacToe(String[][] b){
        
    	
    	String winner="";
    	
    	 boolean finished=false;
         //  b[x][y]=symbol;
           
    	 
    	 
         Scanner in= new Scanner(System.in);
          // displays empty board
         String symbolP1="";
           String symbolP2="";
           System.out.println("Choose a symbol X or O");
           symbolP1=in.next();
          
          if(symbolP1.equalsIgnoreCase("x"))
        	  symbolP2="O";
          else
        	  symbolP2="X";
         
          
          int x=0;// coordinates for p1
          int y=0;
          int cX=0;// coordinates for p2
          int cY=0;
          
    	 
    	 
    	 while(finished==false){
                 
           System.out.println("Player 1 Put in X coordinate");
           
           x=in.nextInt();
           System.out.println("Player 1 Put in Y coordinate");
           y=in.nextInt();
                  b[x][y]="[ "+symbolP1+" ]";
                  
               //   usedX.add(x);
                 // usedY.add(y);
                /*  */
                  for(int i=0;i<3;i++){
              for(int j=0; j<3;j++){
              //b[i][j]="[]";
              System.out.print(b[i][j]);
          }
              System.out.println();
          }
                  
                    System.out.println("----------");
                  if( (b[0][0].equals("[ "+symbolP1+" ]") )&&(b[1][1].equals("[ "+symbolP1+" ]"))&&(b[2][2].equals("[ "+symbolP1+" ]")) ||  
                		  
                 		 // hozontal
                 		  
                 		   (b[0][0].equals("[ "+symbolP1+" ]")) &&(b[0][1].equals("[ "+symbolP1+" ]"))&&(b[0][2].equals("[ "+symbolP1+" ]")) ||  
                 		  (b[1][0].equals("[ "+symbolP1+" ]")) &&(b[1][1].equals("[ "+symbolP1+" ]"))&&(b[1][2].equals("[ "+symbolP1+" ]")) ||  
                  	(b[2][0].equals("[ "+symbolP1+" ]")) &&(b[2][1].equals("[ "+symbolP1+" ]"))&&(b[2][2].equals("[ "+symbolP1+" ]")) ||
                 
                  	// vertical
                 		   (b[0][0].equals("[ "+symbolP1+" ]")) &&(b[1][0].equals("[ "+symbolP1+" ]"))&&(b[2][0].equals("[ "+symbolP1+" ]")) ||
                 		  (b[0][1].equals("[ "+symbolP1+" ]")) &&(b[1][1].equals("[ "+symbolP1+" ]"))&&(b[2][1].equals("[ "+symbolP1+" ]")) ||   
                 		  (b[0][2].equals("[ "+symbolP1+" ]")) &&(b[1][2].equals("[ "+symbolP1+" ]"))&&(b[2][2].equals("[ "+symbolP1+" ]")) 
                 		 
                 		  ) {
                    finished=true;
                   winner="player1";
                  break; 
                  }
          
                  if(boardFull(symbolP1,symbolP2,b)==true) {
                	  break;
                  }

                  System.out.println("Player 2 Put in X coordinate");
                  cX=in.nextInt();
                  System.out.println("Player 2 Put in Y coordinate");
                  cY=in.nextInt();

              
               
              b[cX][cY]="[ "+symbolP2+" ]"; 
          //
              for(int i=0;i<3;i++){
                  for(int j=0; j<3;j++){
                  //b[i][j]="[]";
                  System.out.print(b[i][j]);
              }
                  System.out.println();
              }
              
              System.out.println("----------");
              if(boardFull(symbolP1,symbolP2,b)==true) {
            	  break;
              }
            //  finished=boardFull(symbolP1,symbolP2,b);//

             
               if(
            		  
            		  (b[0][0].equals("[ "+symbolP2+" ]")) &&(b[1][1].equals("[ "+symbolP2+" ]"))&&(b[2][2].equals("[ "+symbolP2+" ]")) ||  
            		  
            		  
             		 // hozontal
             		  
             		   (b[0][0].equals("[ "+symbolP2+" ]")) &&(b[0][1].equals("[ "+symbolP2+" ]"))&&(b[0][2].equals("[ "+symbolP2+" ]")) ||  
             		  (b[1][0].equals("[ "+symbolP2+" ]")) &&(b[1][1].equals("[ "+symbolP2+" ]"))&&(b[1][2].equals("[ "+symbolP2+" ]")) ||  
              	(b[2][0].equals("[ "+symbolP2+" ]")) &&(b[2][1].equals("[ "+symbolP2+" ]"))&&(b[2][2].equals("[ "+symbolP2+" ]")) ||
             
              	// vertical
             		   (b[0][0].equals("[ "+symbolP2+" ]")) &&(b[1][0].equals("[ "+symbolP2+" ]"))&&(b[2][0].equals("[ "+symbolP2+" ]")) ||
             		  (b[0][1].equals("[ "+symbolP2+" ]")) &&(b[1][1].equals("[ "+symbolP2+" ]"))&&(b[2][1].equals("[ "+symbolP2+" ]")) ||   
             		  (b[0][2].equals("[ "+symbolP2+" ]")) &&(b[1][2].equals("[ "+symbolP2+" ]"))&&(b[2][2].equals("[ "+symbolP2+" ]")) 
            		  
            		  ) {
            	  
            	  finished=true;
                  winner="player2";
            	  break;
              } 
               
          
    	 
    	 }
         
         if(winner.equals("player1"))
        	   System.out.println("player 1 wins!");
           else if(winner.equals("player2"))
        	   System.out.println("player 2 wins!");
           else
        	   System.out.println("its a tie");
        
    }
  
     public static boolean boardFull(String p1, String p2, String[][]b) {
    	 String p1Symbol="[ "+p1+" ]";
    	 String p2Symbol="[ "+p2+" ]";
     	 
    	 
    	 for(int i=0;i<3;i++) {
    		 for(int j=0;j<3;j++) {
    			 if(!(b[i][j].equals(p1Symbol))&&!(b[i][j].equals(p2Symbol))) {
    			 return false;
    			 
    		 }
    		 } 
    		 
    	 }
     return true;
    	  
     }
    
    
    
}




