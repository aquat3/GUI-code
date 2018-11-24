/*
Tofik Mahdi
CMSC-131-04
Project 2: Breakout


*/



int rad = 10;        // size of ball
int xpos= 250 + int(random(-80,80));
int ypos= 350;    
int xspeed = 5;   
int yspeed = -5;  
int xdirection = 1;  // right or left
int ydirection = 1;  // Top to Bottom

int [] bricks= new int [20];

 int xPaddle = 250;
 int yPaddle = 390;  

int paddleSize = 20;

 
 
void setup() 
{
 
  size(400,400);
   
  frameRate(30);
   
   
 for (int i=0; i<20; i++) {
    bricks[i] = 1; // initializes brick array 

 }

}// end setup

void draw() 
{
  background(253,252,19);
 
 
 
 // moves the ball
  xpos += xspeed;
  ypos += yspeed;
  if (xpos>width || xpos<0)  
    xspeed *= -1;
  if (ypos<0)
    yspeed *= -1;
 
 
 // Checks if user clicks right or left keys
  if (keyPressed) {
    if (keyCode == RIGHT ) {
      // Moves paddle right
      xPaddle +=  9;//8
    } else if (keyCode == LEFT ) {
      // Moves paddle left
      xPaddle -=  9;//8
    } else if (key == ' ') {
      // resets game if user presses space
      xpos = 250 + int(random(-80,80));
      ypos = 250;
      xspeed = 5;  
      yspeed = -5;
      xPaddle = 250;
     
      for (int i=0; i<20; i++) {
        bricks[i] = 1;
      }
    }
  }
 
 
 // checks if ball hits paddle
  if ((xPaddle - paddleSize)<xpos && 
  (xPaddle+paddleSize)>xpos && 
    (yPaddle-rad)<ypos && (yPaddle)>ypos) {
    
    yspeed *= -1;
    
    
  }
 
 
 ellipse(xpos,ypos,rad,rad); //ball

 
 fill(0,0,222);
 rect(xPaddle, yPaddle, paddleSize*2+1, rad+1);// creates paddle
  
  if (ypos>=height -rad) {
    textSize(20);
    textAlign(CENTER);
    fill(0);// changes color of text
    text("Press SPACE to reset", 250, 250);
  }
 
 
  for (int i=0; i<20; i++) {
   
    // brick position
  int  xBrick = i%5*100+10;  
   int yBrick = 40*(i/5)+10; 
     
    if (bricks[i]==1) { 
      // creates bricks
      rect(xBrick+10, yBrick+10, 60, 20); //80
      
 
if(i%2 ==0)
fill(220,0,0);// changes color to red
else
fill(0,222,0);// changes to green
  
}
     // removes blocks if ball hits them
    if (xpos>(xBrick+4) && xpos<(xBrick+76) &&
      ypos>yBrick && ypos<(yBrick+20) && bricks[i]==1) { 
      
        bricks[i]=0;// removes bricks
      
      yspeed *=-1; 
       
    }
 
 
    if (((xpos>(xBrick-5) && xpos<xBrick) || (xpos>(xBrick+80) && 
      xpos<(xBrick+85))) &&
      ypos>yBrick && ypos<(yBrick+20) &&  bricks[i]==1) { 
      
       bricks[i]=0;
      xspeed *= -1;
       
    }
    
    if (((xpos>(xBrick-1) && xpos<(xBrick+5)) || (xpos>(xBrick+75) && xpos<(xBrick+81))) &&
      ypos>yBrick && ypos<(yBrick+20) && bricks[i]==1) { 
      bricks[i]=0;
      xspeed *= -1;
      yspeed *= -1;
       
    }
  }// loop
  

  

  } //end draw()
  