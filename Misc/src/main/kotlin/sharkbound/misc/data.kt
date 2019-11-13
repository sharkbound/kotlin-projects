package sharkbound.misc

import sharkbound.commonutils.collections.nonNullableMutableMapOf
import sharkbound.commonutils.extensions.choice

open class Team(val name: String) {
    open var score: Int = 1
        protected set

    open var wins: Int = 0
    open val members = mutableListOf<String>()

    open infix fun addMember(newMember: String) {
        members.add(newMember)
    }

    open fun addAllMembers(vararg newMembers: String) {
        members.addAll(newMembers)
    }

    open fun fight(other: Team) =
        listOf(this, other).choice().also { if (it.name == this.name) wins++ }
}

class Game {
    val teams = nonNullableMutableMapOf<String, Team>()

    infix fun addTeam(team: Team) {
        teams[team.name] = team

    }

    fun bestOf3(team1: String, team2: String): Team {

    }
}