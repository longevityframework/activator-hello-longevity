package simbl

import longevity.context.LongevityContext
import longevity.context.Mongo
import simbl.domain.Blog
import simbl.domain.BlogPost
import simbl.domain.SimblCoreDomain
import simbl.domain.User
import simbl.api.UserApi

/** default container for all the Simble application components */
class SimblContextImpl extends SimblContext {
  val coreDomain = new SimblCoreDomain
  val longevityContext = LongevityContext(coreDomain, Mongo)
  val repoPool = longevityContext.repoPool

  val blogRepo = repoPool[Blog]
  val blogPostRepo = repoPool[BlogPost]
  val userRepo = repoPool[User]
  val userApi = new UserApi(userRepo)
}
