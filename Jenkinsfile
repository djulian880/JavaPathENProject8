pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Préparation et installation des fichiers JAR locaux
                sh 'mvn -B -DskipTests clean package'
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
