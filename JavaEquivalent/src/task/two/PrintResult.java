package task.two;

import java.util.Optional;

public class PrintResult {

	private static void printResult(Foo foo) {
		String result = Optional.ofNullable(foo).map(Foo::getBar)
				.map(Bar::getBaz).map(Baz::getResult).orElse("No Result");
		System.out.println(result);
	}

	public static void main(String args[]) {
	    
		//all kinds of possibilities
		Foo foo1 = new Foo(null);
	    Foo foo2 = new Foo(new Bar(null));
	    Foo foo3 = new Foo(new Bar(new Baz(null)));
	    Foo foo4 = new Foo(new Bar(new Baz("Hello")));
	    
	    printResult(foo1);
	    printResult(foo2);
	    printResult(foo3);
	    printResult(foo4);
	}

}
