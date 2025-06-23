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
                    sh 'mvn clean verify sonar:sonar -DskipTests=true -Dsonar.projectKey=app-granja-api -Dsonar.projectName=app-granja-api -Dsonar.host.url=http://192.168.80.22:9000 -Dsonar.token=squ_ac6832d7841fd1d563bd39f4367e9f1c05d1bf4c'
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