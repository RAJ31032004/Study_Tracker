# 📘 Study Tracker

## 📌 Overview

Marvellous Study Tracker is a simple **Java console-based application** that helps users track their daily study activities. It allows users to log study sessions, view logs, generate summaries, and export data to a CSV file.

---

## 🚀 Features

* ➕ Add new study logs
* 📋 View all study logs
* 📊 Generate summary by **date**
* 📚 Generate summary by **subject**
* 📁 Export study logs to **CSV file**

---

## 🛠️ Technologies Used

* Java
* Collections Framework (ArrayList, TreeMap)
* File Handling (FileWriter)
* Date API (LocalDate)

---

## 📂 Project Structure

```
StudyLog        → Stores individual study entry
StudyTracker    → Handles all operations (insert, display, summary, export)
program902      → Main class (user interaction)
```

---

## 🧾 How It Works

### 1. Insert Study Log

* Automatically captures current date
* User inputs:

  * Subject
  * Duration (in hours)
  * Description

---

### 2. Display Logs

* Shows all stored study entries in format:

```
Date | Subject | Duration | Description
```

---

### 3. Summary by Date

* Groups study time by date
* Displays total study duration per day

---

### 4. Summary by Subject

* Groups study time by subject
* Displays total hours spent per subject

---

### 5. Export to CSV

* Saves all study logs in:

```
StudyTracker.csv
```

* CSV Format:

```
Date,Subject,Duration,Description
```

---

## ▶️ How to Run

### Step 1: Compile

```
javac ProjectCode.java
```

### Step 2: Run

```
java Program902
```

---

## 📸 Sample Menu

```
1 : Insert new study log
2 : View all study log
3 : Summary of study log by date
4 : Summary of study log by Subject
5 : Exit the application
```

---

