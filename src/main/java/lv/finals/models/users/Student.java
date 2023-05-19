package lv.finals.models.users;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person {
	
	//TODO sasaiste ar Course klasi
	//TODO izveidot DATA jpa anotacijas
	@Column(name = "matriculaNo")
	@NotNull
	@Pattern(regexp = "[0-9]{8,20}")
	private String matriculNo;
	
	
	@Column(name = "FinancialDebt")
	private boolean finanseDept;


	public Student(
			@NotNull @Pattern(regexp = "[A-ZĀĢČĒĪĶĻŅŠŪŽ]{1}[a-zāģčēīķļņšūž\\ ]+") @Size(min = 3, max = 15) String name,
			@NotNull @Pattern(regexp = "[A-ZĀĢČĒĪĶĻŅŠŪŽ]{1}[a-zāģčēīķļņšūž\\ ]+") @Size(min = 3, max = 15) String surname,
			@NotNull @Pattern(regexp = "[0-9]{6}-[0-9]{5}+", message = "Neatbilstošs personas kods") @Size(min = 12, max = 12) String personacode,
			User user, @NotNull @Pattern(regexp = "[0-9]{8,20}") String matriculNo, boolean finanseDept) {
		super(name, surname, personacode, user);
		this.matriculNo = matriculNo;
		this.finanseDept = finanseDept;
	}

	@ManyToMany
	@JoinTable(name = "student_deb_courses_table", joinColumns =  @JoinColumn("Idc"), inverseJoinColumns =  = @JoinColumn(name = "Idp"))
	private Collection<Course> debtCourse = new ArrayList<>();
	
	
}
