package controllers

import javax.inject._
import models.Account
import play.api._
import play.api.mvc._

import services.{AccountService, Counter}

/**
  * This controller demonstrates how to use dependency injection to
  * bind a component into a controller class. The class creates an
  * `Action` that shows an incrementing count to users. The [[Counter]]
  * object is injected by the Guice dependency injection system.
  */
@Singleton
class AccountController @Inject() () extends Controller {

  /**
    * Create an action that responds with the [[Counter]]'s current
    * count. The result is plain text. This `Action` is mapped to
    * `GET /count` requests by an entry in the `routes` config file.
    */
  def register = Action(parse.json) { request =>
    AccountService.register(Account("123123123", "luis", "DR"))
    Ok(request.body)
  }

}
