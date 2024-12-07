pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6'
    }
    stages {
        stage('Build') {
            steps {
                sh '''
                cd TourGuide
                mvn -B -DskipTests clean package
                '''
            }
        }
        stage('Test') {
            steps {
                sh '''
                cd TourGuide
                mvn test
                '''
            }
        }
        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                sh '''
                cd TourGuide
                mvn clean package
                '''
            }
        }
    }
    post {
        always {
            // Sauvegarde des artefacts (facultatif)
            archiveArtifacts artifacts: 'TourGuide/target/*.jar', fingerprint: true
        }
        failure {
            // Action en cas d'échec
            echo 'Build failed!'
        }
    }
}
