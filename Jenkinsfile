pipeline {
    agent any

    tools {
        maven 'Maven 3'   // Name as defined in Jenkins Global Tool Configuration
        jdk 'JDK 17'      // Name as defined in Jenkins Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/yourname/restassured-framework.git', branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'allure generate target/allure-results --clean -o target/allure-report'
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure includeProperties: false,
                       results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/allure-report/**/*.*', fingerprint: true
        }
    }
}
