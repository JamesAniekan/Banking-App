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

                def runApp = 'java -jar Banking-App-0.0.1-SNAPSHOT.jar'
                sshagent(['pp-key']){
                    sh 'scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/bankingAppPipeline/target/Banking-App-0.0.1-SNAPSHOT.jar ubuntu@16.171.38.70:~/'
                   sh "ssh -o StrictHostKeyChecking=no ubuntu@16.171.38.70 ${runApp}"
                  }

            }
        }

    }
}
}