package fog.entityDAO;

import fog.entities.Cloudlet;

import java.util.List;

public class CloudletDAO {
    private static CloudletDAO instance;

    public static CloudletDAO getInstance(){
        if(instance == null)
            instance = new CloudletDAO();

        return instance;
    }

    public List<Cloudlet> LoadCloudlets(String fileName){
        List<Cloudlet> list = DataProvider.getInstance().createCloudlets(fileName);

        return list;
    }
}
