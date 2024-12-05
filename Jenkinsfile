pipeline {
    agent any

    environment {
        // Définir une variable d'environnement pour le repository local Maven
        MAVEN_REPO = "${HOME}/.m2/repository"
    }
    stages {
        stage('Checkout') {
            steps {
                // Cloner le dépôt
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Préparation et installation des fichiers JAR locaux
                sh '''
                    mvn clean install
                '''
            }
        }
        stage('Test') {
            steps {
                // Préparation et exécution des tests
                sh '''
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
