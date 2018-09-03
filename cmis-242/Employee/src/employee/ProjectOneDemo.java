/*
 * filename: ProjectOneDemo.java
 * author: roland carter
 * date: 2018-09-02
 * purpose: cmis 242 project 1
 */

package employee;

// import libraries
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// begining of ProjectOneDemo class
public class ProjectOneDemo {
    
    // txtIntoList is a static method that reads in a .txt field and returns
    // a List<String[]> with the String[] array being the strings on each line
    // and the index of the List being each line
    public static List<String[]> txtIntoList (String filePath) throws FileNotFoundException, IOException{

    // create new BufferedReader object
    BufferedReader br = new BufferedReader(new FileReader(filePath));

    // declare variables
    String line =  null;
    List<String[]> content = new ArrayList<>();

    // while loop creates an array from each line and splits it on the " "
    while((line=br.readLine())!=null){
        content.add(line.split(" "));
        }
    
    return content; // return final List<String[]>
    } // end txtIntoList
    
    // begin main method
    public static void main(String args[]) throws IOException{
        
        // declare file path constant 
        final String FILE_PATH = "/Users/rolandcarter/github-repos/umuc/cmis-242/Employee/src/employee_data.txt";
        
        // create list from txtIntoList() static method
        List<String[]> readInData = txtIntoList(FILE_PATH);

        // print out employee report
        System.out.println("************* Employee Report *************\n");
        
        // loop through years 2014 and 2015
        for(int j = 2014; j <= 2015; j++){ 
                
            // create variables to get average employee salary
            int numEmployees = 0;
            int totalSalary = 0;
            
            // print out year
            System.out.println(String.format("************* Year: %s *************", j));
            
            // loop through each employee array for each year
            for(int i = 0; i < readInData.size(); i++){
                
                // create arrays from each inner array in the readInData list
                String[] dataArray = readInData.get(i);
                        
                // grab data when year is equal to j-loop
                if(Integer.parseInt(dataArray[0]) == j){
                    
                    // explicitly define the names of the variables from array
                    // for readability
                    int year = Integer.parseInt(dataArray[0]);
                    String role = dataArray[1];
                    String fullName = dataArray[2];
                    int monthlySalary = Integer.parseInt(dataArray[3]);
                    
                    // make array into '|' delimited strings
                    String arrayString = Arrays.toString(dataArray);
                    arrayString = arrayString.substring(1, arrayString.length()-1).replace(", ", " | ");
                    
                    // if statement determines the employee role and returns
                    // the annual salary and employee information
                    if(role.equals("Executive")){
                        
                        // get salary multiplier and initial new Employee object
                        int salaryMultiplier = Integer.parseInt(dataArray[4]);
                        Employee e = new Executive(fullName, monthlySalary, salaryMultiplier);
                        
                        // print out employee information and annual salary
                        System.out.println(arrayString + " | Annual Salary: " + e.getAnnualSalary());
                        
                        // add to total salary and number of employees
                        numEmployees++;
                        totalSalary += e.getAnnualSalary();
                    }
                    else if(role.equals("Salesman")){
                        
                        // get salary multiplier and initial new Employee object
                        int salaryMultiplier = Integer.parseInt(dataArray[4]);
                        Employee e = new Salesman(fullName, monthlySalary, salaryMultiplier);

                        // print out employee information and annual salary
                        System.out.println(arrayString + " | Annual Salary: " + e.getAnnualSalary());
                        
                        // add to total salary and number of employees
                        numEmployees++;
                        totalSalary += e.getAnnualSalary();

                    } else{
                        // create Employee object for non-sale people or execs
                        Employee e = new Employee(fullName, monthlySalary);
                        
                        // print out employee information and annual salary
                        System.out.println(arrayString + " | Annual Salary: " + e.getAnnualSalary());
                        
                        // add to total salary and number of employees
                        numEmployees++;
                        totalSalary += e.getAnnualSalary();
                    }
                
                }
            }
            //calculate the average salary of an employee
            double avgSalary = totalSalary / numEmployees;
            
            // print out average salary for the year
            System.out.println(String.format("The average salary for %s is: %s\n",
                    j,
                    (double)Math.round(avgSalary * 100d) / 100d));
        }
    }
}