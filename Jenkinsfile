pipeline{
    agent any
    tools{
        maven '3.8.1'
    }
     environment{
        JEN_PPKEY = ""
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
                sh 'scp -i /var/lib/jenkins/workspace/ppKey.pem -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/bankingAppPipeline/target/Banking-App-0.0.1-SNAPSHOT.jar ubuntu@16.171.38.70:~/'
                def runApp = 'java -jar ~/Banking-App-0.0.1-SNAPSHOT.jar'
                sshagent(['pp-key']){
                   sh "ssh -o StrictHostKeyChecking=no ubuntu@16.171.38.70 ${runApp}"
                  }

            }
        }

    }
}
}