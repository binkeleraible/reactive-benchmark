import java.util
import java.util.{Arrays, List, Random}

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration.FiniteDuration

class GatlingGetTest extends Simulation {
  private val LETTERS: util.List[String] =
    util.Arrays.asList("a", "b", "c", "d", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
      "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")

  private val random = new Random()

  val nbUsers: Int = System.getenv("USERS").toInt
  val duration: Int = System.getenv("DURATION").toInt
  val url: String = System.getenv("URL")
  val name: String = System.getenv("TESTNAME")

  val requests: Int = System.getenv("REQUESTS").toInt

  val scn: ScenarioBuilder = scenario("FindPersonsByAppelation")
    .repeat(requests, "n") {
      exec(
        http(name) //"PersonStarts-API-Reactive"
          .get(url + randomLetter()) //"http://localhost:12051/person/starts/H"
          .check(status.is(200))
      )
    }

  setUp(scn.inject(atOnceUsers(nbUsers))).maxDuration(FiniteDuration.apply(duration, "minutes"))

  def randomLetter(): String = {
    val idx: Int = random.nextInt(LETTERS.size)
    LETTERS.get(idx)
  }

}