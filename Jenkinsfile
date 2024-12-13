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
                sh "screen -dmS TourGuide java -jar TourGuide/target/tourguide-0.0.1-SNAPSHOT.jar"
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
