pipeline {
  agent any
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
        stage('Build') {
          steps {
            sh '''whoami
sudo docker pull ubuntu
whoami'''
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