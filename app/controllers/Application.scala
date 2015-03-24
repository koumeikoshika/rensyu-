package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import scalikejdbc._

case class CreateForm(title: String, content: String)

object Application extends Controller {

  val createForm = Form(
    mapping(
      "title" -> text,
      "contents" -> text
    )(CreateForm.apply)(CreateForm.unapply)
  )


  def index = Action {
   Ok("")
   }

  def tasks = Action{
    Ok("aiueo")
  }

  def show(id: Int) = Action{
    Ok(id.toString)
  }

  def createFormView = Action {
  Ok(views.html.create(createForm))
  }

  def create = Action { implicit request =>
    createForm.bindFromRequest.fold(
      error => {
        BadRequest("Error")
      },
      {
        case CreateForm(t, c) => {
          Task.create(t, c)
          Redirect(routes.Application.tasks)
        }
      }
    )
  }

  def delete(id: Int) = Action{
    Ok(id.toString)
  }

}