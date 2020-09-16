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
	Hampster {
		@Override
		public String toString(){
			return "Hampster";
		}
	};
	
	public abstract String toString();
}
