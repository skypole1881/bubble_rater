mvn package -Dmaven.test.failure.ignore=true
scp -i ~/.ssh/aws_private_keys/"kp-2019.pem" target/demo-0.0.1-SNAPSHOT.jar ec2-user@ec2-13-230-125-32.ap-northeast-1.compute.amazonaws.com:~/
ssh -i ~/.ssh/aws_private_keys/"kp-2019.pem" ec2-user@ec2-13-230-125-32.ap-northeast-1.compute.amazonaws.com 'sudo systemctl restart test.service'
