pipeline {
    agent any
    environment {
        LOCATION = 'us-east-1c'
        DOCKERHUB_PASS = 'Vanitha%12'
    }

    stages {
        stage("Checkout code") {
            steps {
                checkout scm
            }
        }
        stage("Building the Student Survey Image") {
            steps {
                script {
                    echo 'Creating the Jar..'
                    sh 'rm -rf *.jar'
                    sh 'mvn clean package'
                }
            }
        }
        stage("Docker image building"){
            steps{
                script{
                    sh 'echo ${BUILD_TIMESTAMP}'
                    sh 'echo $DOCKERHUB_PASS | docker login -u vishal77 --password-stdin'
                    sh 'docker build -t vishal77/swe645 .'
                }
            }
        }
        stage("Pushing image to docker") {
            steps {
                script {
                    sh 'docker push vishal77/swe645'
                }
            }
        }
        stage("Deploying to rancher") {
            steps {
                script {
                    sh 'kubectl rollout restart deploy swe-backend'
                }
            }
        }
    }
}
