#!/bin/sh

cd ..

cp ./docker/data/foundation/console/contracts/sdk/java/com/donationsystem/foundation/contract/* ./foundation/src/main/java/com/donationsystem/foundation/contract

cp ./docker/data/hospital/console/contracts/sdk/java/com/donationsystem/hospital/contract/* ./hospital/src/main/java/com/donationsystem/hospital/contract

cp ./docker/data/platform/console/contracts/sdk/java/com/donationsystem/platform/contract/* ./platform/backend/src/main/java/com/donationsystem/platform/contract

cp ./docker/data/logistic/console/contracts/sdk/java/com/donationsystem/logistic/contract/* ./logistic/src/main/java/com/donationsystem/logistic/contract