pipeline {
    agent any

    environment {
        DOCKERHUB_PASS = credentials('Vanitha%12')
        DOCKER_IMAGE_TAG = "${env.BUILD_NUMBER}" // You can use a more sophisticated versioning strategy
    }

    stages {
        stage("Building the Student Survey Image") {
            steps {
                script {
                    checkout scm
                    sh 'rm -rf *.jar'
                    sh 'mvn clean package'
                    echo "${BUILD_TIMESTAMP}"
                    withCredentials([usernamePassword(credentialsId: 'Vanitha%12', usernameVariable: 'vishal77', passwordVariable: 'Vanitha%12')]) {
                        sh "docker login -u ${vishal77} -p ${Vanitha%12}"
                        sh "docker build -t vishal77/swe645:${ok} ."
                    }
                }
            }
        }

        stage("Pushing image to Docker Hub") {
            steps {
                script {
                    sh "docker push vishal77/swe645:${ok}"
                }
            }
        }

        stage("Deploying to Rancher") {
            steps {
                script {
                    sh 'kubectl rollout restart deploy demo -n swe-backend'
                }
            }
        }
    }

    post {
        success {
            echo "Build and deployment successful!"
        }
        failure {
            echo "Build or deployment failed!"
        }
    }
}
