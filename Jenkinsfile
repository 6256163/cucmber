pipeline {
  agent {
    docker {
      image 'ubuntu:16.04'
    }
    
  }
  stages {
    stage('TEST') {
      parallel {
        stage('unit') {
          steps {
            sh '''whoami
echo UNIT'''
          }
        }
        stage('component') {
          steps {
            sh '''whoami
echo COMPONENT'''
          }
        }
      }
    }
    stage('BROWSER') {
      parallel {
        stage('chrome') {
          steps {
            sh 'echo CHROME'
          }
        }
        stage('firefox') {
          steps {
            sh 'echo FIREFOX'
          }
        }
      }
    }
    stage('DEPLOYMENT') {
      steps {
        sh 'echo DEPLOYMENT'
      }
    }
  }
}