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
                echo "Running the JAR file: "
                sh '''
                cd TourGuide
                cd target
                nohup java -jar tourguide-0.0.1-SNAPSHOT.jar > application.log 2>&1 &
                '''
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
