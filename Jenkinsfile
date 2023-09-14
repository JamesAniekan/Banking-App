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

                    sh 'sudo cd /home/ubuntu/ppKeyFile'
                    sh 'ls'

//                sh 'scp -i  ~/ppKey.pem /var/lib/jenkins/workspace/bankingAppPipeline/target/Banking-App-0.0.1-SNAPSHOT.jar ubuntu@13.49.230.55:~/'

//                 def runApp = 'java -jar usr/share/java/Banking-App-0.0.1-SNAPSHOT.jar'
//                 sshagent(['pp-key']){
//                    scp
//                    sh "ssh -o StrictHostKeyChecking=no ubuntu@13.49.230.55 ${runApp}"
//                   }

            }
        }

    }
}
