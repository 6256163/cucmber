pipeline {
  agent {
    docker {
      image 'ubuntu'
      args '-u root:sudo'
    }
    
  }
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