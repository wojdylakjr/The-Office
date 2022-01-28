package models;

public class Branch {
    private int id;
    private String cityName;
    private Employee branchManager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Employee getBranchManager() {
        return branchManager;
    }

    public void setBranchManager(Employee branchManager) {
        this.branchManager = branchManager;
    }
}
