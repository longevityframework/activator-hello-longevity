package simbl

import akka.actor.ActorSystem
import longevity.persistence.Repo
import simbl.api.UserService
import simbl.api.UserRoute
import simbl.domain.Blog
import simbl.domain.BlogPost
import simbl.domain.User

/** an API for a container for all the Simble application components */
trait SimblContext {
  val actorSystem: ActorSystem
  val blogRepo: Repo[Blog]
  val blogPostRepo: Repo[BlogPost]
  val userRepo: Repo[User]
  val userService: UserService
  val userRoute: UserRoute
}
