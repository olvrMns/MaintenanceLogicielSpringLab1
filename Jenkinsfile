pipeline {
    agent 'JavaAgent'

    stages {
        stages('Build') {
            steps {
                echo 'building'
            }
        }

        stages('Test') {
            steps {
                echo 'testing'
            }
        }

        stages('Deploy') {
            steps {
                echo 'deploy'
            }
        }
    }
}