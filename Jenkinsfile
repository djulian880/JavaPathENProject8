pipeline {
    agent any
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
                sh 'mvn test'
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
