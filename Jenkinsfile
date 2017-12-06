pipeline {
  agent any
  stages {
    stage('TEST') {
      parallel {
        stage('unit') {
          steps {
            sh 'echo UNIT'
          }
        }
        stage('component') {
          steps {
            sh 'echo COMPONENT'
          }
        }
        stage('Build') {
          steps {
            sh 'sudo docker pull ubuntu'
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