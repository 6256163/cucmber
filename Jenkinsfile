pipeline {
  agent {
    docker {
      image 'gradle:4.3.1-jdk8-alpine'
      args '-v "$PWD":/home/gradle/project'
    }
    
  }
  stages {
    stage('unit') {
      steps {
        sh 'gradle --version'
      }
    }
    stage('BROWSER') {
      parallel {
        stage('chrome') {
          steps {
            sh '''echo CHROME
cd ${workspace}
pwd'''
          }
        }
        stage('firefox') {
          steps {
            sh '''echo FIREFOX
cd ${workspace}
pwd'''
          }
        }
      }
    }
    stage('DEPLOYMENT') {
      steps {
        sh '''echo DEPLOYMENT
cd ${workspace}
pwd'''
      }
    }
  }
}