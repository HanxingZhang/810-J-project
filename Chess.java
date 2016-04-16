/*
 * Author: Hanxing Zhang
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Chess extends Frame
{
 ChessPad chesspad= new ChessPad();
 
 Chess()
 {
  add(chesspad);
  chesspad.setBounds(70,90,440,440);
  
  Label label=new Label("click to point,doubled_click to remove,right click to back",Label.CENTER);
  add(label);
  label.setBounds(70,55,440,24);
  label.setBackground(Color.orange);
  
  addWindowListener
  (
   new WindowAdapter()
   {
    public void windowClosing(WindowEvent e)
    {
     System.exit(0);
    }
   } 
  );
  
  setLayout(null);
  setVisible(true);
  setSize(600,550);
 }
 
 public static void main(String args[])
 {
  Chess chess=new Chess();
 }
}

