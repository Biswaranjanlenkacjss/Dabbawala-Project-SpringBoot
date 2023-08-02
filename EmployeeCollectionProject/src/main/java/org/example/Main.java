package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //For Emp_Location class

        //for 1st emp
         List<Emp_Location> empLocationList1=new ArrayList<>();
        empLocationList1.add(new Emp_Location("Hyderabad","India"));

        //for 2nd emp
        List<Emp_Location> empLocationList2=new ArrayList<>();
        empLocationList2.add(new Emp_Location("Chennai","India"));

        //for 3rd emp
        List<Emp_Location> empLocationList3=new ArrayList<>();
        empLocationList3.add(new Emp_Location("Colombo","Srilanka"));

        //for 4th emp
        List<Emp_Location> empLocationList4=new ArrayList<>();
        empLocationList4.add(new Emp_Location("Bhubaneswar","India"));

        //for 5th emp
        List<Emp_Location> empLocationList5=new ArrayList<>();
        empLocationList5.add(new Emp_Location("Melbourne","Australia"));

        //=====================================================================================================

        //For Emp_Departments

        //for 1st emp
        List<Emp_Departments> empDeptList1=new ArrayList<>();
        empDeptList1.add(new Emp_Departments("100","IT "));

        //for 2nd emp
        List<Emp_Departments> empDeptList2=new ArrayList<>();
        empDeptList2.add(new Emp_Departments("101","Health"));

        //for 3rd emp
        List<Emp_Departments> empDeptList3=new ArrayList<>();
        empDeptList3.add(new Emp_Departments("102","Finance "));

        //for 4th emp
        List<Emp_Departments> empDeptList4=new ArrayList<>();
        empDeptList4.add(new Emp_Departments("103","Bank"));

        //for 5th emp
        List<Emp_Departments> empDeptList5=new ArrayList<>();
        empDeptList5.add(new Emp_Departments("104","Sport "));
        //=====================================================================================================

        //For Emp_Benefits

        //for 1st emp
        List<Emp_Benefits> empBenefitsList1=new ArrayList<>();
        empBenefitsList1.add(new Emp_Benefits("b1","Health Insurance","Health Insurance total cost is 1000000"));
        empBenefitsList1.add(new Emp_Benefits("b2","Travel Allowance","Travel Allowance total cost is 5000"));

        //for 2nd emp
        List<Emp_Benefits> empBenefitsList2=new ArrayList<>();
        empBenefitsList2.add(new Emp_Benefits("b3","House Rent","House Rent total cost is 8000"));
        empBenefitsList2.add(new Emp_Benefits("b4","Food","Monthly Food Cost is 4000"));

        //for 3rd emp
        List<Emp_Benefits> empBenefitsList3=new ArrayList<>();
        empBenefitsList3.add(new Emp_Benefits("b5","Bonus","Bonus Amount in each Month is 1000"));

        //for 4rd emp
        List<Emp_Benefits> empBenefitsList4=new ArrayList<>();
        empBenefitsList4.add(new Emp_Benefits("b5","Bonus","Bonus Amount in each Month is 2000"));
        empBenefitsList4.add(new Emp_Benefits("b3","House Rent","House Rent total cost is 8000"));

        //for 5th emp
        List<Emp_Benefits> empBenefitsList5=new ArrayList<>();
        empBenefitsList5.add(new Emp_Benefits("b1","Health Insurance","Health Insurance total cost is 1000000"));
        empBenefitsList5.add(new Emp_Benefits("b4","Food","Monthly Food Cost is 4000"));



        //===================================================================================================
        //For Employee Class
        List<Employee> empList=new ArrayList<>();

        empList.add(new Employee("biswa@gmail.com","Biswaranjan",150000,empDeptList1,empLocationList1, empBenefitsList1) );
        empList.add(new Employee("sai@gmail.com","Sai",160000,empDeptList2,empLocationList2,empBenefitsList2));
        empList.add(new Employee("manoj@gmail.com","manoj",170000,empDeptList3,empLocationList3,empBenefitsList3));
        empList.add(new Employee("ranjit@gmail.com","Ranjit",180000,empDeptList4,empLocationList4,empBenefitsList4));
        empList.add(new Employee("raj@gmail.com","Raj",190000,empDeptList5,empLocationList5,empBenefitsList5));

        //===============================================================================================================

        /*
        //a. Retrieve all employees in India

        System.out.println("List Of Employee who are Present in INDIA:");
        System.out.println("=====================================");
      StringBuilder sb=new StringBuilder();

        empList.stream().forEach(emp->{
            emp.getEmpLocationList().stream().filter(loc->loc.getCountry().equalsIgnoreCase("India")).forEach(loc->{
                sb.append("\n Emp Name:").append(emp.getName()).append("\nEmp Email:").append(emp.getEmail()).
                append("\nEmp Salary:").append(emp.getSalary()).append("\nEmpCountry:").append(loc.getCountry()+"\n");
            });
        });
        System.out.println(sb);

           */

        //===============================================================================================================
      /*
          // b. Retrieve employees who are in Chennai or Hyderabad

        System.out.println("List Of Employee whose Location is Hyderbad or Chennai:");
        System.out.println("================================================");
        StringBuilder sb1=new StringBuilder();

        empList.stream().forEach(emp->{
            emp.getEmpLocationList().stream().filter(loc->loc.getLocation().equalsIgnoreCase("Chennai") ||
                    loc.getLocation().equalsIgnoreCase("Hyderabad") ).forEach(loc->{
                sb1.append("\nEmp Name:").append(emp.getName()).append("\nEmp Email:").append(emp.getEmail()).
                append("\nEmp Salary:").append(emp.getSalary()).append("\nEmpLocation:").append(loc.getLocation()+"\n");

            });
        });
        System.out.println(sb1);

       */

        //==============================================================================================================
        /*
       // c. Retrieve employees who have Benefits and display benefits details


        System.out.println("List Of Employee with Respect to their Benefits ");
        System.out.println("=========================================");
        StringBuilder sb2=new StringBuilder();

        empList.stream().forEach(emp->{
            sb2.append("\nEmployee Name:").append(emp.getName());
            emp.getEmpBenefits().forEach(ben->{
              sb2.append("\nEmployee Benefits Name:").append(ben.getName()).
                        append("\nBenefit Description:").append(ben.getDescription()+"\n");
            });
            sb2.append("============================================");
        });

        System.out.println(sb2);

 */
        //==============================================================================================================
        /*
        d. Retrieve employee details -  employeeId, employeeName, Salary, deptName, locationName, locationCountry
   *   */
        StringBuilder sb3=new StringBuilder();

        empList.stream().forEach(emp->{
            emp.getEmpDepartments().forEach(d->{
                emp.getEmpLocationList().stream().forEach(loc->{
                    sb3.append("\nEmployee Name:").append(emp.getName()).append("\nEmployee Emailid:").append(emp.getEmail()).
                            append("\nEmployee Salary:").append(emp.getSalary()).append("\nEmployee Department:").append(d.getName()).
                            append("\nEmployee Location:").append(loc.getLocation()).append("\nEmployee Country:").append(loc.getCountry()+"\n");
                });

            });
        });
        System.out.println(sb3);

        //==============================================================================================================
     /*
        e. Retrieve employees who are in Chennai and India


        System.out.println("List Of Employee whose Location is Chennai and Country is India:");
        System.out.println("=====================================================");
        StringBuilder sb4=new StringBuilder();

        empList.stream().forEach(emp->{
            emp.getEmpLocationList().stream().filter(loc->loc.getLocation().equalsIgnoreCase("Chennai") &&
                    loc.getCountry().equalsIgnoreCase("India") ).forEach(loc->{
                sb4.append("\nEmp Name:").append(emp.getName()).append("\nEmp Email:").append(emp.getEmail()).append("\nEmp Salary:").append(emp.getSalary()).
                        append("\nEmpLocation:").append(loc.getLocation()).append("\nEmployeeCountry:").append(loc.getCountry()+"\n");

            });
        });
        System.out.println(sb4);

   */
    }//end of main
}