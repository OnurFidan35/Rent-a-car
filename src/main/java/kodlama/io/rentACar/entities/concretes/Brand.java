package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "brands")
public class Brand {
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")	
private int id;

@Column(name="name")
private String name;


public Brand(int id, String name) {

	this.id = id;
	this.name = name;
}



public Brand() {
	
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
}


	
	
}
