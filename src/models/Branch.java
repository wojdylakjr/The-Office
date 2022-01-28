package models;

public class Branch {
    private int id;
    private String cityName;
    private Employee branchDirector;

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

    public Employee getBranchDirector() {
        return branchDirector;
    }

    public void setBranchDirector(Employee branchDirector) {
        this.branchDirector = branchDirector;
    }
}
