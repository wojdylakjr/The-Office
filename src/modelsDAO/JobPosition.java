package modelsDAO;

public class JobPosition {
    private int id;
    private String positionName;
    private int minSalary;
    private int maxSalary;

    public JobPosition() {
    }

    public JobPosition(int id, String positionName, int minSalary, int maxSalary) {
        this.id = id;
        this.positionName = positionName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public JobPosition(String positionName, int minSalary, int maxSalary) {
        this.positionName = positionName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
}
