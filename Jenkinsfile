pipeline {
    agent any

    tools {
        maven 'Maven3.10'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Email Notification') {
            steps {
            emailext body: "Pipeline execution ${currentBuild.result}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n\nCheck console output at ${env.BUILD_URL}",
                subject: "Jenkins Build ${currentBuild.result}: ${env.JOB_NAME}",
                to: 'jesusmatiz35@gmail.com'
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}