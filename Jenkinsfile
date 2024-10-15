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

        stage('Compile') {
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

        stage('Test validation') {
            steps {
                recordCoverage(tools: [[parser: 'JACOCO']],
                        id: 'jacoco', name: 'JaCoCo Coverage',
                        sourceCodeRetention: 'EVERY_BUILD',
                        qualityGates: [
                                [threshold: 50.0, metric: 'LINE', baseline: 'PROJECT', unstable: true],
                                [threshold: 50.0, metric: 'BRANCH', baseline: 'PROJECT', unstable: true]])
            }
        }

        stage('Package') {
            steps {
                echo 'Package...'
                sh 'mvn package'
            }
        }

        stage('docker build') {
            steps {
                echo 'Docker...'
            }
        }
    }
}