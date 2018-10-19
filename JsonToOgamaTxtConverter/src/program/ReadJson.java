package program;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class ReadJson {
private String filename = null;
private String outPutName = null; 

private ArrayList<Double> l_pc_x = new ArrayList<Double>(); 
private ArrayList<Double> l_pc_y = new ArrayList<Double>(); 
private ArrayList<Double> l_pc_z = new ArrayList<Double>(); 

private ArrayList<Double> r_pc_x = new ArrayList<Double>(); 
private ArrayList<Double> r_pc_y = new ArrayList<Double>(); 
private ArrayList<Double> r_pc_z = new ArrayList<Double>(); 

private ArrayList<Double> l_pd = new ArrayList<Double>(); 
private ArrayList<Double> r_pd = new ArrayList<Double>(); 

private ArrayList<Double> l_gd_x = new ArrayList<Double>(); 
private ArrayList<Double> l_gd_y = new ArrayList<Double>(); 
private ArrayList<Double> l_gd_z = new ArrayList<Double>(); 

private ArrayList<Double> r_gd_x = new ArrayList<Double>(); 
private ArrayList<Double> r_gd_y = new ArrayList<Double>(); 
private ArrayList<Double> r_gd_z = new ArrayList<Double>(); 

private ArrayList<Double> gp_x = new ArrayList<Double>(); 
private ArrayList<Double> gp_y = new ArrayList<Double>(); 

private ArrayList<Double> gp3_x = new ArrayList<Double>(); 
private ArrayList<Double> gp3_y = new ArrayList<Double>();
private ArrayList<Double> gp3_z = new ArrayList<Double>();

private ArrayList<Double> ac_x = new ArrayList<Double>(); 
private ArrayList<Double> ac_y = new ArrayList<Double>();
private ArrayList<Double> ac_z = new ArrayList<Double>();

private ArrayList<Double> gy_x = new ArrayList<Double>(); 
private ArrayList<Double> gy_y = new ArrayList<Double>();
private ArrayList<Double> gy_z = new ArrayList<Double>();

private ArrayList<Double> time = new ArrayList<Double>();
private ArrayList<Double> timeGy = new ArrayList<Double>();
private ArrayList<Double> timeAc = new ArrayList<Double>();

private ArrayList<Double> timeSec = new ArrayList<Double>();
private ArrayList<Double> timeGySec = new ArrayList<Double>();
private ArrayList<Double> timeAcSec = new ArrayList<Double>();

private ArrayList<Double> vtsAr = new ArrayList<Double>();
private ArrayList<Double> vtsTs = new ArrayList<Double>();


	public ReadJson(String name)
	{
		filename = name;

		
	}
	public void parseJsonInfo(String outputName)
	{
		
		outPutName = outputName; 
		
		Reader reader = null;
		try {
			
			reader = new FileReader(filename);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		JsonReader jreader =  new JsonReader(reader); 
		jreader.setLenient(true);
		
		try {
				
			while (jreader.peek() != JsonToken.END_DOCUMENT)
			{
					try{
						jreader.beginObject();
					} catch (IllegalStateException ise){
						//ise.printStackTrace();
						//break;
					}
						double t_pc_x = 0.0;
						double t_pc_y = 0.0;
						double t_pc_z = 0.0;
						double t_pd = 0.0;
						double t_gd_x = 0.0;
						double t_gd_y = 0.0;
						double t_gd_z = 0.0;
						double t_gp_x = 0.0;
						double t_gp_y = 0.0;
						double t_gp3_x = 0.0;
						double t_gp3_y = 0.0;
						double t_gp3_z = 0.0;
						double t_ac_x = 0.0;
						double t_ac_y = 0.0;
						double t_ac_z = 0.0;
						double t_gy_x = 0.0;
						double t_gy_y = 0.0;
						double t_gy_z = 0.0;
						double t_time = 0.0;
						int t_state = 0;
						double vts = 0.0; 
						double vtsTS = 0.0; 
						double tempT = 0.0;
						double latency = 0.0;
						
					while(jreader.hasNext())
					{
						
						
						String name = jreader.nextName();
						
						
						if(name.equals("s"))
						{
							t_state = jreader.nextInt();
						}
						else if(name.equals("pc"))
						{	
							t_time = tempT;
							jreader.beginArray();

							while (jreader.hasNext()) 
							{
								if(t_pc_x == 0.0)
								{	
									t_pc_x = jreader.nextDouble(); 
									t_pc_x = checkIfError(t_state, t_pc_x); 
									
									
								}
								else if(t_pc_y == 0.0 && t_pc_x != 0.0)
								{
									t_pc_y = jreader.nextDouble();
									t_pc_y = checkIfError(t_state, t_pc_y);
								}
								else if(t_pc_z == 0.0 && t_pc_y != 0.0 && t_pc_x != 0.0)
								{
									t_pc_z = jreader.nextDouble();
									t_pc_z = checkIfError(t_state, t_pc_z);
								}
							}
							jreader.endArray();
						}
						else if(name.equals("pd"))
						{
							t_time = tempT;
							t_pd = jreader.nextDouble();
							t_pd = checkIfError(t_state, t_pd);
						}
						else if(name.equals("ts"))
						{
							
							tempT = jreader.nextDouble();
								
						}
						else if(name.equals("l"))
						{
							//latency between image taken and streamed data. 
							//so we subtract the latency from the timestamp before it is processed further. 
							latency = jreader.nextDouble();
							tempT = tempT - latency; 
								
						}
						else if(name.equals("vts"))
						{
							
							vtsTS = tempT;
							vts = jreader.nextDouble();
							
							vtsTs.add(vtsTS);
							vtsAr.add(vts); 
						}
					
						else if(name.equals("gd"))
						{
							t_time = tempT;
							jreader.beginArray();

							while (jreader.hasNext()) 
							{
								if(t_gd_x == 0.0)
								{
									t_gd_x = jreader.nextDouble(); 
									t_gd_x = checkIfError(t_state, t_gd_x);
								}
								else if(t_gd_y == 0.0 && t_gd_x != 0.0)
								{
									t_gd_y = jreader.nextDouble();
									t_gd_y = checkIfError(t_state, t_gd_y);
								}
								else if(t_gd_z == 0.0 && t_gd_y != 0.0 && t_gd_x != 0.0)
								{
									t_gd_z = jreader.nextDouble();
									t_gd_z = checkIfError(t_state, t_gd_z);
								}
							}
							jreader.endArray();
						}
						else if(name.equals("gp"))
						{
							t_time = tempT;
							jreader.beginArray();

							while (jreader.hasNext()) 
							{
								if(t_gp_x == 0.0)
								{
									t_gp_x = jreader.nextDouble();
									t_gp_x = t_gp_x*1920;
									gp_x.add(t_gp_x);
									t_gp_x = checkIfError(t_state, t_gp_x);
								
								}
								else if(t_gp_y == 0.0 && t_gp_x !=0.0)
								{
									t_gp_y = jreader.nextDouble();
									t_gp_y = t_gp_y*1080;
									gp_y.add(t_gp_y);
									time.add(t_time); 
									t_gp_y = checkIfError(t_state, t_gp_y);
									t_time = 0.0; 
									t_gp_y = 0.0; 
									t_gp_x = 0.0; 
								}
							}
							jreader.endArray();
						}	
						else if(name.equals("gp3"))
						{
							t_time = tempT;
							jreader.beginArray();

							while (jreader.hasNext()) 
							{
								if(t_gp3_x == 0.0)
								{
									t_gp3_x = jreader.nextDouble();
									gp3_x.add(t_gp3_x);
									t_gp3_x = checkIfError(t_state, t_gp3_x);
								}
								else if(t_gp3_y == 0.0)
								{
									t_gp3_y = jreader.nextDouble();
									gp3_y.add(t_gp3_y);
									t_gp3_y = checkIfError(t_state, t_gp3_y);
								}
								else if(t_gp3_z == 0.0)
								{
									t_gp3_z = jreader.nextDouble();
									gp3_z.add(t_gp3_z);
									t_gp3_z = checkIfError(t_state, t_gp3_z);
									t_gp3_x = 0.0;
									t_gp3_y = 0.0;
									t_gp3_z = 0.0;
								}
							}
							jreader.endArray();
						}	
						else if(name.equals("ac"))
						{
							t_time = tempT;
							jreader.beginArray();

							while (jreader.hasNext()) 
							{
								if(t_ac_x == 0.0)
								{
									t_ac_x = jreader.nextDouble();
									ac_x.add(t_ac_x);
									t_ac_x = checkIfError(t_state, t_ac_x);
									if(t_ac_x == 0.0)
									{
										t_ac_x = 0.1;
									}
								}
								else if(t_ac_y == 0.0)
								{
									t_ac_y = jreader.nextDouble();
									ac_y.add(t_ac_y);
									t_ac_y = checkIfError(t_state, t_ac_y);
									if(t_ac_y == 0.0)
									{
										t_ac_y = 0.1;
									}
								}
								else if(t_ac_z == 0.0)
								{
									t_ac_z = jreader.nextDouble();
									ac_z.add(t_ac_z);
									timeAc.add(t_time); 
									t_ac_z = checkIfError(t_state, t_ac_z);
									if(t_ac_z == 0.0)
									{
										t_ac_z = 0.1;
									}
									t_ac_x = 0.0;
									t_ac_y = 0.0;
									t_ac_z = 0.0;
								}
							}
							jreader.endArray();
						}
						else if(name.equals("gy"))
						{
							t_time = tempT;
							jreader.beginArray();

							while (jreader.hasNext()) 
							{
								
								if(t_gy_x == 0.0)
								{
									t_gy_x = jreader.nextDouble();
									gy_x.add(t_gy_x);
									t_gy_x = checkIfError(t_state, t_gy_x);
									if(t_gy_x == 0.0)
									{
										t_gy_x = 0.1;
									}
								}
								else if(t_gy_y == 0.0)
								{
									t_gy_y = jreader.nextDouble();
									gy_y.add(t_gy_y);
									t_gy_y = checkIfError(t_state, t_gy_y);
									if(t_gy_y == 0.0)
									{
										t_gy_y = 0.1;
									}
								}
								else if(t_gy_z == 0.0)
								{
									t_gy_z = jreader.nextDouble();
									gy_z.add(t_gy_z);
									timeGy.add(t_time); 
									t_gy_z = checkIfError(t_state, t_gy_z);
									if(t_gy_z == 0.0)
									{
										t_gy_z = 0.1;
									}
									t_gy_x = 0.0;
									t_gy_y = 0.0;
									t_gy_z = 0.0;
								}
							}
							jreader.endArray();
						}
						else if(name.equals("eye"))
						{
							String eye = jreader.nextString();
								if(eye.equals("right") && t_pc_x != 0.0)
								{
									r_pc_x.add(t_pc_x);
									r_pc_y.add(t_pc_y);
									r_pc_z.add(t_pc_z);
									t_pc_x = 0.0;
									t_pc_y = 0.0;
									t_pc_z = 0.0;
								}
								else if(eye.equals("left") && t_pc_x != 0.0)
								{
									l_pc_x.add(t_pc_x);
									l_pc_y.add(t_pc_y);
									l_pc_z.add(t_pc_z);
									t_pc_x = 0.0;
									t_pc_y = 0.0;
									t_pc_z = 0.0;
								}
								
								if(eye.equals("right") && t_pd != 0.0)
								{
									if(t_pd == 0.1)
									{
										t_pd = 0.0;
									}
									r_pd.add(t_pd);
									t_pd = 0.0;
								}
								else if(eye.equals("left") && t_pd != 0.0)
								{
									if(t_pd == 0.1)
									{
										t_pd = 0.0;
									}
									l_pd.add(t_pd);
									t_pd = 0.0;
								}
								
								if(eye.equals("right") && t_gd_x != 0.0)
								{
									r_gd_x.add(t_gd_x);
									r_gd_y.add(t_gd_y);
									r_gd_z.add(t_gd_z);
									t_gd_x = 0.0;
									t_gd_y = 0.0;
									t_gd_z = 0.0;
								}
								else if(eye.equals("left") && t_gd_x != 0.0)
								{
									l_gd_x.add(t_gd_x);
									l_gd_y.add(t_gd_y);
									l_gd_z.add(t_gd_z);
									t_gd_x = 0.0;
									t_gd_y = 0.0;
									t_gd_z = 0.0;
								}
						}
					
						else jreader.skipValue();
				}
				jreader.endObject(); 
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		//Sorting
		time.sort(null);
		//Delete duplicates by converting it to a Set and then back to List 
		Set<Double> s = new LinkedHashSet<>();
		s.addAll(time);
		time.clear();
		time.addAll(s);
		
		for(int i = 0; i < time.size(); i++)
		{
			//subtracting the captured timestamp with VTS at frame 0 timestamp
			//and dividing it by 1 mio to get it from microseconds to seconds from the start.
			
			timeSec.add((time.get(i)-vtsTs.get(0))/1000000 );
			
			
		}
		
		for(int i = 0; i < timeAc.size(); i++)
		{
			
			timeAcSec.add((timeAc.get(i)-vtsTs.get(0))/1000000 );
		
		}
		
		for(int i = 0; i < timeGy.size(); i++)
		{
			timeGySec.add((timeGy.get(i)-vtsTs.get(0))/1000000 );
			/*if(i == 0)
			{
				timeGy.set(i, 0.0);
			}
			else if(timeFromRec != 0)
			{
				timeGy.set(i, (double)i/(timeGy.size()/timeFromRec)); 
			}
			else timeGy.set(i, (double)i/95); 
			*/
		}
		
		System.out.println(gp_x.size());
		System.out.println(ac_x.size());
		System.out.println(gy_x.size());
		
		WriteFile writer = new WriteFile(outPutName, timeSec ,timeAcSec, timeGySec,
				l_pd,r_pd, gp_x, gp_y, gp3_x,gp3_y, gp3_z, 
				l_gd_x,l_gd_y, l_gd_z, r_gd_x, r_gd_y, r_gd_z, 
				l_pc_x, l_pc_y, l_pc_z, r_pc_x, r_pc_y, r_pc_z, 
				ac_x, ac_y, ac_z, gy_x, gy_y, gy_z);
		writer.writedata();

	}
	private double checkIfError (int status, double var)
	{
		if(status != 0)
		{
			var = 0.1;
			return var ;
		}
		else 
		{
		return var;
		}
	}
}
