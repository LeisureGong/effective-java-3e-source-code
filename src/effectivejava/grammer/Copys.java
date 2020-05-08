package effectivejava.grammer;

/**
 * java的拷贝方法
 * @author gonglei
 * @date 2020/5/8
 */
public class Copys {
	static class Person implements Cloneable{

		private Integer age;
		private String name;

		public Person(Integer age,String name){
			super();
			this.age = age;
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString(){
			return super.toString();
		}

		@Override
		public Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
	}

	static class Face implements Cloneable{
		@Override
		protected Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
	}

	static class Head implements Cloneable{
		public Face face;

		public Head(){}

		public Head(Face face){
			this.face = face;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException{
			Head newHead = (Head) super.clone();
			newHead.face = (Face) this.face.clone();
			return newHead;
		}
	}

	static class Body implements Cloneable{
		public Head head;
		public Body(){}
		public Body(Head head){
			this.head = head;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException{
			Body newBody = (Body) super.clone();
			newBody.head = (Head) head.clone();
			return newBody;
		}
	}

	public static void main(String[] args) throws Exception{
		Body body = new Body(new Head());
		Body body1 = (Body) body.clone();
		System.out.println(body.head.face == body1.head.face );
	}

}
