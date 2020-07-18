import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.1"

project {

    vcsRoot(HttpsGithubComTylerRTeamcityTestMainRefsHeadsMaster)
    vcsRoot(HttpsGithubComTylerRTeamcityTestMainRefsHeadsMaster1)

    buildType(Deploy)
    buildType(Verify)
}

object Deploy : BuildType({
    name = "Deploy"

    vcs {
        root(HttpsGithubComTylerRTeamcityTestMainRefsHeadsMaster)
    }

    triggers {
        vcs {
        }
    }
})

object Verify : BuildType({
    name = "Verify"

    vcs {
        root(HttpsGithubComTylerRTeamcityTestMainRefsHeadsMaster1)
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComTylerRTeamcityTestMainRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/Tyler-R/teamcity-test-main#refs/heads/master"
    url = "https://github.com/Tyler-R/teamcity-test-main"
    authMethod = password {
        userName = "Tyler-R"
        password = "credentialsJSON:5c48c11d-099d-4fb5-abc1-c01d825f09fa"
    }
})

object HttpsGithubComTylerRTeamcityTestMainRefsHeadsMaster1 : GitVcsRoot({
    name = "https://github.com/Tyler-R/teamcity-test-main"
    url = "https://github.com/Tyler-R/teamcity-test-main"
    branch = "-refs/heads/master"
    authMethod = password {
        userName = "Tyler-R"
        password = "credentialsJSON:5c48c11d-099d-4fb5-abc1-c01d825f09fa"
    }
})
