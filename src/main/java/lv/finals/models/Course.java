package lv.finals.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.finals.models.users.Student;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc") 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;
	
	@Column(name = "Title")
	@NotNull
	@Pattern(regexp = "[A-ZĀĢČĒĪĶĻŅŠŪŽ]{1}[a-zāģčēīķļņšūž\\ ]+")
	@Size(min = 4, max = 30)
	private String title;
	
	@Column(name = "CreditPoint")
	@Min(value = 1)
	@Max(value = 20)
	private int creditPoint;
	
	@ManyToMany(mappedBy = "debtCourses")
	private Collection<Student> debtStudents = new ArrayList<>();
	
	public Course(String title, int creditPoint) {
		this.title = title;
		this.creditPoint = creditPoint;
		
	}
	
	public void addStudent(Student student) {
		if(!debtStudents.contains(student)) {
			debtStudents.add(student);
		}
	}
	
	public void removeStudent(Student student) {
		debtStudents.remove(student);
	}
	
}
