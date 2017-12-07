pipeline {
  agent any
  stages {
    stage('unit') {
      steps {
        sh '''
docker run -d -P --name selenium-hub -e GRID_TIMEOUT=10 selenium/hub'''
      }
    }
    stage('BROWSER') {
      parallel {
        stage('chrome') {
          steps {
            sh '''docker run 

echo CHROME;
cd "${workspace}";
pwd;
cd "$WORKSPACE";
pwd;'''
          }
        }
        stage('firefox') {
          steps {
            sh '''cd /home/gradle/project;
ls;

docker run -d --link selenium-hub:hub selenium/node-firefox;
'''
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