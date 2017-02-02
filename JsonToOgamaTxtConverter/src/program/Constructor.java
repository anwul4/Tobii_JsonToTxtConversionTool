package program;
import java.awt.*;

import javax.swing.*;
public class Constructor {
	

	
	
	
	public static void main(String[] args)
	{
		 
    	JFrame frame = new JFrame("Json To Ogama Txt Converter");
    	
    	Container contentPane = frame.getContentPane(); 
    	frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width-frame.getWidth())/2, (screenSize.height-frame.getHeight())/2);
        
        
        FrameContent addContent = new FrameContent(contentPane); 
        addContent.AddContent(contentPane);
        
        frame.setSize(640,480);
        frame.setVisible(true);
        
        
      
	}

}
