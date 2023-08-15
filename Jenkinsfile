pipeline{
    agent any
    tools{
        maven '3.9.4'
    }
    stages{
        stage('Checkout'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JamesAniekan/Banking-App.git']])
            }
        }
        stage('Package'){
            steps{
                sh 'mvn --version'
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}