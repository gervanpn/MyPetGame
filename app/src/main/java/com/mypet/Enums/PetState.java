package com.mypet.Enums;

public enum PetState {
	Happy {
		@Override
		public PetState nextState() {
			return Energetic;
		}
		
		@Override
		public String toString() {
			return "Happy";
		}
	},

	Hungry {
		@Override
		public PetState nextState() {
			return Happy;
		}
		
		@Override
		public String toString() {
			return "Hungry";
		}
	},

	Energetic {
		@Override
		public PetState nextState() {
			return Happy;
		}
		
		@Override
		public String toString() {
			return "Energetic";
		}
	};
	
	public abstract PetState nextState();
	public abstract String toString();
}
