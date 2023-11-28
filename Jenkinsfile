pipeline {
    agent any

    environment {
        DOCKERHUB_USER = 'vishal77' // Replace with your Docker Hub username
        DOCKERHUB_PASS = credentials('Vanitha%12') // Replace with your Docker Hub password
        DOCKER_IMAGE_TAG = "${env.BUILD_NUMBER}" // You can use a more sophisticated versioning strategy
    }

    stages {
        stage("Declarative: Checkout SCM") {
            steps {
                script {
                    def gitTool = tool 'Default'
                    checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[credentialsId: 'Vanitha%12', url: 'https://github.com/vishalrathod22/swe645_Assign3']]], gitTool: gitTool)
                }
            }
        }

        stage("Building the Student Survey Image") {
            steps {
                script {
                    sh 'rm -rf *.jar'
                    sh 'mvn clean package'
                    echo "${BUILD_TIMESTAMP}"
                    withCredentials([usernamePassword(credentialsId: 'Vanitha%12', usernameVariable: 'vishal77', passwordVariable: 'Vanitha%12')]) {
                        sh "docker login -u ${DOCKERHUB_USER} -p ${DOCKERHUB_PASS}"
                        sh "docker build -t ${DOCKERHUB_USER}/swe645:${DOCKER_IMAGE_TAG} ."
                    }
                }
            }
        }

        stage("Pushing image to Docker Hub") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'Vanitha%12', usernameVariable: 'vishal77', passwordVariable: 'Vanitha%12')]) {
                        sh "docker push ${DOCKERHUB_USER}/swe645:${DOCKER_IMAGE_TAG}"
                    }
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
