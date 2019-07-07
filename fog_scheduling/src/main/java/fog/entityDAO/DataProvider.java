package fog.entityDAO;

import fog.entities.Cloudlet;
import fog.entities.FogDevice;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProvider {
    private static final String COMMA_DELIMITER = ",";

    private static DataProvider instance;
    private DataProvider(){}

    public static DataProvider getInstance(){
        if(instance == null){
            instance = new DataProvider();
        }
        return DataProvider.instance;
    }

    private static void setInstance(DataProvider value){
        DataProvider.instance = value;
    }

    public static List<FogDevice> createFogDevices(String filename){
        return readJSONToFogDevice(filename);
    }

    private static List<FogDevice> readJSONToFogDevice(String fileName){
        List<FogDevice> fogDevices = new ArrayList<FogDevice>();
        try {
            JSONObject doc = (JSONObject) JSONValue.parse(new FileReader(fileName));
            JSONArray nodes = (JSONArray) doc.get("nodes");
            @SuppressWarnings("unchecked")
            Iterator<JSONObject> iter = nodes.iterator();
            while (iter.hasNext()) {
                JSONObject node = iter.next();
                String nodeType = (String) node.get("type");
                String nodeName = (String) node.get("name");

                if (nodeType.equals("FOG_DEVICE")) {
                    long mips = (Long) node.get("mips");
                    int ram = new BigDecimal((Long) node.get("ram")).intValueExact();
                    long upBw = new BigDecimal((Long) node.get("upBw")).intValueExact();
                    long downBw = new BigDecimal((Long) node.get("downBw")).intValueExact();
                    int level = new BigDecimal((Long) node.get("level")).intValue();
                    double rate = new BigDecimal((Double) node.get("ratePerMips")).doubleValue();
                    double costPerSec = (Double) node.get("costPerSec");
                    double costPerMem = new BigDecimal((Double) node.get("costPerMem")).doubleValue();
                    double costPerBw = new BigDecimal((Double) node.get("costPerBw")).doubleValue();

                    FogDevice fogDevice = new FogDevice(mips, ram, upBw, downBw, level, rate, costPerSec, costPerMem, costPerBw);
                    fogDevices.add(fogDevice);
                }
            }
//            for (int i = 0; i < fogDevices.size(); i++) {
//                System.out.println(i + ". MIPS: " + fogDevices.get(i).getMips());
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        System.out.println("############################");
//        System.out.println("Read data to Fog Infrucstructure successfully");
//        System.out.println("############################");
        return fogDevices;
    }

    public static List<Cloudlet> createCloudlets(String filename){
        return readFileToCloudlet(filename);
    }

    private static List<Cloudlet> readFileToCloudlet(String filename){
        List<Cloudlet> list = new ArrayList<Cloudlet>();

        int cloudletId;
        long length;
        long fileSize;
        long outputSize;
        long memRequired;

        BufferedReader br = null;
        try{
            String line;

            br = new BufferedReader(new FileReader((filename)));

            while((line = br.readLine()) != null){
                String[] splitData = line.split(COMMA_DELIMITER);
                cloudletId = Integer.parseInt(splitData[0]);
                length = Long.parseLong(splitData[1]);
                fileSize = Long.parseLong(splitData[2]);
                outputSize = Long.parseLong(splitData[3]);
                memRequired = Long.parseLong(splitData[4]);

                Cloudlet cloudlet = new Cloudlet(cloudletId, length, fileSize, outputSize, memRequired);
                list.add(cloudlet);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(br != null)
                    br.close();
            }catch (IOException crunchifyException){
                crunchifyException.printStackTrace();
            }
        }

//        for (Cloudlet cloudlet: list) {
//            System.out.println(cloudlet.getCloudletFileSize());
//        }
        return list;
    }
}
