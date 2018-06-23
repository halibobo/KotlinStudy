package me.dahei.myapplication.data

class KotlinItem {

    var title: String = ""
    var content: String = ""
    var outcome: String = ""

    constructor()

    constructor(title: String, content: String, outcome: String) {
        this.title = title
        this.content = content
        this.outcome = outcome
    }
}