package sebnozzi.katas.bowling

object BowlingScoreCalculator {

  def scoreOf(rolls: String): Int = scoreOf(rolls.toList)

  private def scoreOf(rolls: List[Char]): Int = {
    rolls match {

      case 'X' :: firstRollAfterStrike :: secondRollAfterStrike :: rest => {
        10 + scoreOf(firstRollAfterStrike, secondRollAfterStrike) +
          scoreOfRestAndAddedRolls(rest, addedRolls = firstRollAfterStrike, secondRollAfterStrike)
      }

      case firstRollInSpare :: '/' :: rollAfterSpare :: rest => {
        10 + scoreOf(rollAfterSpare) +
          scoreOfRestAndAddedRolls(rest, addedRolls = rollAfterSpare)
      }

      case oneRoll :: rest => scoreOf(oneRoll) + scoreOf(rest)

      case List() => 0
    }
  }

  private def scoreOf(firstRoll: Char, secondRoll: Char): Int = {
    List(firstRoll, secondRoll) match {
      case firstRollInBonusSpare :: '/' :: Nil => 10
      case _ => scoreOf(firstRoll) + scoreOf(secondRoll)
    }
  }

  private def scoreOf(oneRoll: Char): Int = {
    def numberValue(c: Char) = Integer.parseInt(c.toString())
    oneRoll match {
      case 'X' => 10
      case '-' => 0
      case c if c.isDigit => numberValue(c)
      case _ => throw new IllegalArgumentException(s"Unknown roll: '$oneRoll'")
    }
  }

  private def scoreOfRestAndAddedRolls(rest: List[Char], addedRolls: Char*): Int = {
    val atBonusFrame = rest.isEmpty
    if (atBonusFrame)
      0 // no more points, rolls were added before
    else
      scoreOf(addedRolls.toList ++ rest)
  }

}
