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
        sh 'mvn clean package'
      }
    }
    stage('Unit Test Execution') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Build Docker image') {
      steps {
        sh 'docker build -t neva250/nevasolo:tagname .'
      }
    }
    stage('Push Docker image') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhubpass', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
          sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
          sh 'docker push neva250/nevasolo:tagname'
        }
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
