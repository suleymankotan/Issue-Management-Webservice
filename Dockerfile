FROM openjdk:8
ADD target /var/jenkins_home/jobs/issue-management/workspace/target/issue-management-0.0.1-SNAPSHOT.jar issue-management-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/issue-management-0.0.1-SNAPSHOT.jar"]
