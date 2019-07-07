package fog.main;

import fog.entityDAO.CloudletDAO;
import fog.entityDAO.FogDeviceDAO;

public class Main {
    public static void main(String [] args){
        FogDeviceDAO.getInstance().LoadFogDevices("D:\\fog_scheduling\\src\\data\\fogDevices\\data04");
        CloudletDAO.getInstance().LoadCloudlets("D:\\fog_scheduling\\src\\data\\cloudlet\\data40.txt");
    }
}
