pipeline{
    agent any
    tools{
        maven '3.8.1'
    }
    stages{
        stage('Package'){
            steps{
                sh 'mvn --version'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Deploy'){
            steps{
            script{
                def runApp = 'java -jar /var/lib/jenkins/workspace/bankingAppPipeline/target/Banking-App-0.0.1-SNAPSHOT.jar'
                sshagent('pp-key'){
                   sh "ssh ubuntu@13.49.230.55 ${runApp}"
                  }
                }
            }
        }

    }
}