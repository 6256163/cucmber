pipeline {
  agent none
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
        stage('whoami') {
          steps {
            sh 'whoami'
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