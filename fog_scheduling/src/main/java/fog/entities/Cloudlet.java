package fog.entities;

public class Cloudlet {
    private int cloudletId;
    private long cloudletLength;
    private long cloudletFileSize;
    private long cloudletOutputSize;
    private long memRequired;

    public Cloudlet(int cloudletId, long cloudletLength, long cloudletFileSize, long cloudletOutputSize, long memRequired) {
        this.cloudletId = cloudletId;
        this.cloudletLength = cloudletLength;
        this.cloudletFileSize = cloudletFileSize;
        this.cloudletOutputSize = cloudletOutputSize;
        this.memRequired = memRequired;
    }

    public long getMemRequired() {
        return memRequired;
    }

    public void setMemRequired(long memRequired) {
        this.memRequired = memRequired;
    }

    public int getCloudletId() {
        return cloudletId;
    }

    public void setCloudletId(int cloudletId) {
        this.cloudletId = cloudletId;
    }

    public long getCloudletLength() {
        return cloudletLength;
    }

    public boolean setCloudletLength(long cloudletLength) {
        if(cloudletLength <= 0)
            return false;
        this.cloudletLength = cloudletLength;
        return true;
    }

    public long getCloudletFileSize() {
        return cloudletFileSize;
    }

    public void setCloudletFileSize(long cloudletFileSize) {
        this.cloudletFileSize = cloudletFileSize;
    }

    public long getCloudletOutputSize() {
        return cloudletOutputSize;
    }

    public void setCloudletOutputSize(long cloudletOutputSize) {
        this.cloudletOutputSize = cloudletOutputSize;
    }
}
