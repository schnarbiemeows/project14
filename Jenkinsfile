pipeline {
    agent any
    stages {
        stage("Cleaning stage") {
            steps {
                bat "mvn clean"
            }
        }
        stage("Installation stage") {
            steps {
                bat "mvn install"
            }
        }
        stage("Deployment stage") {
            steps {
                echo "deploying"
                echo "deployed"
            }
        }
    }
}