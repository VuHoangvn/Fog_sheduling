package fog.entityDAO;

import fog.entities.FogDevice;

import java.util.List;

public class FogDeviceDAO {
    private static FogDeviceDAO instance;

    public static FogDeviceDAO getInstance(){
        if(instance == null)
            instance = new FogDeviceDAO();

        return instance;
    }

    public static void setInstance(FogDeviceDAO value){
        FogDeviceDAO.instance = value;
    }

    public List<FogDevice> LoadFogDevices(String fileName){
        List<FogDevice> list = DataProvider.getInstance().createFogDevices(fileName);

        return list;
    }
}
