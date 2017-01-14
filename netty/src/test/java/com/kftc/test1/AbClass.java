package com.kftc.test1;

 abstract class AbClass implements IA,IB,IAll {

	 @Override
		public void All() {
		 throw new UnsupportedOperationException("추상클래스에서는 미구현상태 입니다. 구현체를 호출하셔야합니다");
		}
	 
	@Override
	public void b() { throw new UnsupportedOperationException("추상클래스에서는 미구현상태 입니다. 구현체를 호출하셔야합니다"); }

	@Override
	public void a() {throw new UnsupportedOperationException("추상클래스에서는 미구현상태 입니다. 구현체를 호출하셔야합니다");}
}
