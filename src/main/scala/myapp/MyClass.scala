package myapp

object MyClass {
  @mypackage.MyMacro.myAnnotation
  class MyInnerClass

  def main(args: Array[String]): Unit = {
    new the_method_named_is_modified_by_myAnnotation
  }
}