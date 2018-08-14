package mypackage

import scala.annotation.compileTimeOnly
import scala.annotation.StaticAnnotation
import scala.reflect.internal.annotations.compileTimeOnly
import scala.reflect.macros.Context
import scala.language.experimental.macros

object MyMacro {
  def macroTransform(c: Context)(annottees: c.Tree*): c.Tree = {
    import c._, universe._
    q"class the_method_named_is_modified_by_myAnnotation"
  }


  @compileTimeOnly("requires macros paradise plugin")
  final class myAnnotation extends StaticAnnotation {
    def macroTransform(annottees: Any*): Any = macro MyMacro.macroTransform
  }

}