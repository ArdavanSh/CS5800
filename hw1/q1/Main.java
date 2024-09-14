public class Main {
    public static void main(String[] args) {

//        Instantiate the SalariedEmployee
        SalariedEmployee joe = new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500);

//        Instantiate the HourlyEmployees
        HourlyEmployee stephanie = new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25, 32);
        HourlyEmployee mary = new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19, 47);

//        Instantiate the CommissionEmployee
        CommisionEmployee nicole = new CommisionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000);

//        Instantiate the SalariedEmployee for Renwa
        SalariedEmployee renwa = new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700);

//        Instantiate the BaseEmployee for Mike
        BaseEmployee mike = new BaseEmployee("Mike", "Davenport", "666-66-6666", 0.0, 0.0, 95000);

//        Instantiate the CommissionEmployee for Mahnaz
        CommisionEmployee mahnaz = new CommisionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000);

//        Display information about each employee
        System.out.println("Salaried Employee: " + joe.getFirstName() + " " + joe.getLastName() + ", Weekly Salary: $" + joe.getWeeklySalary());
        System.out.println("Hourly Employee: " + stephanie.getFirstName() + " " + stephanie.getLastName() + ", Wage: $" + stephanie.getWage() + ", Hours Worked: " + stephanie.getHoursWorked());
        System.out.println("Hourly Employee: " + mary.getFirstName() + " " + mary.getLastName() + ", Wage: $" + mary.getWage() + ", Hours Worked: " + mary.getHoursWorked());
        System.out.println("Commission Employee: " + nicole.getFirstName() + " " + nicole.getLastName() + ", Commission Rate: " + (nicole.getCommissionRate() * 100) + "%, Gross Sales: $" + nicole.getGrossSalary());
        System.out.println("Salaried Employee: " + renwa.getFirstName() + " " + renwa.getLastName() + ", Weekly Salary: $" + renwa.getWeeklySalary());
        System.out.println("Base Employee: " + mike.getFirstName() + " " + mike.getLastName() + ", Base Salary: $" + mike.getBaseSalary());
        System.out.println("Commission Employee: " + mahnaz.getFirstName() + " " + mahnaz.getLastName() + ", Commission Rate: " + (mahnaz.getCommissionRate() * 100) + "%, Gross Sales: $" + mahnaz.getGrossSalary());

    }
}

