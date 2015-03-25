package models.tasks

import scalikejdbc._
import org.joda.time.DateTime

case class Task(id: Int, title: String, content: String, createdAt: DateTime)

object Task extends SQLSyntaxSupport[Task] {

  override val tableName = "tasks"

  def apply(rs: WrappedResultSet): Task = Task(
    rs.int("id"),
    rs.string("title"),
    rs.string("content"),
    rs.jodaDateTime("createdAt")
  )

  def tasks = {
    DB readOnly { implicit session =>
      sql"select id, title, createdAt".map(Task(_)).single.apply()
    }
  }
  def create(title: String, content: String)(implicit dbSession: DBSession = AutoSession) = {
    sql"insert into tasks (title, content) values (${title}, ${content})".update.apply()
  }

  def findById(id: Int): Option[Task] = {
    DB readOnly { implicit session =>
      sql"select id, title, content, createdAt from tasks where id = ${id}".map(Task(_)).single.apply()
    }
  }

}