     package TypingSpeed;
     import java.awt.*;
     import java.awt.event.KeyAdapter;
     import java.awt.event.KeyEvent;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import java.awt.event.WindowAdapter;
    import java.awt.event.WindowEvent;
    import java.util.logging.Level;
    import java.util.logging.Logger;
     
    public class TypingSpeed
    { 
        private TextArea text;
        private TextField input,time,output;
        //private Button start;
        private boolean isStarted=false;
        private String in="",s="";
        private int point;
        TypingSpeed()
        {
            s="coding is really easy logical just use logic get without errors";
            s+="\n people class like never nowadays freedom implement fundamental";
            s+="\nthis not done tells speak what is how good that when you say it";
            s+="\nnecessary because might where there another named speech";
            new SetFrame();
        }
        
    private class SetFrame extends Frame
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int position=-1;
        private String next="";
        
        
        SetFrame()
        {
            setLayout(new FlowLayout());
            text=new TextArea(6,60);
            output=new TextField(25);
            output.setBackground(Color.orange);
            //start=new Button("Start");
            time=new TextField(2);
            input=new TextField(25);
            text.setText(s);
            text.setEditable(false);
            time.setEditable(false);
            add(text);
            add(time);
            add(output);
            add(input);
            input.setText("Click here to start");
            output.setText("This box shows the required input");
            //add(start);
            setSize(600,300);
            input.addMouseListener(new MouseAdapter() 
            {
                 @Override
                 public void mousePressed(MouseEvent e) {
                     
                     if(!isStarted)
                     {
                        input.setText("");
                        output.setText("");
                        next=getNext();
                        output.setText(next);
                        Timer t=new Timer();
                        t.start();
                     }
                 }
            });
            input.addKeyListener(new KeyAdapter(){
                @Override
                public void keyTyped(KeyEvent e) {
                    if(e.getKeyChar()==' ')
                    {
                        in=input.getText();
                        in=in.trim();
                        input.setText("");
                        if(in.equals(next))
                        {
                            point+=in.length();
                        }
                        next=getNext();
                        output.setText(next);
                    }
                }            
     
            });
         
           addWindowListener(new WindowAdapter(){
               @Override
               public void windowClosing(WindowEvent e)
               {
                   System.exit(0);
               }
           });
           setVisible(true);
           setTitle("Typing Speed Calculator");
           add(new Label("                Created by ELITE"));
           add(new Label("                Let's check your typing speed.."));
       }
       private String getNext()
       {
          String right="";
           while(s.charAt(++position)!=' ')
               right+=s.charAt(position);
           return right;
       }
       
   }
   private class Timer extends Thread
   {
      private float wpm;
       @Override
       public void run() {
           //input.setVisible(true);
           for(int i=60;i>0;i--)
                   {
                       
                       isStarted=true;
                       time.setText(i+"");
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(TypingSpeed.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
           time.setText(0+"");
           output.setText("Time Up");
           input.setEditable(false);
           input.setBackground(Color.green);
           wpm=(float)point/5;
           input.setText("your speed = "+wpm+" wpm");
       }
   }
       /**
        * @param args the command line arguments
        */
    
       public static void main(String[] args) {
           // TODO code application logic here
           new TypingSpeed();   
       }
 }