package nonreactive.domain;

import org.springframework.data.annotation.Id;

public class Person {

	@Id
	private String id;

	private String appelation;
	private String name;


	Person() {
	}

	public Person(String appelation, String name) {
		this.appelation = appelation;
		this.name = name;
	}

	public String getAppelation() {
		return this.appelation;
	}

	public void setAppelation(String appelation) {
		this.appelation = appelation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
}
