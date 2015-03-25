package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import scalikejdbc._
import models.tasks.Task

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
    Ok(views.html.list(Task))
  }

  def show(id: Int) = Action{
    findById(id: Int) match{
      case Some(id) => Ok(views.html.show(Task))
      case _        => "nothing"
    }
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
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }

}