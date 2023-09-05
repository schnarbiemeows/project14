pipeline {
    agent any
    stages {
        /* stage("Cleaning stage") {
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
        } */
        stage("parallel exceution") {
            steps {
                parallel (
                    a: {
                        bat "mvn clean"
                    },
                    b: {
                        bat "mvn install"
                    }
                )
            }
        }
    }
}