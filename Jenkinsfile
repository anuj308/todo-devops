pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage('checkout code from gitHub') {
            steps {
                git branch: "main", url: "https://github.com/anuj308/todo-devops.git"
            }
        }
        stage('build the project') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('run a test stage') {
            steps {
                sh 'mvn test'
            }
        }
        stage('package the application') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
