import java.util
import java.util.{Arrays, List, Random}

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration.FiniteDuration

class GatlingGetTest extends Simulation {

  val nbUsers: Int = System.getenv("USERS").toInt
  val duration: Int = System.getenv("DURATION").toInt
  val url: String = System.getenv("URL")
  val name: String = System.getenv("TESTNAME")
  val requests: Int = System.getenv("REQUESTS").toInt

  val scn: ScenarioBuilder = scenario("FindPersonsByAppelation")
    .repeat(requests, "n") {
      exec(
        http(name) //"PersonStarts-API-Reactive"
          .get(url) //"http://localhost:12051/person/starts/H"
          .check(status.is(200))
      )
    }

  setUp(scn.inject(atOnceUsers(nbUsers))).maxDuration(FiniteDuration.apply(duration, "minutes"))

}