package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaterLog extends Log {
    List<Sample> waterLog;
    WaterSample waterSample = new WaterSample();

    //EFFECTS: creates empty water log
    public WaterLog() {
        super();
    }

    @Override
    //EFFECTS: writes borehole log data to txt file
    public void save(String fileSaveName) throws IOException {
        File fileName = new File(fileSaveName);
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (Sample sample : waterLog) {
            pw.println(waterSample.getName());
            pw.println(waterSample.getType());
            pw.println(waterSample.isOdourous());
            pw.println(waterSample.getConductivity());
            pw.println(waterSample.getTemperature());
            pw.println(waterSample.getTurbidity());
        }
        pw.close();
        System.out.println("File " + fileName + " was saved.");

    }

    @Override
    //MODIFIES: this
    //EFFECTS: loads borehole log data saved in .txt file
    public void load(String fileLoadName) throws FileNotFoundException {
        File file = new File(fileLoadName);
        FileInputStream fis = new FileInputStream(file);
        Scanner in = new Scanner(fis);

        while (in.hasNext()) {
            WaterSample waterSample1 = new WaterSample();
            waterSample1.setName(in.nextLine());
            waterSample1.setType(in.nextLine());
            waterSample1.setOdour((in.nextLine().equals("true")));
            waterSample1.setConductivity((in.nextInt()));
            waterSample1.setTemperature((in.nextInt()));
            waterSample1.setTurbidity((in.nextInt()));
            waterLog.add(waterSample1);
        }
        System.out.println(file + " data has been loaded.");
    }
}

//methods inherited from sample
// set/getName
// set/getType
// set/isOdourous