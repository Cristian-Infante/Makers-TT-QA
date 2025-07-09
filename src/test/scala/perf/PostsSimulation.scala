package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PostsSimulation extends Simulation {

  private val httpConf = http
    .baseUrl("https://jsonplaceholder.typicode.com")
    .acceptHeader("application/json")

  private val scn = scenario("GET /posts")
    .exec(
      http("List posts")
        .get("/posts")
        .check(status.is(200))
    )

  setUp(
    scn.inject(atOnceUsers(100))
  )
    .protocols(httpConf)
    .assertions(
      global.responseTime.mean.lt(800),
      global.responseTime.max.lt(1200),
      global.failedRequests.percent.lte(1)
    )
}
