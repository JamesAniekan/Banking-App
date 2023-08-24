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
        stage('Run'){
            steps{
               sh 'java -jar /var/lib/jenkins/workspace/banking_app_pipeline/target/Banking-App-0.0.1-SNAPSHOT.jar'
            }
        }

    }
}