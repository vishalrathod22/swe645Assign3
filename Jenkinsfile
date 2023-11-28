pipeline{
	agent any
	environment {
		DOCKERHUB_PASS = credentials('Vanitha%12')
	}
	stages{
		stage("Building the Student Survey Image"){
			steps{
				script{
					checkout scm
					sh 'rm -rf *.jar'
					sh 'mvn clean package'
					sh 'echo ${BUILD_TIMESTAMP}'
					sh 'docker login -u vishal77 -p ${DOCKERHUB_PASS}'
					sh 'docker build -t vishal77/swe645 .'
				}
			}
		}
		stage("Pushing image to docker"){
			steps{
				script{
					sh 'docker push vishal77/swe645'
				}
			}
		}
		stage("Deploying to rancher"){
			steps{
				script{
					sh 'kubectl rollout restart deploy demo -n swe-backend'
				}
			}
		}
	}
}
