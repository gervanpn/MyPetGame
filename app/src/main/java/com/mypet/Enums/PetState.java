package com.mypet.Enums;

public enum PetState {
	Happy {
		@Override
		public PetState nextState() {
			return Hungry;
		}
		
		@Override
		public String toString() {
			return "Happy";
		}
		
		
	},
	Hungry {
		@Override
		public PetState nextState() {
			return Sleepy;
		}
		
		@Override
		public String toString() {
			return "Hungry";
		}
		
	},
	Sleepy {
		@Override
		public PetState nextState() {
			return this;
		}
		
		@Override
		public String toString() {
			return "Sleepy";
		}
		
	};
	
	public abstract PetState nextState();
	public abstract String toString();
}
