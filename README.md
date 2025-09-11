# APCS-Classwork

This repo is for you to keep any non-lab code you write for this course so you can access it on any computer. 

Please format your classwork folders with the date that an assignment is started. For multi day assignments keep using the original folder name.

Sometimes the specific name will be given in your classwork, but in general the format should be 

`YEAR-MO-DT-DESCRIPTION/` e.g. `2024-09-27-looptests` 

# Commit only the files you specifically want

As with all repositories, do not commit extra files. This includes your class files, and also hidden folders on mac like .DS_Store/

Instead of something simple like `git add *.java` students will often use shortcuts not discussed in class and do not understand the consequences of their actions.



### 🧠 Think how these can cause problems for you:

- `git add -A`: Adds **all changes** new, modified, and deleted files (including your class files)
- `git add .`: Adds **new and modified files**  in the current directory (including your class files), but **not deletions**

## 📄 How to Create a `.gitignore` File and Ignore Files in Git

 1. Create the `.gitignore` File

You can create a `.gitignore` file at the root of each of your Git repositories that need to ignore files.

2. Add Patterns to Ignore

Edit .gitignore and add the files, folders, or patterns you want Git to ignore. 

For example: (you will want to edit this, it is intentionally wrong so that you have to make some changes.)

```
# Ignore Java files (do not do this)
*.java

# Ignore macOS system files (mac people need this)
.DS_Store
```
✅ Important: Do not add .java to your .gitignore — that's your actual code!

## Renaming repos:

You can rename your repos for your convenience, this one can be just `classwork`.

You can alternatively clone your repos and include the name you want:

`git clone SSH_LINK LOCAL_FOLDER_NAME`

e.g. 

`git clone git@github.com/stuff/here.git classwork`
