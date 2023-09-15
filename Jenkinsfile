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
                sh 'scp -i /var/lib/jenkins/workspace/ppKey.pem  /var/lib/jenkins/workspace/bankingAppPipeline/target/Banking-App-0.0.1-SNAPSHOT.jar ubuntu@13.49.49.33:~/'
                def runApp = 'java -jar ~/Banking-App-0.0.1-SNAPSHOT.jar'
                sshagent(['pp-key']){
                   sh "ssh -o StrictHostKeyChecking=no ubuntu@13.49.49.33 ${runApp}"
                  }

            }
        }

    }
}
}