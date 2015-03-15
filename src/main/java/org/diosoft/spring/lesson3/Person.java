package org.diosoft.spring.lesson3;

class Person {

	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
