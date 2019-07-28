package practice.matchLearn

import practice.matchLearn.Person

class Animal
case class Dog(name:String) extends Animal
case class Cat(name:String) extends Animal
case object Woodpecker extends Animal
object traitAnimal extends App{
  def determineType(x:Animal) : String = x match {
    case Dog(moniker) => "Got a Dog, named " + moniker
    case _:Cat => "Got a Cat (ignoring the name)"
    case Woodpecker => "That was a woodpecker"
  }
  def speak(p:Person) = p match {
    case Person(firstName,lastName) if firstName == "Fred" => println("Yubba dubba doo")
    case Person(firstName,lastName) if firstName == "Bam Bam" => println("Bam Bam!")
    case _ => println("Watch the Flintstones!")
  }
  def isPerson(x:Any): Boolean = x match {
    case p: Person => true
    case _ => false
  }
  val p = new Person("Fred","Bam")
  println(p.isInstanceOf[Person])
  println(isPerson(p))
  speak(p)
  println(determineType(new Dog("Rocky")))
  println(determineType(new Cat("Rusty the cat")))
  println(determineType(Woodpecker))
}
