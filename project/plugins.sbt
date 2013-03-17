resolvers += Classpaths.typesafeResolver

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

//resolvers += "undercoverRepo" at "http://undercover.googlecode.com/svn/maven/repository/"


addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")


addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.1")


addSbtPlugin("com.proinnovate" % "sbt-coverage_2.7.7" % "0.2")
