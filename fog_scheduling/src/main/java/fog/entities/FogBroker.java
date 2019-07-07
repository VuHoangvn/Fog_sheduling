package fog.entities;

import fog.entityDAO.SchedulingAlgorithm;

import java.util.List;

public class FogBroker {
    private List<FogDevice> fogDevices;
    private List<Cloudlet> cloudletList;

    public List<FogDevice> getFogDevices() {
        return fogDevices;
    }

    public void setFogDevices(List<FogDevice> fogDevices) {
        this.fogDevices = fogDevices;
    }

    public List<Cloudlet> getCloudletList() {
        return cloudletList;
    }

    public void setCloudletList(List<Cloudlet> cloudletList) {
        this.cloudletList = cloudletList;
    }

    public Individual assignCloudlet(String schedulingStrategy) {
        Individual individual = new Individual(cloudletList.size());
        individual = SchedulingAlgorithm.runLocalSearchAlgorithm(fogDevices, cloudletList);

//        switch (schedulingStrategy) {
//            case SchedulingAlgorithm.GA:
//                individual = SchedulingAlgorithm.runGeneticAlgorithm(fogDevices, cloudletList);
//                break;
//            case SchedulingAlgorithm.LOCAL_SEARCH:
//                individual = SchedulingAlgorithm.runLocalSearchAlgorithm(fogDevices, cloudletList);
//                break;
//            case SchedulingAlgorithm.TABU_SEARCH:
//                individual = SchedulingAlgorithm.runTabuSearchAlgorithm(fogDevices, cloudletList);
//                break;
//            case SchedulingAlgorithm.BEE:
//                individual = SchedulingAlgorithm.runBeeAlgorithm(fogDevices, cloudletList);
//                break;
//        }
        return individual;
    }
}
