import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int employeeId;
    private String employeeName;
    private String joiningDate;
    private String employementType;
    private String role;
    private String domain;
    public Employee(int employeeId, String employeeName, String joiningDate, String employementType, String role,
            String domain) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.joiningDate = joiningDate;
        this.employementType = employementType;
        this.role = role;
        this.domain = domain;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
    public String getEmployementType() {
        return employementType;
    }
    public void setEmployementType(String employementType) {
        this.employementType = employementType;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", joiningDate=" + joiningDate
                + ", employementType=" + employementType + ", role=" + role + ", domain=" + domain + "]";
    }

}

class EmployeeFile{
    List<Employee> employeeList = new ArrayList<>();
    
    public void readEmployeeData(){
    try{
        File file = new File("src/employee.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        while ((s = br.readLine()) != null){
            String[] data= s.split(",");
            Employee employee = new Employee(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]); 
            employeeList.add(employee);
        }
    }catch(FileNotFoundException e){
        System.out.println(e.getMessage());
    }catch (IOException e) {
        System.out.println(e.getMessage());
    }
    }

    public void displayEmployeeId(int employeeId){
        for(Employee e:employeeList){
            if(e.getEmployeeId() == employeeId){
                System.out.println(e);
                return;
            }
        }
        throw new NotFoundException("Employee with employee ID "+employeeId+" not found");
    }

    public void displayEmployeeRole(String role){
        List<Employee> employees= new ArrayList<>();
        for(Employee e:employeeList){
            if(e.getRole().equalsIgnoreCase(role)){
                employees.add(e);
            }
        } 
        if(employees.size()>0)
        {
            for(Employee e:employees)
                System.out.println(e);
        }
        else
            throw new NotFoundException("Employee with role "+role+" not found");
        }
    

    public void displayEmployeeExperience(int expererince){
        LocalDate current = LocalDate.now();
        List<Employee> employees= new ArrayList<>();
        for(Employee e:employeeList){
            LocalDate d= LocalDate.parse(e.getJoiningDate());
            LocalDate doj = LocalDate.of(d.getYear(),d.getMonthValue(),d.getDayOfMonth());
            int exp = Period.between(doj,current).getYears();
            if(exp >= expererince){
                employees.add(e);
            }
        }
        if(employees.size()>0)
        {
            for(Employee e:employees)
                System.out.println(e);
        }
        else
            throw new NotFoundException("Employee with experience "+expererince+" not found");
    }
    

    public static void main(String[] args) {
        EmployeeFile employeeFile= new EmployeeFile();

        Scanner s= new Scanner(System.in);
        employeeFile.readEmployeeData();
        System.out.println("Enter the employee id of the employee you are looking for");
        int id=s.nextInt();
        employeeFile.displayEmployeeId(id);

        System.out.println("Enter the experince years of the employee you are searching for");
        int exp=s.nextInt();
        employeeFile.displayEmployeeExperience(exp);
        s.nextLine();

        System.out.println("Enter the job role of the employee you are searching for");
        String role=s.nextLine();
        employeeFile.displayEmployeeRole(role);

        s.close();  
    }
}

