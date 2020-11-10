# docker run -itd -v /home/gongyueyang/BlockChain/DonationSystem/foundation:/root/fisco/foundation --name=foundation --network=fisco_net --ip 172.18.0.2 shiki92/foundation:1.0 /bin/bash /root/fisco/node/node/start_all.sh 
# docker run -itd -v /home/gongyueyang/BlockChain/DonationSystem/logistic:/root/fisco/logistic --name=logistic --network=fisco_net --ip 172.18.0.3 shiki92/logistic:1.0 /bin/bash /root/fisco/node/node/start_all.sh
# docker run -itd --name=hospital  --network=fisco_net --ip 172.18.0.4 shiki92/hospital:1.0 /bin/bash /root/fisco/node/node/start_all.sh 
# docker run -itd --name=platform  --network=fisco_net --ip 172.18.0.5 shiki92/platform:1.0 /bin/bash /root/fisco/node/node/start_all.sh 
docker run -itd -v /home/gongyueyang/BlockChain/DonationSystem/foundation:/root/fisco/foundation --name=foundation --network=fisco_net --ip 172.100.0.2 shiki92/foundation:1.1
docker run -itd -v /home/gongyueyang/BlockChain/DonationSystem/logistic:/root/fisco/logistic --name=logistic --network=fisco_net --ip 172.100.0.3 shiki92/logistic:1.1
docker run -itd -v /home/gongyueyang/BlockChain/DonationSystem/hospital:/root/fisco/hospital --name=hospital  --network=fisco_net --ip 172.100.0.4 shiki92/hospital:1.1
docker run -itd -v /home/gongyueyang/BlockChain/DonationSystem/platform:/root/fisco/platform --name=platform  --network=fisco_net --ip 172.100.0.5 shiki92/platform:1.1
docker run -itd -v /home/gongyueyang/BlockChain/DonationSystem/platform:/root/fisco/platform/mysqldata:/var/lib/mysql --name mysql_pla --network=fisco_net --ip 172.100.0.10 mysql:5.7