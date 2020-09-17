package com.mypet.Enums;

public enum AnimalType {
	
	Cat {
		@Override
		public String toString() {
			return "Cat";
		}
	},
	Dog {
		@Override
		public String toString(){
			return "Dog";
		}
	},
	Hamster {
		@Override
		public String toString(){
			return "Hamster";
		}
	};
	
	public abstract String toString();
}
