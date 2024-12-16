pipeline {
    agent any
    environment {
        TERM = "xterm" // Définit le terminal pour éviter les erreurs
    }
    tools {
        maven 'Maven-3.9.6'
    }
    stages {
        stage('Build') {
            steps {
                sh '''
                cd TourGuide
                mvn -B -DskipTests clean install
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
            steps {
                sh '''
                cd TourGuide
                mvn clean package
                '''
            }
        }
        stage('Run Jar') {
            steps {

                try {
                    timeout(time: 5, unit: 'MINUTES') {
                        echo "Running the JAR file: "
                        sh '''
                        cd TourGuide
                        cd target
                        java -jar tourguide-0.0.1-SNAPSHOT.jar
                        '''
                    }
                } catch (Exception e) {
                    echo "Timeout or error occurred: ${e.getMessage()}"
                    currentBuild.result = 'SUCCESS' // Définir explicitement le statut
                }

            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'TourGuide/target/*.jar', fingerprint: true
        }
        failure {
            echo 'Build failed!'
        }
    }
}
