pipeline {
    agent any

    tools {
        maven 'Maven_HOME'
    }

    triggers {
        cron('H/2 * * * *')
        pollSCM('H/1 * * * *')
    }

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/dishamaiti/Maven-mini-game-project.git'
            }
        }

        stage('Build') {
            steps {
                sh "${tool 'Maven_HOME'}/bin/mvn clean package"
            }
        }

        stage('Echo Build Status') {
            steps {
                echo "Build Status: ${currentBuild.currentResult}"
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            build job: 'Scripted-Pipeline'
        }
    }
}
