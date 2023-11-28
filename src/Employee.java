import java.util.Comparator;

public class Employee{
    private int id;
    private String name;
    private String lastName;
    private Gender gender;
    private int age;
    private int salary;
    private int workExperience;
    private Speciality speciality;

    public Employee(int id, String name, String lastName, Gender gender, int age, int salary, int workExperience, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.workExperience = workExperience;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", salary=" + salary +
                ", workExperience=" + workExperience +
                ", speciality=" + speciality +
                '}';
    }
}
