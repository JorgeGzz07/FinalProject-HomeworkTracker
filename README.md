# Homework Task Tracker

This is a beginner-friendly Java console application that helps you keep track of your homework tasks. You can add tasks, view pending and completed tasks, and save your progress between runs using file storage.

## 💡 Problem Solved

Sometimes it's hard to remember what homework needs to be done. This program allows you to create a list of homework tasks, mark them as complete, and automatically save everything to files.

## 🛠 Features

- Add new homework tasks with due dates
- View pending and completed tasks
- Mark tasks as completed
- Save tasks to files (`pending.txt` and `completed.txt`)
- Load saved tasks when the program starts
- Handles bad user input with try-catch and recursion

## 📂 How It Works

- **ArrayList** stores pending tasks
- **Array** stores completed tasks
- **Recursive methods** validate menu input
- **Try-catch blocks** handle invalid input and file errors
- **File persistence** saves task data between sessions

## ▶️ How to Run

1. Open this project in GitHub Codespaces or any Java IDE
2. Compile the code:
   ```bash
   javac Main.java
Run the program:
java Main
📁 Files

Main.java - Program logic and user menu
Task.java - Task class with name and due date
FileHandler.java - Saves and loads task data
👤 Created By

JorgeGzz07