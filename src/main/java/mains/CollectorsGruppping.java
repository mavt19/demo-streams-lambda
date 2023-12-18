package mains;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Department;
import model.Employee;
import model.enums.Gender;

public class CollectorsGruppping {

	public static void main(String[] args) {
//		System.out.println(findAllEmployees());
		
		// Group employees by department
//			List<Department> departments = findAllEmployees().stream().map(Employee::getDepartment).collect(Collectors.toList());
//            System.out.println(departments);
//            
//            // Group employees by gender
//            List<Gender> genders = findAllEmployees().stream().map(Employee::getGender).collect(Collectors.toList());
//            System.out.println(genders);
//            
//            // Group employees by designation
//            List<String> designations = findAllEmployees().stream().map(Employee::getDesignation).collect(Collectors.toList());
//            System.out.println(designations);
//            
//            // Group employees by department and gender
//           Map<Department, Map<Gender, List<Employee>>> departmentsAndGender = findAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender)));
//            System.out.println(departmentsAndGender);
			//Group employees by designation
			Map<String,List<Employee>> departmentsbyDesignation = findAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDesignation));
			System.out.println(departmentsbyDesignation);
			
			//Group employees by gender
			Map<Gender,List<Employee>> departmentsByGender = findAllEmployees().stream().collect(Collectors.groupingBy(Employee::getGender));
			System.out.println(departmentsByGender);
			
			//Group employees by department
			Map<Department,List<Employee>> departmentsByDepartment = findAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
			System.out.println(departmentsByDepartment);
			
			//obtener los empleados con el salario mas alto por departamento
			List<Employee> highPayEmpByDept = findAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment))
			.values().stream().map(depEmp -> depEmp.stream().max(Comparator.comparing(Employee::getSalary)).get()).collect(Collectors.toList());
			
			System.out.println(highPayEmpByDept);
			
			//obtener la lista de listas de empleados agrupados por departamento
			Collection<List<Employee>> resultList = findAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList())).values();
			System.out.println(resultList);
			
	}
	
	
	private static List<Employee> findAllEmployees() {
		 // Creating List and adding Employees values.
		/*
		 * Departamentos de empresas:

			Headquarters: sede central
			Head Office: oficina central
			Sales Department: Departamento de Ventas
			Human Resources (HR) Department: Departamento de Recursos Humanos
			Purchasing Department: Departamento de Compras
			Accounts Department: Departamento de Contabilidad
			Finance Department: Departamento de Finanzas
			Customer Service Department: Departamento de Atención al cliente
			Public Relations (PR): Relaciones públicas
			Research & Development (R&D) Department: Departamento de Investigación y desarrollo
			After-Sales Service: Servicio post venta
			Production Department: Departamento de producción
			Marketing Department: Departamento de Marketing
			Communications Department: Departamento de Comunicación
			IT Department: Departamento de Tecnología e Información
			Warehousing Department: Departamento de Almacenaje
			Logistics Department: Departamento de Logística
			Legal Department: Departamento Legal
			Reception: Recepción
			Board of Directors: Junta Directiva
		 * */
        List<Employee> employeesList = new ArrayList<>();
 
        Department it = new Department(1L, "IT Department");
        Department hr = new Department(1L, "Human Resources (HR) Department");
        Department sales = new Department(1L, "Sales Department");
        employeesList.add(new Employee(101L, "Glady", "Manager", Gender.MALE, it, 25_00_000));
        employeesList.add(new Employee(102L, "Vlad", "Software Engineer", Gender.FEMALE, it, 15_00_000));
        employeesList.add(new Employee(103L, "Shine", "Lead Engineer", Gender.FEMALE, it, 20_00_000));
        employeesList.add(new Employee(104L, "Nike", "Manager", Gender.FEMALE, it, 25_00_000));
        employeesList.add(new Employee(105L, "Slagan", "Software Engineer", Gender.MALE, it, 15_00_000));
        employeesList.add(new Employee(106L, "Murekan", "Software Engineer", Gender.MALE, it, 15_00_000));
        employeesList.add(new Employee(107L, "Gagy", "Talent Recruiter", Gender.MALE, hr, 15_00_000));
        employeesList.add(new Employee(107L, "Gagy", "Sales Manager", Gender.FEMALE, sales, 15_00_000));
        employeesList.add(new Employee(107L, "Gagy", "Talent Recruiter", Gender.MALE, hr, 15_00_000));
        
        return employeesList;
	}
}
