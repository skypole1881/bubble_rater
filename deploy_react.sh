cd bubble-react
npm install
npm run build
tar cvzf build.tar.gz build
scp -i ~/.ssh/aws_private_keys/"kp-2019.pem" build.tar.gz ec2-user@ec2-13-230-125-32.ap-northeast-1.compute.amazonaws.com:/usr/share/nginx/html
ssh -i ~/.ssh/aws_private_keys/"kp-2019.pem" ec2-user@ec2-13-230-125-32.ap-northeast-1.compute.amazonaws.com "cd /usr/share/nginx/html; sudo tar zxvf build.tar.gz"


