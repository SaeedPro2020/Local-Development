pipeline {
    agent any

    tools {
        maven '3.9.7' // Make sure you have configured Maven 3.9.7 in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub
                git branch: 'main', url: 'https://github.com/SaeedPro2020/Assessment-Java-stack.git'
            }
        }

        stage('Build') {
            steps {
                // Build the application using Maven
                sh 'mvn compile'
            }
        }

        stage('Run') {
            steps {
                // Run the application using Maven
                sh 'mvn compile exec:java -Dexec.mainClass="com.example.Main"'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
