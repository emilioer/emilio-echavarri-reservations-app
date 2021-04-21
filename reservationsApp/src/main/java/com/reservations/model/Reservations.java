package com.reservations.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Table(name = "reservations")
public class Reservations {

	@Id
	private int id;
	private String name;
	private String time;

	public Reservations() {}

	public Reservations(int id, String name, String time) {
		this.id = id;
		this.name = name;
		this.time = time;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
