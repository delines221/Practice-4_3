import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeRepository extends Employee{

    public EmployeeRepository(int id, String name, String lastName, Gender gender, int age, int salary, int workExperience, Speciality speciality) {
        super(id, name, lastName, gender, age, salary, workExperience, speciality);
    }
    List<Employee> list = new ArrayList<>();

    public String[] getNameAndSureNameOfTop3BySalary(){
     return  list.stream()
             .sorted(Comparator.comparing(Employee::getSalary)
             .reversed()).limit(3)
             .map(employee -> employee.getName()+" "+ employee.getLastName())
             .toArray(String[]::new);
    }
    public Map<Speciality, List<Employee>> groupBySpeciality(){
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getSpeciality));
    }

    public int getSalaryByHugeCriteriaList(){
        return list.stream()
                .filter(employee -> employee.getGender() == Gender.FEMALE)
                .filter(employee -> employee.getSpeciality() == Speciality.QA)
                .filter(employee -> employee.getWorkExperience() <= 5)
                .mapToInt(Employee::getSalary)
                .sum();
    }
    public boolean checkIfPresentEmployeeWithWorkExperienceMoreThenTwenty(){
        return list.stream().filter(employee -> employee.getGender() == Gender.MALE)
                .filter(employee -> employee.getSpeciality() == Speciality.BACKEND_DEVELOPER || employee.getSpeciality() == Speciality.DEV_OPS)
                .anyMatch(employee -> employee.getWorkExperience() > 20);
    }
    public String getDescendingSalaryWithFullName(){
      return list.stream()
                   .sorted(Comparator.comparingInt(Employee::getSalary)
                        .reversed())
                   .map(employee -> String.format("%s, %s, %d ;", employee.getName(), employee.getLastName(), employee.getSalary()))
                   .collect(Collectors.joining());
    }
    public Map<Speciality, Double> getAverageSalaryBySpeciality(){
        return list.stream().collect((Collectors.groupingBy(Employee::getSpeciality, Collectors.averagingInt(Employee::getSalary))));
    }


}
