package effectivejava.chapter2.item2.builder;

/**
 * @author gonglei
 * @date 2020/5/9
 */
public class Car {

	private final int weight;
	private final String color;
	private final int light;
	private final int year;

	public static class Builder{
		private final int year;

		private int weight = 0;
		private String color = "red";
		private int light = 0;

		public Builder(int year){
			this.year = year;
		}

		public Builder weight(int val){
			weight = val;
			return this;
		}
		public Builder color(String str){
			color = str;
			return this;
		}
		public Builder light(int val){
			light = val;
			return this;
		}

		public Car build(){
			return new Car(this);
		}
	}

	private Car(Builder builder){
		year = builder.year;
		weight = builder.weight;
		color = builder.color;
		light = builder.light;
	}

	@Override
	public String toString() {
		return "Car{" +
				"weight=" + weight +
				", color='" + color + '\'' +
				", light=" + light +
				", year=" + year +
				'}';
	}

	public static void main(String[] args){
		Car car = new Builder(100).weight(10).color("Blue").light(1000).build();
		System.out.println(car.toString());
	}
}
