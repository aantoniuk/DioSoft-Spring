package org.diosoft.spring.lesson5.spel;

class Person implements org.diosoft.spring.lesson5.spel.Observer {

	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void notify(Message message) {
		System.out.println(message.getMessage() + ", " + name);
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
