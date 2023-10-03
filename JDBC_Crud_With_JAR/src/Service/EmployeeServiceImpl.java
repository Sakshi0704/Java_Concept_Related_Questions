package Service;

import java.time.LocalDate;
import java.util.List;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import Entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDAO empdao1;
	
	
	

	@Override
	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		if(emp==null) {
			sb.append("Provided data is null");
			//return sb;
		}else {
			empdao1=new EmployeeDAOImpl();
			try{
				
				empdao1.addEmployeeInData(emp);
				sb.append("Added succesfulluy");
				
			}catch(Exception e){
				e.getStackTrace();
			}
		}
		
		return sb.toString();
		
		
		
		
	}

	@Override
	public Employee viewEmployee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployee(Employee emp, String eid) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		if(emp==null) {
			sb.append("Provided data is null");
			//return sb;
		}else {
			empdao1=new EmployeeDAOImpl();
			try{
				
				empdao1.updateEmployeeInData(emp,eid);
				sb.append("updated succesfulluy");
				
			}catch(Exception e){
				e.getStackTrace();
			}
		}
		
		return sb.toString();
		//return null;
	}

	@Override
	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		empdao1=new EmployeeDAOImpl();
		try {
			empdao1.deleteEmployeeInData(id);
			sb.append("employee delete ");
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		return sb.toString();
		//return null;
	}

	@Override
	public List<Employee> searchEmployeeByJoiningDateRange(LocalDate dt1, LocalDate dt2) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
