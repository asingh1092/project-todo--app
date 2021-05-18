package com.singh.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

// this is a Activity life style function (onCreate())
class MainActivity : AppCompatActivity() {

    private lateinit var toDoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoAdapter = ToDoAdapter(mutableListOf())

        // List of ToDos
        rvToDoItems.adapter = toDoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        // Add Button
        btnAddToDo.setOnClickListener {
            val toDoTitle = etToDoTitle.text.toString()
            if (toDoTitle.isNotEmpty()) {
                val toDo = ToDo(toDoTitle)
                toDoAdapter.addToDo(toDo)
                etToDoTitle.text.clear()
            }
        }

        // Delete Done To Dos Button
        btnDeleteDoneToDos.setOnClickListener {
            toDoAdapter.deleteDoneToDos()
        }
    }
}

// CSS/HTML for Web apps -> XML files for Android apps