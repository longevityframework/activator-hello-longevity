package simbl

import akka.actor.ActorSystem
import longevity.context.LongevityContext
import longevity.context.Mongo
import simbl.api.UserService
import simbl.api.UserRoute
import simbl.domain.Blog
import simbl.domain.BlogPost
import simbl.domain.SimblCoreDomain
import simbl.domain.User

/** default container for all the Simble application components */
class SimblContextImpl extends SimblContext {
  val coreDomain = new SimblCoreDomain
  val longevityContext = LongevityContext(coreDomain, Mongo)
  val repoPool = longevityContext.repoPool

  val blogRepo = repoPool[Blog]
  val blogPostRepo = repoPool[BlogPost]
  val userRepo = repoPool[User]

  val actorSystem = ActorSystem("SimpleBlogging")
  implicit val context = actorSystem.dispatcher

  val userService = new UserService(userRepo)
  val userRoute = new UserRoute(userService)
}
