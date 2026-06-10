pipeline {
  agent any
  tools {
    maven 'Maven'    // Remplacez par le nom de l'outil Maven configuré dans Jenkins
  }
  stages {
    stage('Git checkout') {
      steps {
        git credentialsId: 'git_credentials', url: 'https://github.com/NevaSolo/Tp2.git'
      }
    }
    stage('Build') {
      steps {
        bat 'mvn clean package'
      }
    }
    stage('Unit Test Execution') {
      steps {
        bat 'mvn test'
      }
    }
  }
  post {
    failure {
      emailext body: 'Ce Build $BUILD_NUMBER a échoué',
               recipientProviders: [requestor()],
               subject: 'Build échoué',
               to: 'ton.email@example.com'
    }
  }
}
