package com.vti.entity;

public class CPU {
	int price;

	public class Processor {
		int coreAmount;
		String menufacturer;

		public Processor(int coreAmount, String menufacturer) {

			this.coreAmount = coreAmount;
			this.menufacturer = menufacturer;

		}

		public float getCache() {
			return 4.3f;
		}

	}

	public class Ram {
		int memory;
		String menufacturer;

		public Ram(int memory, String menufacturer) {

			this.memory = memory;
			this.menufacturer = menufacturer;
		}

		public float getClockSpeed() {
			return 5.5f;
		}
	}
}
