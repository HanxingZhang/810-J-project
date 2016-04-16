/*
 * Author: Hanxing Zhang
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

class ChessPad extends Panel implements MouseListener, ActionListener,FocusListener
{
 int x = -1, y = -1, chessColor = 1;
 
 String blackname="",whitename="";

 Button button=new Button("start");
 Button inputButton=new Button("input");
 
 TextField text_1=new TextField("black please"),
     text_2=new TextField(""),//white please
     text_3=new TextField("black'name"),
     text_4=new TextField("white'name");
 
 ChessPad()
 {
  add(inputButton);
  inputButton.setBounds(35,5,60,26);
  inputButton.addActionListener(this);
  inputButton.addFocusListener(this);
  add(text_3);
  text_3.setBounds(115,5,90,24);
  text_3.addFocusListener(this);
  text_3.setEditable(true);
  
  add(text_4);
  text_4.setBounds(315,5,90,24);
  text_4.addFocusListener(this);
  text_4.setEditable(true);
  
  add(button);
  button.setBounds(35,36,60,26);
  button.setEnabled(false);
  button.addActionListener(this);
  
  add(text_1);
  text_1.setBounds(115,36,90,24);
  text_1.setEnabled(false);
  text_1.setEditable(false);
  
  add(text_2);
  text_2.setBounds(315,36,90,24);
  text_2.setEnabled(false);
  text_2.setEditable(false);

  add(text_2);
  text_2.setBounds(315,36,90,24);
  text_2.setEnabled(false);
  text_2.setEditable(false);
  
  setSize(440,440);
  setLayout(null);
  setBackground(Color.orange);
  addMouseListener(this);
 }
 
 public void paint(Graphics g)
 {
  for(int i=80;i<=400;i=i+20)
  {
   g.drawLine(40,i,400,i);
  }
  g.drawLine(40,420,400,420);
  
  for(int j=40;j<=380;j=j+20)
  {
   g.drawLine(j,80,j,420);
  }
  g.drawLine(400,80,400,420);
  
  g.fillOval(97,137,6,6);
  g.fillOval(337,137,6,6);
  g.fillOval(97,377,6,6);
  g.fillOval(337,377,6,6);
  g.fillOval(217,257,6,6);
 }

 public void focusGained(FocusEvent e)
 {
  Component com=(Component)e.getSource();
  if(com==text_3)
  {
   text_3.setText("");
  }
  else if(com==text_4)
  {
   text_4.setText("");
  }
  
 }
 public void focusLost(FocusEvent e)
 {
  
 }
 public void mousePressed(MouseEvent e)
 { 

  if(blackname.length()==0||whitename.length()==0)
  {
   JOptionPane.showMessageDialog(this,"please input the player's name,and click input button before you start chess!","reminder",JOptionPane.WARNING_MESSAGE);
  }
  
  else if(blackname.equals("black'name"))
  {
   JOptionPane.showMessageDialog(this,"please input the black player's name,and click input button","reminder",JOptionPane.WARNING_MESSAGE);
  }
  else if(whitename.equals("white'name"))
  {
   JOptionPane.showMessageDialog(this,"please input the white player's name,and click input button","reminder",JOptionPane.WARNING_MESSAGE);
  }
  else if(e.getModifiers()==InputEvent.BUTTON1_MASK)
  {
   
   x = (int)e.getX();
   y = (int)e.getY();
   
   int a=(x+10)/20,b=(y+10)/20;
   
   ChessPoint_black chesspoint_black=new ChessPoint_black(this);
   ChessPoint_white chesspoint_white=new ChessPoint_white(this);
   
   if(x/20<2||y/20<4||x/20>19||y/20>20)
   {
    
   }
   
   else
   {
    if(chessColor==1)
    {
     this.add(chesspoint_black);
     chesspoint_black.setBounds(a*20-10,b*20-10,20,20);
     chessColor=chessColor*(-1);
     
     text_2.setText(this.whitename+" please");
     text_1.setText("");
    }
    
    else if(chessColor==-1)
    {
     this.add(chesspoint_white);
     chesspoint_white.setBounds(a*20-10,b*20-10,20,20);
     chessColor=chessColor*(-1);
     
     text_1.setText(this.blackname+" please");
     text_2.setText("");
    }
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
 
 public void mouseClicked(MouseEvent e)
 {
  
 }
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource()==inputButton)
  {
   blackname=text_3.getText();
   whitename=text_4.getText();
   if(blackname.length()==0||whitename.length()==0)
   {
    JOptionPane.showMessageDialog(this,"you did not complete the information!","reminder",JOptionPane.WARNING_MESSAGE);
   }
   else if(blackname.equals("black'name"))
   {
    JOptionPane.showMessageDialog(this,"please input the black player's name","reminder",JOptionPane.WARNING_MESSAGE);
   }
   else if(whitename.equals("white'name"))
   {
    JOptionPane.showMessageDialog(this,"please input the white player's name","reminder",JOptionPane.WARNING_MESSAGE);
   }
   else
   {
    inputButton.setEnabled(false);
    text_3.removeFocusListener(this);
    text_3.setEnabled(false);
    text_4.setEnabled(false);
    button.setEnabled(true);
    text_1.setEnabled(true);
    text_1.setText(blackname+" please");
    text_2.setEnabled(true);
   }
  }
  else if(e.getSource()==button)
  {
   inputButton.setEnabled(true);
   text_3.setEnabled(true);
   text_4.setEnabled(true);
   button.setEnabled(false);
   text_1.setEnabled(false);
   text_2.setEnabled(false);
  
   this.removeAll();
  
   chessColor=1;
  
   add(button);
   button.setBounds(35,36,60,26);
  
   add(text_1);
   text_1.setBounds(115,36,90,24);
   text_1.setText("black please");
  
   add(text_2);
   text_2.setBounds(315,36,90,24);
   text_2.setText("");
  
   add(inputButton);
   inputButton.setBounds(35,5,60,26);
  
   add(text_3);
   text_3.setText("black'name");
   text_3.addFocusListener(this);
   text_3.setBounds(115,5,90,24);
  
   add(text_4);
   text_4.setText("white'name");
   text_4.setBounds(315,5,90,24);
   blackname="";
   whitename="";
  }
  
 }
}
