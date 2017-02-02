package program;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFile {

	private ArrayList<Double> t= new ArrayList<Double>();
	private ArrayList<Double> t_Ac= new ArrayList<Double>();
	private ArrayList<Double> t_Gy= new ArrayList<Double>();
	
	private ArrayList<Double> l_pd= new ArrayList<Double>();
	private ArrayList<Double> r_pd= new ArrayList<Double>();
	
	private ArrayList<Double> gp_x= new ArrayList<Double>();
	private ArrayList<Double> gp_y= new ArrayList<Double>();
	
	private ArrayList<Double> gp3_x= new ArrayList<Double>();
	private ArrayList<Double> gp3_y= new ArrayList<Double>();
	private ArrayList<Double> gp3_z= new ArrayList<Double>();
	
	private ArrayList<Double> l_gd_x= new ArrayList<Double>();
	private ArrayList<Double> l_gd_y= new ArrayList<Double>();
	private ArrayList<Double> l_gd_z= new ArrayList<Double>();
	private ArrayList<Double> r_gd_x= new ArrayList<Double>();
	private ArrayList<Double> r_gd_y= new ArrayList<Double>();
	private ArrayList<Double> r_gd_z= new ArrayList<Double>();
	
	private ArrayList<Double> l_pc_x= new ArrayList<Double>();
	private ArrayList<Double> l_pc_y= new ArrayList<Double>();
	private ArrayList<Double> l_pc_z= new ArrayList<Double>();
	private ArrayList<Double> r_pc_x= new ArrayList<Double>();
	private ArrayList<Double> r_pc_y= new ArrayList<Double>();
	private ArrayList<Double> r_pc_z= new ArrayList<Double>();
	
	private ArrayList<Double> ac_x= new ArrayList<Double>();
	private ArrayList<Double> ac_y= new ArrayList<Double>();
	private ArrayList<Double> ac_z= new ArrayList<Double>();
	
	private ArrayList<Double> gy_x= new ArrayList<Double>();
	private ArrayList<Double> gy_y= new ArrayList<Double>();
	private ArrayList<Double> gy_z= new ArrayList<Double>();
	
	private String eye_tracking_info; 
	private String acc_info;
	private String gyro_info;
	private String pathFileName; 
	
	public WriteFile(String outputname, ArrayList<Double> time,ArrayList<Double> timeAcc, ArrayList<Double> timeGyro,
			ArrayList<Double> l_pupilDia, ArrayList<Double> r_pupilDia, 
			ArrayList<Double> gazeP_x, ArrayList<Double> gazeP_y, ArrayList<Double> gazeP3_x,
			ArrayList<Double> gazeP3_y, ArrayList<Double> gazeP3_z, ArrayList<Double> l_gazedir_x,
			ArrayList<Double> l_gazedir_y, ArrayList<Double> l_gazedir_z, ArrayList<Double> r_gazedir_x,
			ArrayList<Double> r_gazedir_y, ArrayList<Double> r_gazedir_z, ArrayList<Double> l_pupilC_x, 
			ArrayList<Double> l_pupilC_y, ArrayList<Double> l_pupilC_z, ArrayList<Double> r_pupilC_x, 
			ArrayList<Double> r_pupilC_y, ArrayList<Double> r_pupilC_z, ArrayList<Double> accel_x, 
			ArrayList<Double> accel_y, ArrayList<Double> accel_z, ArrayList<Double> gyro_x, 
			ArrayList<Double> gyro_y, ArrayList<Double> gyro_z)
	{
		t= time;
		t_Ac = timeAcc;
		t_Gy = timeGyro;
		l_pd = l_pupilDia;
		r_pd = r_pupilDia;
		gp_x = gazeP_x;
		gp_y = gazeP_y;
		gp3_x = gazeP3_x;
		gp3_y = gazeP3_y;
		gp3_z = gazeP3_z;
		l_gd_x = l_gazedir_x; 
		l_gd_y = l_gazedir_y;
		l_gd_z = l_gazedir_z;
		r_gd_x = r_gazedir_x;
		r_gd_y = r_gazedir_y; 
		r_gd_z = r_gazedir_z; 
		l_pc_x = l_pupilC_x;
		l_pc_y = l_pupilC_y;
		l_pc_z = l_pupilC_z;
		r_pc_x = r_pupilC_x;
		r_pc_y = r_pupilC_y;
		r_pc_z = r_pupilC_z;
		ac_x = accel_x; 
		ac_y = accel_y;
		ac_z = accel_z;
		gy_x = gyro_x;
		gy_y = gyro_y;
		gy_z = gyro_z; 
		pathFileName = outputname; 
		
		
	}
	public void writedata()
	{
		eye_tracking_info = stringifyEyeTracking(eye_tracking_info,t ,l_pd, r_pd, gp_x, gp_y, gp3_x, gp3_y, gp3_z, l_gd_x, 
				l_gd_y, l_gd_z, r_gd_x, r_gd_y, r_gd_z, l_pc_x, l_pc_y, l_pc_z, r_pc_x, r_pc_y, r_pc_z); 
		acc_info = stringifyACC(acc_info,t_Ac, ac_x, ac_y, ac_z);
		gyro_info = stringifyGyro(gyro_info, t_Gy, gy_x, gy_y, gy_z); 
		write(pathFileName+".txt",eye_tracking_info);
		write(pathFileName+"AccelerometerData.txt", acc_info);
		write(pathFileName+"GyroscopeData.txt", gyro_info);
	}
	public String stringifyEyeTracking(String info, ArrayList<Double> t, ArrayList<Double> l_pd, ArrayList<Double> r_pd,
			ArrayList<Double> gp_x, ArrayList<Double> gp_y, ArrayList<Double> gp3_x, ArrayList<Double> gp3_y, 
			ArrayList<Double> gp3_z, ArrayList<Double> l_gd_x, ArrayList<Double> l_gd_y, ArrayList<Double> l_gd_z,
			ArrayList<Double> r_gd_x, ArrayList<Double> r_gd_y, ArrayList<Double> r_gd_z,ArrayList<Double> l_pc_x,
			ArrayList<Double> l_pc_y,ArrayList<Double> l_pc_z,ArrayList<Double> r_pc_x,ArrayList<Double> r_pc_y,
			ArrayList<Double> r_pc_z)
	{
		ArrayList<Integer> size = new ArrayList<Integer>(); 
		size.add(t.size());
		size.add(l_pd.size());
		size.add(r_pd.size());
		size.add(gp_x.size());
		size.add(gp_y.size());
		size.add(gp3_x.size());
		size.add(gp3_y.size());
		size.add(gp3_z.size());
		size.add(l_gd_x.size());
		size.add(l_gd_y.size());
		size.add(l_gd_z.size());
		size.add(r_gd_x.size());
		size.add(r_gd_y.size());
		size.add(r_gd_z.size());
		size.add(l_pc_x.size());
		size.add(l_pc_y.size());
		size.add(l_pc_z.size());
		size.add(r_pc_x.size());
		size.add(r_pc_y.size());
		size.add(r_pc_z.size());
		
		size.sort(null);
		
		
		info = "Time,PupilDiaL,PupilDiaR,GazePosX,GazePosY,GazePos3DX,GazePos3DY,GazePos3DZ,GazeDirectionLX,"
				+ "GazeDirectionLY,GazeDirectionLZ,GazeDirectionRX,GazeDirectiomRY,GazeDirectionRZ,"
				+ "PupilCenterLX,PupilCenterLY,PupilCenterLZ,PupilCenterRX,PupilCenterRY,PupilCenterRZ \n";
		for(int i = 0; i < size.get(0); i++)
		{
			info += t.get(i) +"," + l_pd.get(i) + ","+ r_pd.get(i) + "," + gp_x.get(i) + "," + gp_y.get(i) + "," 
					+ gp3_x.get(i) + "," + gp3_y.get(i) + "," + gp3_z.get(i) + "," + l_gd_x.get(i)+ "," + l_gd_y.get(i)
					+ "," + l_gd_z.get(i) + "," + r_gd_x.get(i) + "," + r_gd_y.get(i) + "," + r_gd_z.get(i)
					+ "," + l_pc_x.get(i) + "," + l_pc_y.get(i) + "," + l_pc_z.get(i) + "," + r_pc_x.get(i)
					+ "," + r_pc_x.get(i) + "," + r_pc_y.get(i) + "," + r_pc_z.get(i) + "\n";
		}
		
		return info;
	}
	
	public String stringifyACC(String info, ArrayList<Double> t, ArrayList<Double> ac_x, ArrayList<Double> ac_y,
			ArrayList<Double> ac_z)
	{
		info = "Time,AccelerometerX,AccelerometerY,AccelerometerZ \n";
		
		for(int i = 0; i < t.size(); i++)
		{
			info += t.get(i) + "," + ac_x.get(i) + "," + ac_y.get(i) + "," + ac_z.get(i) + "\n"; 
		}
		
		return info; 
	}
	
	public String stringifyGyro(String info, ArrayList<Double> t, ArrayList<Double> gy_x, ArrayList<Double> gy_y,
			ArrayList<Double> gy_z)
	{
		info = "Time,GyroscopeX,GyroscopeY,GyroscopeZ \n";
		for(int i = 0; i < t.size(); i++)
		{
			info += t.get(i) + "," + gy_x.get(i) + "," + gy_y.get(i) + "," + gy_z.get(i) + "\n"; 
		}
		return info;
	}
	public void write(String fileName, String content){
		System.out.println("printing");
		try {
			FileWriter file = new FileWriter(new File( fileName));
			file.write(content);
			file.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}





