#!/bin/bash

# listele
path=/usr/bin
for ch in $path/*; do
        if [ -L $ch ] ; then
                echo $ch  >>/tmp/link
	elif [ -x $ch ] ; then 
		echo $ch >>/tmp/exe 
	fi
done

echo -n " Sybolic links "
echo -n "--------------------------------------------------------------------"
cat /tmp/link

echo -n "Execute file"
echo -n "--------------------------------------------------------------------"
cat /tmp/exe
