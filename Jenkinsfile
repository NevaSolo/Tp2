pipeline {
  agent any
  tools {
    maven 'Maven'    // Remplacez par le nom de l'outil Maven configuré dans Jenkins
  }
  environment {
    SONAR_HOST_URL = 'https://sonarcloud.io'
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
    stage('SonarQube analysis') {
      steps {
        withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
          bat 'mvn sonar:sonar -Dsonar.host.url=%SONAR_HOST_URL% -Dsonar.login=%SONAR_TOKEN% -Dsonar.projectKey=tp2-triangle-app -Dsonar.projectName=Triangle-App'
        }
      }
    }
  }
  post {
    failure {
      emailext body: '''Build ${BUILD_NUMBER} failed!
      
Project: ${PROJECT_NAME}
Build URL: ${BUILD_URL}
Console Output: ${BUILD_URL}console

Check the logs for details.''',
               subject: '❌ Jenkins Build ${BUILD_NUMBER} FAILED - ${PROJECT_NAME}',
               to: '${DEFAULT_RECIPIENTS}',
               recipientProviders: [requestor(), brokenBuildSuspects()]
    }
    success {
      emailext body: '''Build ${BUILD_NUMBER} passed successfully!
      
Project: ${PROJECT_NAME}
Build URL: ${BUILD_URL}
Tests: All tests passed ✅''',
               subject: '✅ Jenkins Build ${BUILD_NUMBER} SUCCESS - ${PROJECT_NAME}',
               to: '${DEFAULT_RECIPIENTS}',
               recipientProviders: [requestor()]
    }
  }
}
