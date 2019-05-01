mvn package
scp -i "bubble.pem" target/bubbleblog-0.0.1-SNAPSHOT.jar ubuntu@ec2-54-254-149-198.ap-southeast-1.compute.amazonaws.com:~/
ssh -i "bubble.pem" ubuntu@54.254.149.198 'pkill java; tmux; java -jar bubbleblog-0.0.1-SNAPSHOT.jar'
