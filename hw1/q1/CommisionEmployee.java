public class CommisionEmployee extends Employee {
    private double commissionRate;
    private double grossSalary;

    public CommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double commissionRate, double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        this.commissionRate = commissionRate;
        this.grossSalary = grossSales;

    }
    public double getCommissionRate() {
        return commissionRate;
    }
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    public double getGrossSalary(){
        return grossSalary;
    }
    public void setGrossSalary(double grossSalary){
        this.grossSalary = grossSalary;
    }
}
