package com.entity;

public class TodoEntity {
	private int id;
	private String nameString;
	private String todoString;
	private String statusString;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getTodoString() {
		return todoString;
	}
	public void setTodoString(String todoString) {
		this.todoString = todoString;
	}
	public String getStatuString() {
		return statusString;
	}
	public void setStatuString(String statuString) {
		this.statusString = statuString;
	}
	@Override
	public String toString() {
		return "Entity [id=" + id + ", nameString=" + nameString + ", todoString=" + todoString + ", statuString="
				+ statusString + "]";
	}
	
	

}
