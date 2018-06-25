package me.dahei.myapplication.data

import java.io.Serializable

class KotlinNote : Serializable {
    var notes: ArrayList<NoteItem> = ArrayList()
    var name: String? = ""

    constructor()
    constructor(kotlinNote: ArrayList<NoteItem>, name: String?) {
        this.notes = kotlinNote
        this.name = name
    }


}