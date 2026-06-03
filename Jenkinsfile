pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Checkout Code From GitHub') {
            steps {
                git branch: "main", url: "https://github.com/anuj308/todo-devops.git"
            }
        }
        stage('Build The Project') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package The Application') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
