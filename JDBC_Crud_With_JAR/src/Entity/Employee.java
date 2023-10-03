package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	public Employee() {
		
	}
	public Employee(String id, String name, double salary, LocalDate joining_date) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.joining_date = joining_date;
	}
	private String id;
	private String name;
	private double salary;
	private LocalDate joining_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(LocalDate joining_date) {
		this.joining_date = joining_date;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", joining_date=" + joining_date + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, joining_date, name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id) && Objects.equals(joining_date, other.joining_date)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	

}
