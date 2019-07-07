package fog.entities;

import java.util.List;

public class FogDevice {

    protected List<Cloudlet> cloudletListAssignment;

    protected long mips;
    protected int ram;
    protected long upBw;
    protected long downBw;
    protected int level;
    protected double ratePerMips;
    protected double costPerSec;
    protected double costPerMem;
    protected double costPerBw;

    public FogDevice( long mips, int ram, long upBw, long downBw, int level, double ratePerMips, double costPerSec,
                      double costPerMem, double costPerBw) {
        this.mips = mips;
        this.ram = ram;
        this.upBw = upBw;
        this.downBw = downBw;
        this.level = level;
        this.ratePerMips = ratePerMips;
        this.costPerSec = costPerSec;
        this.costPerMem = costPerMem;
        this.costPerBw = costPerBw;
    }

    public long getMips() {
        return mips;
    }

    public double getCostPerBw() {
        return costPerBw;
    }

    public void setCostPerBw(double costPerBw) {
        this.costPerBw = costPerBw;
    }

    public void setMips(long mips) {
        this.mips = mips;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public long getUpBw() {
        return upBw;
    }

    public void setUpBw(long upBw) {
        this.upBw = upBw;
    }

    public long getDownBw() {
        return downBw;
    }

    public void setDownBw(long downBw) {
        this.downBw = downBw;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getRatePerMips() {
        return ratePerMips;
    }

    public void setRatePerMips(double ratePerMips) {
        this.ratePerMips = ratePerMips;
    }

    public double getCostPerSec() {
        return costPerSec;
    }

    public void setCostPerSec(double costPerSec) {
        this.costPerSec = costPerSec;
    }

    public double getCostPerMem() {
        return costPerMem;
    }

    public void setCostPerMem(double costPerMem) {
        this.costPerMem = costPerMem;
    }

    public List<Cloudlet> getCloudletListAssignment() {
        return cloudletListAssignment;
    }

    public void setCloudletListAssignment(List<Cloudlet> cloudletListAssignment) {
        this.cloudletListAssignment = cloudletListAssignment;
    }
}
