pipeline {
    agent any

    tools {
        maven 'Maven3.10'
    }

    stages {
        stage('SonarQube Analysis') {
            steps {
                echo 'Starting SonarQube analysis...'
                withSonarQubeEnv('SonarQube') {
                    // sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=app-granja-api -Dsonar.projectName=app-granja-api -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_42ccaa424766922e71777fa3780818f3dacc4a68'
                }
            }
        }
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