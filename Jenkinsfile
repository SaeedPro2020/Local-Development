pipeline {
    agent any

    tools {
        maven '3.9.7' // Make sure you have configured Maven 3.9.7 in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub
                git branch: 'main', url: 'https://github.com/SaeedPro2020/Local-Development.git'
            }
        }

        stage('Build') {
            steps {
                // Build the application using Maven
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                  // Run the tests
                  sh 'mvn test'
            }
        }

        stage('Run') {
            steps {
                // Run the application using Maven
                sh 'mvn compile exec:java -Dexec.mainClass="com.example.Main"'
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Archive the jar file and output.json
                archiveArtifacts artifacts: '*.jar, output.json', allowEmptyArchive: true
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
