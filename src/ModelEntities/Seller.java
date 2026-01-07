package ModelEntities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable{
	private static final long serialVersionUID = 1L;
	private int Id;
	private String Name;
	private String Email;
	private Date BirthDate;
	private Double BaseSalary;
	
	private Department department;
	
	public Seller() {
	}
	
	public Seller(int id, String name, String email, Date birthDate, Double baseSalary, Department department) {
		super();
		Id = id;
		Name = name;
		Email = email;
		BirthDate = birthDate;
		BaseSalary = baseSalary;
		this.department = department;
	}



	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getDate() {
		return BirthDate;
	}
	public void setDate(Date date) {
		BirthDate = date;
	}
	public Double getBaseSalary() {
		return BaseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		BaseSalary = baseSalary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(BaseSalary, BirthDate, Email, Id, Name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(BaseSalary, other.BaseSalary) && Objects.equals(BirthDate, other.BirthDate)
				&& Objects.equals(Email, other.Email) && Id == other.Id && Objects.equals(Name, other.Name);
	}
	@Override
	public String toString() {
		return "Setter [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Date=" + BirthDate + ", BaseSalary="
				+ BaseSalary + "]";
	}
	
	
	
}
