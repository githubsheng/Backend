package task.one;

/**
 * a fake repository, in real world it could return an empty Option
 * get this from:
 * http://docs.scala-lang.org/tutorials/scala-for-java-programmers.html
 */
object PrintUserRoles {

  def printRoles(user: User) {
    Option(user) map { _.getRoles } map { _.foreach { println } }
  }

  def main(args: Array[String]) {

    //below are all kinds of possibilities
    val user1 = new User()
    val user2 = null

    printRoles(user1)
    printRoles(user2)

  }

}