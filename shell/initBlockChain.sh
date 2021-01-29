#!/bin/bash

rm -rf /home/gongyueyang/BlockChain/DonationSystem/docker/data/foundation/node/node_172.17.0.2_30300
rm -rf /home/gongyueyang/BlockChain/DonationSystem/docker/data/logistic/node/node_172.17.0.3_30300
rm -rf /home/gongyueyang/BlockChain/DonationSystem/docker/data/hospital/node/node_172.17.0.4_30300
rm -rf /home/gongyueyang/BlockChain/DonationSystem/docker/data/platform/node/node_172.17.0.5_30300

cp -rf /home/gongyueyang/BlockChain/DonationSystem/generator/tmp_one_click/agencyA/node/node_172.17.0.2_30300 /home/gongyueyang/BlockChain/DonationSystem/docker/data/foundation/node
cp -rf /home/gongyueyang/BlockChain/DonationSystem/generator/tmp_one_click/agencyB/node/node_172.17.0.3_30300 /home/gongyueyang/BlockChain/DonationSystem/docker/data/logistic/node
cp -rf /home/gongyueyang/BlockChain/DonationSystem/generator/tmp_one_click/agencyC/node/node_172.17.0.4_30300 /home/gongyueyang/BlockChain/DonationSystem/docker/data/hospital/node
cp -rf /home/gongyueyang/BlockChain/DonationSystem/generator/tmp_one_click/agencyD/node/node_172.17.0.5_30300 /home/gongyueyang/BlockChain/DonationSystem/docker/data/platform/node

rm -f /home/gongyueyang/BlockChain/DonationSystem/docker/data/foundation/jar/db/h2.mv.db
rm -f /home/gongyueyang/BlockChain/DonationSystem/docker/data/logistic/jar/db/h2.mv.db
rm -f /home/gongyueyang/BlockChain/DonationSystem/docker/data/hospital/jar/db/h2.mv.db
rm -f /home/gongyueyang/BlockChain/DonationSystem/docker/data/platform/jar/db/h2.mv.db