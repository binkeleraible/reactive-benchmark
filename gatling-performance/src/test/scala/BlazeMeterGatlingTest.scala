import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

import scala.concurrent.duration.FiniteDuration

class BlazeMeterGatlingTest extends Simulation {

  val scn = scenario("AddAndFindPersons").repeat(1000, "n") {
    exec(
      http("PersonStarts-API-Reactive")
        .get("http://localhost:12051/rperson/starts/H")
        .check(status.is(200))
    )
  }

  setUp(scn.inject(atOnceUsers(30))).maxDuration(FiniteDuration.apply(10, "minutes"))

}