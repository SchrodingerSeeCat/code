#!/bin/sh

VERSION=`sed -n 2p /mc/config`
Xmx=`sed -n 5p /mc/config`
Xms=`sed -n 7p /mc/config`

cd /mc

if [ ! -e /mc/eula.txt ]
then
    # Self-start
    echo "@reboot /mc/start.sh" >> /etc/crontabs/root
	# download spigot
	wget "https://cdn.getbukkit.org/spigot/spigot-${VERSION}.jar"

	# Initialize the spigot
	java -Xmx${Xmx} -Xms${Xms} -jar spigot-${VERSION}.jar nogui

	# Accept the license agreement
	echo "eula=true" > eula.txt
elif [ ! -e /mc/spigot-${VERSION}.jar ]
then
    # Move out of old version
    rm -rf spigot-*
    # download spigot
	wget "https://cdn.getbukkit.org/spigot/spigot-${VERSION}.jar"
fi
# Start minecraft server
java -Xmx${Xmx} -Xms${Xms} -jar spigot-${VERSION}.jar nogui
