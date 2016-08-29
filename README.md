All runnable code are in the repository. Below are my answers:  
# Problem 1
```java
List<String> roleNames = new ArrayList<String>();
User user = userRepository.findUser(1);
if (user != null) {
  List<Role> roles = user.getRoles();
  for (Role role : roles) {
    roleNames.add(role.getName());
  }
}
for (String roleName: roleNames) {
  System.out.println(“Role: ” + roleName);
}
```
Java 8 solution
```java
private static void printRoles(User user){
	Optional.ofNullable(user).map(User::getRoles).ifPresent(l -> l.forEach(System.out::println));
}
```
Testing
```java
//all kinds of possibilities
User user1 = new User();
User user2 = null;

printRoles(user1); //print user roles
printRoles(user2); //will not throw null pointer exception
```

Scala solution (my best guesses)
```scala
def printRoles(user: User) {
  Option(user) map { _.getRoles } map { _.foreach { println } }
}
```
Testing
```scala
//below are all kinds of possibilities
val user1 = new User()
val user2 = null

printRoles(user1) //print user roles
printRoles(user2) //will not throw null pointer exception
```
Summary  
Compared with Java 7: more concise, FP style (maybe monad, foreach)  
Compared with Java 8: no difference in this particular case  
#Problem 2
```java
Result result;
Foo foo = getFoo();
if (foo != null) {
  Bar bar = first.getSecond();
  if (bar != null) {
    Baz baz = bar.getBaz();
    if (baz != null) {
      result = baz.getResult();
    }
  }
}
if (result != null) {
  System.out.println(result.toString());
} else {
  System.out.println(“No result”);
}
```

Java 8 solution
```java
String result = Optional.ofNullable(foo).map(Foo::getBar).map(Bar::getBaz).map(Baz::getResult).orElse("No Result");
System.out.println(result);
```
Testing
```java
//all kinds of possibilities
Foo foo1 = new Foo(null);
Foo foo2 = new Foo(new Bar(null));
Foo foo3 = new Foo(new Bar(new Baz(null)));
Foo foo4 = new Foo(new Bar(new Baz("Hello")));
//following will either print "No result" or "Hello"
printResult(foo1);
printResult(foo2);
printResult(foo3);
printResult(foo4);
```
Scala solution
```scala
implicit def toOption[T](x: T): Option[T] = Option(x)
val result: String = Option(foo) flatMap { _.getBar } flatMap { _.getBaz } flatMap { _.getResult } getOrElse "No Result"
println(result)
```
Testing
```scala
//below are all kinds of possibilities
val foo1 = new Foo(null)
val foo2 = new Foo(new Bar(null))
val foo3 = new Foo(new Bar(new Baz(null)))
val foo4 = new Foo(new Bar(new Baz("Hello")))
//following will either print "No result" or "Hello"
printResult(foo1)
printResult(foo2)
printResult(foo3)
printResult(foo4)
```
Summary  
Compared with Java 7: Much better, free from potential null pointer exceptions and saves many lines of null checks.  
Compared with Java 8: Same  
#Problem 3
The Java fix is in the repository. I will just describe scala solution because the content is getting too long.
Scala solution (my best guesses)
```scala
val retFuture: Future[Integer] = Future{ 1 + 1 }
retFuture.map { println(_) }
```
Summary  
So I read from some dude's blog saying in this case we should use `Future/Promise` instead of `Actor`.  
In whatever cases it should be better than explicitly locking / releasing locks, marking fields as `transient`.  
