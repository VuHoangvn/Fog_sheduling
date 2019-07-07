package fog.main;

import fog.entities.Cloudlet;
import fog.entities.FogBroker;
import fog.entities.FogDevice;
import fog.entityDAO.CloudletDAO;
import fog.entityDAO.FogDeviceDAO;

import java.util.List;

import static fog.entityDAO.FogDeviceDAO.*;

public class Main {
    public static String algorithm = null;
    public static void main(String [] args){
        FogBroker broker = new FogBroker();

        List<FogDevice> fogDevices = getInstance().LoadFogDevices("./src/data/fogDevices/data04");
        List<Cloudlet> cloudletList = CloudletDAO.getInstance().LoadCloudlets("./src/data/cloudlet/data40.txt");

        broker.setFogDevices(fogDevices);
        broker.setCloudletList(cloudletList);

        broker.assignCloudlet(algorithm);
    }
}
