package program;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameContent {
	public JLabel inputlab = new JLabel("write the path and the name of the livedata.json file"); 
	
	public JLabel outputLab = new JLabel("write the path and the name of the output file without file extension");
	public JLabel infoLab = new JLabel("The converter will convert the Tobii Eye-tracker data, accelerometer and gyroscope"
			+ " data."); 
	public JLabel infoLab2 = new JLabel("Three different files."
			+ "The eye-tracking file will contain:"); 
	public JLabel infoLab3 = new JLabel("Time, Pupil diameter, Gaze postiion, Gaze position in 3D, Gaze direction:"
			+ " three coordinates per eye, ");
	public JLabel infoLab4 = new JLabel("Pupil center: three coordinates per eye. ");
	public JLabel infoLab5 = new JLabel("The accelerometer file will contain: Time and three axis of accelerometer.");
	public JLabel infoLab6 = new JLabel("The gyroscope file will contain: Time and three axis of gyroscope.");
	public JLabel infoLab7 = new JLabel("All time data is in seconds. They are synched to the time of the videofeed");
	public JButton convert = new JButton("convert");
	public JTextField jsonName = new JTextField(); 
	public JTextField outputName = new JTextField();

 
	public short w = 120;
	public short h = 50; 
	
	public FrameContent(Container pane)
	{

	}
	public void AddContent(Container pane)
	{
		pane.setLayout(null);
	
		
		inputlab.setSize(w*4,h);
		inputlab.setLocation(140, 20);
		String text = "C:\\JsonToOgamaTxtConverter\\src\\livedata.json";
		jsonName.setLocation(140, 60);
		jsonName.setSize(w*3,h);
		jsonName.setText(text);
		
		
		
		outputLab.setSize(w*4,h);
		outputLab.setLocation(130,260);
		
		outputName.setLocation(140,300);
		outputName.setSize(w*3,h); 
		
		convert.setSize(w,h);
		convert.setLocation(260, 380);
		
		infoLab.setSize(w*5,h);
		infoLab.setLocation(50,110);
		infoLab2.setSize(w*5,h);
		infoLab2.setLocation(50,130);
		infoLab3.setSize(w*5,h);
		infoLab3.setLocation(50,150);
		infoLab4.setSize(w*5,h);
		infoLab4.setLocation(50,170);
		infoLab5.setSize(w*5,h);
		infoLab5.setLocation(50,190);
		infoLab6.setSize(w*5,h);
		infoLab6.setLocation(50,210);
		infoLab7.setSize(w*5,h);
		infoLab7.setLocation(50,230);
		
		convert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String input = jsonName.getText(); 
				String output = outputName.getText();
				
				
				ReadJson info = new ReadJson(input);
				info.parseJsonInfo(output);
				
			}
			
		});

		pane.add(jsonName);
		pane.add(outputName); 
		pane.add(inputlab);
		pane.add(outputLab);
		pane.add(convert); 
		pane.add(infoLab);
		pane.add(infoLab2);
		pane.add(infoLab3);
		pane.add(infoLab4);
		pane.add(infoLab5);
		pane.add(infoLab6);
		pane.add(infoLab7);

	}
}
