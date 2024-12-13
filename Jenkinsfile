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
                tmux new-session -d -s tourguide_session "java -jar tourguide-0.0.1-SNAPSHOT.jar"
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
