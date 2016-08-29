package task.one

/**
 * I got this from:
 * http://docs.scala-lang.org/tutorials/scala-for-java-programmers.html
 */
class User () {
  
  /**
   * I got this from:
   * http://www.scala-lang.org/api/2.12.0-M5/scala/collection/index.html
   */
  def roles = List(new Role("role 1"), new Role("role 2"), new Role("role 3"))
  
  def getRoles(): List[Role] = {
    return roles;
  }
  
}