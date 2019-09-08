mvn package -Dmaven.test.failure.ignore=true
scp -i "bubble.pem" target/bubbleblog-0.0.1-SNAPSHOT.jar ubuntu@ec2-18-138-217-21.ap-southeast-1.compute.amazonaws.com:~/
ssh -i "bubble.pem" ubuntu@18.138.217.21 'sudo kill -9 $(sudo lsof -t -i:8080); tmux; java -jar bubbleblog-0.0.1-SNAPSHOT.jar'
