mvn package
scp -i "bubble.pem" target/bubbleblog-0.0.1-SNAPSHOT.jar ubuntu@ec2-18-138-217-21.ap-southeast-1.compute.amazonaws.com:~/
ssh -i "bubble.pem" ubuntu@18.138.217.21 'pkill java; tmux; java -jar bubbleblog-0.0.1-SNAPSHOT.jar'
