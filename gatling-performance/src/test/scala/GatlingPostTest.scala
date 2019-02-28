import java.util
import java.util.Random

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration.FiniteDuration

class GatlingPostTest extends Simulation {

  private val NAMES: util.List[String] =
    util.Arrays.asList("Bob", "Fred", "Heinrich", "John", "Noman", "Raimund", "Ankit", "Patrick",
      "Thomas", "Kyril", "Dirk", "Stefan", "Hugo", "Chris", "Sepp", "Josef", "Franz", "Mischa", "Hubert",
      "Horst", "Norbert", "David", "Manuel", "Christian", "Thorsten", "Espen", "Brian", "Frederik", "Kimi",
      "Michael", "Mathew", "Milan", "Manfred", "Sebastian", "Markus", "Dieter", "Eberhard", "Henning",
      "Bruce", "Tom", "George", "Robert", "Paul", "Richard", "Keith", "Steven", "Cliff", "Jeremy", "Vladimir",
      "Giuseppe", "Vincenzo", "Michele", "Giovanni", "Pietro", "Peter", "Silvio", "Rene", "Yannick",
      "Elias", "Steffen", "Aswatha", "Mario", "Matteo", "Abraham", "Giulio", "Jorge", "Nils", "Jürgen")

  private val APPELATION = util.Arrays.asList("joyful", "painful", "smart", "beloved", "boring", "nice",
    "cruel", "hopeless", "jealous", "freaky", "lazy", "quick", "stormy", "ruthless", "heavy", "cheerful",
    "underestimated", "sweet", "bitter", "spicy", "hot", "sunny", "cloudy", "respectful", "noisy", "loud",
    "waving", "unkown", "pleasant", "amazing", "joyful", "nostalgic", "unbearable", "disguised", "smelling",
    "untrusted", "tiny", "stupid", "hidden", "light", "sleeping", "tasting", "crying", "wheeping", "praying",
    "running", "spinning", "twisting", "rushing", "sitting", "bathing", "watching", "pushing",
    "irresistible", "famous", "brave", "dizzy", "lunatic", "fanatic", "simple", "complicated", "difficult",
    "horrible", "unpleasent", "childish", "foolish", "fierce", "giggling", "clapping", "stomping")

  private val random = new Random()


  val nbUsers: Int = System.getenv("USERS").toInt
  val duration: Int = System.getenv("DURATION").toInt
  val url: String = System.getenv("URL")
  val name: String = System.getenv("TESTNAME")
  val requests: Int = System.getenv("REQUESTS").toInt

  val scn: ScenarioBuilder = scenario("CreatePersonsWithAppelation")
    .repeat(requests, "n") {
      exec(
        http(name)
          .post(url)
          .header("Content-Type", "application/json; charset=ISO-8859-1")
          .header("accept", "*/*")
          .body(StringBody(randomBody()))
          .check(status.is(200))
      )
    }

  setUp(scn.inject(atOnceUsers(nbUsers))).maxDuration(FiniteDuration.apply(duration, "minutes"))



  def randomName(): String = {
    val idx: Int = random.nextInt(NAMES.size)
    NAMES.get(idx)
  }

  def randomAppelation(): String = {
    val idx: Int = random.nextInt(APPELATION.size)
    APPELATION.get(idx)
  }

  def randomBody(): String = {
    """{"appelation":"$1","name":"$2"}"""
      .replace("$1", randomAppelation())
      .replace("$2", randomName())
  }
}