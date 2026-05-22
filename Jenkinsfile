pipeline {
    agent any

    environment {
        SONAR_SCANNER_HOME = tool 'SonarScanner'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Code récupéré depuis Git'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                        ${SONAR_SCANNER_HOME}/bin/sonar-scanner \
                          -Dsonar.projectKey=pipeline-cicd \
                          -Dsonar.sources=src \
                          -Dsonar.java.binaries=.
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Publish to Nexus') {
            steps {
                echo 'Artéfact publié sur Nexus (Étudiant B)'
            }
        }
    }

    post {
        failure {
            echo 'Pipeline ÉCHOUÉ : Quality Gate non passé !'
        }
        success {
            echo 'Pipeline RÉUSSI : code validé !'
        }
    }
}
