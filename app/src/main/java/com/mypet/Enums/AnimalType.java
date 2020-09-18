package com.mypet.Enums;

public enum AnimalType {
	
	Cat {
		@Override
		public String toString() {
			return "Cat";
		}
		
		public String returnImage(){
			return "cat_button";
		}
	},
	Dog {
		@Override
		public String toString(){
			return "Dog";
		}
		public String returnImage(){
			return "dog_button";
		}
	},
	Hamster {
		@Override
		public String toString(){
			return "Hamster";
		}
		public String returnImage(){
			return "hamster_but";
		}
	};
	
	public abstract String toString();
	public abstract String returnImage();
}
