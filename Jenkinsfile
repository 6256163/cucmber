pipeline {
  agent {
    docker {
      image 'gradle:4.3.1-jdk8-alpine'
      args '-v "$WORKSPACE":/home/gradle/project'
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
            sh '''echo CHROME;
cd "${workspace}";
pwd;
cd "$WORKSPACE";
pwd;'''
          }
        }
        stage('firefox') {
          steps {
            sh '''cd /home/gradle/project;
gradle test --Dspring.avtive.profile=firefox;'''
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