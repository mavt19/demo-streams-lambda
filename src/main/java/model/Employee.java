package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.enums.Gender;

@Data
@AllArgsConstructor
public class Employee {
	private Long id;
    private String name;
    private String designation;
    private Gender gender;
    private Department department;
    private long salary;
}
