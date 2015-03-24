package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import scalikejdbc._

case class CreateForm(title: String, content: String)

object Application extends Controller {
  

  def index = Action {
   Ok("")
   }
  
  def tasks = Action{
    Ok("aiueo")
  }

  def show(id: Int) = Action{
    Ok(id.toString)
  }
  
  def createFormView = Action{
    Ok("")
  }
  
  def create = Action{
    Ok("")
  }
  
  def delete(id: Int) = Action{
    Ok(id.toString)
  }
  
  case class Task(content:String, id:Int, todoAt:String, title:String)
  
}