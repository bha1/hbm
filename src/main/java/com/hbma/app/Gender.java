package com.hbma.app;

public enum Gender {
	M("M"), F("F");
	
	private final String name;
	
	private Gender(String name){
		this.name = name;
	}
	
	public Gender fromName(String name){
		for(Gender gender : Gender.values()){
			if(gender.toString().equals(name))
				return gender;
		}
		return null;
	}
	
	public String toString(){
		return this.name();
	}
}
