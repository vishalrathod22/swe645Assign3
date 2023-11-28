pipeline {
    agent any

    environment {
        DOCKERHUB_USER = 'vishal77' // Replace with your Docker Hub username
        DOCKERHUB_PASS = credentials('Vanitha%12') // Replace with your Docker Hub password
        DOCKER_IMAGE_TAG = "${env.BUILD_NUMBER}" // You can use a more sophisticated versioning strategy
    }


    
        stages ("Declarative: Checkout SCM") {
            steps {
                script {
                    def gitTool = tool 'Default'
                    checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[credentialsId: 1337, url: 'https://github.com/vishalrathod22/swe645_Assign3']]], gitTool: gitTool)
                }
            }
        }

        // The rest of your pipeline stages...
    
    
    stages {
        stage("Building the Student Survey Image") {
            steps {
                script {
                    checkout scm
                    sh 'rm -rf *.jar'
                    sh 'mvn clean package'
                    echo "${BUILD_TIMESTAMP}"
                    withCredentials([usernamePassword(credentialsId: 'Vanitha%12', usernameVariable: 'vishal77', passwordVariable: 'Vanitha%12')]) {
                        sh "docker login -u ${DOCKERHUB_USER} -p ${DOCKERHUB_PASS}"
                        sh "docker build -t ${vishal77}/swe645:${ok} ."
                    }
                }
            }
        }

        stage("Pushing image to Docker Hub") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'Vanitha%12', usernameVariable: 'vishal77', passwordVariable: 'Vanitha%12')]) {
                        sh "docker push ${vishal77}/swe645:${ok}"
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
