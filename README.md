# Tobii_JsonToTxtConversionTool
This repository consist of a Java program which can convert the Tobii Pro Glasses 2 livedata.json file to comma separated .txt files 
perfect for Matlab, Ogama or other analysis software. 

The Github will consist of:

The source code

A Runable .jar file 

Version 1.1 of the runable jar -> created through an updated version of Eclipse 18/10/2018

Version 1.2 of the ruanble jar + sourcecode change -> the time stamps from the videofeed was taken into consideration and the latency in the recording, now the data should be synched to the videofeed. 
in the documentation the following variable weren't described. 
vts = video time stamp, if vts = 0, then the corresponding ts is equal to the 0th frame from the videofeed. 
l = latency = time it took from when the frame was captured in the feed to the livedata was placed in the livestream file. 
additionally the software is now capable of taking any length recording intop consideration. before the program could only handle 1 mio lines in the livedata file. 19/10/2018

However, I've noticed that Tobii creates livedata.json.GZ files now instead of livedata.json, so be sure that yuo are still running an old firmware version to be able to use this software. I'll look into this issue later. 

A technical documentation <-- In case you want to know what is going on inside the software and how to use it please read this. 

Here is a link in which you can see how to cite this software http://vbn.aau.dk/en/publications/data-conversion-tool-for-tobii-pro-glasses-2-live-data-files(3d12851f-adec-415a-9c48-68a5eedb1811)/export.html
