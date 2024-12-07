pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6'
    }
    stages {
        stage('Check Commands') {
            steps {
                sh '''
                echo "Testing commands..."
                which cp
                which mv
                which sleep
                echo "PATH: $PATH"
                '''
            }
        }
        stage('Test Maven') {
            steps {
                sh '''
                echo "Testing Maven..."
                which mvn
                mvn -v
                '''
            }
        }
        stage('Build') {
            steps {
                // Préparation et installation des fichiers JAR locaux
                // sh 'mvn -B -DskipTests clean package'
                echo 'toto maven'
                sh 'ls'
            }
        }
        stage('Test') {
            steps {
                // Préparation et exécution des tests
                sh '''
                cd TourGuide
                mvn test
                '''
            }
        }
        stage('Deploy') {
            when {
                branch 'main' // Exécute cette étape uniquement sur la branche main
            }
            steps {
                echo 'Deployment step'
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
