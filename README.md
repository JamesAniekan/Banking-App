# Banking-App
In this project, I've implemented a streamlined continuous integration and deployment pipeline using Jenkins, Maven, and AWS EC2 instances. The goal is to automate the end-to-end process of building and deploying a Springboot application.

Technologies Used:

Jenkins:
Jenkins serves as the backbone of the continuous integration and continuous deployment (CI/CD) pipeline. It automates the entire process, from fetching the latest code changes from version control to deploying the application to our AWS EC2 instances.

Maven:
Maven is the build automation tool of choice. It manages project dependencies, compiles source code, and packages the application into a deployable artifact. 

AWS EC2 Instances:
AWS EC2 instances provide the scalable compute power needed to host the application. The Jenkins server, application server and the MySQL database server on which stores the application data are all hosted on EC2 instances and configured for network interconnection.

Project Workflow:

Code Repository:
The project's source code is hosted on a version control system, Github. Jenkins monitors this repository for any changes.

Jenkins Pipeline:
Upon detecting changes, Jenkins triggers a CI/CD pipeline. The pipeline comprises stages for building and deploying the application.

Maven Build:
The Build stage of the pipeline utilizes Maven for building the application. It resolves dependencies, compiles the source code, and creates an executable artifact.

AWS EC2 Deployment:
In the deploy stage of the pipeline, Jenkins, integrated with AWS, deploys the application to an EC2 instances. An sshagent plug-in is used with AWS credentials configured in Jenkins, to authenticate and get access to the EC2 server. The artifact is then copied securely and run on the server.


Conclusion:
This DevOps project exemplifies the power of automation, leveraging Jenkins, Maven, and AWS to create a seamless and efficient CI/CD pipeline.
