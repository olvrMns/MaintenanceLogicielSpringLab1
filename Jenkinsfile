pipeline {
    agent {
        label 'JavaAgent'
    }

    stages {
        stage('Clean') {
            steps {
                echo 'Clean...'
                sh 'mvn clean'
            }
        }

        stage('Validate') {
            steps {
                echo 'Validate...'
                sh 'mvn validate'
            }
        }

        stage('compile') {
            steps {
                echo 'Compile...'
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Test...'
                sh 'mvn test'
            }
        }

        stage('package') {
            steps {
                echo 'Package...'
                sh 'mvn package'
            }
        }
    }
}